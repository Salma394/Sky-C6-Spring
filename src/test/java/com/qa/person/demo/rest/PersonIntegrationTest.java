package com.qa.person.demo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.person.demo.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PersonIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    // converts JSON to java and java to JSON
    private ObjectMapper mapper;


    @Test
    void testCreate() throws Exception {
//        RequestBuilder req = MockMvcRequestBuilders.post("/create").content("JSON DATA").contentType(MediaType.APPLICATION_JSON);

        Person testPerson = new Person("Jordan", 29, "Trainer");
        String reqBody = this.mapper.writeValueAsString(testPerson);
        System.out.println("PERSON: " + testPerson);
        System.out.println("JSON: " + reqBody);

        RequestBuilder req = post("/create").content(reqBody).contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = status().isCreated();
        testPerson.setId(1);
        String resBody = this.mapper.writeValueAsString(testPerson);
        System.out.println("SAVED PERSON: " + testPerson);
        System.out.println("RES JSON: " + reqBody);
        ResultMatcher checkBody = content().json(resBody);

        mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testCreate2() throws Exception {
        String reqBody = this.mapper.writeValueAsString(new Person("Jordan", 29, "Trainer"));

        String resBody = this.mapper.writeValueAsString(new Person(2, "Jordan", 29, "Trainer"));

        mvc.perform(post("/create").content(reqBody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andExpect(content().json(resBody));
    }
}
