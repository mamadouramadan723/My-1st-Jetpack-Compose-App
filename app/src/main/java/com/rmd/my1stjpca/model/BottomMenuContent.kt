package com.rmd.my1stjpca.model

import androidx.annotation.DrawableRes

// having two parameters title and iconId
data class BottomMenuContent(
    val title: String,
    @DrawableRes val iconId: Int
)