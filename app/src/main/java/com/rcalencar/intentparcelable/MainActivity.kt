package com.rcalencar.intentparcelable

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rcalencar.intentparcelable.ui.theme.IntentParcelableTheme

const val INTENT_ACTION = "com.rcalencar.intentparcelable.INTENT_USER_DATA_PARCELABLE"
const val INTENT_USER_DATA_PARCELABLE = "INTENT_USER_DATA_PARCELABLE"
const val INTENT_USER_DATA_SERIALIZABLE = "INTENT_USER_DATA_SERIALIZABLE"
const val INTENT_START_TIME = "INTENT_START_TIME"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntentParcelableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Greeting("Android")
                        Button(onClick = {
                            val userData = UserParcelableData("User UserParcelableData", listOf("address 1"))
                            val mIntent = Intent(this@MainActivity, ParcelableHostActivity::class.java).apply {
                                putExtra(INTENT_USER_DATA_PARCELABLE, userData)
                                putExtra(INTENT_START_TIME, System.currentTimeMillis())
                            }
                            startActivity(mIntent)
                        }) {
                            Text(text = "Navigate with Parcelable")
                        }
                        Button(onClick = {
                            val userData = UserSerializableData("User UserSerializableData", listOf("address 1"))
                            val mIntent = Intent(this@MainActivity, SerializableHostActivity::class.java).apply {
                                putExtra(INTENT_USER_DATA_SERIALIZABLE, userData)
                                putExtra(INTENT_START_TIME, System.currentTimeMillis())
                            }
                            startActivity(mIntent)
                        }) {
                            Text(text = "Navigate with Serializable")
                        }
                        Button(onClick = {
                            val userData = UserParcelableData("User UserParcelableData", listOf("address 1"))
                            val mIntent = Intent(INTENT_ACTION).apply {
                                putExtra(INTENT_USER_DATA_PARCELABLE, userData)
                                putExtra(INTENT_START_TIME, System.currentTimeMillis())
                            }
                            startActivity(mIntent)
                        }) {
                            Text(text = "Navigate with implicit intent")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IntentParcelableTheme {
        Greeting("Android")
    }
}