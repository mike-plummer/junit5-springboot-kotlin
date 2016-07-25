package com.objectpartners.plummer.junit5

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.objectpartners.plummer.junit5")
open class Application

// Main function executes the Application class above as a SpringBoot application.
// Annotations on the class tell Spring where to start looking for beans and other
// Spring-type stuff.
fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
