package com.example.expert.Rest.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

 
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Personne {
   
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom ;
    private String prenom ;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private int age ;
    private float salaire ;
    @ManyToMany(fetch =  FetchType.EAGER)
    private Collection<AppRoles> appRoles= new ArrayList<>();

    public Personne(String nom, String prenom,String password, int age, float salaire, Collection<AppRoles> appRoles) {
        this.nom = nom;
        this.prenom = prenom;
        this.password=password;
        this.age = age;
        this.salaire = salaire;
        this.appRoles = appRoles;
    } 

    


}
