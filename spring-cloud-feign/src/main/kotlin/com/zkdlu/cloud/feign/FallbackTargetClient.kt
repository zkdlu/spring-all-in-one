package com.zkdlu.cloud.feign

import org.springframework.stereotype.Component

@Component
class FallbackTargetClient: TargetClient {
    override fun getDemo(): String {
        TODO("Not yet implemented")
    }

    override fun getTarget(): Target {
        TODO("Not yet implemented")
    }

    override fun getReadTimeout(): String {
        return "Fallback ReadTimeout"
    }

}
