package com.language.unitconvertorappjetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.language.unitconvertorappjetpack_compose.data.ConverterDatabase
import com.language.unitconvertorappjetpack_compose.data.ConverterRepository
import com.language.unitconvertorappjetpack_compose.data.ConverterRepositoryImp
import com.language.unitconvertorappjetpack_compose.ui.theme.UnitConvertorAppjetpackcomposeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var factory: ConverterViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConvertorAppjetpackcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    BaseScreen(factory)
                }
            }
        }
    }
}
