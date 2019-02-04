
package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "MsgId",
    "CreDtTm",
    "NbOfTxs",
    "InitgPty"
})
public class GrpHdr {

    @JsonProperty("MsgId")
    private String msgId;
    @JsonProperty("CreDtTm")
    private String creDtTm;
    @JsonProperty("NbOfTxs")
    private String nbOfTxs;
    @JsonProperty("InitgPty")
    private InitgPty initgPty;

    @JsonProperty("MsgId")
    public String getMsgId() {
        return msgId;
    }

    @JsonProperty("MsgId")
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    @JsonProperty("CreDtTm")
    public String getCreDtTm() {
        return creDtTm;
    }

    @JsonProperty("CreDtTm")
    public void setCreDtTm(String creDtTm) {
        this.creDtTm = creDtTm;
    }

    @JsonProperty("NbOfTxs")
    public String getNbOfTxs() {
        return nbOfTxs;
    }

    @JsonProperty("NbOfTxs")
    public void setNbOfTxs(String nbOfTxs) {
        this.nbOfTxs = nbOfTxs;
    }

    @JsonProperty("InitgPty")
    public InitgPty getInitgPty() {
        return initgPty;
    }

    @JsonProperty("InitgPty")
    public void setInitgPty(InitgPty initgPty) {
        this.initgPty = initgPty;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("msgId", msgId).append("creDtTm", creDtTm).append("nbOfTxs", nbOfTxs).append("initgPty", initgPty).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(creDtTm).append(initgPty).append(msgId).append(nbOfTxs).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GrpHdr) == false) {
            return false;
        }
        GrpHdr rhs = ((GrpHdr) other);
        return new EqualsBuilder().append(creDtTm, rhs.creDtTm).append(initgPty, rhs.initgPty).append(msgId, rhs.msgId).append(nbOfTxs, rhs.nbOfTxs).isEquals();
    }

}
