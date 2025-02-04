package com.mluengo.snoozeloo.alarm.domain

interface AlarmDataSource {
    suspend fun getAlarms(): Result<List<Alarm>>
}