package com.mubarak.tmdb.ui.screens.dashboard.movies.details.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mubarak.tmdb.ui.theme.Green
import com.mubarak.tmdb.ui.theme.MustardYellow
import com.mubarak.tmdb.ui.theme.Ruby

@Composable
fun CircularProgressbar(
    number: Float?,
    numberStyle: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    size: Dp = 120.dp,
    indicatorThickness: Dp = 16.dp,
    animationDuration: Int = 1000,
    animationDelay: Int = 0,
    backgroundIndicatorColor: Color = Color.LightGray.copy(alpha = 0.3f)
) {

    // Number Animation
    val animateNumber = animateFloatAsState(
        targetValue = number ?: 0f,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        ), label = ""
    )

    // Set the green and red colors
    val foregroundIndicatorColor = if (animateNumber.value >= 75) {
        Green
    } else if (animateNumber.value >= 40){
        MustardYellow
    } else {
        Ruby
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = size)
    ) {
        Canvas(
            modifier = Modifier
                .size(size = size)
        ) {

            // Background circle
            drawCircle(
                color = backgroundIndicatorColor,
                radius = size.toPx() / 2,
                style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Round)
            )

            val sweepAngle = (animateNumber.value / 100) * 360

            // Foreground circle
            drawArc(
                color = foregroundIndicatorColor,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(indicatorThickness.toPx(), cap = StrokeCap.Round)
            )
        }

        // Text that shows number inside the circle
        Text(
            text = (animateNumber.value).toInt().toString() + "%",
            style = numberStyle,
            color = foregroundIndicatorColor  // Set text color same as foreground indicator color
        )
    }

    Spacer(modifier = Modifier.height(32.dp))

}