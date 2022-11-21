package com.ramadan.financeui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramadan.financeui.ui.theme.*

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(CustomDarkGray, CustomLightGreen)
                )
            )
            .padding(25.dp)
        ,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.more),
                    contentDescription = "menu",
                    modifier = Modifier.size(30.dp),
                    tint = Color.White
                )
            }

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        width = 1.dp,
                        color = CustomOrange,
                        shape = RoundedCornerShape(20f)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ram),
                    contentDescription = "profile_image",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(5.dp))
                )
            }

        }

        Column {
            Text(
                text = "Hello, Ramadan",
                fontSize = 30.sp,
                color = Color.White,
                fontFamily = FontFamily(
                    Font(R.font.ubuntu)
                )
            )

            Text(
                text = "Welcome Back",
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = FontFamily(
                    Font(R.font.ubuntu)
                )
            )
        }

            ProfileInfoCard(
                heading = "Sales",
                subHeading = "Total Sales Today",
                valueText = "$500",
                percentage = 55,
                color = CustomOrange,
                isIncreasing = true
            )

            ProfileInfoCard(
                heading = "Profit",
                subHeading = "Per day ratio",
                valueText = "$150",
                percentage = 30,
                color = CustomGreen,
                isIncreasing = false
            )

            ProfileInfoCard(
                heading = "Orders",
                subHeading = "Total Order Today",
                valueText = "1250",
                percentage = 80,
                color = CustomCyan,
                isIncreasing = true
            )


    }
}



@Composable
fun ProfileInfoCard(
    heading: String,
    subHeading: String,
    valueText: String,
    percentage: Int,
    color: Color,
    isIncreasing: Boolean
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .fillMaxWidth()
            .height(130.dp)
            .background(Color.White.copy(alpha = 0.1f))
            .padding(
                start = 30.dp,
                top = 10.dp,
                end = 10.dp,
                bottom = 10.dp
            )
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .weight(7f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = heading,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.ubuntu)),
                    color = Color.White
                )
                Text(
                    text = subHeading,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.ubuntu)),
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = valueText,
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.ubuntu)),
                    color = color
                )
            }
            Box(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight()
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Arrow",
                    tint = color,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .rotate(if (isIncreasing) -45f else 45f)
                )
                Text(
                    text = "$percentage%",
                    modifier = Modifier.align(Alignment.Center),
                    fontFamily = FontFamily(Font(R.font.ubuntu)),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = color
                )
                Canvas(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(70.dp)
                ) {
                    drawArc(
                        color = color,
                        startAngle = -120f,
                        sweepAngle = 360 * percentage / 100f,
                        useCenter = false,
                        style = Stroke(
                            width = 10f,
                            cap = StrokeCap.Round
                        )
                    )
                }
            }
        }
    }
}
