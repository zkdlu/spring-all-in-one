package com.zkdlu.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoApi {

    @GetMapping("/demo")
    fun demo(): String {
        return "hello"
    }
}