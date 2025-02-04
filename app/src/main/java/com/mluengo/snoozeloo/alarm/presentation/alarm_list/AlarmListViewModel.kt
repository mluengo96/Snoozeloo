package com.mluengo.snoozeloo.alarm.presentation.alarm_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mluengo.snoozeloo.alarm.domain.AlarmDataSource
import com.mluengo.snoozeloo.alarm.presentation.models.toAlarmUi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AlarmListViewModel(
    private val alarmDataSource: AlarmDataSource
) : ViewModel() {
    private val _state = MutableStateFlow(AlarmListState())
    val state = _state
        .onStart { loadAlarms() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            AlarmListState()
        )

    private val _events = Channel<AlarmListEvent>()
    val events = _events.receiveAsFlow()

    /*fun onAction(action: AlarmListAction) {
        when (action) {
            is AlarmListAction.OnAlarmClick -> {
                selectAlarm(action.alarmUi)
            }
        }
    }*/

    private fun loadAlarms() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            alarmDataSource
                .getAlarms()
                .onSuccess { alarms ->
                    _state.update { state ->
                        state.copy(
                            isLoading = false,
                            alarms = alarms.map { it.toAlarmUi() }
                        )
                    }

                }
                .onFailure { error ->
                    _state.update { it.copy(isLoading = false) }
                    _events.send(AlarmListEvent.Error(error.message!!))
                }

        }
    }
}