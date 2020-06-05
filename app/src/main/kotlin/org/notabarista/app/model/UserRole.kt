package org.notabarista.app.model

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.ManyToMany

@Entity
@Table(name = "users_role")
class UserRole (@Id @GeneratedValue var id: Long = 0, var username: String = "", @ManyToMany(mappedBy = "roles") var users: Set<User> ){

}