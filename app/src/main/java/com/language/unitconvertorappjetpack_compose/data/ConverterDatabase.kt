package com.language.unitconvertorappjetpack_compose.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [ConversionResult::class], version = 1)
abstract class ConverterDatabase : RoomDatabase() {
    abstract val converterDAO: ConverterDAO

}