package com.language.unitconvertorappjetpack_compose.data

import kotlinx.coroutines.flow.Flow

class ConverterRepositoryImp(private val dao: ConverterDAO): ConverterRepository {
    override suspend fun insertResult(result: ConversionResult) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteResult(result: ConversionResult) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllResults() {
        TODO("Not yet implemented")
    }

    override fun getAllResults(): Flow<List<ConversionResult>> {
        TODO("Not yet implemented")
    }

}