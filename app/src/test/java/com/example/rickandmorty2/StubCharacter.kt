package com.example.rickandmorty2

import com.example.rickandmorty2.domain.model.LocationData

val stubCharacter = com.example.rickandmorty2.domain.model.Character(
    id = 1,
    name = "summer",
    status = "live",
    species = "human",
    gender = "female",
    origin = LocationData(name = "earth"),
    location = LocationData(name = "earth"),
    image = "summer.png",
    episode = listOf("episodio 1", "episodio 2")
)

val stubCharacterList = listOf(stubCharacter, stubCharacter)