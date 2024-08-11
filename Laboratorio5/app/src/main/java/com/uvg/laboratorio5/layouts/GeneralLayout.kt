package com.uvg.laboratorio5.layouts

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.laboratorio5.R
import com.uvg.laboratorio5.ui.theme.Laboratorio5Theme
import androidx.compose.ui.platform.LocalContext
import android.net.Uri
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import com.uvg.laboratorio5.ui.theme.Purple40

@Composable
fun Content(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Box(
        modifier = modifier
            .background(Color.LightGray.copy(alpha = 0.4f))
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.inversePrimary.copy(alpha = 0.4f))
                    .padding(vertical = 8.dp, horizontal = 18.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                IconButton(
                    onClick = {
                        val url = "https://play.google.com/store/apps/details?id=com.instagram.android"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.Blue.copy(alpha = 0.5f))
                        .size(40.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_update),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Text(text = "Actualización disponible")
                TextButton(
                    onClick = {
                        val url = "https://play.google.com/store/apps/details?id=com.instagram.android"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        .background(Color.Transparent, shape = RoundedCornerShape(12.dp))
                ) {
                    Text(
                        text = "Descargar",
                        style = TextStyle(
                            color = Color.Blue.copy(alpha = 0.9f),
                            fontSize = 17.sp
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column (
                    modifier = Modifier,
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ){
                    Text(
                        text = "Miércoles",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp,
                        )
                    )
                    Text(
                        text = "13 de marzo",
                        style = TextStyle(
                            fontSize = 22.sp,
                        )
                    )
                }
                TextButton(
                    onClick = {},
                    modifier = Modifier
                        .border(BorderStroke(2.dp, Color.Black.copy(alpha = 0.5f)), shape = RoundedCornerShape(12.dp))
                        .background(Color.Transparent, shape = RoundedCornerShape(12.dp))
                ) {
                    Text(
                        text = "Terminar jornada",
                        style = TextStyle(
                            color = Purple40,
                            fontSize = 17.sp
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            Box (
                modifier = Modifier
                    .padding(horizontal = 18.dp)
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(15.dp)
            ){
                Column (
                    modifier = modifier,
                    verticalArrangement = Arrangement.spacedBy(18.dp)
                ){
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Column (
                            modifier = modifier,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ){
                            Text(
                                text = "Skillets",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 22.sp,
                                )
                            )
                            Text(
                                text = "Miraflores, 21 avenida Zona 7",
                                style = TextStyle(
                                    fontSize = 17.sp,
                                )
                            )
                            Text(
                                text = "7:00AM 10:00PM",
                                style = TextStyle(
                                    fontSize = 17.sp,
                                    color = Color.Black.copy(alpha = 0.6f)
                                )
                            )
                        }
                        IconButton(
                            onClick = {
                                val url = "https://www.google.com/maps/place/Skillets+%E2%80%A2+Miraflores/@14.6202705,-90.5575698,17z/data=!4m10!1m2!2m1!1sgoogle+maps+skillets+miraflores+guatemala!3m6!1s0x8589a1a57a940005:0xb75b837d5996263!8m2!3d14.6200815!4d-90.5534866!15sCilnb29nbGUgbWFwcyBza2lsbGV0cyBtaXJhZmxvcmVzIGd1YXRlbWFsYSIDiAEBWisiKWdvb2dsZSBtYXBzIHNraWxsZXRzIG1pcmFmbG9yZXMgZ3VhdGVtYWxhkgETYW1lcmljYW5fcmVzdGF1cmFudOABAA!16s%2Fg%2F11gb3w6k13?entry=ttu"
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                context.startActivity(intent)
                            },
                            modifier = Modifier
                                .size(30.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_direction),
                                contentDescription = null,
                                tint = Purple40.copy(alpha = 0.9f),
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ){
                        TextButton(
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "Juan Diego Solís Martínez",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            modifier = Modifier
                                .background(Color.Red.copy(alpha = 0.5f), shape = RoundedCornerShape(10.dp))
                                .weight(1f)
                        ) {
                            Text(
                                text = "Iniciar",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    color = Color.White
                                )
                            )
                        }
                        TextButton(
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "Comida americana\nNormal: QQ",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            modifier = Modifier
                                .background(Color.LightGray.copy(alpha = 0.4f), shape = RoundedCornerShape(10.dp))
                                .weight(1f)
                        ) {
                            Text(
                                text = "Detalles",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    color = Color.Black.copy(alpha = 0.6f)
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewInformation() {
    Laboratorio5Theme {
        Surface {
            Content()
        }
    }
}