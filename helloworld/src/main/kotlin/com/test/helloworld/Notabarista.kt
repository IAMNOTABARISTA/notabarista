package com.test.helloworld

import lombok.Data
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "notabarista")
@Data
class Notabarista : Serializable {
    @Id
    @Column(name = "id", nullable = false)
    var id: Int? = null

    @Column(name = "name", nullable = false)
    var name: String? = null


    companion object {
        const val serialVersionUID = 1L
    }

    constructor(id: Int?, name:String?){
        this.id = id
        this.name = name
    }
}