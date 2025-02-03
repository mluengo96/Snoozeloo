package com.mluengo.snoozeloo.alarm.presentation.alarm_list

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.mluengo.snoozeloo.ui.theme.LocalSpacing
import com.mluengo.snoozeloo.ui.theme.SnoozelooTheme

@Composable
fun AlarmListScreen(
    modifier: Modifier = Modifier,
) {
    val spacing = LocalSpacing.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        AlarmListContent(
            modifier = Modifier
                .statusBarsPadding()
                .consumeWindowInsets(innerPadding)
        )
    }
}

@Composable
fun AlarmListContent(modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(spacing.spaceMedium),
    ) {
        Text(
            text = "Your Alarms",
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface,
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium)
        ) {
            items(10) {
                ListItem(
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.large)
                        .clickable {

                        },
                    overlineContent = {
                        Text(
                            text = "Wake up",
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
                                text = "10:00",
                                style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface,
                            )
                            Text(
                                text = "AM",
                                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface,
                            )
                        }
                    },
                    supportingContent = {
                        Text(
                            text = "Alarm in 30min",
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    },
                    trailingContent = {
                        Switch(
                            checked = true,
                            onCheckedChange = { }
                        )
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AlarmListScreenPreview() {
    SnoozelooTheme {
        AlarmListScreen(
            modifier = Modifier
        )
    }
}