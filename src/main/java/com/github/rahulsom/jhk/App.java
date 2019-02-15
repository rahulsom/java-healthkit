package com.github.rahulsom.jhk;

import com.github.rahulsom.jhk.model.HealthData;
import com.github.rahulsom.jhk.model.ObjectFactory;
import com.github.rahulsom.jhk.model.Record;
import com.github.rahulsom.jhk.model.Workout;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class App {

    public static void main(String[] args) throws JAXBException, IOException, ParseException {
        if (args.length != 1) {
            System.err.println("Need one arg: File name");
            System.exit(1);
        }
        JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller u = jc.createUnmarshaller();

        HealthData export = (HealthData) u.unmarshal(new File(args[0]));


        List<String> dates2 = records(export).map(it -> it.getStartDate().substring(0, 10)).distinct().collect(Collectors.toList());
        dates2.addAll(workouts(export).map(it -> it.getStartDate().substring(0, 10)).distinct().collect(Collectors.toList()));

        List<String> dates = dates2.stream().distinct().sorted().collect(Collectors.toList());

        Date start = new SimpleDateFormat("yyyy-MM-dd").parse(dates.get(0));
        Date end = new SimpleDateFormat("yyyy-MM-dd").parse(dates.get(dates.size() - 1));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);

        String template = new BufferedReader(new InputStreamReader(App.class.getResourceAsStream("/index.html"))).lines().collect(Collectors.joining("\n"));

        //noinspection ResultOfMethodCallIgnored
        new File("build").mkdirs();

        for (String date : dates) {
            PrintWriter ww = new PrintWriter("build/summary-" + date + ".html");

            ArrayList<Map> maps = new ArrayList<>();
            for (Workout it : workouts(export).filter(it -> it.getStartDate().startsWith(date))
                    .collect(Collectors.toList())) {

                HashMap<String, Object> map = new HashMap<>();
                map.put("x", parseTime(it.getStartDate()));
                map.put("text", it.getWorkoutActivityType() + " Started");

                maps.add(map);

                HashMap<String, Object> map2 = new HashMap<>();
                map2.put("x", parseTime(it.getEndDate()));
                map2.put("text", it.getWorkoutActivityType() + " Ended - " + it.getTotalDistance() + it.getTotalDistanceUnit());

                maps.add(map2);
            }

            maps.sort(Comparator.comparing(map -> (long) map.get("x")));

            String text = maps.stream().map(x -> "At: " + new Date((Long) x.get("x")) + ", " + x.get("text")).collect(Collectors.joining("<br/>"));
            ArrayList<String> lines = new ArrayList<>();
            for (Record it : records(export)
                    .filter(it ->
                            it.getStartDate().startsWith(date)
                                    && it.getType().equals("HKQuantityTypeIdentifierHeartRate"))
                    .sorted(Comparator.comparing(Record::getStartDate))
                    .collect(Collectors.toList())) {
                long start1 = parseTime(it.getStartDate());
                if (!maps.isEmpty() && ((long) maps.get(0).get("x")) < start1) {
                    Map map = maps.remove(0);
                    lines.add("[new Date(" + start1 + "), " + it.getValue() + ", '" + map.get("text") + "', '" + map.get("text") + "']");
                } else {
                    lines.add("[new Date(" + start1 + "), " + it.getValue() + ", undefined, undefined]");
                }
            }

            ww.println(
                    template
                            .replace("$data", String.join(",\n      ", lines))
                            .replace("$text", text)
            );

            ww.flush();
            ww.close();
        }

    }

    private static long parseTime(String dateString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString.substring(0, 19)).getTime();
    }

    private static Stream<Workout> workouts(HealthData export) {
        return export.getRecordOrCorrelationOrWorkoutOrActivitySummaryOrClinicalRecord()
                .stream()
                .filter(it -> it instanceof Workout)
                .map(it -> (Workout) it);
    }

    private static Stream<Record> records(HealthData export) {
        return export.getRecordOrCorrelationOrWorkoutOrActivitySummaryOrClinicalRecord()
                .stream()
                .filter(it -> it instanceof Record)
                .map(it -> (Record) it);
    }
}