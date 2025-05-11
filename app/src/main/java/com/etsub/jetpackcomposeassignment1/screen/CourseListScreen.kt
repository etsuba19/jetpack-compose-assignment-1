package com.etsub.jetpackcomposeassignment1.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.etsub.jetpackcomposeassignment1.components.CourseCard
import com.etsub.jetpackcomposeassignment1.model.Course


@Composable
fun CourseListScreen(
    courses: List<Course>
) {

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
