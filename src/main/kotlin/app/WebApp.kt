package app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import controllers.*
import org.springframework.context.annotation.ComponentScan

@ComponentScan("controllers")
@SpringBootApplication
class WebApp

fun main(args: Array<String>) {
    SpringApplication.run(WebApp::class.java, *args)
}

