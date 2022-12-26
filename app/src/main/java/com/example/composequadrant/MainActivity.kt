package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeCards()
                }
            }
        }
    }
}

@Composable
fun ComposeCards() {
    Column() {
        Row(Modifier.weight(1f, true)) {
            Column(Modifier.weight(1f, true)) {
                Quadrant(
                    titleRes = R.string.text_title,
                    textRes = R.string.text_text,
                    backgroundColor = Color.Green
                )
            }
            Column(Modifier.weight(1f, true)) {
                Quadrant(
                    titleRes = R.string.image_title,
                    textRes = R.string.image_text,
                    backgroundColor = Color.Yellow
                )
            }
        }
        Row(Modifier.weight(1f, true)) {
            Column(Modifier.weight(1f, true)) {
                Quadrant(
                    titleRes = R.string.row_title,
                    textRes = R.string.row_text,
                    backgroundColor = Color.Cyan
                )
            }
            Column(Modifier.weight(1f, true)) {
                Quadrant(
                    titleRes = R.string.column_title,
                    textRes = R.string.column_text,
                    backgroundColor = Color.LightGray
                )
            }
        }
    }
}

@Composable
fun Quadrant(titleRes: Int, textRes: Int, backgroundColor: Color) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = titleRes),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = stringResource(id = textRes),
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        ComposeCards()
    }
}