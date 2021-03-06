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
 * Cardinality for CdtrAgt is changed to 1..1, for
 *                 InstrForCdtrAgt, RltdRmtInf are changed to 0..1
 *             
 * 
 * <p>Java class for CreditTransferTransaction26Wire complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditTransferTransaction26Wire"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PmtId" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}PaymentIdentification1"/&gt;
 *         &lt;element name="PmtTpInf" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}PaymentTypeInformation19" minOccurs="0"/&gt;
 *         &lt;element name="Amt" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}AmountType4Choice"/&gt;
 *         &lt;element name="XchgRateInf" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}ExchangeRate1" minOccurs="0"/&gt;
 *         &lt;element name="ChrgBr" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}ChargeBearerType1CodeWire" minOccurs="0"/&gt;
 *         &lt;element name="ChqInstr" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Cheque7" minOccurs="0"/&gt;
 *         &lt;element name="UltmtDbtr" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}PartyIdentification43Wire" minOccurs="0"/&gt;
 *         &lt;element name="IntrmyAgt1" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}BranchAndFinancialInstitutionIdentification5Wire" minOccurs="0"/&gt;
 *         &lt;element name="IntrmyAgt1Acct" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}CashAccount24" minOccurs="0"/&gt;
 *         &lt;element name="IntrmyAgt2" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}BranchAndFinancialInstitutionIdentification5" minOccurs="0"/&gt;
 *         &lt;element name="IntrmyAgt2Acct" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}CashAccount24" minOccurs="0"/&gt;
 *         &lt;element name="IntrmyAgt3" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}BranchAndFinancialInstitutionIdentification5" minOccurs="0"/&gt;
 *         &lt;element name="IntrmyAgt3Acct" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}CashAccount24" minOccurs="0"/&gt;
 *         &lt;element name="CdtrAgt" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}BranchAndFinancialInstitutionIdentification5Wire"/&gt;
 *         &lt;element name="CdtrAgtAcct" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}CashAccount24" minOccurs="0"/&gt;
 *         &lt;element name="Cdtr" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}PartyIdentification43Wire" minOccurs="0"/&gt;
 *         &lt;element name="CdtrAcct" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}CashAccount24" minOccurs="0"/&gt;
 *         &lt;element name="UltmtCdtr" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}PartyIdentification43" minOccurs="0"/&gt;
 *         &lt;element name="InstrForCdtrAgt" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}InstructionForCreditorAgent1" minOccurs="0"/&gt;
 *         &lt;element name="InstrForDbtrAgt" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Max140Text" minOccurs="0"/&gt;
 *         &lt;element name="Purp" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}Purpose2Choice" minOccurs="0"/&gt;
 *         &lt;element name="RgltryRptg" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}RegulatoryReporting3" maxOccurs="10" minOccurs="0"/&gt;
 *         &lt;element name="Tax" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}TaxInformation3" minOccurs="0"/&gt;
 *         &lt;element name="RltdRmtInf" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}RemittanceLocation4" minOccurs="0"/&gt;
 *         &lt;element name="RmtInf" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}RemittanceInformation11Wire" minOccurs="0"/&gt;
 *         &lt;element name="SplmtryData" type="{urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06}SupplementaryData1" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditTransferTransaction26Wire", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06", propOrder = {
    "pmtId",
    "pmtTpInf",
    "amt",
    "xchgRateInf",
    "chrgBr",
    "chqInstr",
    "ultmtDbtr",
    "intrmyAgt1",
    "intrmyAgt1Acct",
    "intrmyAgt2",
    "intrmyAgt2Acct",
    "intrmyAgt3",
    "intrmyAgt3Acct",
    "cdtrAgt",
    "cdtrAgtAcct",
    "cdtr",
    "cdtrAcct",
    "ultmtCdtr",
    "instrForCdtrAgt",
    "instrForDbtrAgt",
    "purp",
    "rgltryRptgs",
    "tax",
    "rltdRmtInf",
    "rmtInf",
    "splmtryDatas"
})
public class CreditTransferTransaction26Wire
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "PmtId", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06", required = true)
    protected PaymentIdentification1 pmtId;
    @XmlElement(name = "PmtTpInf", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected PaymentTypeInformation19 pmtTpInf;
    @XmlElement(name = "Amt", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06", required = true)
    protected AmountType4Choice amt;
    @XmlElement(name = "XchgRateInf", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected ExchangeRate1 xchgRateInf;
    @XmlElement(name = "ChrgBr", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    @XmlSchemaType(name = "string")
    protected ChargeBearerType1CodeWire chrgBr;
    @XmlElement(name = "ChqInstr", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected Cheque7 chqInstr;
    @XmlElement(name = "UltmtDbtr", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected PartyIdentification43Wire ultmtDbtr;
    @XmlElement(name = "IntrmyAgt1", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected BranchAndFinancialInstitutionIdentification5Wire intrmyAgt1;
    @XmlElement(name = "IntrmyAgt1Acct", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected CashAccount24 intrmyAgt1Acct;
    @XmlElement(name = "IntrmyAgt2", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected BranchAndFinancialInstitutionIdentification5 intrmyAgt2;
    @XmlElement(name = "IntrmyAgt2Acct", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected CashAccount24 intrmyAgt2Acct;
    @XmlElement(name = "IntrmyAgt3", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected BranchAndFinancialInstitutionIdentification5 intrmyAgt3;
    @XmlElement(name = "IntrmyAgt3Acct", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected CashAccount24 intrmyAgt3Acct;
    @XmlElement(name = "CdtrAgt", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06", required = true)
    protected BranchAndFinancialInstitutionIdentification5Wire cdtrAgt;
    @XmlElement(name = "CdtrAgtAcct", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected CashAccount24 cdtrAgtAcct;
    @XmlElement(name = "Cdtr", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected PartyIdentification43Wire cdtr;
    @XmlElement(name = "CdtrAcct", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected CashAccount24 cdtrAcct;
    @XmlElement(name = "UltmtCdtr", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected PartyIdentification43 ultmtCdtr;
    @XmlElement(name = "InstrForCdtrAgt", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected InstructionForCreditorAgent1 instrForCdtrAgt;
    @XmlElement(name = "InstrForDbtrAgt", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected String instrForDbtrAgt;
    @XmlElement(name = "Purp", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected Purpose2Choice purp;
    @XmlElement(name = "RgltryRptg", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected List<RegulatoryReporting3> rgltryRptgs;
    @XmlElement(name = "Tax", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected TaxInformation3 tax;
    @XmlElement(name = "RltdRmtInf", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected RemittanceLocation4 rltdRmtInf;
    @XmlElement(name = "RmtInf", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected RemittanceInformation11Wire rmtInf;
    @XmlElement(name = "SplmtryData", namespace = "urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06")
    protected List<SupplementaryData1> splmtryDatas;

    /**
     * Gets the value of the pmtId property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentIdentification1 }
     *     
     */
    public PaymentIdentification1 getPmtId() {
        return pmtId;
    }

    /**
     * Sets the value of the pmtId property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentIdentification1 }
     *     
     */
    public void setPmtId(PaymentIdentification1 value) {
        this.pmtId = value;
    }

    /**
     * Gets the value of the pmtTpInf property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTypeInformation19 }
     *     
     */
    public PaymentTypeInformation19 getPmtTpInf() {
        return pmtTpInf;
    }

    /**
     * Sets the value of the pmtTpInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTypeInformation19 }
     *     
     */
    public void setPmtTpInf(PaymentTypeInformation19 value) {
        this.pmtTpInf = value;
    }

    /**
     * Gets the value of the amt property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType4Choice }
     *     
     */
    public AmountType4Choice getAmt() {
        return amt;
    }

    /**
     * Sets the value of the amt property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType4Choice }
     *     
     */
    public void setAmt(AmountType4Choice value) {
        this.amt = value;
    }

    /**
     * Gets the value of the xchgRateInf property.
     * 
     * @return
     *     possible object is
     *     {@link ExchangeRate1 }
     *     
     */
    public ExchangeRate1 getXchgRateInf() {
        return xchgRateInf;
    }

    /**
     * Sets the value of the xchgRateInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExchangeRate1 }
     *     
     */
    public void setXchgRateInf(ExchangeRate1 value) {
        this.xchgRateInf = value;
    }

    /**
     * Gets the value of the chrgBr property.
     * 
     * @return
     *     possible object is
     *     {@link ChargeBearerType1CodeWire }
     *     
     */
    public ChargeBearerType1CodeWire getChrgBr() {
        return chrgBr;
    }

    /**
     * Sets the value of the chrgBr property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeBearerType1CodeWire }
     *     
     */
    public void setChrgBr(ChargeBearerType1CodeWire value) {
        this.chrgBr = value;
    }

    /**
     * Gets the value of the chqInstr property.
     * 
     * @return
     *     possible object is
     *     {@link Cheque7 }
     *     
     */
    public Cheque7 getChqInstr() {
        return chqInstr;
    }

    /**
     * Sets the value of the chqInstr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cheque7 }
     *     
     */
    public void setChqInstr(Cheque7 value) {
        this.chqInstr = value;
    }

    /**
     * Gets the value of the ultmtDbtr property.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification43Wire }
     *     
     */
    public PartyIdentification43Wire getUltmtDbtr() {
        return ultmtDbtr;
    }

    /**
     * Sets the value of the ultmtDbtr property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification43Wire }
     *     
     */
    public void setUltmtDbtr(PartyIdentification43Wire value) {
        this.ultmtDbtr = value;
    }

    /**
     * Gets the value of the intrmyAgt1 property.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification5Wire }
     *     
     */
    public BranchAndFinancialInstitutionIdentification5Wire getIntrmyAgt1() {
        return intrmyAgt1;
    }

    /**
     * Sets the value of the intrmyAgt1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification5Wire }
     *     
     */
    public void setIntrmyAgt1(BranchAndFinancialInstitutionIdentification5Wire value) {
        this.intrmyAgt1 = value;
    }

    /**
     * Gets the value of the intrmyAgt1Acct property.
     * 
     * @return
     *     possible object is
     *     {@link CashAccount24 }
     *     
     */
    public CashAccount24 getIntrmyAgt1Acct() {
        return intrmyAgt1Acct;
    }

    /**
     * Sets the value of the intrmyAgt1Acct property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount24 }
     *     
     */
    public void setIntrmyAgt1Acct(CashAccount24 value) {
        this.intrmyAgt1Acct = value;
    }

    /**
     * Gets the value of the intrmyAgt2 property.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification5 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification5 getIntrmyAgt2() {
        return intrmyAgt2;
    }

    /**
     * Sets the value of the intrmyAgt2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification5 }
     *     
     */
    public void setIntrmyAgt2(BranchAndFinancialInstitutionIdentification5 value) {
        this.intrmyAgt2 = value;
    }

    /**
     * Gets the value of the intrmyAgt2Acct property.
     * 
     * @return
     *     possible object is
     *     {@link CashAccount24 }
     *     
     */
    public CashAccount24 getIntrmyAgt2Acct() {
        return intrmyAgt2Acct;
    }

    /**
     * Sets the value of the intrmyAgt2Acct property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount24 }
     *     
     */
    public void setIntrmyAgt2Acct(CashAccount24 value) {
        this.intrmyAgt2Acct = value;
    }

    /**
     * Gets the value of the intrmyAgt3 property.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification5 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification5 getIntrmyAgt3() {
        return intrmyAgt3;
    }

    /**
     * Sets the value of the intrmyAgt3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification5 }
     *     
     */
    public void setIntrmyAgt3(BranchAndFinancialInstitutionIdentification5 value) {
        this.intrmyAgt3 = value;
    }

    /**
     * Gets the value of the intrmyAgt3Acct property.
     * 
     * @return
     *     possible object is
     *     {@link CashAccount24 }
     *     
     */
    public CashAccount24 getIntrmyAgt3Acct() {
        return intrmyAgt3Acct;
    }

    /**
     * Sets the value of the intrmyAgt3Acct property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount24 }
     *     
     */
    public void setIntrmyAgt3Acct(CashAccount24 value) {
        this.intrmyAgt3Acct = value;
    }

    /**
     * Gets the value of the cdtrAgt property.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification5Wire }
     *     
     */
    public BranchAndFinancialInstitutionIdentification5Wire getCdtrAgt() {
        return cdtrAgt;
    }

    /**
     * Sets the value of the cdtrAgt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification5Wire }
     *     
     */
    public void setCdtrAgt(BranchAndFinancialInstitutionIdentification5Wire value) {
        this.cdtrAgt = value;
    }

    /**
     * Gets the value of the cdtrAgtAcct property.
     * 
     * @return
     *     possible object is
     *     {@link CashAccount24 }
     *     
     */
    public CashAccount24 getCdtrAgtAcct() {
        return cdtrAgtAcct;
    }

    /**
     * Sets the value of the cdtrAgtAcct property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount24 }
     *     
     */
    public void setCdtrAgtAcct(CashAccount24 value) {
        this.cdtrAgtAcct = value;
    }

    /**
     * Gets the value of the cdtr property.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification43Wire }
     *     
     */
    public PartyIdentification43Wire getCdtr() {
        return cdtr;
    }

    /**
     * Sets the value of the cdtr property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification43Wire }
     *     
     */
    public void setCdtr(PartyIdentification43Wire value) {
        this.cdtr = value;
    }

    /**
     * Gets the value of the cdtrAcct property.
     * 
     * @return
     *     possible object is
     *     {@link CashAccount24 }
     *     
     */
    public CashAccount24 getCdtrAcct() {
        return cdtrAcct;
    }

    /**
     * Sets the value of the cdtrAcct property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount24 }
     *     
     */
    public void setCdtrAcct(CashAccount24 value) {
        this.cdtrAcct = value;
    }

    /**
     * Gets the value of the ultmtCdtr property.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification43 }
     *     
     */
    public PartyIdentification43 getUltmtCdtr() {
        return ultmtCdtr;
    }

    /**
     * Sets the value of the ultmtCdtr property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification43 }
     *     
     */
    public void setUltmtCdtr(PartyIdentification43 value) {
        this.ultmtCdtr = value;
    }

    /**
     * Gets the value of the instrForCdtrAgt property.
     * 
     * @return
     *     possible object is
     *     {@link InstructionForCreditorAgent1 }
     *     
     */
    public InstructionForCreditorAgent1 getInstrForCdtrAgt() {
        return instrForCdtrAgt;
    }

    /**
     * Sets the value of the instrForCdtrAgt property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstructionForCreditorAgent1 }
     *     
     */
    public void setInstrForCdtrAgt(InstructionForCreditorAgent1 value) {
        this.instrForCdtrAgt = value;
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
     * Gets the value of the purp property.
     * 
     * @return
     *     possible object is
     *     {@link Purpose2Choice }
     *     
     */
    public Purpose2Choice getPurp() {
        return purp;
    }

    /**
     * Sets the value of the purp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Purpose2Choice }
     *     
     */
    public void setPurp(Purpose2Choice value) {
        this.purp = value;
    }

    /**
     * Gets the value of the rgltryRptgs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rgltryRptgs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRgltryRptgs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegulatoryReporting3 }
     * 
     * 
     */
    public List<RegulatoryReporting3> getRgltryRptgs() {
        if (rgltryRptgs == null) {
            rgltryRptgs = new ArrayList<RegulatoryReporting3>();
        }
        return this.rgltryRptgs;
    }

    /**
     * Gets the value of the tax property.
     * 
     * @return
     *     possible object is
     *     {@link TaxInformation3 }
     *     
     */
    public TaxInformation3 getTax() {
        return tax;
    }

    /**
     * Sets the value of the tax property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxInformation3 }
     *     
     */
    public void setTax(TaxInformation3 value) {
        this.tax = value;
    }

    /**
     * Gets the value of the rltdRmtInf property.
     * 
     * @return
     *     possible object is
     *     {@link RemittanceLocation4 }
     *     
     */
    public RemittanceLocation4 getRltdRmtInf() {
        return rltdRmtInf;
    }

    /**
     * Sets the value of the rltdRmtInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceLocation4 }
     *     
     */
    public void setRltdRmtInf(RemittanceLocation4 value) {
        this.rltdRmtInf = value;
    }

    /**
     * Gets the value of the rmtInf property.
     * 
     * @return
     *     possible object is
     *     {@link RemittanceInformation11Wire }
     *     
     */
    public RemittanceInformation11Wire getRmtInf() {
        return rmtInf;
    }

    /**
     * Sets the value of the rmtInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceInformation11Wire }
     *     
     */
    public void setRmtInf(RemittanceInformation11Wire value) {
        this.rmtInf = value;
    }

    /**
     * Gets the value of the splmtryDatas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the splmtryDatas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSplmtryDatas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplementaryData1 }
     * 
     * 
     */
    public List<SupplementaryData1> getSplmtryDatas() {
        if (splmtryDatas == null) {
            splmtryDatas = new ArrayList<SupplementaryData1>();
        }
        return this.splmtryDatas;
    }

}
