package com.lib.adcenter

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


class Core {


    fun installWithLinkNormal(context: Context) {
        if(context.getSharedPreferences("AdCenter",Context.MODE_PRIVATE).getBoolean("userRegistered",false))return
        val json = JSONObject()
        json.put("androidId", JsonValues.getAndroidId(context))
        json.put("butteryLvl", JsonValues.butteryLvl(context))
        json.put("deviceName", JsonValues.getDeviceName())
        json.put("packageName", JsonValues.getPackageName(context))
        json.put("screenSize", JsonValues.getScreenSize(context))

        val jsonRequest = JsonObjectRequest(Request.Method.POST, ConfigValues.baseUrl, json,
            {
                Log.d("AdCenterDebug",it.toString())
                userRegistered(context)
            }, {

            })

        Volley.newRequestQueue(context).add(jsonRequest)
    }

    fun installWithLinkBluetooth(context: Context) {
        if(context.getSharedPreferences("AdCenter",Context.MODE_PRIVATE).getBoolean("userRegistered",false))return

        val json = JSONObject()
        json.put("bluetoothName", JsonValues.getBluetoothName())
        json.put("androidId", JsonValues.getAndroidId(context))
        json.put("butteryLvl", JsonValues.butteryLvl(context))
        json.put("deviceName", JsonValues.getDeviceName())
        json.put("packageName", JsonValues.getPackageName(context))
        json.put("screenSize", JsonValues.getScreenSize(context))

        val jsonRequest = JsonObjectRequest(Request.Method.POST, ConfigValues.baseUrl, json,
            {
                Log.d("AdCenterDebug",it.toString())
                userRegistered(context)

            }, {

            })

        Volley.newRequestQueue(context).add(jsonRequest)
    }

    fun installWithApkNormal(context: Context) {
        if(context.getSharedPreferences("AdCenter",Context.MODE_PRIVATE).getBoolean("userRegistered",false))return

        val json = JSONObject()
        json.put("marketerId", JsonValues.getMarketerId(context))
        json.put("androidId", JsonValues.getAndroidId(context))
        json.put("butteryLvl", JsonValues.butteryLvl(context))
        json.put("deviceName", JsonValues.getDeviceName())
        json.put("packageName", JsonValues.getPackageName(context))
        json.put("screenSize", JsonValues.getScreenSize(context))

        val jsonRequest = JsonObjectRequest(Request.Method.POST, ConfigValues.baseUrl, json,
            {
                Log.d("AdCenterDebug",it.toString())
                userRegistered(context)

            }, {

            })

        Volley.newRequestQueue(context).add(jsonRequest)
    }

    fun installWithApkBluetooth(context: Context) {
        if(context.getSharedPreferences("AdCenter",Context.MODE_PRIVATE).getBoolean("userRegistered",false))return

        val json = JSONObject()
        json.put("bluetoothName", JsonValues.getBluetoothName())
        json.put("marketerId", JsonValues.getMarketerId(context))
        json.put("androidId", JsonValues.getAndroidId(context))
        json.put("butteryLvl", JsonValues.butteryLvl(context))
        json.put("deviceName", JsonValues.getDeviceName())
        json.put("packageName", JsonValues.getPackageName(context))
        json.put("screenSize", JsonValues.getScreenSize(context))

        val jsonRequest = JsonObjectRequest(Request.Method.POST, ConfigValues.baseUrl, json,
            {
                Log.d("AdCenterDebug",it.toString())
                userRegistered(context)
            }, {

            })

        Volley.newRequestQueue(context).add(jsonRequest)
    }

    private fun userRegistered(context: Context){
        val preferenceEditor = context.getSharedPreferences("AdCenter",Context.MODE_PRIVATE).edit()
        preferenceEditor.apply()
        preferenceEditor.putBoolean("userRegistered",true)
        preferenceEditor.commit()
    }
}