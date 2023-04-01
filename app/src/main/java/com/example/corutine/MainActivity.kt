package com.example.corutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn:Button=findViewById(R.id.background_btn)
        btn.setOnClickListener {
            lifecycleScope.launch{
                execute("Task executed completely")
            }
        }
    }

    private suspend fun execute(result:String)
    {
        withContext(Dispatchers.IO){
            for (i in 1..100000){
                Log.e("delay",""+i)
            }
        }
        runOnUiThread {
            Toast.makeText(
                this, result,Toast.LENGTH_SHORT
            ).show()
        }
    }
}