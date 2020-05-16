package com.test.server

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


class Test
{
    var name:String = "Default"
    var value:Int = 15
}

@CrossOrigin("http://localhost:4200")
@RestController
class HtmlController {

    @GetMapping("/name",produces = [MediaType.APPLICATION_JSON_VALUE])
    fun displayName(): Test
    {
        val obj = Test()
        obj.name = "Angular + Spring = WTF"
        obj.value = 10

        println(obj.name+" "+obj.value)

        return obj
    }

}