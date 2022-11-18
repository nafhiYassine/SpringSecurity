package com.example.expert.Rest.respo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.expert.Rest.models.AppRoles;

@Repository
public interface AppRolesRepository extends JpaRepository<AppRoles,Long> {
     public AppRoles findRolesByRolesName(String rolesName);
     
}
