//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.01 at 10:11:10 AM IST 
//


package com.sample.pain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Party11ChoiceWire complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Party11ChoiceWire">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="OrgId" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}OrganisationIdentification8Wire"/>
 *         &lt;element name="PrvtId" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}PersonIdentification5Wire"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Party11ChoiceWire", propOrder = {
    "orgId",
    "prvtId"
})
public class Party11ChoiceWire {

    @XmlElement(name = "OrgId")
    protected OrganisationIdentification8Wire orgId;
    @XmlElement(name = "PrvtId")
    protected PersonIdentification5Wire prvtId;

    /**
     * Gets the value of the orgId property.
     * 
     * @return
     *     possible object is
     *     {@link OrganisationIdentification8Wire }
     *     
     */
    public OrganisationIdentification8Wire getOrgId() {
        return orgId;
    }

    /**
     * Sets the value of the orgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganisationIdentification8Wire }
     *     
     */
    public void setOrgId(OrganisationIdentification8Wire value) {
        this.orgId = value;
    }

    /**
     * Gets the value of the prvtId property.
     * 
     * @return
     *     possible object is
     *     {@link PersonIdentification5Wire }
     *     
     */
    public PersonIdentification5Wire getPrvtId() {
        return prvtId;
    }

    /**
     * Sets the value of the prvtId property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonIdentification5Wire }
     *     
     */
    public void setPrvtId(PersonIdentification5Wire value) {
        this.prvtId = value;
    }

}
