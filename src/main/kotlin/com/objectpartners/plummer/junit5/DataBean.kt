package com.objectpartners.plummer.junit5

interface DataBean {
    fun getAllStates(): List<String>
    fun getStatesStartingWith(c: Char) : List<String>
}
