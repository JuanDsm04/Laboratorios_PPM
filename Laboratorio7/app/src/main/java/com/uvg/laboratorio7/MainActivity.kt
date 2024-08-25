package com.uvg.laboratorio7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.saveable.rememberSaveable
import com.uvg.ejercicioslabs.ejercicios.agosto19.generateFakeNotifications
import com.uvg.laboratorio7.layouts.Content
import com.uvg.laboratorio7.ui.theme.Laboratorio7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio7Theme {
                Surface {
                    val notifications = rememberSaveable { generateFakeNotifications() }
                    Content(notifications)
                }
            }
        }
    }
}