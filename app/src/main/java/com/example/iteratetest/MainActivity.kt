package com.example.iteratetest

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import com.example.iteratetest.ui.theme.IterateTestTheme
import com.iteratehq.iterate.Iterate

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IterateTestTheme {
                var loading by remember { mutableStateOf(false) }
                Column(modifier = Modifier.padding(top = 24.dp)) {
                    TextButton(onClick = {
                        Iterate.sendEvent(
                            eventName = EventName,
                            fragmentManager = supportFragmentManager
                        )
                        loading = true
                    }) {
                        Text(text = "Show survey")
                    }

                    if (loading) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colorScheme.secondary,
                            trackColor = MaterialTheme.colorScheme.surfaceVariant,
                        )
                    }
                }
            }
        }
    }
}

private const val EventName = ""
