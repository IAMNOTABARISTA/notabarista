package org.notabarista.app.model

import org.springframework.data.jpa.repository.JpaRepository


interface RoleRepository : JpaRepository<UserRole?, Long?>