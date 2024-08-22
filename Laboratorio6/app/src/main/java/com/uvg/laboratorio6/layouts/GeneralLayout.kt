package com.uvg.laboratorio6.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.laboratorio6.ui.theme.Green6
import com.uvg.laboratorio6.ui.theme.Laboratorio6Theme
import com.uvg.laboratorio6.ui.theme.Red6

@Composable
fun Content(){
    var counter by rememberSaveable {
        mutableIntStateOf(0)
    }
    var nIncrements by rememberSaveable {
        mutableIntStateOf(0)
    }
    var nDecrements by rememberSaveable {
        mutableIntStateOf(0)
    }
    var maximumValue by rememberSaveable {
        mutableIntStateOf(0)
    }
    var minimumValue by rememberSaveable {
        mutableIntStateOf(0)
    }
    var totalChanges by rememberSaveable {
        mutableIntStateOf(0)
    }
    val historyItems = remember {
        mutableStateListOf<Pair<String, Color>>()
    }

    Column (
        modifier = Modifier
            .background(Color.LightGray.copy(alpha = 0.6f))
            .fillMaxSize()
            .padding(20.dp)
    ){
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Juan Diego Solís",
                style = TextStyle(
                    fontSize = 28.sp
                )
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Counter(
            counter = counter,
            onIncrement = {
                counter++
                nIncrements++
                totalChanges++
                historyItems.add(Pair(counter.toString(), Green6))
                if (counter > maximumValue) maximumValue = counter
            },
            onDecrement = {
                counter--
                nDecrements++
                totalChanges++
                historyItems.add(Pair(counter.toString(), Red6))
                if (counter < minimumValue) minimumValue = counter
            }
        )
        Spacer(modifier = Modifier.height(25.dp))
        Statistics(
            nIncrements = nIncrements,
            nDecrements = nDecrements,
            maximumValue = maximumValue,
            minimumValue = minimumValue,
            totalChanges = totalChanges
        )

        History(
            items = historyItems,
            onReset = {
                counter = 0
                nIncrements = 0
                nDecrements = 0
                maximumValue = 0
                minimumValue = 0
                totalChanges = 0
                historyItems.clear()
            }
        )
    }
}

@Composable
private fun Counter(
    modifier: Modifier = Modifier,
    counter: Int,
    onIncrement: ()-> Unit,
    onDecrement: ()-> Unit,
){
    Row (
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Button(
            onClick = onDecrement,
            shape = CircleShape,
            modifier = Modifier.size(40.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = "-",
                style = TextStyle(
                    fontSize = 30.sp
                )
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = "$counter",
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(modifier = Modifier.width(20.dp))
        Button(
            onClick = onIncrement,
            shape = CircleShape,
            modifier = Modifier.size(40.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(text = "+",
                style = TextStyle(
                    fontSize = 25.sp
                ))
        }
    }
}

@Composable
private fun Statistics(
    modifier: Modifier = Modifier,
    nIncrements: Int,
    nDecrements: Int,
    maximumValue: Int,
    minimumValue: Int,
    totalChanges: Int,
    ){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column (
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            Text(
                text = "Total incrementos: ",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Total decrementos: ",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Valor máximo: ",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Valor mínimo: ",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Total cambios: ",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Historial: ",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Column (
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(11.dp)
        ){
            Text(
                text = "$nIncrements",
                style = TextStyle(
                    fontSize = 20.sp,
                )
            )
            Text(
                text = "$nDecrements",
                style = TextStyle(
                    fontSize = 20.sp,
                )
            )
            Text(
                text = "$maximumValue",
                style = TextStyle(
                    fontSize = 20.sp,
                )
            )
            Text(
                text = "$minimumValue",
                style = TextStyle(
                    fontSize = 20.sp,
                )
            )
            Text(
                text = "$totalChanges",
                style = TextStyle(
                    fontSize = 20.sp,
                )
            )
        }
    }
}

@Composable
private fun History(
    items: List<Pair<String, Color>>,
    onReset: () -> Unit
) {
    val columns = 5
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Spacer(modifier = Modifier.height(10.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items.size) {
                    index -> val (value, color) = items[index]
                Box(
                    modifier = Modifier
                        .width(60.dp)
                        .height(40.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(color),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = value,
                        style = TextStyle(
                            color = Color.White
                        ))
                }
            }
        }
        TextButton(
            onClick = { onReset() },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = "Reiniciar",
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewInformation() {
    Laboratorio6Theme {
        Surface {
            Content()
        }
    }
}