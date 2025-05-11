package com.etsub.jetpackcomposeassignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.etsub.jetpackcomposeassignment1.sample.CoursesData
import com.etsub.jetpackcomposeassignment1.screen.CourseListScreen
import com.etsub.jetpackcomposeassignment1.ui.theme.JetpackComposeAssignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAssignment1Theme {
                CourseListScreen(courses = CoursesData)
            }
        }
    }
}
