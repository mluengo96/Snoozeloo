package com.mluengo.snoozeloo.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.mluengo.snoozeloo.alarm.presentation.alarm_list.AlarmListViewModel
import com.mluengo.snoozeloo.alarm.data.local.LocalAlarmDataSource
import com.mluengo.snoozeloo.alarm.domain.AlarmDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind

val appModule = module {
    singleOf(::LocalAlarmDataSource).bind<AlarmDataSource>()

    viewModelOf(::AlarmListViewModel)
}