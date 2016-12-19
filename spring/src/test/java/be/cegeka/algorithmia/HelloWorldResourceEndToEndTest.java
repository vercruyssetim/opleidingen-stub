package be.cegeka.algorithmia;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class HelloWorldResourceEndToEndTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void helloWorld(){
        ResponseEntity<String> result = testRestTemplate.getForEntity("/rest/algorithmia/helloWorld", String.class);

        assertThat(result.getBody()).isEqualTo("hello world from server");
    }
}