package com.mluengo.snoozeloo.alarm.domain

import java.time.LocalTime

data class Alarm(
    val id: String,
    val label: String,
    val time: LocalTime,
    val enabled: Boolean,
)
