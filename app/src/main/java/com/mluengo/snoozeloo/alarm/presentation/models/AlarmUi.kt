package com.mluengo.snoozeloo.alarm.presentation.models

import com.mluengo.snoozeloo.alarm.domain.Alarm
import java.time.LocalTime

data class AlarmUi(
    val id: String,
    val label: String,
    val time: LocalTime,
    val enabled: Boolean,
)

fun Alarm.toAlarmUi(): AlarmUi {
    return AlarmUi(
        id = id,
        label = label,
        time = time,
        enabled = enabled
    )
}