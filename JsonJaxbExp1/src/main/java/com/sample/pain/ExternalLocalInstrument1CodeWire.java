//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.05 at 02:29:15 PM IST 
//


package com.sample.pain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExternalLocalInstrument1CodeWire.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExternalLocalInstrument1CodeWire">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BTR"/>
 *     &lt;enumeration value="CTP"/>
 *     &lt;enumeration value="CTR"/>
 *     &lt;enumeration value="DRC"/>
 *     &lt;enumeration value="DRB"/>
 *     &lt;enumeration value="DRW"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExternalLocalInstrument1CodeWire")
@XmlEnum
public enum ExternalLocalInstrument1CodeWire {

    BTR,
    CTP,
    CTR,
    DRC,
    DRB,
    DRW;

    public String value() {
        return name();
    }

    public static ExternalLocalInstrument1CodeWire fromValue(String v) {
        return valueOf(v);
    }

}