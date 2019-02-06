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
 * restricted Nm and AdrLine in FinInstnId to 35
 *                 characters
 *             
 * 
 * <p>Java class for BranchAndFinancialInstitutionIdentification5Wire complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BranchAndFinancialInstitutionIdentification5Wire"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FinInstnId" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}FinancialInstitutionIdentification8Wire"/&gt;
 *         &lt;element name="BrnchId" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}BranchData2" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BranchAndFinancialInstitutionIdentification5Wire", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06", propOrder = {
    "finInstnId",
    "brnchId"
})
public class BranchAndFinancialInstitutionIdentification5Wire
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "FinInstnId", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06", required = true)
    protected FinancialInstitutionIdentification8Wire finInstnId;
    @XmlElement(name = "BrnchId", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected BranchData2 brnchId;

    /**
     * Gets the value of the finInstnId property.
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstitutionIdentification8Wire }
     *     
     */
    public FinancialInstitutionIdentification8Wire getFinInstnId() {
        return finInstnId;
    }

    /**
     * Sets the value of the finInstnId property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstitutionIdentification8Wire }
     *     
     */
    public void setFinInstnId(FinancialInstitutionIdentification8Wire value) {
        this.finInstnId = value;
    }

    /**
     * Gets the value of the brnchId property.
     * 
     * @return
     *     possible object is
     *     {@link BranchData2 }
     *     
     */
    public BranchData2 getBrnchId() {
        return brnchId;
    }

    /**
     * Sets the value of the brnchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchData2 }
     *     
     */
    public void setBrnchId(BranchData2 value) {
        this.brnchId = value;
    }

}
