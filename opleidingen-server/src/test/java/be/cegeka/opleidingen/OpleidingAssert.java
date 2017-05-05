package be.cegeka.opleidingen;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class OpleidingAssert extends AbstractAssert<OpleidingAssert, Opleiding> {

    private String id;
    private String name;
    private String getuigschrift;
    private String doelgroep;
    private boolean erkend;

    private OpleidingAssert(Opleiding actual) {
        super(actual, OpleidingAssert.class);
    }

    public static OpleidingAssert assertThat(Opleiding actual){
        return new OpleidingAssert(actual);
    }

    public OpleidingAssert hasId(String id) {
        Assertions.assertThat(this.actual.getId()).isEqualTo(id);
        return this;
    }

    public OpleidingAssert hasName(String name) {
        Assertions.assertThat(this.actual.getName()).isEqualTo(name);
        return this;
    }

    public OpleidingAssert hasGetuigschrift(String getuigschrift) {
        Assertions.assertThat(this.actual.getGetuigschrift()).isEqualTo(getuigschrift);
        return this;
    }

    public OpleidingAssert hasDoelgroep(String doelgroep) {
        Assertions.assertThat(this.actual.getDoelgroep()).isEqualTo(doelgroep);
        return this;
    }

    public OpleidingAssert isErkend(boolean erkend) {
        Assertions.assertThat(this.actual.isErkend()).isEqualTo(erkend);
        return this;
    }
}