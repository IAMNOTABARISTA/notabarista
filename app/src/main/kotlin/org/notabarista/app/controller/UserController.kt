package org.notabarista.app.controller

import org.notabarista.app.model.User
import org.notabarista.app.model.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController (private val userRepository:UserRepository){
    @GetMapping("/login/{id}")
    fun getUser(@PathVariable(value = "id") id: Long): ResponseEntity<User> {
        return userRepository.findById(id).map { id -> ResponseEntity.ok(id) }.orElse(ResponseEntity.notFound().build())
    }

}