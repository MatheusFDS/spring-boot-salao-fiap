package com.mathex.salonservice.config;

import com.mathex.salonservice.domain.model.Role;
import com.mathex.salonservice.domain.model.User;
import com.mathex.salonservice.domain.repository.RoleRepository;
import com.mathex.salonservice.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Configuration
public class DataLoader {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            if (!userRepository.existsByUsername("admin")) {
                User user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("admin"));
                user.setEnabled(true);

                Set<Role> roles = new HashSet<>();
                Role adminRole = new Role();
                adminRole.setName("ROLE_ADMIN");
                roleRepository.save(adminRole);

                Optional<Role> savedRole = roleRepository.findById(adminRole.getId());
                savedRole.ifPresent(roles::add);

                user.setRoles(roles);
                userRepository.save(user);
            }
        };
    }
}
