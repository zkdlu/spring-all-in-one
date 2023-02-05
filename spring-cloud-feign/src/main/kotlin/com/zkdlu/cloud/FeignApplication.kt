package com.zkdlu.cloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class FeignApplication

fun main(args: Array<String>) {
    runApplication<FeignApplication>(*args)
}
