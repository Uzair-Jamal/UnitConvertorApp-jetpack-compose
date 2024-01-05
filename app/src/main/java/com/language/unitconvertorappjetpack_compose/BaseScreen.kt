package com.language.unitconvertorappjetpack_compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.language.unitconvertorappjetpack_compose.converter.TopScreen
import com.language.unitconvertorappjetpack_compose.history.HistoryScreen

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier : Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel(factory = factory)
){
    val list = converterViewModel.getConversion()
    val historyList = converterViewModel.resultList.collectAsState(initial = emptyList())


    Column(modifier = modifier.padding(30.dp)) {
        TopScreen(list,
            converterViewModel.selectedConversion,
            converterViewModel.inputText,
            converterViewModel.typedValue)
        {
            message1,message2 -> converterViewModel.getResult(message1,message2)
        }
        Spacer(modifier = Modifier.height(20.dp))
        HistoryScreen(
            historyList, {
                item -> converterViewModel.removeResult(item)
            },
            {
                converterViewModel.clearAll()
            }
            )
    }
}