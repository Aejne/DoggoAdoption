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
package com.example.androiddevchallenge

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.MainDestinations.PUPPY_DETAIL_ID_KEY
import com.example.androiddevchallenge.ui.details.DoggoDetails
import com.example.androiddevchallenge.ui.list.DoggoList

object MainDestinations {
    const val PUPPY_LIST = "puppy_list"
    const val PUPPY_DETAILS = "puppy_details"
    const val PUPPY_DETAIL_ID_KEY = "puppy_id"
}

@ExperimentalFoundationApi
@Composable
fun NavGraph(startDestination: String = MainDestinations.PUPPY_LIST) {
    val navController = rememberNavController()

    val actions = remember(navController) { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.PUPPY_LIST) {
            DoggoList { id -> actions.toPuppyDetails(id) }
        }
        composable(
            "${MainDestinations.PUPPY_DETAILS}/{$PUPPY_DETAIL_ID_KEY}",
            arguments = listOf(navArgument(PUPPY_DETAIL_ID_KEY) { type = NavType.IntType })
        ) { backstackEntry ->
            val arguments = requireNotNull(backstackEntry.arguments)
            DoggoDetails(
                dogIndex = arguments.getInt(PUPPY_DETAIL_ID_KEY),
                upAction = actions.upPress
            )
        }
    }
}

class MainActions(navController: NavHostController) {
    val toPuppyDetails: (Int) -> Unit = { id: Int ->
        navController.navigate("${MainDestinations.PUPPY_DETAILS}/$id")
    }

    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
