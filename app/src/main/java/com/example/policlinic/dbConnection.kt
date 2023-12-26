package com.example.policlinic

import java.sql.Connection
import java.sql.DriverManager
import java.util.Properties

class  Connect
{

 val url = "jdbc:postgresql://172.20.7.8:5432/Policlinic"

val password = "pwd1991"
    val user = "st1991"


private val props = Properties().apply {
    setProperty("user", user)
    setProperty("password", password)
}

fun getConnection(): Connection {
    Class.forName("org.postgresql.Driver")
    return DriverManager.getConnection(url, props)
}
}