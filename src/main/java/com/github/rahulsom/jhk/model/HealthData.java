//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.11 at 08:43:48 PM PST 
//


package com.github.rahulsom.jhk.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "exportDate",
    "me",
    "recordOrCorrelationOrWorkoutOrActivitySummaryOrClinicalRecord"
})
@XmlRootElement(name = "HealthData")
public class HealthData {

    @XmlAttribute(name = "locale", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String locale;
    @XmlElement(name = "ExportDate", required = true)
    protected ExportDate exportDate;
    @XmlElement(name = "Me", required = true)
    protected Me me;
    @XmlElements({
        @XmlElement(name = "Record", type = Record.class),
        @XmlElement(name = "Correlation", type = Correlation.class),
        @XmlElement(name = "Workout", type = Workout.class),
        @XmlElement(name = "ActivitySummary", type = ActivitySummary.class),
        @XmlElement(name = "ClinicalRecord", type = ClinicalRecord.class)
    })
    protected List<Object> recordOrCorrelationOrWorkoutOrActivitySummaryOrClinicalRecord;

    /**
     * Gets the value of the locale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Sets the value of the locale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocale(String value) {
        this.locale = value;
    }

    /**
     * Gets the value of the exportDate property.
     * 
     * @return
     *     possible object is
     *     {@link ExportDate }
     *     
     */
    public ExportDate getExportDate() {
        return exportDate;
    }

    /**
     * Sets the value of the exportDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportDate }
     *     
     */
    public void setExportDate(ExportDate value) {
        this.exportDate = value;
    }

    /**
     * Gets the value of the me property.
     * 
     * @return
     *     possible object is
     *     {@link Me }
     *     
     */
    public Me getMe() {
        return me;
    }

    /**
     * Sets the value of the me property.
     * 
     * @param value
     *     allowed object is
     *     {@link Me }
     *     
     */
    public void setMe(Me value) {
        this.me = value;
    }

    /**
     * Gets the value of the recordOrCorrelationOrWorkoutOrActivitySummaryOrClinicalRecord property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recordOrCorrelationOrWorkoutOrActivitySummaryOrClinicalRecord property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecordOrCorrelationOrWorkoutOrActivitySummaryOrClinicalRecord().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Record }
     * {@link Correlation }
     * {@link Workout }
     * {@link ActivitySummary }
     * {@link ClinicalRecord }
     * 
     * 
     */
    public List<Object> getRecordOrCorrelationOrWorkoutOrActivitySummaryOrClinicalRecord() {
        if (recordOrCorrelationOrWorkoutOrActivitySummaryOrClinicalRecord == null) {
            recordOrCorrelationOrWorkoutOrActivitySummaryOrClinicalRecord = new ArrayList<Object>();
        }
        return this.recordOrCorrelationOrWorkoutOrActivitySummaryOrClinicalRecord;
    }

}
