package com.xiaoyu.autoroute.utils

import android.os.Process;
import android.util.Log
import com.xiaoyu.autoroute.BuildConfig

object LogUtils {

    private val DEBUG = BuildConfig.DEBUG

    @JvmStatic
    fun i(tag: String = getFileLineMethod(), msg: String, tr: Throwable? = null) {
        if (DEBUG)
            Log.i(tag, msg, tr)
    }

    @JvmStatic
    fun d(tag: String = getFileLineMethod(), msg: String, tr: Throwable? = null) {
        if (DEBUG)
            Log.d(tag, msg, tr)
    }

    @JvmStatic
    fun e(tag: String = getFileLineMethod(), msg: String, tr: Throwable? = null) {
        if (DEBUG)
            Log.e(tag, msg, tr)
    }

    @JvmStatic
    fun v(tag: String = getFileLineMethod(), msg: String, tr: Throwable? = null) {
        if (DEBUG)
            Log.v(tag, msg, tr)
    }

    @JvmStatic
    fun w(tag: String = getFileLineMethod(), msg: String, tr: Throwable? = null) {
        if (DEBUG)
            Log.w(tag, msg, tr)
    }

    private fun getFileLineMethod() = run {
        val traceElement =
            Exception().stackTrace[2]
        StringBuffer("").append(traceElement.fileName)
            .append(" | ")
            .append(Thread.currentThread().id)
            .append(" | ")
            .append(traceElement.lineNumber)
            .append(" | ")
            .append(traceElement.methodName)
            .append("").toString()
    }

    private fun getLineMethod() = run {
        val traceElement =
            Exception().stackTrace[2]
        StringBuffer("").append(traceElement.lineNumber)
            .append(" | ")
            .append(Process.myTid().toString() + "")
            .append(" | ")
            .append(traceElement.methodName)
            .append("").toString()
    }
}