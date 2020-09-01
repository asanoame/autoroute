package com.xiaoyu.autoroute

import com.xiaoyu.autoroute.utils.LogUtils
import java.util.*

internal object AutoRouteLoader {
    private val sServiceMap = mutableMapOf<String, Any>()

    @Suppress("UNCHECKED_CAST")
    fun <S> load(serviceClass: Class<S>): S {
        LogUtils.d(msg = "开始加载--${serviceClass.name}")
        val service = sServiceMap[serviceClass.name]
        if (service != null) {
            LogUtils.d(msg = "缓存中存在，取缓存 -- ${service::class.java.name}")
            return service as S
        } else {
            LogUtils.d(msg = "缓存中没有，开始查找实现类...")
        }
        val iterator = ServiceLoader.load(serviceClass).iterator()
        if (iterator.hasNext()) {
            val next = iterator.next()
            if (iterator.hasNext()) {
                throw RuntimeException("${serviceClass.simpleName} 只能有一个实现")
            } else {
                sServiceMap[serviceClass.name] = next!! as Any
                LogUtils.d(msg = "找到实现类(${(next as Any)::class.java.name}),加入缓存，key = ${serviceClass.name}")
                return next
            }
        } else {
            throw RuntimeException("${serviceClass.simpleName} 没有实现")
        }
    }
}