//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.05 at 02:29:15 PM IST 
//


package com.sample.pain;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Cardinality for CdtTrfTxInf, PmtTpInf was changed
 *                 to 1..1
 *             
 * 
 * <p>Java class for PaymentInstruction22Wire complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentInstruction22Wire">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PmtInfId" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Max35Text"/>
 *         &lt;element name="PmtMtd" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}PaymentMethod3CodeWire"/>
 *         &lt;element name="BtchBookg" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}BatchBookingIndicator" minOccurs="0"/>
 *         &lt;element name="NbOfTxs" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Max15NumericText" minOccurs="0"/>
 *         &lt;element name="CtrlSum" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}DecimalNumber" minOccurs="0"/>
 *         &lt;element name="PmtTpInf" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}PaymentTypeInformation19Wire"/>
 *         &lt;element name="ReqdExctnDt" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}DateWire"/>
 *         &lt;element name="PoolgAdjstmntDt" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}ISODate" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}PartyIdentification43Wire"/>
 *         &lt;element name="DbtrAcct" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}CashAccount24"/>
 *         &lt;element name="DbtrAgt" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}BranchAndFinancialInstitutionIdentification5Wire"/>
 *         &lt;element name="DbtrAgtAcct" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}CashAccount24" minOccurs="0"/>
 *         &lt;element name="InstrForDbtrAgt" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Max140Text" minOccurs="0"/>
 *         &lt;element name="UltmtDbtr" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}PartyIdentification43" minOccurs="0"/>
 *         &lt;element name="ChrgBr" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}ChargeBearerType1Code" minOccurs="0"/>
 *         &lt;element name="ChrgsAcct" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}CashAccount24" minOccurs="0"/>
 *         &lt;element name="ChrgsAcctAgt" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}BranchAndFinancialInstitutionIdentification5" minOccurs="0"/>
 *         &lt;element name="CdtTrfTxInf" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}CreditTransferTransaction26Wire"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInstruction22Wire", propOrder = {
    "pmtInfId",
    "pmtMtd",
    "btchBookg",
    "nbOfTxs",
    "ctrlSum",
    "pmtTpInf",
    "reqdExctnDt",
    "poolgAdjstmntDt",
    "dbtr",
    "dbtrAcct",
    "dbtrAgt",
    "dbtrAgtAcct",
    "instrForDbtrAgt",
    "ultmtDbtr",
    "chrgBr",
    "chrgsAcct",
    "chrgsAcctAgt",
    "cdtTrfTxInf"
})
public class PaymentInstruction22Wire {

