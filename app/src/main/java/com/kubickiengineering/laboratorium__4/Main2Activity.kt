package com.kubickiengineering.laboratorium__4

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import kotlin.concurrent.thread


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()
        thread(true) {

            val yahoo = URL("http://google.com/")
            val `in` = BufferedReader(
                InputStreamReader(
                    yahoo.openStream()
                )
            )

            var inputLine: String = ""

            while (`in`.readLine().also({

                   if (it!=null) inputLine = it
                }) != null) {
                println(inputLine)
            }

            `in`.close()

            runOnUiThread {
                println(inputLine)
                Toast.makeText(this, inputLine, Toast.LENGTH_LONG).show()
            }

        }
    }
}
