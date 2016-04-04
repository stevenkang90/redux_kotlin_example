package com.example.ste.redux_kotlin_example.state

import android.app.Activity
import com.example.ste.redux_kotlin_example.ActionListener
import com.example.ste.redux_kotlin_example.Subscriber
import com.example.ste.redux_kotlin_example.actions.CounterAction
import com.example.ste.redux_kotlin_example.reducers.Reducer
import java.util.*

/**
 * Created by ska23 on 29/03/16.
 */
data class GlobalState(val count : Int = 0) {

    fun copyAndSetState(value: Int =0) : GlobalState{
      var global = this.copy(count + value)
        return global
    }

}


