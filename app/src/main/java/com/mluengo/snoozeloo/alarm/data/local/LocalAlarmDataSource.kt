package com.mluengo.snoozeloo.alarm.data.local

import com.mluengo.snoozeloo.alarm.domain.Alarm
import com.mluengo.snoozeloo.alarm.domain.AlarmDataSource
import kotlinx.datetime.LocalTime

class LocalAlarmDataSource() : AlarmDataSource {
    override suspend fun getAlarms(): Result<List<Alarm>> {
        return Result.success(
            listOf(
                Alarm(
                    id = "wakeup",
                    label = "Wake up",
                    time = LocalTime(12, 0),
                    enabled = true
                ),
                Alarm(
                    id = "meds",
                    label = "Meds",
                    time = LocalTime(0,30),
                    enabled = false
                ),
                Alarm(
                    id = "workout",
                    label = "Workout",
                    time = LocalTime(9, 45),
                    enabled = true
                ),
            )
        )
    }
}