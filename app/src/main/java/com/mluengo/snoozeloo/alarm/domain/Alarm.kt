package com.mluengo.snoozeloo.alarm.domain

import kotlinx.datetime.LocalTime

data class Alarm(
    val id: String,
    val label: String,
    val time: LocalTime,
    val enabled: Boolean,
)
