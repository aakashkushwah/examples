//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.01.28 at 03:25:08 PM IST 
//


package com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxParty1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxParty1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TaxId" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Max35Text" minOccurs="0"/&gt;
 *         &lt;element name="RegnId" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Max35Text" minOccurs="0"/&gt;
 *         &lt;element name="TaxTp" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Max35Text" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxParty1", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06", propOrder = {
    "taxId",
    "regnId",
    "taxTp"
})
public class TaxParty1
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "TaxId", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected String taxId;
    @XmlElement(name = "RegnId", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected String regnId;
    @XmlElement(name = "TaxTp", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected String taxTp;

    /**
     * Gets the value of the taxId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxId() {
        return taxId;
    }

    /**
     * Sets the value of the taxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxId(String value) {
        this.taxId = value;
    }

    /**
     * Gets the value of the regnId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegnId() {
        return regnId;
    }

    /**
     * Sets the value of the regnId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegnId(String value) {
        this.regnId = value;
    }

    /**
     * Gets the value of the taxTp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxTp() {
        return taxTp;
    }

    /**
     * Sets the value of the taxTp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxTp(String value) {
        this.taxTp = value;
    }

}
