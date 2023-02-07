package com.zkdlu.cloud.feign

import org.springframework.stereotype.Service

@Service
class FeignService(
    private val targetClient: TargetClient,
) {
    fun getDemo(): String {
        return targetClient.getDemo()
    }

    fun getTarget(): Target {
        return targetClient.getTarget()
    }

    fun getReadTimeout(): String {
        return targetClient.getReadTimeout()
    }

    fun getOtherTarget(): Other {
        return targetClient.getOtherTarget()
    }
}