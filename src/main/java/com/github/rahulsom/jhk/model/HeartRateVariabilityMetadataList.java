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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "instantaneousBeatsPerMinute"
})
@XmlRootElement(name = "HeartRateVariabilityMetadataList")
public class HeartRateVariabilityMetadataList {

    @XmlElement(name = "InstantaneousBeatsPerMinute")
    protected List<InstantaneousBeatsPerMinute> instantaneousBeatsPerMinute;

    /**
     * Gets the value of the instantaneousBeatsPerMinute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instantaneousBeatsPerMinute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstantaneousBeatsPerMinute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InstantaneousBeatsPerMinute }
     * 
     * 
     */
    public List<InstantaneousBeatsPerMinute> getInstantaneousBeatsPerMinute() {
        if (instantaneousBeatsPerMinute == null) {
            instantaneousBeatsPerMinute = new ArrayList<InstantaneousBeatsPerMinute>();
        }
        return this.instantaneousBeatsPerMinute;
    }

}
