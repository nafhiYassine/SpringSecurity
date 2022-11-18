package com.example.expert.Rest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
@Entity
public class AppRoles{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoles;
    @Column
    private String rolesName;
   
    public AppRoles(String rolesName){
        this.rolesName=rolesName;
    }


}