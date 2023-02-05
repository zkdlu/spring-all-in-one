package com.zkdlu.cloud.feign

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TargetApi {

    @GetMapping("/demo")
    fun getDemo(): String {
        return "Hello"
    }

    @GetMapping("/target")
    fun getTarget(): Target {
        return Target("zkdlu");
    }

    @GetMapping("/read-timeout")
    fun getReadTimeout(): String {

        Thread.sleep(3000)

        return "Read Timeout"
    }
}

data class Target(
    val name: String,
);