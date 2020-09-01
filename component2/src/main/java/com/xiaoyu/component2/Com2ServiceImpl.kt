package com.xiaoyu.component2

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import com.google.auto.service.AutoService
import com.xiaoyu.base.ICom2Service

@AutoService(ICom2Service::class)
class Com2ServiceImpl : ICom2Service {
    override fun start(context: Context) {
        context.startActivity(Intent().apply {
            component = ComponentName(context, Com2Activity::class.java)
        })
    }
}