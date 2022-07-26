package com.example.wechat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private var firebaseAuth: FirebaseAuth?=null
    private val splashTime:Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth= FirebaseAuth.getInstance()
        Handler().postDelayed({
            if(firebaseAuth?.currentUser==null)
            {
                startActivity(Intent(this,LoginActivity::class.java))
                finish()
            }
            else{
                startActivity(Intent(this,UsersActivity::class.java))
                finish()
            }
        },splashTime)
    }
}