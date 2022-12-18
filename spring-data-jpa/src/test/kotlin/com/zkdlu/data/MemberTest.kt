package com.zkdlu.data

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MemberTest {

    @Test
    fun `멤버 이름은 빈 값이 들어올 수 없다`() {
        assertThrows<IllegalArgumentException> {
            Member.fixture(name = "")
        }
    }
}