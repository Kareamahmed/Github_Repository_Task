package com.example.githubreposapp.data.dataSources.remote.model.issues

import com.google.gson.annotations.SerializedName

data class Reactions(
    @SerializedName("+1")
    val plusOne: Int,
    @SerializedName("-1")
    val minusOne: Int,
    val confused: Int,
    val eyes: Int,
    val heart: Int,
    val hooray: Int,
    val laugh: Int,
    val rocket: Int,
    val total_count: Int,
    val url: String
)