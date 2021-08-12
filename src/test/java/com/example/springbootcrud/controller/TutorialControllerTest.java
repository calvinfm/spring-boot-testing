package com.example.springbootcrud.controller;

import com.example.springbootcrud.model.Tutorial;
import com.example.springbootcrud.repository.TutorialRepository;
import org.jboss.jandex.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.OutputStream;
import java.util.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TutorialController.class)
class TutorialControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TutorialController tutorialController;

    @Test
    void getAllTutorials() throws Exception {
        Tutorial tutorial = new Tutorial();
        tutorial.setTitle("The Big Tutor");
        tutorial.setDescription("Tutor");
        tutorial.setPublished(true);

        Tutorial tutorial2 = new Tutorial();
        tutorial2.setTitle("The Small Tutor");
        tutorial2.setDescription("Desc Tutor");
        tutorial2.setPublished(false);

        List<Tutorial> tutorialss = new ArrayList<Tutorial>();
        tutorialss.add(tutorial);
        tutorialss.add(tutorial2);

        ResponseEntity<List<Tutorial>> tutorials =
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(tutorialss);

        given(tutorialController.getAllTutorials("")).willReturn(tutorials);

        mvc.perform(get("/api/tutorials").param("title","")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id", is(tutorial.getId())))
                .andExpect(jsonPath("$[0].title", is(tutorial.getTitle())));
    }

    @Test
    void getTutorialById() {
    }

    @Test
    void createTutorial() {
    }

    @Test
    void updateTutorial() {
    }

    @Test
    void deleteTutorial() {
    }

    @Test
    void deleteAllTutorials() {
    }

    @Test
    void findByPublished() {
    }
}