package com.ciazhar.twoactivity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    companion object {
        val EXTRA_REPLY = "com.ciazhar.twoactivity.extra.REPLY"
    }

    private var mReply : EditText ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        mReply = findViewById(R.id.editText_second) as EditText

        var intent = intent
        var message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        var textView = findViewById(R.id.text_message) as TextView
        textView.text = message
    }

    fun returnReply(view: View)   {
        var reply = mReply?.text.toString()
        var replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(Activity.RESULT_OK,replyIntent)
        finish()
    }
}
