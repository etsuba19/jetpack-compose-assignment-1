package com.etsub.jetpackcomposeassignment1.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.etsub.jetpackcomposeassignment1.model.Course


@Composable
fun CourseCard(
    course: Course,
    isExpanded: Boolean,
    onExpandToggle: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
//            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { onExpandToggle() },
        elevation = CardDefaults.cardElevation()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(course.title, style = MaterialTheme.typography.titleLarge)

            Row(modifier = Modifier.padding(vertical = 4.dp)) {
                Text("Code: ${course.code}", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.width(16.dp))
                Text("Credit: ${course.creditHours}", style = MaterialTheme.typography.bodyMedium)
            }



            Column(
                modifier = Modifier
                    .animateContentSize(
                        animationSpec = tween(durationMillis = 300)
                    )
            ) {
                if (isExpanded) {

                    Spacer(modifier = Modifier.height(20.dp))

                    Text("Description:", style = MaterialTheme.typography.titleLarge)
                    Text(course.description)
                    Spacer(Modifier.height(32.dp))
                    Text("Prerequisites: ${course.prerequisites}")
                }

            }

        }
    }
}

