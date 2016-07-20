package com.objectpartners.plummer.states

import org.springframework.stereotype.Component
import org.springframework.util.Assert

@Component
class FibonacciServiceImpl: FibonacciService {
    override fun fibonacci(max: Long): List<Long> {
        Assert.isTrue(max > 0)
        return generateSequence (0L to 1L, { previous -> previous.second to previous.first + previous.second})
            .takeWhile { result -> result.second <= max }
            .map {result -> result.second}
            .toList()
    }
}