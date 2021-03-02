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
package com.example.androiddevchallenge.ui.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.Gender
import com.example.androiddevchallenge.dogs
import com.example.androiddevchallenge.ui.theme.Blue800
import com.example.androiddevchallenge.ui.theme.DoggoAdoptionTheme
import com.example.androiddevchallenge.ui.theme.Purple200
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.systemBarsPadding

@ExperimentalFoundationApi
@Composable
fun DoggoList(onPuppySelected: (Int) -> Unit) {
    DoggoAdoptionTheme {
        Scaffold(
            topBar = {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.primary,
                    elevation = 4.dp,
                    shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Row(
                            modifier = Modifier
                                .padding(vertical = 24.dp)
                                .systemBarsPadding(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_doggo_adoption),
                                contentDescription = "App Icon",
                                modifier = Modifier.size(32.dp),
                                tint = Color.White
                            )
                            Text(
                                text = "Doggo Adoption",
                                style = MaterialTheme.typography.h4,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }
                }
            }
        ) {
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                state = rememberLazyListState(),
                contentPadding = PaddingValues(
                    top = 12.dp,
                    bottom = LocalWindowInsets.current.navigationBars.bottom.dp
                ),
            ) {
                items(dogs) { dog ->
                    DogItem(onPuppySelected, dog = dog)
                }
            }
        }
    }
}

@Composable
fun DogItem(onPuppySelected: (Int) -> Unit, modifier: Modifier = Modifier, dog: Dog) {
    Column(
        modifier = modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth()
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .clickable { onPuppySelected(dog.id) },
            elevation = 16.dp,
            backgroundColor = MaterialTheme.colors.surface,
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(bottom = 8.dp)) {
                CoilImage(
                    data = dog.imageUrl,
                    contentDescription = "DoggoImage",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.height(100.dp),
                    fadeIn = false
                )
                DogDetails(modifier = Modifier.padding(8.dp), dog = dog)
            }
        }
    }
}

@Composable
fun DogDetails(modifier: Modifier = Modifier, dog: Dog) {

    Row(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = dog.name,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 8.dp)
            )
            Text(
                text = dog.breed,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 8.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }

        val male = dog.gender == Gender.MALE

        Row(modifier = Modifier.align(Alignment.CenterVertically)) {
            Text(
                text = dog.age.toString(),
                modifier = Modifier
                    .padding(end = 4.dp)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
                    .requiredSize(24.dp),
                textAlign = TextAlign.Center
            )
            Icon(
                imageVector = if (male) Icons.Filled.Male else Icons.Filled.Female,
                contentDescription = "Gender",
                tint = if (male) Blue800 else Purple200
            )
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun DoggoListPreview() {
    DoggoList(onPuppySelected = { /*TODO*/ })
}

@Preview
@Composable
fun DogItemPreview() {
    DoggoAdoptionTheme {
        DogItem({ }, modifier = Modifier.padding(8.dp), dog = dogs.first())
    }
}
