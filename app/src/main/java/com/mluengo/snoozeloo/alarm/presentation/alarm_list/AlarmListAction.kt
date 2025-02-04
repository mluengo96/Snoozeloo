package com.mluengo.snoozeloo.alarm.presentation.alarm_list

import com.mluengo.snoozeloo.alarm.presentation.models.AlarmUi

sealed interface AlarmListAction {
    data class OnAlarmClick(val alarmUi: AlarmUi): AlarmListAction
}