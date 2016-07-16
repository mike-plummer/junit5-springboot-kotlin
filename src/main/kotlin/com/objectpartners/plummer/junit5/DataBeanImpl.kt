package com.objectpartners.plummer.junit5

import org.springframework.stereotype.Component

@Component
open class DataBeanImpl: DataBean {
    override fun getAllStates() : List<String> {
        return DATA
    }

    override fun getStatesStartingWith(c: Char) : List<String> {
        return DATA.filter { state -> state.startsWith(c) }.toList()
    }
}
