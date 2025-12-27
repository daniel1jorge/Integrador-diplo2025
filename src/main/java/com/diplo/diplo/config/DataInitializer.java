package com.diplo.diplo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.diplo.diplo.model.Role;
import com.diplo.diplo.model.User;
import com.diplo.diplo.repository.RoleRepository;
import com.diplo.diplo.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (!roleRepository.existsByName("ROLE_USER")) {
            Role userRole = new Role("ROLE_USER");
            
            roleRepository.save(userRole);
            log.info("Rol ROLE_USER creado");
        }

        if (!roleRepository.existsByName("ROLE_ADMIN")) {
            Role adminRole = new Role("ROLE_ADMIN");
     
            roleRepository.save(adminRole);
            log.info("Rol ROLE_ADMIN creado");
        }
        
        if (!userRepository.existsByEmail("admin@test.com")) {
       
            User adminInitial = new User();
            adminInitial.setEmail("admin@test.com");
            adminInitial.setFirstName("Admin");
            adminInitial.setLastName("Principal");
            adminInitial.setPassword(passwordEncoder.encode("admin123"));
            
            Role roleAdmin = roleRepository.findByName("ROLE_ADMIN")
                    .orElseThrow(() -> new RuntimeException("Error: Role ADMIN no encontrado"));

            adminInitial.getRoles().add(roleAdmin);
            
            userRepository.save(adminInitial);
            
            log.info("user: admin@test.com pass: admin123 - creado correctamente.");
        }
    }
}