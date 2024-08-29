package com.veterinaria.entity;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    // Relación bidireccional opcional
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    // Implementación del método de GrantedAuthority
    @Override
    public String getAuthority() {
        return name;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

   
}
