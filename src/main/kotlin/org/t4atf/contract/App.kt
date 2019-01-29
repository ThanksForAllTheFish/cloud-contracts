package org.t4atf.contract

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class App

fun main(args: Array<String>) {
	runApplication<App>(*args)
}

@RestController
class Controller {
	@GetMapping("/list", produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
	fun links() = mapOf(
		"content" to mapOf(
			"two" to "two",
			"three" to mapOf("six" to "seven")))
}
