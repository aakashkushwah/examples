
package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Envlp"
})
public class SplmtryDatum {

    @JsonProperty("Envlp")
    private Envlp envlp;

    @JsonProperty("Envlp")
    public Envlp getEnvlp() {
        return envlp;
    }

    @JsonProperty("Envlp")
    public void setEnvlp(Envlp envlp) {
        this.envlp = envlp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("envlp", envlp).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(envlp).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SplmtryDatum) == false) {
            return false;
        }
        SplmtryDatum rhs = ((SplmtryDatum) other);
        return new EqualsBuilder().append(envlp, rhs.envlp).isEquals();
    }

}
