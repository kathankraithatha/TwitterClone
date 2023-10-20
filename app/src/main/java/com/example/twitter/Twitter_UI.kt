package com.example.twitter

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.twotone.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twitterclone.R

@Composable
fun Twitter_UI() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Box( modifier = Modifier.fillMaxSize()){
            val context= LocalContext.current
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(ScrollState(1))
            ) {
                Twitter_Header()
                Divider(thickness = 0.6.dp)
                Tweets("Android Development is OP!!!")
                Tweets("Kotlin is The Real King Of All Languages")
                Tweets("Kotlin is The Real King Of All Languages")
                Tweets("Kotlin is The Real King Of All Languages")
                Tweets("Kotlin is The Real King Of All Languages")
            }
            FloatingActionButton(
                onClick = {
                    val intent=Intent(context,SecondActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 30.dp, end = 15.dp),
                shape = CircleShape,
                containerColor = Color(96, 194, 224, 255),
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add",
                )
            }
        }
    }
}

@Composable
fun Twitter_Header() {
    Row(
        modifier= Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
    ){
        Image(
            painter = painterResource(id =R.drawable.kathank ),
            contentDescription = "Kathank",
            modifier = Modifier
                .size(58.dp)
                .padding(start = 10.dp, top = 8.dp)
                .fillMaxWidth()
        )
        Image(
            painter = painterResource(id =R.drawable.finaltweet),
            contentDescription ="twiiter",
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .size(70.dp),

        )
    }
}

@Composable
fun Tweets(tweetTitle:String) {
    var heartCount by remember {
        mutableStateOf(0)
    }
    var shareCount by remember {
        mutableStateOf(0)
    }
    Row(
    ) {
        Card(
            colors = CardDefaults.cardColors(Color.Transparent),
            modifier = Modifier
                .height(160.dp)
                .padding(top = 20.dp, end = 10.dp)
                .weight(0.5f)
        ) {
            Row(
                modifier= Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.kathank),
                    contentDescription ="kathank",
                    modifier = Modifier.size(50.dp)
                )
                Text(
                    text = "Kathank Raithatha",
                    color=Color.White,
                    modifier = Modifier.padding(start = 10.dp),
                    fontSize = 19.sp
                )
                Text(
                    text = "@KathankRaithat1",
                    color=Color.White,
                    modifier = Modifier.padding(start = 10.dp),
                    fontWeight = FontWeight.Light,
                )
            }
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(start = 60.dp)
            ) {
                Text(
                    text = tweetTitle,
                    color=Color.White
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(start = 60.dp)
                    .fillMaxWidth()
            ) {
                Row(modifier= Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "Delete",
                        tint = Color.White,
                        modifier = Modifier.clickable {
                            heartCount++
                        }
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(text = heartCount.toString(), color = Color.White)
                    Spacer(modifier = Modifier.padding(40.dp))
                    Icon(
                        imageVector =Icons.Outlined.Share,
                        contentDescription = "Share",
                        tint = Color.White,
                        modifier = Modifier.clickable {
                            shareCount++
                        }
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text =shareCount.toString(),
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.padding(60.dp))
                    Icon(
                        imageVector = Icons.Outlined.Star,
                        contentDescription = "Share",
                        tint = Color.White,
                    )
                }
            }
        }
    }
    Divider(thickness = 0.7.dp)
}