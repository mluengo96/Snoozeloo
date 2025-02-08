package com.mluengo.snoozeloo.core.presentation.util

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun timeLeft(hour: Int, minute: Int): LocalTime {
    val now = Clock.System.now().toLocalDateTime(TimeZone.of("Europe/Madrid"))
    var hoursLeft = hour - now.hour
    val minutesLeft: Int

    if (hoursLeft < 0) {
        hoursLeft += 24
    }

    if (minute == 0) {
        minutesLeft = 60 - now.minute
    } else if (minute < now.minute) {
        minutesLeft = now.minute - minute
    } else {
        minutesLeft = minute - now.minute
    }

    return LocalTime(hoursLeft, minutesLeft)
}

fun LocalTime.toDisplayableTimeLeft(): String {
    val format = LocalTime.Format {
        hour()
        chars("h ")
        minute()
        chars("min")
    }
    return format.format(this)
}