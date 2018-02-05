package com.mmartin.ghibliapi.network.moshi

import com.squareup.moshi.JsonQualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

/**
 * Created by mmartin on 2/3/18.
 */
@Retention(RUNTIME)
@JsonQualifier
annotation class UrlsWithId