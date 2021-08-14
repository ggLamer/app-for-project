package com.gglamer.jetpackcompose

import java.net.ServerSocket
import java.net.Socket
import java.util.*

val host = "192.168.117.218"

class parametrs {
    fun send(data: String) {
        try {
            val client = Socket(host, 80)
            client.outputStream.write(data.toByteArray())
            client.close()
        }catch (e: java.net.ConnectException){
            println(e)
        }

        }

    fun gettemp() {
        try {
            val server = ServerSocket(8080)
            println("Server running on port ${server.localPort}")
            val client = server.accept()
            println("Client connected : ${client.inetAddress.hostAddress}")
            val scanner = Scanner(client.inputStream)
            while (scanner.hasNextLine()) {
                var data = scanner.nextLine()
                println(data)
                temp.value = data
                break
            }
            server.close()
        } catch (e: java.net.SocketException) {
            println(e)
        }
    }

    fun gethumidity() {
        try {
            val server = ServerSocket(9090)
            println("Server running on port ${server.localPort}")
            val client = server.accept()
            println("Client connected : ${client.inetAddress.hostAddress}")
            val scanner = Scanner(client.inputStream)
            while (scanner.hasNextLine()) {
                var data = scanner.nextLine()
                println(data)
                humi.value = data
                break
            }
            server.close()
        } catch (e: java.net.SocketException) {
            println(e)
        }
    }
}