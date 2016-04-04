package com.example.ste.redux_kotlin_example

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.example.ste.redux_kotlin_example.actions.ActionCreator
import com.example.ste.redux_kotlin_example.state.GlobalState
import com.example.ste.redux_kotlin_example.state.StateContainer

class MainActivity : AppCompatActivity(), Subscriber  {



    override fun onStateChanged(value : Int) {
        val textView = findViewById(R.id.counter_textview) as TextView
        textView.text = "$value"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar?
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton?
        fab?.setOnClickListener(View.OnClickListener { view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() })

        val increaseButton = findViewById(R.id.increase_button) as Button
        increaseButton.setOnClickListener(View.OnClickListener { view -> ActionCreator.increaseCount() })

        val decreaseButton = findViewById(R.id.decrease_button) as Button
        decreaseButton.setOnClickListener(View.OnClickListener { view -> ActionCreator.decreateCount() })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()

        StateContainer.addSubscriber(this)
    }

    override fun onPause() {
        super.onPause()
        StateContainer.removeSubscriber(this)
    }

}
