/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.Gender
import com.example.androiddevchallenge.dogs
import com.example.androiddevchallenge.ui.theme.BlueGrey400
import com.example.androiddevchallenge.ui.theme.Brown400
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun DoggoDetails(modifier: Modifier = Modifier, dogIndex: Int, upAction: () -> Unit) {
    val dog = dogs[dogIndex]
    Scaffold(modifier = modifier) {
        Column(
            Modifier.scrollable(
                rememberScrollState(),
                orientation = Orientation.Vertical
            )
        ) {
            Box(
                contentAlignment = Alignment.BottomCenter
            ) {
                CoilImage(
                    data = dog.imageUrl,
                    contentDescription = "DoggoImage",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(320.dp)
                        .fillMaxWidth()
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Color.Transparent, MaterialTheme.colors.background)
                            )
                        ),
                )
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, end = 40.dp, bottom = 16.dp),
                    elevation = 12.dp,
                    shape = CutCornerShape(8.dp)
                ) {
                    Text(
                        text = dog.name,
                        style = MaterialTheme.typography.h4,
                        textAlign = TextAlign.Center,
                    )
                }
            }
            DoggoDetail(
                dog = dog,
                modifier = Modifier
                    .padding(start = 16.dp, top = 24.dp, end = 16.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(
                contentPadding = PaddingValues(16.dp)
            ) {
                items(dog.characteristics) { characteristic ->
                    Charateristic(characteristic = characteristic)
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .navigationBarsPadding(bottom = true),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row {
                TextButton(
                    modifier = Modifier.height(64.dp),
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Brown400,
                        contentColor = Color.White
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Adorable",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Icon(
                            imageVector = Icons.Outlined.Favorite,
                            contentDescription = "Save",
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                TextButton(
                    modifier = Modifier.height(64.dp),
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(topStart = 32.dp, bottomStart = 32.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Brown400,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Adopt me",
                        modifier = Modifier.padding(
                            start = 12.dp,
                            end = 12.dp
                        ),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
        }
    }

    IconButton(
        onClick = upAction,
        modifier = Modifier
            .padding(top = 32.dp, start = 8.dp)
            .padding(4.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Navigate Up",
            tint = Color.White
        )
    }
}

@Composable
fun DoggoDetail(modifier: Modifier = Modifier, dog: Dog) {
    Column(modifier = modifier) {
        DoggoDetailItem(
            modifier = Modifier.padding(4.dp),
            title = "Breed",
            text = dog.breed
        )

        DoggoDetailItem(
            modifier = Modifier.padding(4.dp),
            title = "Age",
            text = dog.age.toString()
        )

        DoggoDetailItem(
            modifier = Modifier.padding(4.dp),
            title = "Gender",
            text = if (dog.gender == Gender.MALE) "Male" else "Female"
        )

        DoggoDetailItem(
            modifier = Modifier.padding(4.dp),
            title = "About",
            text = dog.description
        )
    }
}

@Composable
fun DoggoDetailItem(modifier: Modifier = Modifier, title: String, text: String) {
    Row(modifier = modifier) {
        Text(
            modifier = Modifier.width(80.dp),
            text = "$title: ",
            style = MaterialTheme.typography.body1,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End
        )

        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            fontSize = 18.sp
        )
    }
}

@Composable
fun Charateristic(characteristic: String) {
    Text(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .background(BlueGrey400, shape = RoundedCornerShape(8.dp))
            .padding(vertical = 8.dp, horizontal = 8.dp),
        text = characteristic,
        color = Color.White,
        fontSize = 16.sp,
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun CharacteristicPreview() {
    Charateristic(characteristic = "Playful")
}

@Preview
@Composable
fun DoggoDetailsPreview() {
    DoggoDetails(dogIndex = 2, upAction = { /*TODO*/ })
}
