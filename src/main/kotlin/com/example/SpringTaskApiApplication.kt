// Lab 6, Step 7: Run and Test (Application Entry)
package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringTaskApiApplication

fun main(args: Array<String>) {
    runApplication<SpringTaskApiApplication>(*args)
}