package com.notabarista.authentication.repository;

import com.notabarista.authentication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer> {
public Role findByRole(String role);
}
