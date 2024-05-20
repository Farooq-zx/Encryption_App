package com.example.encryptionapp


fun DecryptText(text: String, encryptKey: Int):  String {

    //val textBefore = text.toMutableList()
    var decryptedText : String = ""

//    for (char in text){
//        textBefore.add(char + encryptKey)
//    }

    text.forEach { char ->
        decryptedText += char - encryptKey

    }
    return decryptedText
}
