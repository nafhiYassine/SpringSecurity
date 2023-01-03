package com.example.expert.Rest.respo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expert.Rest.models.PersonneTest;

public interface RepoPersonneTest extends JpaRepository<PersonneTest,Long> {
    
}
