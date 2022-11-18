package com.example.expert.Rest.services;
import java.util.List;
import java.util.Optional;

import com.example.expert.Rest.models.*;
public interface Ipersonne {
    List <Personne> getAll();
    Personne save(Personne personne);
    Personne findPersonneByNom(String nom);
    Personne updatePersonne(Personne personne);
    void delete (Long id);
    Optional<Personne> getPersonneById(long id);
    void saveRoles (AppRoles roles);
    void AddRolesToUser(String rolesName,String nom);

}
