package com.example.expert.Rest;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expert.Rest.em.EmailSender;
import com.example.expert.Rest.models.Personne;
import com.example.expert.Rest.services.PersonneImp;

import lombok.Data;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("test")

public class RestApi{

    @Autowired
    private PersonneImp service;
    
    @Autowired
	private EmailSender emailSender;

    @GetMapping("/get")
    /*@PostAutorize("hasAutority('user')" */
    public List <Personne> getTest(){

        return service.getAll();
    }

    @PostMapping("/register")
    public void resgiterP(@RequestBody Personne personne){
  
        service.save(personne);
        emailSender.sendSimpleMessage();
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id" )Long id){
        service.delete(id);
        
    }
    @GetMapping("/getBy/{id}")
    public Optional<Personne> findById(@PathVariable(name = "id" )Long id){
       
        return  service.getPersonneById(id);
        
    }
    @PostMapping("/addroleuser")
    public void addRoleToUser(@RequestBody FormRolesUser formRolesUser ){
        service.AddRolesToUser(formRolesUser.getNom(), formRolesUser.getRolesName());
    }
    // @PostMapping("/resetPassword/{email}")
    // public void resetPassword(@PathParam("email") String email, HttpServletRequest request) {
    //     // Personne user = repTest.findUserByEmail(email);
    //     // String url = "";
    //     // if(user!=null){
    //     //     String token = UUID.randomUUID().toString();
            
    //     // }
    //     // return url;
    //     System.out.println(email);
    //     System.out.println(request);
    // }


}

@Data
class FormRolesUser{
    private String nom;
    private String rolesName;
}