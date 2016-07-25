package com.objectpartners.plummer.junit5

interface FibonacciService {
    /**
     * Return the fibonacci sequence up until the sequence numbers exceed the maximum value supplied.
     * For example, specifying '9' would return {1, 1, 2, 3, 5, 8} since '8' is the largest number in
     * the sequence that is less than '9'.
     */
    fun fibonacci(max: Long): List<Long>
}