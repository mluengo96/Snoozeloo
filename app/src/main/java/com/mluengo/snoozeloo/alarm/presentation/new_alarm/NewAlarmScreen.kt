package com.mluengo.snoozeloo.alarm.presentation.new_alarm

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.mluengo.snoozeloo.ui.theme.LocalSpacing
import com.mluengo.snoozeloo.ui.theme.SnoozelooTheme
import com.mluengo.snoozeloo.ui.theme.fontStyle16SemiBold
import com.mluengo.snoozeloo.ui.theme.fontStyle52Medium
import com.mluengo.snoozeloo.ui.theme.veryLightGray

@Composable
fun NewAlarmScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
    ) { innerPadding ->
        NewAlarmContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )

    }
}

@Composable
fun NewAlarmContent(modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier.padding(spacing.spaceMedium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBarComponent(
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(spacing.spaceMedium))

        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(spacing.spaceSmall)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(spacing.spaceSmall)
                ) {
                    TextField(
                        value = "16",
                        onValueChange = {},
                        modifier = Modifier
                            .weight(1f),
                        shape = RoundedCornerShape(10.dp),
                        colors = TextFieldDefaults.colors(
                            focusedTextColor = MaterialTheme.colorScheme.primary,
                            unfocusedTextColor = MaterialTheme.colorScheme.primary,
                            focusedContainerColor = MaterialTheme.colorScheme.background,
                            unfocusedContainerColor = MaterialTheme.colorScheme.background,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                        ),
                        textStyle = fontStyle52Medium.copy(textAlign = TextAlign.Center)
                    )
                    Text(":")
                    TextField(
                        modifier = Modifier
                            .weight(1f),
                        value = "45",
                        onValueChange = {},
                        shape = RoundedCornerShape(10.dp),
                        colors = TextFieldDefaults.colors(
                            focusedTextColor = MaterialTheme.colorScheme.primary,
                            unfocusedTextColor = MaterialTheme.colorScheme.primary,
                            focusedContainerColor = MaterialTheme.colorScheme.background,
                            unfocusedContainerColor = MaterialTheme.colorScheme.background,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                        ),
                        textStyle = fontStyle52Medium.copy(textAlign = TextAlign.Center)
                    )
                }
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                Text(
                    text = "Alarm in 7h 15min",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Medium),
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(spacing.spaceMedium))

        AlarmName(

        )
    }
}

@Composable
fun TopAppBarComponent(
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.small)
                .background(veryLightGray)
                .padding(spacing.spaceSmall),
        ) {
            Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = "Cancel new alarm",
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = Color.White,
            )
        }

        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.extraLarge)
                .background(veryLightGray)
                .padding(vertical = spacing.spaceSmall, horizontal = spacing.spaceMedium),
        ) {
            Text(
                text = "Save",
                style = fontStyle16SemiBold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }

    }
}

@Composable
fun AlarmName() {
    val spacing = LocalSpacing.current
    Box(
        modifier = Modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(spacing.spaceSmall)
            )
            .clickable {

            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(spacing.spaceMedium),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Alarm Name",
                style = fontStyle16SemiBold,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Work",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun AlarmNameDialog() {
    val spacing = LocalSpacing.current
    Dialog(onDismissRequest = { }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(spacing.spaceMedium),
            shape = RoundedCornerShape(spacing.spaceMedium),
            colors = CardColors(
                containerColor = Color.White,
                contentColor = Color.White,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(spacing.spaceMedium),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Alarm Name",
                    style = fontStyle16SemiBold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier,
                    textAlign = TextAlign.Center
                )
                OutlinedTextField(
                    modifier = Modifier,
                    value = "Work",
                    onValueChange = {},
                    shape = RoundedCornerShape(spacing.spaceSmall),
                    textStyle = MaterialTheme.typography.bodySmall
                )
                Button(
                    onClick = {},
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(
                        text = "Save",
                        style = fontStyle16SemiBold,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun NewAlarmScreenPreview() {
    SnoozelooTheme {
        NewAlarmScreen()
    }
}

@Preview
@Composable
private fun AlarmNamePreview() {
    SnoozelooTheme {
        AlarmNameDialog()
    }
}