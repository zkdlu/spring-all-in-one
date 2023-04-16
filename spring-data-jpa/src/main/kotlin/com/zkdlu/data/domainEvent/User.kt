package com.zkdlu.data.domainEvent

import org.springframework.data.domain.AbstractAggregateRoot
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "users")
@Entity
class User(
    val userId: String,
    var age: Int,
    val created: LocalDateTime,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) : AbstractAggregateRoot<User>() {

    fun addAge() {
        this.age++;
        registerEvent(MyEvent(this, "age: $age"))
    }

}