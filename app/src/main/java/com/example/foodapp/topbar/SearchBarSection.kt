package com.example.foodapp.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodapp.R
import com.example.foodapp.components.RoundedIcon

@Composable
fun SearchBarSection(
    onFilterClick: () -> Unit
) {

    var text by remember { mutableStateOf("") }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(353.dp)
            .height(40.dp)
            .background(color = Color(0x80C5C5C5), shape = RoundedCornerShape(size = 20.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.material_symbols_search_rounded),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .padding(start = 20.dp, end = 13.dp)
            )

            BasicTextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .height(40.dp),
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF)
                ),
                decorationBox = { innerTextField ->
                    Box(
                        Modifier
                            .background(Color.Transparent),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (text.isEmpty()) {
                            Text(
                                text = "Pizza",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = FontFamily(Font(R.font.inter)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFFFFFFF)
                                )
                            )
                        }
                        innerTextField()
                    }
                }
            )
        }

        SearchBarFilter(onFilterClick)

    }
}

@Composable
fun SearchBarFilter(
    onFilterClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(40.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 30.dp)),
        contentAlignment = Alignment.CenterEnd
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable{
                    onFilterClick()
                }
        ) {
            Text(
                text = "Filter",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000)
                )
            )

            Spacer(modifier = Modifier.width(11.dp))

            RoundedIcon(
                painter = painterResource(R.drawable.mage_filter),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .background(color = Color(0xFFFDD835), shape = RoundedCornerShape(size = 30.dp))
                    .padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun SearchBarSection_Preview() {
    SearchBarSection(
        onFilterClick = {}
    )
}