package com.example.encryptionapp.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutScreen() {
    var isEnglish by remember {
        mutableStateOf(false)
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp)
            .padding(horizontal = 20.dp)

    ) {

        // Header
        Text(
            text = "Algorithm Information's",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace
        )

        // Description
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 18.sp, fontFamily = FontFamily.SansSerif
                )
            ) {
                append("This algorithm is called ")
                withStyle(
                    style = SpanStyle(
                        fontSize = 17.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("\"Caesar Cipher\"\n")
                }
                append("Which is earlier known and simplest method used by \"julius Caesar\"")
            }

        })
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "The encryption equation for this algorithm is :",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "X = M + K (MOD 26)"
            )
            Text(text = "But !", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            Text(text = "This algorithm only support the english language, So ")
            Text(
                text = "This is the encryption equation for this program :",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "X += (M + K)", fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.heightIn(20.dp))
            Text(
                text = "Which is:", fontSize = 16.sp, fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "X  -> Encrypted text", fontSize = 16.sp, fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "M -> Each letter in the word (X)", fontSize = 16.sp, fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "K  -> Encryption Key", fontSize = 16.sp, fontWeight = FontWeight.SemiBold
            )
        }

/*
        AnimatedContent(targetState = isEnglish, label = "") { inEnglish ->
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            ) {

                if (inEnglish) {
                    AboutScreenInEnglish()
                } else AboutScreenInArabic()
            }
        }
        Button(onClick = {
            isEnglish = !isEnglish

        }) {
            Text(text = if (isEnglish) "Change the language" else "تغيير اللغة")
        }
*/
    }
}

/*
@Composable
fun AboutScreenInEnglish() {
    // Header
    Text(
        text = "Algorithm Information's",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Monospace
    )

    // Description
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 18.sp, fontFamily = FontFamily.SansSerif
            )
        ) {
            append("The algorithm we use here it's called ")
            withStyle(
                style = SpanStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("\"Caesar Cipher\"\n")
            }
            append("Which is earlier known and simplest method used by \"julius Caesar\"")
        }

    })
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "The encryption equation for this algorithm is :",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "X = M + K (MOD 26)", fontSize = 16.sp, fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.heightIn(20.dp))
        Text(
            text = "Which :", fontSize = 16.sp, fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "X -> Encrypted text", fontSize = 16.sp, fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "M -> Encrypted text", fontSize = 16.sp, fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "K -> Encryption Key", fontSize = 16.sp, fontWeight = FontWeight.SemiBold
        )
    }
}


@Composable
fun AboutScreenInArabic() {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {


        // Header
        Text(
            text = "معلومات حول الخوارزمية المستخدمة",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))
        // Description
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 19.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                    )
                ) {
                    append("الخوارزمية المستخدمة هنا تُسمَّى ")
                    withStyle(
                        style = SpanStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("\"Caesar Cipher\"\n")
                    }
                    append("Which is earlier known and simplest method used by \"julius Caesar\"\n")
                }

                append(
                    text = "معادلة التشفير المستخدمة في هذه الخوارزمية :",

                    )
            },

            textAlign = TextAlign.Right,
        )
        Text(
            text = "X = M + K (MOD 26)", fontSize = 16.sp, fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.heightIn(20.dp))
        Text(
            text = "Which :", fontSize = 16.sp, fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "X -> Encrypted text", fontSize = 16.sp, fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "M -> Encrypted text", fontSize = 16.sp, fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "K -> Encryption Key", fontSize = 16.sp, fontWeight = FontWeight.SemiBold
        )
    }
}
*/

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    AboutScreen()
}