package com.mluengo.snoozeloo.alarm.presentation.alarm_list

import androidx.compose.runtime.Immutable
import com.mluengo.snoozeloo.alarm.presentation.models.AlarmUi

@Immutable
data class AlarmListState(
    val isLoading: Boolean = false,
    val alarms: List<AlarmUi> = emptyList(),
    val selectedAlarm: AlarmUi? = null
)