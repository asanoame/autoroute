package com.xiaoyu.autoroute

object AutoRoute {
    fun <S> load(serviceClass: Class<S>): S {
        return AutoRouteLoader.load(serviceClass)
    }
}