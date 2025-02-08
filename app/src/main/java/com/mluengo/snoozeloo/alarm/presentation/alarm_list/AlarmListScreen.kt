package com.mluengo.snoozeloo.alarm.presentation.alarm_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.mluengo.snoozeloo.alarm.domain.Alarm
import com.mluengo.snoozeloo.alarm.presentation.models.toAlarmUi
import com.mluengo.snoozeloo.core.presentation.util.timeLeft
import com.mluengo.snoozeloo.core.presentation.util.toDisplayableTimeLeft
import com.mluengo.snoozeloo.ui.theme.LocalSpacing
import com.mluengo.snoozeloo.ui.theme.SnoozelooTheme
import kotlinx.datetime.LocalTime

@Composable
fun AlarmListScreen(
    modifier: Modifier = Modifier,
    state: AlarmListState
) {
    val spacing = LocalSpacing.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(spacing.spaceSmall)
                    .wrapContentSize()
                    .clip(MaterialTheme.shapes.extraLarge)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    contentDescription = "Add Alarm",
                    modifier = Modifier.scale(1.25f, 1.25f)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        if (state.isLoading) {

        } else if (state.alarms.isEmpty()) {
            AlarmEmptyContent()
        } else {
            AlarmListContent(
                modifier = Modifier
                    .statusBarsPadding()
                    .consumeWindowInsets(innerPadding),
                state = state
            )
        }
    }
}

@Composable
fun AlarmListContent(
    modifier: Modifier = Modifier,
    state: AlarmListState,
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = spacing.spaceLarge,
                start = spacing.spaceMedium,
                end = spacing.spaceMedium
            ),
    ) {
        Text(
            text = "Your Alarms",
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface,
        )
        Spacer(modifier = Modifier.height(spacing.spaceLarge))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium)
        ) {
            items(state.alarms) { alarm ->
                val amPmMarker = alarm.displayTime.substringAfter(" ", "")
                val time12H = alarm.displayTime

                val timeLeft = timeLeft(alarm.time.hour, alarm.time.minute).toDisplayableTimeLeft()

                ListItem(
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.large)
                        .clickable {

                        },
                    overlineContent = {
                        Text(
                            text = alarm.label,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                    },
                    headlineContent = {
                        Row(
                            modifier = Modifier.padding(vertical = spacing.spaceSmall),
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Text(
                                text = time12H.removeSuffix(amPmMarker),
                                style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface,
                            )
                            Text(
                                text = amPmMarker,
                                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface,
                            )
                        }
                    },
                    supportingContent = {
                        Text(
                            text = "Alarm in $timeLeft",
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    },
                    trailingContent = {
                        Switch(
                            checked = alarm.enabled,
                            onCheckedChange = { }
                        )
                    },
                )
            }
        }
    }
}

@Composable
fun AlarmEmptyContent(
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = "It's empty! Add the first alarm so you don't miss an important moment!",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AlarmListScreenPreview() {
    SnoozelooTheme {
        AlarmListScreen(
            state = AlarmListState(
                alarms = (1..10).map {
                    previewAlarm.copy(id = it.toString())
                }
            ),
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background),
        )
    }
}

internal val previewAlarm = Alarm(
    id = "alarm",
    label = "Wake up",
    time = LocalTime(4, 40),
    enabled = true
).toAlarmUi()