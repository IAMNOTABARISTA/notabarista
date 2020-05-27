package org.notabarista.app


import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


class Data
{
    var message:String = "I am not a barista app"
    var id:Int = 42;
}

@CrossOrigin("http://localhost:4200")
@RestController
class MainController {
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
}