package com.example.encryptionapp

import android.util.Range


fun EncryptText(text: String, encryptKey: Int): String {

/*

    val letterRange: MutableList<Char> = mutableListOf()

    // Small letters
    for (c in 'a'..'z') {
        letterRange.add(c)
    }

    // Capital letters
    for (c in 'A'..'Z') {
        letterRange.add(c)
    }

    // Numbers
    for (c in '0'..'z') {
        letterRange.add(c)
    }
*/


    var encryptedText = ""

    text.forEach { char ->
        encryptedText += (char + encryptKey)


    }
    return encryptedText
}
