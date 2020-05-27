package org.notabarista.app

import org.notabarista.app.model.User
import org.notabarista.app.model.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppApplication

	@Autowired
	var repository: UserRepository? = null
	fun main(args: Array<String>) {
		runApplication<AppApplication>(*args)
	}

	@Throws(Exception::class)
	 fun run(vararg args: String?) {
		repository?.save(User(1000,"John"))

	}
