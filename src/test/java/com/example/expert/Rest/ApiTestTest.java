package com.example.expert.Rest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
public class ApiTestTest {

    @Autowired
	private MockMvc mockMvc;

	
    /**
     * @throws Exception
     */
    @Test
    void testGetHelloJava() throws Exception {
        this.mockMvc.perform(get("/apiV2/string")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("heyJava")));
    }
    
    
 
    
 
    
}
