package com.example.expert.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expert.Rest.services.PersonneImp;
import com.example.expert.Rest.models.Personne;

@RestController
@RequestMapping("api")
public class ApiTest {
    @Autowired
    private PersonneImp service;
    
    @GetMapping("/get")
    /*@PostAutorize("hasAutority('user')" */
    public List <Personne> getTest(){
        return service.getAll();

        
    }
}
