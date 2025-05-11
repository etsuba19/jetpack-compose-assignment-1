package com.etsub.jetpackcomposeassignment1.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.etsub.jetpackcomposeassignment1.components.CourseCard
import com.etsub.jetpackcomposeassignment1.model.Course


@Composable
fun CourseListScreen(
    courses: List<Course>
) {


    // Managing the expanded state for each course
    val expandedStates = rememberSaveable { courses.map { mutableStateOf(false) } }

    LazyColumn {
        itemsIndexed(courses) { index, course ->
            CourseCard(
                course = course,
                isExpanded = expandedStates[index].value,
                onExpandToggle = {
                    expandedStates[index].value = !expandedStates[index].value
                }
            )
        }
    }
}
