package com.example.expert.Rest.respo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.expert.Rest.models.Personne;

@Repository
public interface RepositoryJpa extends JpaRepository<Personne,Long>{
    public Personne findPersonneByNom(String nom);
}