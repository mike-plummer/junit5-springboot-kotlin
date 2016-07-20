package com.objectpartners.plummer.states.junit4;

import com.objectpartners.plummer.states.ApplicationTest
import com.objectpartners.plummer.states.FibonacciService
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner


@RunWith(SpringJUnit4ClassRunner::class)
class FibonacciTest: ApplicationTest() {

    @Autowired lateinit var fibonacciSvc: FibonacciService

    @Test
    fun testValidInputs() {
        assertEquals(fibonacciSvc.fibonacci(100), listOf<Long>(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89))
        assertEquals(fibonacciSvc.fibonacci(1), listOf<Long>(1, 1))
    }

    @Test(expected = IllegalArgumentException::class)
    fun testZeroInput() {
        fibonacciSvc.fibonacci(0L)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testNegativeInput() {
        fibonacciSvc.fibonacci(-1L)
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
    @Ignore //Don't run this test! It takes waaaaay too long!!!!
    fun largeLoadTest() {
        val max: Long = Long.MAX_VALUE;
        // Try a million values to make sure we don't have crazy-low fail limits
        val result: List<Long> = fibonacciSvc.fibonacci(max)

        if (result.filter { value -> value <= 0 || value > max }.any()) {
            fail("Invalid sequence")
        }
    }
}
