package com.jetback.mypharm.android


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0xFFBB86FC),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5)
        )
    } else {
        lightColors(
            primary = Color(0xFF6200EE),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5)
        )
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {

    var myName by remember {
        mutableStateOf("")
    }
    var myPassWord by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White), horizontalAlignment = Alignment.CenterHorizontally

    ) {


        Image(
            painter = painterResource(id = R.drawable.dev),
            contentDescription = " Developer",
            modifier = Modifier.height(255.dp)
        )
//        Image(
//            painter = painterResource(id = R.drawable.dev),
//            contentDescription = "Background",
//            modifier = Modifier.height(255.dp)
//        )


        Spacer(
            modifier = Modifier
                .height(8.dp)
                .background(Color.Black)
        )
        Text(
            text = "Ahmed Sh.Mahmood", modifier = Modifier
                .width(IntrinsicSize.Max)
                .height(32.dp), fontSize = 25.sp
        )
        Spacer(
            modifier = Modifier
                .height(22.dp)
                .background(Color.Black)
        )
        BasicTextField(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth(0.7f)
                .background(Color.White)
                .padding(4.dp),
            value = myName,
            onValueChange = {
                myName = it
            }
        )
        Spacer(
            modifier = Modifier
                .height(22.dp)
                .background(Color.Black)
        )
        BasicTextField(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth(0.7f)
                .background(Color.DarkGray)
                .padding(4.dp),
            value = myPassWord,

            onValueChange = {
                myPassWord = it
                println(myPassWord)
            }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun LoginPreivew(){
    LoginScreen()
}

