package com.objectpartners.plummer.states

import java.util.*

fun <T> safeList(value: List<T>?): List<T> {
    if (value == null) {
        return Collections.emptyList()
    }
    return value
}
