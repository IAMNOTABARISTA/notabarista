package org.notabarista.app.model

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository

//  Since we’ve extended UserRepository from JpaRepository interface, all the CRUD methods on User entity is readily available to us
@Repository
interface  UserRepository : JpaRepository<User,Long>

