package com.example.ste.redux_kotlin_example.reducers

import com.example.ste.redux_kotlin_example.actions.CounterAction
import com.example.ste.redux_kotlin_example.state.GlobalState
import com.example.ste.redux_kotlin_example.state.StateContainer

/**
 * Created by ska23 on 30/03/16.
 */
class Reducer() {
    companion object {
        fun handleAction(action: CounterAction, state : GlobalState) : GlobalState{

            var copiedState : GlobalState
            when(action.type){
                CounterAction.INCREASE_STRING -> copiedState = state.copyAndSetState(1)
                CounterAction.DECREASE_STRING -> copiedState = state.copyAndSetState(-1)
                else -> copiedState = GlobalState()
            }
            return copiedState
        }
    }
}