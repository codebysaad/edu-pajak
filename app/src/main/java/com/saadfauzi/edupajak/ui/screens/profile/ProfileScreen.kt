package com.saadfauzi.edupajak.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.saadfauzi.edupajak.R
import com.saadfauzi.edupajak.ui.components.TopAppBar

@Composable
fun ProfileScreen() {
    TopAppBar()
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(R.drawable.profile), contentDescription = null, modifier = Modifier
                .size(200.dp)
                .clip(
                    CircleShape
                ))

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Saad Fauzi", style = MaterialTheme.typography.h6)
            Text(text = "saadfauzi.sf@gmail.com", color = Color.Gray)
        }
    }
}