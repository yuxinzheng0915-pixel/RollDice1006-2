package tw.edu.pu.csim.yuxin.rolldice

import android.media.Image
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.edu.pu.csim.yuxin.rolldice.ui.theme.RollDiceTheme
import androidx.compose.runtime.getValue // 引入 getValue
import androidx.compose.runtime.mutableStateOf // 引入 mutableStateOf
import androidx.compose.runtime.remember // 引入 remember
import androidx.compose.runtime.setValue // 引入 setValue
import androidx.compose.ui.input.pointer.pointerInput


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RollDiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Dice(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Dice(modifier: Modifier = Modifier) {
    var diceNumber by remember  { mutableStateOf(0) }
    val diceImages = listOf(
        R.drawable.dice0, // 索引 0
        R.drawable.dice1, // 索引 1
        R.drawable.dice2, // 索引 2
        R.drawable.dice3, // 索引 3
        R.drawable.dice4, // 索引 4
        R.drawable.dice5, // 索引 5
        R.drawable.dice6  // 索引 6
    )


    Column(
        modifier = modifier.fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center
    ) {
        Text("請點擊圖片隨機丟骰子\n作者：鄭宇芯yuxin")

        Spacer(modifier = Modifier.height(20.dp))

        androidx.compose.foundation.Image(

            painter = painterResource(id = diceImages[3]),

            contentDescription = "Dice",
             modifier = Modifier
                 .pointerInput(Unit) {
                     detectTapGestures(
                         onTap = {
                             // 單擊：產生 1 到 6 的隨機整數
                             diceNumber = (1..6).random()
                         },
                         onDoubleTap = {
                             // 雙擊：重置為 0 (回到 dice0)
                             diceNumber = 0
                         }
                     )
                 }






        )

    }

}

