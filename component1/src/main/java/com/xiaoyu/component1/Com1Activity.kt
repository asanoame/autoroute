package com.xiaoyu.component1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xiaoyu.autoroute.AutoRoute
import com.xiaoyu.base.ICom2Service
import kotlinx.android.synthetic.main.activity_com1.*

class Com1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_com1)
        to_2_button.setOnClickListener {
            AutoRoute.load(ICom2Service::class.java).start(this)
        }
    }
}