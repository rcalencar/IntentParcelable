package com.rcalencar.intentparcelable

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.rcalencar.intentparcelable.ui.theme.IntentParcelableTheme


class SerializableHostActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntentParcelableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val userData: UserSerializableData? = intent.getSerializableExtra(INTENT_USER_DATA_SERIALIZABLE) as UserSerializableData?
                    val now = System.currentTimeMillis()
                    val timeSpent = now - intent.getLongExtra(INTENT_START_TIME, now)
                    Log.d("timeSpent", "$timeSpent")
                    Greeting("${userData?.name} - ${userData?.address?.joinToString()} in ${timeSpent}ms")
                }
            }
        }
    }
}