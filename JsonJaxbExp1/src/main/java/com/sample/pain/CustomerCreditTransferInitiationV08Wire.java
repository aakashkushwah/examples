//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.05 at 02:29:15 PM IST 
//


package com.sample.pain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Cardinality for PmtInf was changed to 1..1
 *             
 * 
 * <p>Java class for CustomerCreditTransferInitiationV08Wire complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerCreditTransferInitiationV08Wire">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}GroupHeader48"/>
 *         &lt;element name="PmtInf" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}PaymentInstruction22Wire"/>
 *         &lt;element name="SplmtryData" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}SupplementaryData1Wire" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerCreditTransferInitiationV08Wire", propOrder = {
    "grpHdr",
    "pmtInf",
    "splmtryData"
})
public class CustomerCreditTransferInitiationV08Wire {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader48 grpHdr;
    @XmlElement(name = "PmtInf", required = true)
    protected PaymentInstruction22Wire pmtInf;
    @XmlElement(name = "SplmtryData", required = true)
    protected List<SupplementaryData1Wire> splmtryData;

    /**
     * Gets the value of the grpHdr property.
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader48 }
     *     
     */
    public GroupHeader48 getGrpHdr() {
        return grpHdr;
    }

    /**
     * Sets the value of the grpHdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader48 }
     *     
     */
    public void setGrpHdr(GroupHeader48 value) {
        this.grpHdr = value;
    }

    /**
     * Gets the value of the pmtInf property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentInstruction22Wire }
     *     
     */
    public PaymentInstruction22Wire getPmtInf() {
        return pmtInf;
    }

    /**
     * Sets the value of the pmtInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentInstruction22Wire }
     *     
     */
    public void setPmtInf(PaymentInstruction22Wire value) {
        this.pmtInf = value;
    }

    /**
     * Gets the value of the splmtryData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the splmtryData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSplmtryData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplementaryData1Wire }
     * 
     * 
     */
    public List<SupplementaryData1Wire> getSplmtryData() {
        if (splmtryData == null) {
            splmtryData = new ArrayList<SupplementaryData1Wire>();
        }
        return this.splmtryData;
    }

}
