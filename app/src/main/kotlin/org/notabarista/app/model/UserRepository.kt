package org.notabarista.app.model
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
@Repository
interface  UserRepository : CrudRepository<User,Long>

