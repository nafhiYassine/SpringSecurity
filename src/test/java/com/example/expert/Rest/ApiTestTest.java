package com.example.expert.Rest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.*;
import com.example.expert.Rest.models.Personne;
import com.example.expert.Rest.services.PersonneImp;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
public class ApiTestTest {

    @Autowired
	private MockMvc mockMvc;
    
    @MockBean
    private PersonneImp RepoPersonneTest;
	

    Personne p1= new Personne("yassine","nafhi","yassine",24,20000,new ArrayList<>());
    Personne p2= new Personne("mounir","nafhi","yassine",24,20000,new ArrayList<>());
    Personne p3= new Personne("anass","nafhi","yassine",24,20000,new ArrayList<>());
    /**
     * @throws Exception
     */
    @Test
    void testGetHelloJava() throws Exception {
        this.mockMvc.perform(get("/apiV2/string")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("heyJava")));
    }


    @Test
    void testGetTest() throws Exception {
        List<Personne> records = new ArrayList<>(Arrays.asList(p1, p2, p3));
    
        Mockito.when(RepoPersonneTest.getAll()).thenReturn(records);
        
        mockMvc.perform(MockMvcRequestBuilders
                .get("/apiV2/get")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].nom", is("anass")));
        
    }
    
    
 
    
 
    
}
