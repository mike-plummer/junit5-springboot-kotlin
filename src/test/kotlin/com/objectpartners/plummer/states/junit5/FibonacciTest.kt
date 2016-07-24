package com.objectpartners.plummer.states.junit5;

import com.objectpartners.plummer.states.ApplicationTest
import com.objectpartners.plummer.states.FibonacciService
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit.jupiter.SpringExtension

@Tag("Fibonacci")
@ExtendWith(SpringExtension::class)
class FibonacciTest: ApplicationTest() {

    @Autowired lateinit var fibonacciSvc: FibonacciService

    @Nested
    @Tag("inputs")
    inner class testInputValueOf {
        @Test
        fun largePositive() {
            val result: List<Long> = fibonacciSvc.fibonacci(100);
            assertEquals(result, listOf<Long>(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89))
        }

        @Test fun one() {
            val result: List<Long> = fibonacciSvc.fibonacci(1)
            assertEquals(result, listOf<Long>(1, 1))
        }

        @Test fun zero() {
            assertThrows(IllegalArgumentException::class.java, { fibonacciSvc.fibonacci(0L) })
        }

        @Test fun negative() {
            assertThrows(IllegalArgumentException::class.java, { fibonacciSvc.fibonacci(-1L) })
        }
    }

    @Test
    fun mediumLoadTest() {
        val max: Long = 1000000;
        // Try a million values to make sure we don't have crazy-low fail limits
        val result: List<Long> = fibonacciSvc.fibonacci(max)

        if (result.filter { value -> value <= 0 || value > max }.any()) {
            fail("Invalid sequence")
        }
    }

    @Test
    @Disabled   //Don't run this test! It takes waaaaay too long!!!!
    @DisplayName("Crazy-long computational test to demonstrate that streams are super awesome")
    fun largeLoadTest() {
        val max: Long = Long.MAX_VALUE;
        val result: List<Long> = fibonacciSvc.fibonacci(max)

        if (result.filter { value -> value <= 0 || value > max }.any()) {
            fail("Invalid sequence")
        }
    }
}
