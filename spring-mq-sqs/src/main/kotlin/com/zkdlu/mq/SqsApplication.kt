package com.zkdlu.mq

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SqsApplication

fun main(args: Array<String>) {
    runApplication<SqsApplication>(*args)
}
