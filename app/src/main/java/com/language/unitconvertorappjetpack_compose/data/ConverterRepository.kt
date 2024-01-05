package com.language.unitconvertorappjetpack_compose.data

import kotlinx.coroutines.flow.Flow

interface ConverterRepository {
    suspend fun insertResult(result: ConversionResult)
    suspend fun deleteResult(result: ConversionResult)
    suspend fun deleteAllResults()
    fun getSavedResults(): Flow<List<ConversionResult>>
}