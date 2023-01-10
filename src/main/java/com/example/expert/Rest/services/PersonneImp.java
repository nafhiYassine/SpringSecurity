package com.example.expert.Rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.expert.Rest.models.AppRoles;
import com.example.expert.Rest.models.Personne;
import com.example.expert.Rest.respo.AppRolesRepository;
import com.example.expert.Rest.respo.RepositoryJpa;

@Service
@Transactional
public class PersonneImp implements Ipersonne {
    private RepositoryJpa repJpa;
    private AppRolesRepository RepRoles;
    private PasswordEncoder passwordEncoder;
    
    
        public PersonneImp(RepositoryJpa repJpa, AppRolesRepository repRoles, PasswordEncoder passwordEncoder) {
        this.repJpa = repJpa;
        RepRoles = repRoles;
        this.passwordEncoder = passwordEncoder;
    }

        

    @Override
    public Personne save(Personne personne) {
        personne.setPassword(passwordEncoder.encode(personne.getPassword()));
        return repJpa.save(personne);
    }

    @Override
    public Personne updatePersonne(Personne personne) {
        return repJpa.save(personne);
    }

    @Override
    public void delete(Long id) {
        repJpa.deleteById(id);
        
    }

    @Override
    public List<Personne> getAll() {
    
        return repJpa.findAll();
        // userRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public void saveRoles(AppRoles roles) {
        RepRoles.save(roles);
        
    }
    
    @Override
    public Optional<Personne> getPersonneById(long id) {
         return repJpa.findById(id);
    }

    
  @Override
    public void AddRolesToUser(String nom,String rolesName) {
        Personne personne = repJpa.findPersonneByNom(nom);
        AppRoles appRole = RepRoles.findRolesByRolesName(rolesName);
        personne.getAppRoles().add(appRole);
    }



@Override
public Personne findPersonneByNom(String nom) {
    return repJpa.findPersonneByNom(nom);
} 

   

   
    
}
