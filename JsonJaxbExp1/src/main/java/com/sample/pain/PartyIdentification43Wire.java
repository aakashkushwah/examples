//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.05 at 02:29:15 PM IST 
//


package com.sample.pain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * restricted Nm and AdrLine to 35 characters
 *             
 * 
 * <p>Java class for PartyIdentification43Wire complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PartyIdentification43Wire">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nm" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Max35Text" minOccurs="0"/>
 *         &lt;element name="PstlAdr" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}PostalAddress6Wire" minOccurs="0"/>
 *         &lt;element name="Id" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Party11Choice" minOccurs="0"/>
 *         &lt;element name="CtryOfRes" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}CountryCode" minOccurs="0"/>
 *         &lt;element name="CtctDtls" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}ContactDetails2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartyIdentification43Wire", propOrder = {
    "nm",
    "pstlAdr",
    "id",
    "ctryOfRes",
    "ctctDtls"
})
public class PartyIdentification43Wire {

    @XmlElement(name = "Nm")
    protected String nm;
    @XmlElement(name = "PstlAdr")
    protected PostalAddress6Wire pstlAdr;
    @XmlElement(name = "Id")
    protected Party11Choice id;
    @XmlElement(name = "CtryOfRes")
    protected String ctryOfRes;
    @XmlElement(name = "CtctDtls")
    protected ContactDetails2 ctctDtls;

    /**
     * Gets the value of the nm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNm() {
        return nm;
    }

    /**
     * Sets the value of the nm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNm(String value) {
        this.nm = value;
    }

    /**
     * Gets the value of the pstlAdr property.
     * 
     * @return
     *     possible object is
     *     {@link PostalAddress6Wire }
     *     
     */
    public PostalAddress6Wire getPstlAdr() {
        return pstlAdr;
    }

    /**
     * Sets the value of the pstlAdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostalAddress6Wire }
     *     
     */
    public void setPstlAdr(PostalAddress6Wire value) {
        this.pstlAdr = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Party11Choice }
     *     
     */
    public Party11Choice getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Party11Choice }
     *     
     */
    public void setId(Party11Choice value) {
        this.id = value;
    }

    /**
     * Gets the value of the ctryOfRes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtryOfRes() {
        return ctryOfRes;
    }

    /**
     * Sets the value of the ctryOfRes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtryOfRes(String value) {
        this.ctryOfRes = value;
    }

    /**
     * Gets the value of the ctctDtls property.
     * 
     * @return
     *     possible object is
     *     {@link ContactDetails2 }
     *     
     */
    public ContactDetails2 getCtctDtls() {
        return ctctDtls;
    }

    /**
     * Sets the value of the ctctDtls property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactDetails2 }
     *     
     */
    public void setCtctDtls(ContactDetails2 value) {
        this.ctctDtls = value;
    }

}
