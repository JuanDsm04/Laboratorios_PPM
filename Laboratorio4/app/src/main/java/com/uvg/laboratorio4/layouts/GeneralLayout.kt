// Juan Solís - 23720
package com.uvg.laboratorio4.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.laboratorio4.R
import com.uvg.laboratorio4.ui.theme.Laboratorio4Theme
import com.uvg.laboratorio4.ui.theme.darkGreen

@Composable
fun Information() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkGreen)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.White)
                .padding(22.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.uvg),
                contentDescription = "UVG logo",
                modifier = Modifier
                    .size(300.dp)
                    .align(Alignment.Center)
                    .alpha(0.1f)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Text(
                    text = "Universidad del Valle de Guatemala",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 35.sp
                    ),
                    textAlign = TextAlign.Center,
                )

                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Programación de plataformas móviles, Sección 30",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontSize = 25.sp
                    ),
                    textAlign = TextAlign.Center,
                )

                Spacer(modifier = Modifier.height(25.dp))
                Row(
                    Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "INTEGRANTES",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        ),
                        modifier = Modifier.weight(0.5f),
                        textAlign = TextAlign.Center
                    )
                    Column(
                        modifier = Modifier.weight(0.5f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(text = "Juan Solís", fontSize = 18.sp)
                        Text(text = "Victor Pérez", fontSize = 18.sp)
                    }
                }

                Spacer(modifier = Modifier.height(25.dp))
                Row(
                    Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "CATEDRÁTICO",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(0.5f)
                    )
                    Text(
                        text = "Juan Carlos Durini",
                        fontSize = 18.sp,
                        modifier = Modifier.weight(0.5f),
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(25.dp))
                Text(text = "Juan Solís", fontSize = 18.sp)
                Text(text = "23720", fontSize = 18.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewInformation() {
    Laboratorio4Theme {
        Surface {
            Information()
        }
    }
}