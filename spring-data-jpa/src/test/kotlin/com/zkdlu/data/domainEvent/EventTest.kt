package com.zkdlu.data.domainEvent

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class EventTest (
    @Autowired val userRepository: UserRepository,
    @Autowired val userService: UserService,
){

    @Test
    fun test() {
        val user = User(userId = "1", age = 25, created = LocalDateTime.now())
        userRepository.save(user)

        userService.addAge(user.id!!)
    }
}