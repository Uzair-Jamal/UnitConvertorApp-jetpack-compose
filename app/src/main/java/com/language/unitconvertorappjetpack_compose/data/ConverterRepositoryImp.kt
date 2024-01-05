package com.language.unitconvertorappjetpack_compose.data

import kotlinx.coroutines.flow.Flow

class ConverterRepositoryImp(private val dao: ConverterDAO): ConverterRepository {
    override suspend fun insertResult(result: ConversionResult) {
            dao.insertResult(result)
        }

    override suspend fun deleteResult(result: ConversionResult) {
        dao.deleteResult(result)
    }

    override suspend fun deleteAllResults() {
        dao.deleteAll()
    }

    override fun getSavedResults(): Flow<List<ConversionResult>> {
        return dao.getResults()
    }

}