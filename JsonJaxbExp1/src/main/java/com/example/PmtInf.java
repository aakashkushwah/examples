
package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "InstrForDbtrAgt"
})
public class PmtInf {

    @JsonProperty("InstrForDbtrAgt")
    private String instrForDbtrAgt;

    @JsonProperty("InstrForDbtrAgt")
    public String getInstrForDbtrAgt() {
        return instrForDbtrAgt;
    }

    @JsonProperty("InstrForDbtrAgt")
    public void setInstrForDbtrAgt(String instrForDbtrAgt) {
        this.instrForDbtrAgt = instrForDbtrAgt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("instrForDbtrAgt", instrForDbtrAgt).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(instrForDbtrAgt).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PmtInf) == false) {
            return false;
        }
        PmtInf rhs = ((PmtInf) other);
        return new EqualsBuilder().append(instrForDbtrAgt, rhs.instrForDbtrAgt).isEquals();
    }

}
