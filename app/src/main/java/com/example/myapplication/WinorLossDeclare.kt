import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.myapplication.R
import com.example.myapplication.ui.theme.BlueDark
import com.example.myapplication.ui.theme.YellowDark

@Composable
fun WinorLossDeclare(
    text: String,
    buttonText: String,
    mysteryNumber: Int,
    image: Painter,
    resetGame: () -> Unit
) {
    Dialog(onDismissRequest = { resetGame }) {
        Column(
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(YellowDark),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                onTextLayout = {
                }

            )
            Text(
                text = "The Mystery Number is $mysteryNumber",
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Cursive,
                onTextLayout = {
                }
            )
            Image(
                painter = image,
                contentDescription = "Winnerr",
                modifier = Modifier.fillMaxSize(0.25f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { resetGame },
                colors = ButtonDefaults.buttonColors(
                    containerColor = BlueDark,
                    contentColor = YellowDark
                )
            ) {
                Text(text = buttonText, fontSize = 24.sp, onTextLayout = {})
            }
        }
    }
}


@Preview
@Composable
fun WinDailogpreview() {
    WinorLossDeclare(
        text = "won",
        buttonText = "Play Again",
        mysteryNumber = 9,
        image = painterResource(id = R.drawable.prize),
        resetGame = {}
    )
}

@Preview
@Composable
fun loseDialogpreview() {
    WinorLossDeclare(
        text = "Better luck next time",
        buttonText = "Try Again",
        mysteryNumber = 9,
        image = painterResource(id = R.drawable.try_again),
        resetGame = {}
    )
}
