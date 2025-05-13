package com.example.androiddasar

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class HelloTest {

    @Test
    fun testSayHello() {
        val result = Hello.sayHello("Eko")
        Assert.assertEquals("Hello Eko", result)
    }

}