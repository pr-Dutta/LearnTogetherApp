package com.example.learntogetherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogetherapp.ui.theme.LearnTogetherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnTogetherApp()
                }
            }
        }
    }
}

@Composable
fun LearnTogetherApp() {
    ArticleCard(
        title = stringResource(R.string.title_of_jetpack_compose),
        shortDescription = stringResource(R.string.jetpack_compose_intro),
        longDescription = stringResource(R.string.jetpack_compose_description),
        imagePainter = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
private fun ArticleCard(
    title: String,
    shortDescription: String,
    longDescription:String,
    imagePainter: Painter,                          // new
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )

        Text(
            text = title,
            modifier = modifier
                .padding(16.dp),
            fontSize = 24.sp
        )

        Text(
            text = shortDescription,
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify               // new (21-01-2024)
        )

        Text(
            text = longDescription,
            modifier = modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify               // new (21-01-2024)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "LearnTogetherApp"
)
@Composable
fun AppUiPreview() {
    LearnTogetherAppTheme {
        LearnTogetherApp()
    }
}