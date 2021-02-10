package com.rationalstudio.coroutineexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    val TAG = "MyTag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            val time = measureTimeMillis {
                val result1 = async { AnotherCall() }
                val result2 = async { AnotherCall2() }

                Log.d(TAG,"Result1: ${result1.await()}")
                Log.d(TAG,"Result2: ${result2.await()}")
            }
            Log.d(TAG,"Request time: $time")

        }



    }
    suspend fun AnotherCall(): String{
        delay(2000L)
        return "result"
    }
    suspend fun AnotherCall2(): String{
        delay(2000L)
        return "result"
    }
}