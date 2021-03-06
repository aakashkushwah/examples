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
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Cheque7 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Cheque7"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ChqTp" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}ChequeType2Code" minOccurs="0"/&gt;
 *         &lt;element name="ChqNb" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Max35Text" minOccurs="0"/&gt;
 *         &lt;element name="ChqFr" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}NameAndAddress10" minOccurs="0"/&gt;
 *         &lt;element name="DlvryMtd" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}ChequeDeliveryMethod1Choice" minOccurs="0"/&gt;
 *         &lt;element name="DlvrTo" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}NameAndAddress10" minOccurs="0"/&gt;
 *         &lt;element name="InstrPrty" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Priority2Code" minOccurs="0"/&gt;
 *         &lt;element name="ChqMtrtyDt" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}ISODate" minOccurs="0"/&gt;
 *         &lt;element name="FrmsCd" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Max35Text" minOccurs="0"/&gt;
 *         &lt;element name="MemoFld" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Max35Text" maxOccurs="2" minOccurs="0"/&gt;
 *         &lt;element name="RgnlClrZone" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Max35Text" minOccurs="0"/&gt;
 *         &lt;element name="PrtLctn" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Max35Text" minOccurs="0"/&gt;
 *         &lt;element name="Sgntr" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Max70Text" maxOccurs="5" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cheque7", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06", propOrder = {
    "chqTp",
    "chqNb",
    "chqFr",
    "dlvryMtd",
    "dlvrTo",
    "instrPrty",
    "chqMtrtyDt",
    "frmsCd",
    "memoFlds",
    "rgnlClrZone",
    "prtLctn",
    "sgntrs"
})
public class Cheque7
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "ChqTp", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    @XmlSchemaType(name = "string")
    protected ChequeType2Code chqTp;
    @XmlElement(name = "ChqNb", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected String chqNb;
    @XmlElement(name = "ChqFr", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected NameAndAddress10 chqFr;
    @XmlElement(name = "DlvryMtd", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected ChequeDeliveryMethod1Choice dlvryMtd;
    @XmlElement(name = "DlvrTo", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected NameAndAddress10 dlvrTo;
    @XmlElement(name = "InstrPrty", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    @XmlSchemaType(name = "string")
    protected Priority2Code instrPrty;
    @XmlElement(name = "ChqMtrtyDt", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar chqMtrtyDt;
    @XmlElement(name = "FrmsCd", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected String frmsCd;
    @XmlElement(name = "MemoFld", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected List<String> memoFlds;
    @XmlElement(name = "RgnlClrZone", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected String rgnlClrZone;
    @XmlElement(name = "PrtLctn", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected String prtLctn;
    @XmlElement(name = "Sgntr", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected List<String> sgntrs;

    /**
     * Gets the value of the chqTp property.
     * 
     * @return
     *     possible object is
     *     {@link ChequeType2Code }
     *     
     */
    public ChequeType2Code getChqTp() {
        return chqTp;
    }

    /**
     * Sets the value of the chqTp property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChequeType2Code }
     *     
     */
    public void setChqTp(ChequeType2Code value) {
        this.chqTp = value;
    }

    /**
     * Gets the value of the chqNb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChqNb() {
        return chqNb;
    }

    /**
     * Sets the value of the chqNb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChqNb(String value) {
        this.chqNb = value;
    }

    /**
     * Gets the value of the chqFr property.
     * 
     * @return
     *     possible object is
     *     {@link NameAndAddress10 }
     *     
     */
    public NameAndAddress10 getChqFr() {
        return chqFr;
    }

    /**
     * Sets the value of the chqFr property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameAndAddress10 }
     *     
     */
    public void setChqFr(NameAndAddress10 value) {
        this.chqFr = value;
    }

    /**
     * Gets the value of the dlvryMtd property.
     * 
     * @return
     *     possible object is
     *     {@link ChequeDeliveryMethod1Choice }
     *     
     */
    public ChequeDeliveryMethod1Choice getDlvryMtd() {
        return dlvryMtd;
    }

    /**
     * Sets the value of the dlvryMtd property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChequeDeliveryMethod1Choice }
     *     
     */
    public void setDlvryMtd(ChequeDeliveryMethod1Choice value) {
        this.dlvryMtd = value;
    }

    /**
     * Gets the value of the dlvrTo property.
     * 
     * @return
     *     possible object is
     *     {@link NameAndAddress10 }
     *     
     */
    public NameAndAddress10 getDlvrTo() {
        return dlvrTo;
    }

    /**
     * Sets the value of the dlvrTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameAndAddress10 }
     *     
     */
    public void setDlvrTo(NameAndAddress10 value) {
        this.dlvrTo = value;
    }

    /**
     * Gets the value of the instrPrty property.
     * 
     * @return
     *     possible object is
     *     {@link Priority2Code }
     *     
     */
    public Priority2Code getInstrPrty() {
        return instrPrty;
    }

    /**
     * Sets the value of the instrPrty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Priority2Code }
     *     
     */
    public void setInstrPrty(Priority2Code value) {
        this.instrPrty = value;
    }

    /**
     * Gets the value of the chqMtrtyDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getChqMtrtyDt() {
        return chqMtrtyDt;
    }

    /**
     * Sets the value of the chqMtrtyDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setChqMtrtyDt(XMLGregorianCalendar value) {
        this.chqMtrtyDt = value;
    }

    /**
     * Gets the value of the frmsCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrmsCd() {
        return frmsCd;
    }

    /**
     * Sets the value of the frmsCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrmsCd(String value) {
        this.frmsCd = value;
    }

    /**
     * Gets the value of the memoFlds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the memoFlds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMemoFlds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMemoFlds() {
        if (memoFlds == null) {
            memoFlds = new ArrayList<String>();
        }
        return this.memoFlds;
    }

    /**
     * Gets the value of the rgnlClrZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRgnlClrZone() {
        return rgnlClrZone;
    }

    /**
     * Sets the value of the rgnlClrZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRgnlClrZone(String value) {
        this.rgnlClrZone = value;
    }

    /**
     * Gets the value of the prtLctn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrtLctn() {
        return prtLctn;
    }

    /**
     * Sets the value of the prtLctn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrtLctn(String value) {
        this.prtLctn = value;
    }

    /**
     * Gets the value of the sgntrs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sgntrs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSgntrs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSgntrs() {
        if (sgntrs == null) {
            sgntrs = new ArrayList<String>();
        }
        return this.sgntrs;
    }

}
