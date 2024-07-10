package com.example.collegenotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collegenotes.ui.theme.CollegeNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                AppBar()
                setuprecycler()
                bottombuton()

            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray)
            .size(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "PMS", modifier = Modifier.padding(bottom = 5.dp,start = 10.dp),
            fontSize = 20.sp
        )

        Icon(
            imageVector = Icons.Outlined.MoreVert,
            contentDescription = "icon",
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Preview
@Composable
fun setuprecycler(){
    val data= listOf(
        Mydata(R.drawable.folder,"Jetpack Compose",R.drawable.delete ),
        Mydata(R.drawable.folder,"Android",R.drawable.delete ),
        Mydata(R.drawable.folder,"Kotlin",R.drawable.delete ),
        Mydata(R.drawable.folder,"kotlin Coroutine",R.drawable.delete ),
        Mydata(R.drawable.folder,"MVVM",R.drawable.delete ),
        Mydata(R.drawable.folder,"Firebase",R.drawable.delete ),
        Mydata(R.drawable.folder,"Room Database",R.drawable.delete ),
        Mydata(R.drawable.folder,"Rest API",R.drawable.delete ),
        Mydata(R.drawable.folder,"Retrofit",R.drawable.delete ),
        Mydata(R.drawable.folder,"Advanced Project",R.drawable.delete ),
        Mydata(R.drawable.folder,"Git And Github",R.drawable.delete ),
        Mydata(R.drawable.folder,"XML",R.drawable.delete ),
        Mydata(R.drawable.folder,"Kotlin Flows",R.drawable.delete ),)

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.92f)
            .background(Color.White)
    ) {
        items(data.size){
            Listitem(data[it])

        }

    }

}

@Composable
fun Listitem(data:Mydata,modifier: Modifier=Modifier){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(painter = painterResource(id = R.drawable.folder), contentDescription = "icon"
            ,modifier=Modifier.size(50.dp))
        Text(text = data.text)

        Spacer(modifier = modifier.size(12.dp))
        Image(painter = painterResource(id = R.drawable.delete), contentDescription ="delete",
            modifier=Modifier.size(30.dp))

    }
}
@Preview
@Composable
fun bottombuton(){
    var statebutton= remember {
        mutableStateOf(20.dp)
    }
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween)
    {
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.padding(start =statebutton.value, bottom = 4.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "ADD SUBJECTS")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.padding(end = 20.dp, bottom = 4.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "UPLOAD NOTES")

        }
    }
}

class Mydata(val icon:Int,val text:String,val icon2:Int)