    @XmlElement(name = "PmtInfId", required = true)
    protected String pmtInfId;
    @XmlElement(name = "PmtMtd", required = true)
    @XmlSchemaType(name = "string")
    protected PaymentMethod3CodeWire pmtMtd;
    @XmlElement(name = "BtchBookg")
    protected Boolean btchBookg;
    @XmlElement(name = "NbOfTxs")
    protected String nbOfTxs;
    @XmlElement(name = "CtrlSum")
    protected BigDecimal ctrlSum;
    @XmlElement(name = "PmtTpInf", required = true)
    protected PaymentTypeInformation19Wire pmtTpInf;
    @XmlElement(name = "ReqdExctnDt", required = true)
    protected DateWire reqdExctnDt;
    @XmlElement(name = "PoolgAdjstmntDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar poolgAdjstmntDt;
    @XmlElement(name = "Dbtr", required = true)
    protected PartyIdentification43Wire dbtr;
    @XmlElement(name = "DbtrAcct", required = true)
    protected CashAccount24 dbtrAcct;
    @XmlElement(name = "DbtrAgt", required = true)
    protected BranchAndFinancialInstitutionIdentification5Wire dbtrAgt;
    @XmlElement(name = "DbtrAgtAcct")
    protected CashAccount24 dbtrAgtAcct;
    @XmlElement(name = "InstrForDbtrAgt")
    protected String instrForDbtrAgt;
    @XmlElement(name = "UltmtDbtr")
    protected PartyIdentification43 ultmtDbtr;
    @XmlElement(name = "ChrgBr")
    @XmlSchemaType(name = "string")
    protected ChargeBearerType1Code chrgBr;
    @XmlElement(name = "ChrgsAcct")
    protected CashAccount24 chrgsAcct;
    @XmlElement(name = "ChrgsAcctAgt")
    protected BranchAndFinancialInstitutionIdentification5 chrgsAcctAgt;
    @XmlElement(name = "CdtTrfTxInf", required = true)
    protected CreditTransferTransaction26Wire cdtTrfTxInf;

    /**
     * Gets the value of the pmtInfId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPmtInfId() {
        return pmtInfId;
    }

    /**
     * Sets the value of the pmtInfId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPmtInfId(String value) {
        this.pmtInfId = value;
    }

    /**
     * Gets the value of the pmtMtd property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethod3CodeWire }
     *     
     */
    public PaymentMethod3CodeWire getPmtMtd() {
        return pmtMtd;
    }

    /**
     * Sets the value of the pmtMtd property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethod3CodeWire }
     *     
     */
    public void setPmtMtd(PaymentMethod3CodeWire value) {
        this.pmtMtd = value;
    }

    /**
     * Gets the value of the btchBookg property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBtchBookg() {
        return btchBookg;
    }

    /**
     * Sets the value of the btchBookg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBtchBookg(Boolean value) {
        this.btchBookg = value;
    }

    /**
     * Gets the value of the nbOfTxs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbOfTxs() {
        return nbOfTxs;
    }

    /**
     * Sets the value of the nbOfTxs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbOfTxs(String value) {
        this.nbOfTxs = value;
    }

    /**
     * Gets the value of the ctrlSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCtrlSum() {
        return ctrlSum;
    }

    /**
     * Sets the value of the ctrlSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCtrlSum(BigDecimal value) {
        this.ctrlSum = value;
    }

    /**
     * Gets the value of the pmtTpInf property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTypeInformation19Wire }
     *     
     */
    public PaymentTypeInformation19Wire getPmtTpInf() {
        return pmtTpInf;
    }

    /**
     * Sets the value of the pmtTpInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTypeInformation19Wire }
     *     
     */
    public void setPmtTpInf(PaymentTypeInformation19Wire value) {
        this.pmtTpInf = value;
    }

    /**
     * Gets the value of the reqdExctnDt property.
     * 
     * @return
     *     possible object is
     *     {@link DateWire }
     *     
     */
    public DateWire getReqdExctnDt() {
        return reqdExctnDt;
    }

    /**
     * Sets the value of the reqdExctnDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateWire }
     *     
     */
    public void setReqdExctnDt(DateWire value) {
        this.reqdExctnDt = value;
    }

    /**
     * Gets the value of the poolgAdjstmntDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPoolgAdjstmntDt() {
        return poolgAdjstmntDt;
    }

    /**
     * Sets the value of the poolgAdjstmntDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPoolgAdjstmntDt(XMLGregorianCalendar value) {
        this.poolgAdjstmntDt = value;
    }

    /**
     * Gets the value of the dbtr property.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification43Wire }
     *     
     */
    public PartyIdentification43Wire getDbtr() {
        return dbtr;
    }

    /**
     * Sets the value of the dbtr property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification43Wire }
     *     
     */
    public void setDbtr(PartyIdentification43Wire value) {
        this.dbtr = value;
    }

    /**
     * Gets the value of the dbtrAcct property.
     * 
     * @return
     *     possible object is
     *     {@link CashAccount24 }
     *     
     */
    public CashAccount24 getDbtrAcct() {
        return dbtrAcct;
    }

    /**
     * Sets the value of the dbtrAcct property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount24 }
     *     
     */
    public void setDbtrAcct(CashAccount24 value) {
        this.dbtrAcct = value;
    }

    /**
     * Gets the value of the dbtrAgt property.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification5Wire }
     *     
     */
    public BranchAndFinancialInstitutionIdentification5Wire getDbtrAgt() {
        return dbtrAgt;
    }

    /**
     * Sets the value of the dbtrAgt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification5Wire }
     *     
     */
    public void setDbtrAgt(BranchAndFinancialInstitutionIdentification5Wire value) {
        this.dbtrAgt = value;
    }

    /**
     * Gets the value of the dbtrAgtAcct property.
     * 
     * @return
     *     possible object is
     *     {@link CashAccount24 }
     *     
     */
    public CashAccount24 getDbtrAgtAcct() {
        return dbtrAgtAcct;
    }

    /**
     * Sets the value of the dbtrAgtAcct property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount24 }
     *     
     */
    public void setDbtrAgtAcct(CashAccount24 value) {
        this.dbtrAgtAcct = value;
    }

    /**
     * Gets the value of the instrForDbtrAgt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrForDbtrAgt() {
        return instrForDbtrAgt;
    }

    /**
     * Sets the value of the instrForDbtrAgt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrForDbtrAgt(String value) {
        this.instrForDbtrAgt = value;
    }

    /**
     * Gets the value of the ultmtDbtr property.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification43 }
     *     
     */
    public PartyIdentification43 getUltmtDbtr() {
        return ultmtDbtr;
    }

    /**
     * Sets the value of the ultmtDbtr property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification43 }
     *     
     */
    public void setUltmtDbtr(PartyIdentification43 value) {
        this.ultmtDbtr = value;
    }

    /**
     * Gets the value of the chrgBr property.
     * 
     * @return
     *     possible object is
     *     {@link ChargeBearerType1Code }
     *     
     */
    public ChargeBearerType1Code getChrgBr() {
        return chrgBr;
    }

    /**
     * Sets the value of the chrgBr property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeBearerType1Code }
     *     
     */
    public void setChrgBr(ChargeBearerType1Code value) {
        this.chrgBr = value;
    }

    /**
     * Gets the value of the chrgsAcct property.
     * 
     * @return
     *     possible object is
     *     {@link CashAccount24 }
     *     
     */
    public CashAccount24 getChrgsAcct() {
        return chrgsAcct;
    }

    /**
     * Sets the value of the chrgsAcct property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount24 }
     *     
     */
    public void setChrgsAcct(CashAccount24 value) {
        this.chrgsAcct = value;
    }

    /**
     * Gets the value of the chrgsAcctAgt property.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification5 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification5 getChrgsAcctAgt() {
        return chrgsAcctAgt;
    }

    /**
     * Sets the value of the chrgsAcctAgt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification5 }
     *     
     */
    public void setChrgsAcctAgt(BranchAndFinancialInstitutionIdentification5 value) {
        this.chrgsAcctAgt = value;
    }

    /**
     * Gets the value of the cdtTrfTxInf property.
     * 
     * @return
     *     possible object is
     *     {@link CreditTransferTransaction26Wire }
     *     
     */
    public CreditTransferTransaction26Wire getCdtTrfTxInf() {
        return cdtTrfTxInf;
    }

    /**
     * Sets the value of the cdtTrfTxInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTransferTransaction26Wire }
     *     
     */
    public void setCdtTrfTxInf(CreditTransferTransaction26Wire value) {
        this.cdtTrfTxInf = value;
    }

}
