package be.cegeka.opleidingen;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Opleiding {
    private String name;

    public String getName() {
        return name;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public boolean equals(Object object){
        return EqualsBuilder.reflectionEquals(this, object);
    }

    public static class OpleidingBuilder {
        private String name;

        public static OpleidingBuilder anOpleiding() {
            return new OpleidingBuilder();
        }

        public Opleiding build() {
            Opleiding opleiding = new Opleiding();
            opleiding.name = this.name;
            return opleiding;
        }

        public OpleidingBuilder withName(String name) {
            this.name = name;
            return this;
        }
    }
}
