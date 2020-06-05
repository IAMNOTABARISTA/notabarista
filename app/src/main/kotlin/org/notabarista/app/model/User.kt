package org.notabarista.app.model


import javax.persistence.*


@Entity
@Table(name = "users_accounts")
data class User(@Id @GeneratedValue var id: Long = 0, var username: String = "", var email: String = "", var password: String = "", var hash: String? = null, var salt: String? = null)
{

    @get:JoinTable(name = "user_role", joinColumns = [JoinColumn(name = "user_id")], inverseJoinColumns = [JoinColumn(name = "role_id")])
    @get:ManyToMany
    var roles: Set<User>? = null

}

