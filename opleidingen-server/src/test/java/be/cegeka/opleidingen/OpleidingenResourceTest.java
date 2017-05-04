package be.cegeka.opleidingen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.List;

import static be.cegeka.opleidingen.Opleiding.OpleidingBuilder.anOpleiding;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpleidingenResourceTest {

    @Inject
    private OpleidingenResource opleidingenResource;

    @Test
    public void test() {
        List<Opleiding> opleidingen = opleidingenResource.searchOpleiding("lasser");
        assertThat(opleidingen).hasSize(1);
        assertThat(opleidingen.get(0)).isEqualTo(anOpleiding().withName("lasser").build());
    }
}