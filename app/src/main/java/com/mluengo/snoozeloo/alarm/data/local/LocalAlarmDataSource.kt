package com.mluengo.snoozeloo.alarm.data.local

import com.mluengo.snoozeloo.alarm.domain.Alarm
import com.mluengo.snoozeloo.alarm.domain.AlarmDataSource

class LocalAlarmDataSource() : AlarmDataSource {
    override suspend fun getAlarms(): Result<List<Alarm>> {
        TODO("Not yet implemented")
    }
}