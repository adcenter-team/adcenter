package com.lib.adcenter

import org.json.JSONObject
import java.io.BufferedReader
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder


class Core {


    fun pushData() {

        val serverURL: String = "your URL"
        val url = URL(serverURL)
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "POST"
        connection.connectTimeout = 300000
        connection.connectTimeout = 300000
        connection.doOutput = true

        val jsonParam = JSONObject()

        jsonParam.put("ID", "25");
        jsonParam.put("description", "Real");
        jsonParam.put("enable", "true");

        connection.setRequestProperty("charset", "utf-8")
        //    connection.setRequestProperty("Content-lenght", postData.size.toString())
        connection.setRequestProperty("Content-Type", "application/json")

        try {
            val outputStream = DataOutputStream(connection.outputStream)
            outputStream.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"))
            outputStream.flush()
        } catch (exception: Exception) {

        }

        if (connection.responseCode != HttpURLConnection.HTTP_OK && connection.responseCode != HttpURLConnection.HTTP_CREATED) {
            try {
                val inputStream: DataInputStream = DataInputStream(connection.inputStream)
                val reader: BufferedReader = BufferedReader(InputStreamReader(inputStream))
                val output: String = reader.readLine()

                println("There was error while connecting the chat $output")
                System.exit(0)

            } catch (exception: Exception) {
                throw Exception("Exception while push the notification  $exception.message")
            }
        }

    }

}