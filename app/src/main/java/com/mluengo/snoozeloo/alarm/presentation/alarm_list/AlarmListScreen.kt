package com.mluengo.snoozeloo.alarm.presentation.alarm_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mluengo.snoozeloo.alarm.presentation.alarm_list.components.AlarmCard
import com.mluengo.snoozeloo.ui.theme.LocalSpacing

@Composable
fun AlarmListScreen(
    modifier: Modifier = Modifier,
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(spacing.spaceMedium),
    ) {
        Text(
            modifier = modifier,
            text = "Your Alarms",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurface,
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium)
        ) {
            items(10) {
                AlarmCard()
            }
        }
    }
}

@Preview
@Composable
private fun AlarmListScreenPreview() {
    AlarmListScreen(
        modifier = Modifier
    )
}