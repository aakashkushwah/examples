
package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "AddtlInf"
})
public class Envlp {

    @JsonProperty("AddtlInf")
    private AddtlInf addtlInf;

    @JsonProperty("AddtlInf")
    public AddtlInf getAddtlInf() {
        return addtlInf;
    }

    @JsonProperty("AddtlInf")
    public void setAddtlInf(AddtlInf addtlInf) {
        this.addtlInf = addtlInf;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("addtlInf", addtlInf).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(addtlInf).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Envlp) == false) {
            return false;
        }
        Envlp rhs = ((Envlp) other);
        return new EqualsBuilder().append(addtlInf, rhs.addtlInf).isEquals();
    }

}
