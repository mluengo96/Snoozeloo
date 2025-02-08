package com.mluengo.snoozeloo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mluengo.snoozeloo.alarm.presentation.alarm_list.AlarmListScreen
import com.mluengo.snoozeloo.alarm.presentation.alarm_list.AlarmListState
import com.mluengo.snoozeloo.alarm.presentation.alarm_list.AlarmListViewModel
import com.mluengo.snoozeloo.alarm.presentation.alarm_list.previewAlarm
import com.mluengo.snoozeloo.ui.theme.SnoozelooTheme
import org.koin.androidx.compose.koinViewModel

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
                    val viewModel: AlarmListViewModel = koinViewModel()
                    val state by viewModel.state.collectAsStateWithLifecycle()
                    AlarmListScreen(
                        state = state
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SnoozelooPreview() {
    SnoozelooTheme {
        AlarmListScreen(
            state = AlarmListState(
                alarms = (1..10).map {
                    previewAlarm.copy(id = it.toString())
                }
            ),
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background),
        )
    }
}