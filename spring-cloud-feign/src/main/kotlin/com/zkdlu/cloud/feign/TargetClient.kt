package com.zkdlu.cloud.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping


@Component
@FeignClient(name = "target", url = "http://localhost:8080/", fallback = FallbackTargetClient::class)
interface TargetClient {

    @GetMapping("/demo")
    fun getDemo(): String

    @GetMapping("/target")
    fun getTarget(): Target

    @GetMapping("/read-timeout")
    fun getReadTimeout(): String
}