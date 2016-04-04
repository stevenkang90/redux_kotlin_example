package com.example.ste.redux_kotlin_example

import java.util.*

/**
 * Created by ska23 on 31/03/16.
 */
abstract class Subscription() {

    companion object {
        private final var EMPTY : Subscription = object : Subscription() {
            override fun unsubscribe() {
                throw UnsupportedOperationException()
            }
        }
    }

        fun empty() : Subscription {
            return EMPTY
        }

        fun create(subscribers : ArrayList<Subscriber>,  subscriber: Subscriber) : Subscription {
            var subscription = object: Subscription() {
                override fun unsubscribe() {
                    subscribers.remove(subscriber)
                }
            };
            return subscription
    }

    abstract fun unsubscribe()


}