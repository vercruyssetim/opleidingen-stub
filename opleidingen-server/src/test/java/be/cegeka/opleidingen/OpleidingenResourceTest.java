package be.cegeka.opleidingen;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpleidingenResourceTest {

    @Inject
    private OpleidingenResource opleidingenResource;

    @Test
    @Ignore
    public void test() {
        Opleiding opleidingen = opleidingenResource.searchOpleiding("419310");
        OpleidingAssert.assertThat(opleidingen)
                .hasName("Adobe Indesign : geavanceerde opmaaktechnieken")
                .hasDoelgroep("Zelfstandige")
                .isErkend(false)
                .hasGetuigschrift(null)
                .hasId("419310");
    }
}