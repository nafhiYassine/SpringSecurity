package com.example.expert.Rest.Security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.expert.Rest.Security.filter.JwtAuthenticationFilter;
import com.example.expert.Rest.Security.filter.JwtAutorizationFilter;
import com.example.expert.Rest.models.Personne;
import com.example.expert.Rest.services.PersonneImp;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
  @Autowired
  private PersonneImp personneService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth ) throws Exception{
    auth.userDetailsService(new UserDetailsService() {

      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Personne personne = personneService.findPersonneByNom(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        personne.getAppRoles().forEach(r ->{
            authorities.add(new SimpleGrantedAuthority(r.getRolesName()));
        });
        return new User(personne.getNom(), personne.getPassword(), authorities);
      }
      
    });

  }

  protected void configure(HttpSecurity http)throws Exception{

      http.csrf().disable();
      /*http.formLogin().defaultSuccessUrl("/test/get", true);*/
      http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      http.headers().frameOptions().disable();
      http.authorizeRequests().antMatchers("/login/**").permitAll();
      http.authorizeRequests().antMatchers(HttpMethod.POST,"/test/**").hasAuthority("admin");
      http.authorizeRequests().antMatchers(HttpMethod.GET,"/test/**").hasAuthority("user");
      http.authorizeRequests().anyRequest().authenticated();
      http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean()));
      http.addFilterBefore(new JwtAutorizationFilter(),UsernamePasswordAuthenticationFilter.class);
      }
   
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}

    