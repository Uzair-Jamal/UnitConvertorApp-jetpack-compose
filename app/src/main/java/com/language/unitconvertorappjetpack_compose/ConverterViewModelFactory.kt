package com.language.unitconvertorappjetpack_compose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.language.unitconvertorappjetpack_compose.data.ConverterRepository
import javax.inject.Inject

class ConverterViewModelFactory @Inject constructor(private val repository: ConverterRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = ConverterViewModel(repository) as T
}