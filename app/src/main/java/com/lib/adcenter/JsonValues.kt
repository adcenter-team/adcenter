package com.lib.adcenter

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Build
import android.provider.Settings.Secure
import android.util.DisplayMetrics
import android.view.WindowManager
import java.io.IOException


class JsonValues {
    companion object {
        @SuppressLint("HardwareIds")
        fun getAndroidId(context: Context): String {
            return Secure.getString(
                context.contentResolver,
                Secure.ANDROID_ID
            )
        }

        fun getDeviceName(): String {
            return Build.MODEL
        }

        fun butteryLvl(context: Context): String {
            val iFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
            val batteryStatus = context.registerReceiver(null, iFilter)
            val level = batteryStatus?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: -1

            return level.toString()
        }

        fun getBluetoothName(): String {
            val bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
            return bluetoothAdapter.name
        }

        fun getScreenSize(context: Context): String {
            val displayMetrics = DisplayMetrics()
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            wm.defaultDisplay.getMetrics(displayMetrics)
            val height = displayMetrics.heightPixels
            val width = displayMetrics.widthPixels

            return "$height/$width"


        }

        fun getPackageName(context: Context): String {
            return context.packageName
        }

        fun getMarketerId(context: Context): String {
            return try {
                context.assets.open("marketerId.txt").bufferedReader().use {
                    it.readText()
                }
            }catch (e: IOException){
                ""
            }

        }
    }
}