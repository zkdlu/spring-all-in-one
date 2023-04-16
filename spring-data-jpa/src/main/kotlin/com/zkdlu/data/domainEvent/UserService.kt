package com.zkdlu.data.domainEvent

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    val userRepository: UserRepository
){

    @Transactional
    fun addAge(id: Long) {
        userRepository.findByIdOrNull(id)?.let {
            it.addAge()
            userRepository.save(it)
        }
    }
}