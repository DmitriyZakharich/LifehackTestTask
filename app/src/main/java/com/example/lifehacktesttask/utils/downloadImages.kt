package com.example.lifehacktesttask.utils

import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator


fun downloadImages(request: String): RequestCreator = Picasso.get().load(request)
