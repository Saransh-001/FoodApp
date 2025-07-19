package com.example.foodapp.components

import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodapp.R

@Composable
fun OutlineButton(
    icon1: Int? = null,
    icon2: Int? = null,
    text: String
) {
    Row(
        modifier = Modifier
            .border(width = 1.dp, color = Color(0xFF40484E), shape = RoundedCornerShape(size = 10.dp))
            .height(36.dp)
            .padding(start = 5.dp, end = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon1?.let {
            Image(
                painter = painterResource(id = icon1),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )

            Spacer(Modifier.width(3.dp))
        }

        Text(
            text = text,
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(500),
                color = Color(0xFF40484E)
            )
        )

        icon2?.let {
            Spacer(Modifier.width(10.dp))

            Image(
                painter = painterResource(id = icon2),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
        }

    }
}

@Preview
@Composable
fun OutlineButton_Preview() {
    OutlineButton(
        text = "Filter"
    )
}