package com.lib.adcenter

import android.content.Context

class AdCenter {
    private val core = Core()

    companion object{
        fun initWithLinkNormal(context: Context){
            Core().installWithLinkNormal(context)
        }
        fun initWithLinkBluetooth(context: Context){
            Core().installWithLinkBluetooth(context)
        }
        fun initWithApkNormal(context: Context){
            Core().installWithApkNormal(context)
        }
        fun initWithApkNormalBluetooth(context: Context){
            Core().installWithApkBluetooth(context)
        }
    }
}