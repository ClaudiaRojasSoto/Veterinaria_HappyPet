package com.veterinaria;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.veterinaria.entity.Role;
import com.veterinaria.entity.User;
import com.veterinaria.repository.RoleRepository;
import com.veterinaria.repository.UserRepository;

@SpringBootApplication
public class HappyPetApplication implements CommandLineRunner{
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(HappyPetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    // Crear roles si no existen
	    createRoleIfNotFound("ROLE_ADMINISTRADOR");
	    createRoleIfNotFound("ROLE_ASISTENTE");
	    createRoleIfNotFound("ROLE_MEDICO");

	    // Crear usuarios con cada rol
	    createUserWithRole("adminuser", "admin", "ROLE_ADMINISTRADOR");
	    createUserWithRole("asistenteuser", "asistente", "ROLE_ASISTENTE");
	    createUserWithRole("medicouser", "medico", "ROLE_MEDICO");
	}
	private void createUserWithRole(String username, String password, String roleName) {
	    // Verificar si el usuario ya existe
	    Optional<User> existingUserOptional = userRepository.findByUsername(username);
	    if (!existingUserOptional.isPresent()) {
	        System.out.println("Usuario '" + username + "' no existe. Creando...");
	        User newUser = new User();
	        newUser.setUsername(username);
	        newUser.setPassword(passwordEncoder.encode(password));

	        // Asignar rol al usuario
	        Set<Role> roles = new HashSet<>();
	        Role userRole = roleRepository.findByName(roleName).orElseThrow(() -> new RuntimeException("Role " + roleName + " not found"));
	        roles.add(userRole);
	        newUser.setRoles(roles);

	        userRepository.save(newUser);
	        System.out.println("Usuario creado con rol " + roleName);
	    } else {
	        System.out.println("El usuario '" + username + "' ya existe.");
	    }
	}
	private void createRoleIfNotFound(String roleName) {
	    if (!roleRepository.findByName(roleName).isPresent()) {
	        Role role = new Role();
	        role.setName(roleName);
	        roleRepository.save(role);
	        System.out.println("Rol " + roleName + " creado.");
	    }
	}
}



