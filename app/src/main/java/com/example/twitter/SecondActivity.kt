package com.example.twitter

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.RowScopeInstance.align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twitterclone.R
import java.time.format.TextStyle

class SecondActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
                        AddTweet()
                    }
                }
            }
        }


@Composable
fun AddTweet() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 5.dp)
        ) {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 10.dp)
                    .width(75.dp)
                    .height(45.dp),
                shape = CircleShape,
                containerColor = Color(78, 194, 240, 255)
            ) {
                Text(text = "Save")
            }
            
            Divider(thickness = 0.6.dp, modifier = Modifier.padding(top = 5.dp))
            Row {


                Image(
                    painter = painterResource(id = R.drawable.kathank),
                    contentDescription = "Kathank",
                    modifier = Modifier
                        .size(58.dp)
                        .padding(start = 10.dp, top = 8.dp)
                        .fillMaxWidth()
                )
                var textState by remember { mutableStateOf(TextFieldValue()) }

                // When the field is empty, set the text value to a space character

                BasicTextField(
                    value = textState,
                    onValueChange = {
                        textState = it
                    },
                    modifier = Modifier.padding(start = 10.dp),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier.padding(top = 20.dp)
                        ) {
                            if (textState.text.isEmpty()) {
                                Text(
                                    text = " '' What's Happening? ''",
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Light
                                )
                            }
                            innerTextField()
                        }
                    },
                    textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
                )
            }
            }
        }
    }
