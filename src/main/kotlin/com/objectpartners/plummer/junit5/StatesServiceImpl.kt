package com.objectpartners.plummer.junit5

import org.springframework.stereotype.Component

@Component
open class StatesServiceImpl : StatesService {
    override fun getAllStates() : List<String> {
        return STATES
    }

    override fun getStatesStartingWith(c: Char?) : List<String> {
        if (c == null) {
            throw IllegalArgumentException("Character cannot be null");
        }
        return STATES.filter { state -> state.startsWith(c) }.toList()
    }
}
