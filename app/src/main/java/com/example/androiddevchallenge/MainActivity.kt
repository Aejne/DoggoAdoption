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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.Gender
import com.example.androiddevchallenge.ui.theme.DoggoAdoptionTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            ProvideWindowInsets(consumeWindowInsets = false) {
                DoggoAdoptionTheme {
                    NavGraph()
                }
            }
        }
    }
}

val dogs = listOf(
    Dog(
        0, "Kira", "Pomeranian", 6, "https://cdn2.thedogapi.com/images/HJd0XecNX_1280.jpg", Gender.FEMALE,
        "Extroverted, Friendly, Sociable, Playful, Intelligent, Active".split(","),
        "Meet the adorable Kira! This sweet girl is around 6 years old and was found as a stray. All she wants is to sit in your lap and be by your side. She walks well on a leash, is crate trained and house trained. Kira is looking for a home with no cats, older kids and is dog selective when sharing her home with a dog, but does not react when on a walk and seeing other dogs. She is very loyal to her person and has so much love to give."
    ),
    Dog(
        1, "Betty White", "Lhasa Apso", 2, "https://cdn2.thedogapi.com/images/SJp7Qe5EX.jpg", Gender.FEMALE,
        "Steady, Fearless, Friendly, Devoted, Assertive, Spirited, Energetic, Lively, Alert, Obedient, Playful, Intelligent".split(","),
        "Meet Betty White! She is a 2 year old American bulldog mix. This large girl is still full of spunk. She is looking for an experience owner as she still has a few corks to work out as she nips a little and wants to play tug a war with the leash but once on a walk she walk perfect with no pulling. She is very treat drivin and listens very well."
    ),
    Dog(
        2, "Prince", "Herding", 2, "https://cdn2.thedogapi.com/images/SyRe4xcN7.jpg", Gender.MALE,
        "Energetic, Loyal, Intelligent, Trainable".split(","),
        "Prince lived a life with many other dogs, all in crates. He will need an adopter that has patience, one that is willing to work with him. He is scared of loud noises, he will need a secure fenced area and be kept on leash while he adjusts."
    ),
    Dog(
        3, "Bob", "Lapdog", 8, "https://cdn2.thedogapi.com/images/B1SV7gqN7.jpg", Gender.MALE,
        "Playful, Docile, Fearless, Affectionate, Sweet-Tempered, Lively, Responsive, Easygoing, Gentle, Intelligent, Active".split(","),
        "Bobby is a loyal, loving pup searching for his forever home. A home without children would be best for Bobby, as he doesn't prefer to share attention! He does seem to do well with some other dogs, though. A quiet home without a lot of people coming and going would also be great for Bobby, as change and loud noises seem to scare him. This old boy is looking for a place to retire!"
    ),
    Dog(
        4, "Huck", "Siberian Husky", 7, "https://cdn2.thedogapi.com/images/S17ZilqNm.jpg", Gender.FEMALE,
        "Outgoing, Friendly, Alert, Gentle, Intelligent".split(","),
        "Sky is a 7 year old Siberian Husky. This girl needs a quiet home with no kids. She loves to be outside, but enjoys being inside with a nice movie and her favorite people. Huck is good with most other dogs."
    ),
    Dog(
        5, "Grizzly", "Keeshond", 3, "https://cdn2.thedogapi.com/images/S1GAGg9Vm.jpg", Gender.MALE,
        "Playful, Docile, Fearless".split(","),
        "Grizzly is looking to go home with a family that will give him time and an opportunity for lots of outdoor time. He grew up with children and has decided that a quiet adult only home would be best for him. He is sweet, loving, and able to chase a ball or two."
    ),
    Dog(
        6, "Hank", "Komondor", 1, "https://cdn2.thedogapi.com/images/Bko0fl547.jpg", Gender.MALE,
        "Steady, Fearless, Affectionate, Independent, Gentle, Calm".split(","),
        "Hank is a very playful and friendly dog.\n" +
            "He loves people and playing fetch, walking and running around.\n" +
            "Hank is really beautiful, energetic, sweet and he could be a great family dog. He is about 50 lbs and full grown.\n" +
            "Hank is a great dog, affectionate and ready for any adventure."
    ),
    Dog(
        7, "Tiffany", "Kooikerhondje", 3, "https://cdn2.thedogapi.com/images/kOMy84GQE.jpg", Gender.FEMALE,
        "Benevolent, Agile, Alert, Intelligent, Active, Territorial".split(","),
        "Tiffany came to the shelter as a stray. She is deaf. A volunteer has been working with her on sign commands. She is doing very well. We recommend an adult home or kids 15 and older. She is intense when playing with toys especially soft toys."
    ),
    Dog(
        8, "Diego", "Spinone Italiano", 3, "https://cdn2.thedogapi.com/images/rk5Eoe5Nm.jpg", Gender.MALE,
        "Docile, Friendly, Affectionate, Loyal, Patient, Gentle".split(","),
        "Coby is an healthy playful senior. He loves is walks, play and snuggle. He doesn’t really act as a senior at all so we think that his birth certificate is wrong,\n" +
            "Coby is a great companion, no very big, easy to manage, super clean and well behaved in the house and on leash. Coby would love to have a warm winter next to his new family, enjoying the blanket and some good treats."
    ),
    Dog(
        9, "Roxy", "Kuvasz", 3, "https://cdn2.thedogapi.com/images/BykZ7ecVX.jpg", Gender.FEMALE,
        "Clownish, Loyal, Patient, Independent, Intelligent, Protective".split(","),
        "Big handsome girl Roxy will take you on many adventures. She loves to go for walks and enjoys play time in the back yard. She is learning to walk better on her leash. She does love romping around with her doggy friends, but is not a fan of cats. This girl has nothing but love to offer to some lucky family."
    ),
    Dog(
        10, "Lexi", "Silky Terrier", 12, "https://cdn2.thedogapi.com/images/ByzGsl5Nm.jpg", Gender.FEMALE,
        "Friendly, Responsive, Inquisitive, Alert, Quick, Joyful".split(","),
        "Lexi is a compact but strong little girl. She will need an active home to meet her very active level. She loves going for walks and playing."
    ),
    Dog(
        11, "Spike", "Lancashire Heeler", 3, "https://cdn2.thedogapi.com/images/S1RGml5Em.jpg", Gender.FEMALE,
        "Clever, Friendly, Alert, Intelligent".split(","),
        "Spike is a beautiful girl searching for her forever home. She doesn't like to share attention, so a home without other animals or children under 12 would be best for her. She loves to run and play, and loves spending time with her forever family. Please get in touch to learn more about Spiky!"
    )
)
