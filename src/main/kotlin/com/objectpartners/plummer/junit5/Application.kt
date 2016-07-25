package com.objectpartners.plummer.junit5

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.objectpartners.plummer.junit5")
open class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
