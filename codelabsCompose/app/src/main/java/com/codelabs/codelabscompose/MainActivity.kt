package com.codelabs.codelabscompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelabs.codelabscompose.ui.theme.CodelabsComposeTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodelabsComposeTheme {
//                AroundMC()
                Conversation(SampleData.conversationSample)
            }
        }
    }

    @Composable
    fun MC(msg: MessageCard) {
        Row {
            Image(
                painter = painterResource(R.drawable.cole),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    .padding(all = 5.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, Color.DarkGray)
            )

            var isExpanded by remember { mutableStateOf(false) }
            val surfaceColor: Color by animateColorAsState(
                if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
            )
            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body1
                )
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    elevation = 1.dp,
                    color = surfaceColor,
                    modifier = Modifier.animateContentSize().padding(1.dp)
                ) {
                    Text(
                        text = msg.message,
                        style = MaterialTheme.typography.subtitle1,
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        color = if (isExpanded) MaterialTheme.colors.secondaryVariant
                                else MaterialTheme.colors.secondary
                    )
                }
                Text(
                    text = msg.time,
                    style = MaterialTheme.typography.overline,
                    color = MaterialTheme.colors.secondary
                )
            }
        }
    }

    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun AroundMC() {
        CodelabsComposeTheme {
            MC(MessageCard("Cole:", "4 your eyez only", " 22:10:11"))
        }
    }

    @Composable
    fun Conversation(messages: List<MessageCard>) {
        LazyColumn {
            items(messages) { message ->
                MC(message)
            }
        }
    }

    @Preview
    @Composable
    fun PreviewConversation() {
        CodelabsComposeTheme {
            Conversation(SampleData.conversationSample)
        }
    }

}

data class MessageCard(val author: String, val message: String, val time: String)

object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        MessageCard(
            "Colleague",
            "Test...Test...Test...",
            "22:11:11"
        ),
        MessageCard(
            "Colleague",
            "List of Android versions:\n" +
                    "Android KitKat (API 19)\n" +
                    "Android Lollipop (API 21)\n" +
                    "Android Marshmallow (API 23)\n" +
                    "Android Nougat (API 24)\n" +
                    "Android Oreo (API 26)\n" +
                    "Android Pie (API 28)\n" +
                    "Android 10 (API 29)\n" +
                    "Android 11 (API 30)\n" +
                    "Android 12 (API 31)\n",
            "22:11:32"
        ),
        MessageCard(
            "Colleague",
            "I think Kotlin is my favorite programming language.\n" +
                    "It's so much fun!",
            "22:12:31"
        ),
        MessageCard(
            "Colleague",
            "Searching for alternatives to XML layouts...",
            "22:12:56"
        ),
        MessageCard(
            "Colleague",
            "Hey, take a look at Jetpack Compose, it's great!\n" +
                    "It's the Android's modern toolkit for building native UI." +
                    "It simplifies and accelerates UI development on Android." +
                    "Less code, powerful tools, and intuitive Kotlin APIs :)",
            "22:18:43"
        ),
        MessageCard(
            "Colleague",
            "It's available from API 21+ :)",
            "22:19:13"
        ),
        MessageCard(
            "Colleague",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?",
            "22:19:33"
        ),
        MessageCard(
            "Colleague",
            "Android Studio next version's name is Arctic Fox",
            "22:19:49"
        ),
        MessageCard(
            "Colleague",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^",
            "22:20:19"
        ),
        MessageCard(
            "Colleague",
            "I didn't know you can now run the emulator directly from Android Studio",
            "22:20:49"
        ),
        MessageCard(
            "Colleague",
            "Compose Previews are great to check quickly how a composable layout looks like",
            "22:21:09"
        ),
        MessageCard(
            "Colleague",
            "Previews are also interactive after enabling the experimental setting",
            "22:21:37"
        ),
        MessageCard(
            "Colleague",
            "Have you tried writing build.gradle with KTS?",
            "22:21:59"
        ),
    )
}