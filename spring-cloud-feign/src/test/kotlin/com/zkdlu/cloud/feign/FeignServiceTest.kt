package com.zkdlu.cloud.feign

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FeignServiceTest @Autowired constructor(
    private val feignService: FeignService
){
    @Test
    fun FeignClient_테스트_String_반환() {
        val demo = feignService.getDemo()

        assertThat(demo).isEqualTo("Hello")
    }

    @Test
    fun FeignClient_테스트_Target_반환() {
        val target = feignService.getTarget()

        assertThat(target).isEqualTo(Target("zkdlu"))
    }

    @Test
    fun Read_타임아웃() {
        val readTimeout = feignService.getReadTimeout()

        assertThat(readTimeout).isEqualTo("Fallback ReadTimeout")
    }

    @Test
    fun 반환모델_변경() {
        val otherTarget = feignService.getOtherTarget()

        assertThat(otherTarget).isEqualTo(Other(0))
    }
}