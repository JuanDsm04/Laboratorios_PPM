package com.uvg.laboratorio7.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.ejercicioslabs.ejercicios.agosto19.Notification
import com.uvg.ejercicioslabs.ejercicios.agosto19.generateFakeNotifications
import com.uvg.laboratorio7.ui.theme.Laboratorio7Theme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.uvg.ejercicioslabs.ejercicios.agosto19.NotificationType
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatDate(date: Date): String {
    val sdf = SimpleDateFormat("dd MMM - hh:mm a", Locale("es", "ES"))
    return sdf.format(date)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(notificationList: List<Notification>) {
    var selectedType by rememberSaveable { mutableStateOf<NotificationType?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f))
    ) {
        TopAppBar(
            title = {
                Text("Notificaciones")
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            ),
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        )

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Tipos de notificaciones")
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    NotificationFilterChip(
                        isSelected = selectedType== NotificationType.GENERAL,
                        label = "General",
                        onClick = {
                            selectedType = if (selectedType == NotificationType.GENERAL) null else NotificationType.GENERAL
                        }
                    )
                }
                item {
                    NotificationFilterChip(
                        isSelected = selectedType ==NotificationType.NEW_POST,
                        label = "Nuevo Post",
                        onClick = {
                            selectedType = if (selectedType == NotificationType.NEW_POST) null else NotificationType.NEW_POST
                        }
                    )
                }
                item {
                    NotificationFilterChip(
                        isSelected = selectedType == NotificationType.NEW_MESSAGE,
                        label = "Nuevo Mensaje",
                        onClick = {
                            selectedType = if (selectedType ==NotificationType.NEW_MESSAGE) null else NotificationType.NEW_MESSAGE
                        }
                    )
                }
                item {
                    NotificationFilterChip(
                        isSelected = selectedType == NotificationType.NEW_LIKE,
                        label = "Nuevo Like",
                        onClick = {
                            selectedType = if (selectedType ==NotificationType.NEW_LIKE) null else NotificationType.NEW_LIKE
                        }
                    )
                }
            }

            val filteredNotifications = if (selectedType == null) {
                notificationList
            } else {
                notificationList.filter { it.type == selectedType }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                items(filteredNotifications.size) {
                    index -> NotificationCard(filteredNotifications[index])
                }
            }
        }
    }
}

@Composable
fun NotificationFilterChip(
    isSelected:Boolean,
    label: String,
    onClick: () -> Unit
) {
    FilterChip(
        selected = isSelected,
        onClick = onClick,
        label = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (isSelected){
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Selected",
                        modifier = Modifier.size(18.dp)
                    )
                }
                Text(label)
            }
        },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
            selectedLeadingIconColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Composable
private fun NotificationCard(notification: Notification) {

    val iconType = when (notification.type) {
        NotificationType.GENERAL -> Icons.Default.Notifications
        NotificationType.NEW_LIKE  -> Icons.Default.ThumbUp
        NotificationType.NEW_POST -> Icons.Default.Star
        NotificationType.NEW_MESSAGE -> Icons.Default.Email
    }

    val backgroundIconColor = when (notification.type) {
        NotificationType.GENERAL -> MaterialTheme.colorScheme.primary
        NotificationType.NEW_POST -> MaterialTheme.colorScheme.secondary
        NotificationType.NEW_MESSAGE  -> MaterialTheme.colorScheme.tertiary
        NotificationType.NEW_LIKE -> MaterialTheme.colorScheme.error
    }

    val iconColor = when (notification.type) {
        NotificationType.GENERAL -> MaterialTheme.colorScheme.onPrimary
        NotificationType.NEW_POST -> MaterialTheme.colorScheme.onSecondary
        NotificationType.NEW_MESSAGE -> MaterialTheme.colorScheme.onTertiary
        NotificationType.NEW_LIKE  -> MaterialTheme.colorScheme.onError
    }

    Box(
        modifier = Modifier.fillMaxWidth()
    ){
        Row (
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = backgroundIconColor,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    iconType,
                    contentDescription = null,
                    tint = iconColor
                )
            }
            Column {
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Text(
                        text = notification.title,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = formatDate(notification.sendAt),
                        style = TextStyle(
                            fontSize = 12.sp
                        )
                    )
                }
                Row {
                    Text(
                        text = notification.body,
                        style = TextStyle(
                            fontSize = 14.sp
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewInformation() {
    Laboratorio7Theme {
        Surface {
            val notifications = rememberSaveable { generateFakeNotifications() }
            Content(notifications)
        }
    }
}