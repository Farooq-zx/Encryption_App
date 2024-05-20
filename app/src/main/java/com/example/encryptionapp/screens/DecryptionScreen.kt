package com.example.encryptionapp.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.encryptionapp.DecryptText

@Composable
fun DecryptionScreen() {
    var text by remember {
        mutableStateOf("")
    }
    var encryptKey by remember {
        mutableStateOf("")
    }
    var decryptedText by remember {
        mutableStateOf("")
    }
    var isVisible by remember {
        mutableStateOf(false)
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(top = 80.dp)
    ) {

        Text(text = "")
        TextField(value = text,
            onValueChange = { text = it },
            label = { Text(text = "Enter the text") }
        )

        TextField(
            value = encryptKey,
            onValueChange = { encryptKey = it },
            label = { Text(text = "Decryption key") }
        )
        Button(onClick = {
            decryptedText = DecryptText(
                text, if (encryptKey.isDigitsOnly()) {
                    encryptKey.toInt()
                } else 0
            )
            isVisible = true
        }) {
            Text(text = "Decrypt")
        }
        //if (encryptedText.isEmpty()) {

        //Text(text = "${text.hashCode()}")
        AnimatedVisibility(visible = isVisible) {

            SelectionContainer {
                Column {
                    Text(text = "Text before Encryption: $text")
                    Text(text = "Text before Encryption: $decryptedText")
                }
            }
        }
        //}
    }
}


@Preview
@Composable
fun DecryptionScreenPreview() {
    DecryptionScreen()
}