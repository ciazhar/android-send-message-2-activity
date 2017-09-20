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
        // log untuk main activity
        private val LOG_TAG = MainActivity::class.java.simpleName
        // key untuk menampung message yang akan di kirim ke second activiy
        val EXTRA_MESSAGE = "com.ciazhar.twoactivity.extra.MESSAGE"
        /// jumlah text request
        val TEXT_REQUEST = 1
    }
    /// 3 variabel dibawah merupakan implementasi dari view
    private var mMessageEditText : EditText?=null
    private var mReplyHeadTextView : TextView?=null
    private var mReplyTextView : TextView?=null

    /**
     * Method untuk inisialisasi logic pada view
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        ///inisialisasi
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// pesan log
        Log.d(LOG_TAG, "-----")
        Log.d(LOG_TAG, "Starting onCreate")

        ///inisialisasi variabel dari view
        mMessageEditText = findViewById(R.id.editText_main) as EditText?
        mReplyHeadTextView = findViewById(R.id.text_header_reply) as TextView?
        mReplyTextView = findViewById(R.id.text_message) as TextView?

        ///tracking state
        if(savedInstanceState!=null){
            val isVisible : Boolean = savedInstanceState.getBoolean("reply_visible")
            if(isVisible){
                mReplyHeadTextView?.visibility = View.VISIBLE
                mReplyTextView?.text = savedInstanceState.getString("reply_text")
                mReplyTextView?.visibility = View.VISIBLE
            }
        }
    }

    /**
     *  Method untuk menuju ke activity kedua
     */
    fun launchSecondActivity(view: View) {
        ///log
        Log.d(LOG_TAG, "Button clicked!")

        /// intent digunakan untuk action ke second activity
        val intent = Intent(this, SecondActivity::class.java)

        /// mengambil value dari Edit Text
        val message = mMessageEditText?.text.toString()

        ///menambahkan message ke intent
        intent.putExtra(EXTRA_MESSAGE,message)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    //  Methode kebawah merupakan methode untuk debugging state

    override fun onActivityResult(requestCode : Int, resultCode : Int, data : Intent){
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== TEXT_REQUEST){
            if (resultCode== Activity.RESULT_OK){
                val reply = data.getStringExtra(SecondActivity.EXTRA_REPLY)
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

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if(mReplyHeadTextView?.visibility ==View.VISIBLE){
            outState?.putBoolean("reply_visible",true)
            outState?.putString("reply_text",mReplyTextView?.text.toString())
        }
    }

}

