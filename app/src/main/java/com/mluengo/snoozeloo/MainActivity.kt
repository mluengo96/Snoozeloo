package com.mluengo.snoozeloo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mluengo.snoozeloo.alarm.presentation.alarm_list.AlarmListScreen
import com.mluengo.snoozeloo.ui.theme.SnoozelooTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SnoozelooTheme(darkTheme = false, dynamicColor = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    AlarmListScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SnoozelooPreview() {
    SnoozelooTheme {
        AlarmListScreen()
    }
}