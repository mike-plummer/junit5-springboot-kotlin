package com.objectpartners.plummer.states

interface DataBean {
    fun getAllStates(): List<String>
    fun getStatesStartingWith(c: Char?) : List<String>
}
