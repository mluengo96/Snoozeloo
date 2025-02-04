package com.mluengo.snoozeloo.alarm.presentation.alarm_list

sealed interface AlarmListEvent {
    data class Error(val error: String): AlarmListEvent
}