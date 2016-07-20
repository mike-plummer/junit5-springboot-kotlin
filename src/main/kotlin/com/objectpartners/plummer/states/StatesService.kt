package com.objectpartners.plummer.states

interface StatesService {
    fun getAllStates(): List<String>
    fun getStatesStartingWith(c: Char?) : List<String>
}
