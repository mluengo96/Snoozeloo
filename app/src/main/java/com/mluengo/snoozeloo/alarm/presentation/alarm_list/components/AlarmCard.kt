package com.mluengo.snoozeloo.alarm.presentation.alarm_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mluengo.snoozeloo.ui.theme.LocalSpacing

@Composable
fun AlarmCard(modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current

    Card {
        Box(
            modifier = modifier
                .padding(spacing.spaceMedium)
                .fillMaxWidth()
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column {
                    Text(
                        text = "Wake up",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceSmall))
                    Text(
                        text = "10:00 AM",
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceSmall))
                    Text(
                        text = "Alarm in 30min",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
                Column {
                    Switch(
                        checked = true,
                        onCheckedChange = { }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun AlarmCardPreview() {
    AlarmCard()
}