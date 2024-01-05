package com.language.unitconvertorappjetpack_compose.converter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.language.unitconvertorappjetpack_compose.data.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TopScreen(
    list: List<Conversion>,
    selectedConversion : MutableState<Conversion?>,
    inputText: MutableState<String>,
    typedValue: MutableState<String>,
    isLandscape: Boolean,
    save: (String, String) -> Unit
    ) {
    var toSave by remember {
        mutableStateOf(false)
    }

    ConversionMenu(list){
        selectedConversion.value = it
        typedValue.value = "0.0"
    }

    selectedConversion.value?.let{
        InputBlock(conversion = it, inputText = inputText ){ input ->
            typedValue.value = input
            toSave = true
        }
    }
    if(typedValue.value != "0.0"){
        val input = typedValue.value.toDouble()
        val multiply = selectedConversion.value!!.multiplyBy
        val result = input * multiply

        val df = DecimalFormat("#.####")
        df.roundingMode = RoundingMode.DOWN
        val roundedResult = df.format(result)

        val message1 = "${typedValue.value} ${selectedConversion.value!!.convertFrom} is equal to"
        val message2 = "$roundedResult ${selectedConversion.value!!.convertTo}"
        if(toSave){
            save(message1,message2)
            toSave = false
        }
        ResultBlock(message1 = message1, message2 = message2 )
    }
}