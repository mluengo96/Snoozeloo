package com.mluengo.snoozeloo.alarm.presentation.alarm_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.mluengo.snoozeloo.R
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
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier
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
            AlarmLoadingContent()
        } else if (state.alarms.isEmpty()) {
            AlarmEmptyContent()
        } else {
            AlarmListContent(
                contentPaddingValues = innerPadding,
                state = state
            )
        }
    }
}

@Composable
fun AlarmListContent(
    modifier: Modifier = Modifier,
    contentPaddingValues: PaddingValues,
    state: AlarmListState,
) {
    val spacing = LocalSpacing.current
    LazyColumn(
        modifier = modifier.padding(horizontal = spacing.spaceMedium),
        contentPadding = contentPaddingValues,
        verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium)
    ) {
        item {
            Spacer(modifier = Modifier.height(spacing.spaceLarge))
            Text(
                text = "Your Alarms",
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface,
            )
        }

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

@Composable
fun AlarmEmptyContent(
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.alarm),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
            contentDescription = "Alarm icon"
        )
        Spacer(modifier = Modifier.height(spacing.spaceLarge))
        Text(
            text = "It's empty! Add the first alarm so you don't miss an important moment!",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Medium),
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun AlarmLoadingContent(
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}

@Preview(showSystemUi = true, device = "spec:parent=pixel_8", showBackground = true)
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
                .background(MaterialTheme.colorScheme.surfaceDim),
        )
    }
}

@Preview(showSystemUi = true, device = "spec:parent=pixel_8", showBackground = true)
@Composable
private fun AlarmListScreenEmptyPreview() {
    SnoozelooTheme {
        AlarmListScreen(
            state = AlarmListState(),
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceDim),
        )
    }
}

@Preview(showSystemUi = true, device = "spec:parent=pixel_8", showBackground = true)
@Composable
private fun AlarmListScreenLoadingPreview() {
    SnoozelooTheme {
        AlarmListScreen(
            state = AlarmListState(isLoading = true),
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceDim),
        )
    }
}

internal val previewAlarm = Alarm(
    id = "alarm",
    label = "Wake up",
    time = LocalTime(4, 40),
    enabled = true
).toAlarmUi()