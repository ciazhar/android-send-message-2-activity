package com.ciazhar.twoactivity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    companion object {
        val EXTRA_REPLY = "com.ciazhar.twoactivity.extra.REPLY"
        private val LOG_TAG = SecondActivity::class.java.simpleName
    }

    private var mReply : EditText ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        mReply = findViewById(R.id.editText_second) as EditText

        val intent = intent
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        val textView = findViewById(R.id.text_message) as TextView
        textView.text = message
    }

    fun returnReply(view: View)   {
        val reply = mReply?.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(Activity.RESULT_OK,replyIntent)
        Log.d(LOG_TAG,"End Second Activity")
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG,"Starting onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG,"Starting onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG,"Starting onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG,"Starting onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG,"Starting onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG,"Starting onDestroy")
    }
}