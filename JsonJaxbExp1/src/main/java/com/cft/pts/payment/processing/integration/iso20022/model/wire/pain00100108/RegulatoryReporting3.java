//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.01.28 at 03:25:08 PM IST 
//


package com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegulatoryReporting3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegulatoryReporting3"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DbtCdtRptgInd" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}RegulatoryReportingType1Code" minOccurs="0"/&gt;
 *         &lt;element name="Authrty" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}RegulatoryAuthority2" minOccurs="0"/&gt;
 *         &lt;element name="Dtls" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}StructuredRegulatoryReporting3" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegulatoryReporting3", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06", propOrder = {
    "dbtCdtRptgInd",
    "authrty",
    "dtls"
})
public class RegulatoryReporting3
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "DbtCdtRptgInd", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    @XmlSchemaType(name = "string")
    protected RegulatoryReportingType1Code dbtCdtRptgInd;
    @XmlElement(name = "Authrty", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected RegulatoryAuthority2 authrty;
    @XmlElement(name = "Dtls", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected List<StructuredRegulatoryReporting3> dtls;

    /**
     * Gets the value of the dbtCdtRptgInd property.
     * 
     * @return
     *     possible object is
     *     {@link RegulatoryReportingType1Code }
     *     
     */
    public RegulatoryReportingType1Code getDbtCdtRptgInd() {
        return dbtCdtRptgInd;
    }

    /**
     * Sets the value of the dbtCdtRptgInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegulatoryReportingType1Code }
     *     
     */
    public void setDbtCdtRptgInd(RegulatoryReportingType1Code value) {
        this.dbtCdtRptgInd = value;
    }

    /**
     * Gets the value of the authrty property.
     * 
     * @return
     *     possible object is
     *     {@link RegulatoryAuthority2 }
     *     
     */
    public RegulatoryAuthority2 getAuthrty() {
        return authrty;
    }

    /**
     * Sets the value of the authrty property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegulatoryAuthority2 }
     *     
     */
    public void setAuthrty(RegulatoryAuthority2 value) {
        this.authrty = value;
    }

    /**
     * Gets the value of the dtls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dtls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDtls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StructuredRegulatoryReporting3 }
     * 
     * 
     */
    public List<StructuredRegulatoryReporting3> getDtls() {
        if (dtls == null) {
            dtls = new ArrayList<StructuredRegulatoryReporting3>();
        }
        return this.dtls;
    }

}