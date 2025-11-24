package org.example.psychosolution.service;

import org.example.psychosolution.repository.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateService implements UserDetailsService {

    @Autowired
    private PacientesRepository pacientesRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return pacientesRepository.findPacientesByEmail(email).orElseThrow(()-> new UsernameNotFoundException("Usuario ou senha invalido"));
    }
}
