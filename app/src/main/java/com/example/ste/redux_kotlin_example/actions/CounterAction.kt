package com.example.ste.redux_kotlin_example.actions

/**
 * Created by ska23 on 29/03/16.
 */
class CounterAction(type : String = CounterAction.INCREASE_STRING, value : Int = 1){
    companion object {
        const val INCREASE_STRING : String = "increase"
        const val DECREASE_STRING : String = "decrease"
    }
    val type  : String = type;
    val value : Int = value;
}