package com.lib.adcenter

import android.content.Context

class AdCenter {
    companion object{
        fun initWithLinkNormal(context: Context,key:String){
            Core().installWithLinkNormal(context,key)
        }
        fun initWithLinkBluetooth(context: Context,key: String){
            Core().installWithLinkBluetooth(context,key)
        }
        fun initWithApkNormal(context: Context,key: String){
            Core().installWithApkNormal(context,key)
        }
        fun initWithApkBluetooth(context: Context,key: String){
            Core().installWithApkBluetooth(context,key)
        }
    }
}