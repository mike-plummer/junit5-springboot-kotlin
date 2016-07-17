package com.objectpartners.plummer.states

import org.springframework.stereotype.Component

@Component
open class DataBeanImpl: DataBean {
    override fun getAllStates() : List<String> {
        return DATA
    }

    override fun getStatesStartingWith(c: Char?) : List<String> {
        if (c == null) {
            throw IllegalArgumentException("Character cannot be null");
        }
        return DATA.filter { state -> state.startsWith(c) }.toList()
    }
}
