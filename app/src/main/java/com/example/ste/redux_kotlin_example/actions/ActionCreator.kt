package com.example.ste.redux_kotlin_example.actions

import com.example.ste.redux_kotlin_example.state.GlobalState
import com.example.ste.redux_kotlin_example.state.StateContainer

/**
 * Created by ska23 on 29/03/16.
 */
class ActionCreator() {
    companion object {
        fun increaseCount(){
            var action = CounterAction(CounterAction.INCREASE_STRING, 1);
            StateContainer.dispatch(action)
        }

        fun decreateCount(){
            var action = CounterAction(CounterAction.DECREASE_STRING, 1);
            StateContainer.dispatch(action)
        }
    }

}