package com.ciazhar.twoactivity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        private val LOG_TAG = MainActivity::class.java.simpleName
        val EXTRA_MESSAGE = "com.ciazhar.twoactivity.extra.MESSAGE"
        val TEXT_REQUEST = 1
    }
    private var mMessageEditText : EditText?=null
    private var mReplyHeadTextView : TextView?=null
    private var mReplyTextView : TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(LOG_TAG, "-----")
        Log.d(LOG_TAG, "Starting onCreate")

        mMessageEditText = findViewById(R.id.editText_main) as EditText?
        mReplyHeadTextView = findViewById(R.id.text_header_reply) as TextView?
        mReplyTextView = findViewById(R.id.text_message) as TextView?
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")

        var intent = Intent(this, SecondActivity::class.java)
        var message = mMessageEditText?.text.toString()

        intent.putExtra(EXTRA_MESSAGE,message)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode : Int, resultCode : Int, data : Intent){
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== TEXT_REQUEST){
            if (resultCode== Activity.RESULT_OK){
                var reply = data.getStringExtra(SecondActivity.EXTRA_REPLY)
                mReplyHeadTextView?.visibility = View.VISIBLE
                mReplyTextView?.text = reply
                mReplyTextView?.visibility = View.VISIBLE
            }
        }
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

