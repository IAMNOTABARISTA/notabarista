package org.notabarista.app


import org.notabarista.app.model.User
import org.notabarista.app.model.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


class Data
{
    var message:String = "I am not a barista app"
    var id:Int = 42;
}

@CrossOrigin("http://localhost:4200")
@RestController

class MainController {

    @Autowired
    lateinit var repository: UserRepository

    @GetMapping("/")
    fun mainPage(): String
    {
        return "Hello go to notabarista. "
    }
    @GetMapping("/json",produces = [MediaType.APPLICATION_JSON_VALUE])
    fun displayName(): Data
    {
        return Data()
    }

    @GetMapping("/db",produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUser(): Optional<User>?
    {
        return repository.findById(1)
    }
}