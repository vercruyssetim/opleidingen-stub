package be.cegeka.opleidingen;


import be.cegeka.elasticsearch.ElasticSearchDocument;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Opleiding implements ElasticSearchDocument {

    private String id;
    private String name;
    private String getuigschrift;
    private String doelgroep;
    private boolean erkend;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getGetuigschrift() {
        return getuigschrift;
    }

    public String getDoelgroep() {
        return doelgroep;
    }

    public boolean isErkend() {
        return erkend;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    public static class OpleidingBuilder {
        private String id = "E0001";
        private String name = "someOpleiding";
        private String getuigschrift = "getuigschrift";
        private String doelgroep = "doelgroep";
        private boolean erkend = false;

        public static OpleidingBuilder anOpleiding() {
            return new OpleidingBuilder();
        }

        public Opleiding build() {
            Opleiding opleiding = new Opleiding();
            opleiding.id = this.id;
            opleiding.name = this.name;
            opleiding.getuigschrift = this.getuigschrift;
            opleiding.doelgroep = this.doelgroep;
            opleiding.erkend = this.erkend;
            return opleiding;
        }

        public OpleidingBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public OpleidingBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public OpleidingBuilder withGetuigschrift(String getuigschrift) {
            this.getuigschrift = getuigschrift;
            return this;
        }

        public OpleidingBuilder withDoelgroep(String doelgroep) {
            this.doelgroep = doelgroep;
            return this;
        }

        public OpleidingBuilder withErkend(boolean erkend) {
            this.erkend = erkend;
            return this;
        }
    }
}
