package com.Techolution;

/**
 * Created by shrikant on 28/12/2016.
 */


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @RequestMapping("/")
    public String index() {
        String body = this.restTemplate.getForObject("/", String.class);
        assertThat(body).isEqualTo("This is Hell's Kitchen !");
    }
}
