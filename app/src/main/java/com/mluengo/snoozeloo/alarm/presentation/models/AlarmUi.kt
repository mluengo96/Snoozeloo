package com.mluengo.snoozeloo.alarm.presentation.models

import com.mluengo.snoozeloo.alarm.domain.Alarm
import kotlinx.datetime.LocalTime
import kotlinx.datetime.format.char

data class AlarmUi(
    val id: String,
    val label: String,
    val time: LocalTime,
    val displayTime: String,
    val enabled: Boolean,
)

fun Alarm.toAlarmUi(): AlarmUi {
    return AlarmUi(
        id = id,
        label = label,
        time = time,
        displayTime = time.toDisplayableTime(),
        enabled = enabled
    )
}

fun LocalTime.toDisplayableTime(): String {
    val format = LocalTime.Format {
        amPmHour()
        char(':')
        minute()
        char(' ')
        amPmMarker("AM", "PM")
    }
    return format.format(this)
}

fun LocalTime.to24hTime(): String {
    val format = LocalTime.Format {
        hour()
        char(':')
        minute()
    }
    return format.format(this)
}

fun String.toLocalTime(): LocalTime {
    val format = LocalTime.Format {
        amPmHour()
        char(':')
        minute()
        char(' ')
        amPmMarker("AM", "PM")
    }

    return format.parse(this)
}