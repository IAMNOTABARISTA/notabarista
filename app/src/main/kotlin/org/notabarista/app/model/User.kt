package org.notabarista.app.model


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
class User
{
    @Id
    @GeneratedValue
    var id: Long? = null
    var name: String? = null

    constructor() : super() {}

    constructor(id: Long?, name: String?) : super() {
        this.id = id
        this.name = name

    }
    override fun toString(): String {
        return String.format("Student [id=%s, name=%s]", id, name)
    }
}

