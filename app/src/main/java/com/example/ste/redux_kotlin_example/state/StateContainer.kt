package com.example.ste.redux_kotlin_example.state

import com.example.ste.redux_kotlin_example.Subscriber
import com.example.ste.redux_kotlin_example.actions.CounterAction
import com.example.ste.redux_kotlin_example.reducers.Reducer
import java.util.*

/**
 * Created by ska23 on 31/03/16.
 */
object StateContainer {
    private var subscribers : ArrayList<Subscriber> = ArrayList()
    private var instance : GlobalState = GlobalState()



    fun dispatch(action : CounterAction) {
        //write a switch on the action types
        instance = Reducer.handleAction(action, instance)
        notifyDataSetChanged()

    }
    private fun notifyDataSetChanged() {
        for(subscriber in subscribers) {
            subscriber.onStateChanged(instance.count)
        }
    }

    fun addSubscriber(activity : Subscriber) {
        subscribers.add(activity)
    }

    fun removeSubscriber(activity: Subscriber) {
        subscribers.remove(activity)
    }
}