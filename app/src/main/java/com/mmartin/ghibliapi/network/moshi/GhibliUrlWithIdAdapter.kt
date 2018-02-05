package com.mmartin.ghibliapi.network.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * Created by mmartin on 2/3/18.
 */
class GhibliUrlWithIdAdapter {
    @ToJson
    fun toJson(@UrlsWithId list: List<String>): List<String> {
        return list
    }

    @FromJson
    @UrlsWithId
    fun fromJson(urlsWithId: List<String>?): List<String> {
        val idList = mutableListOf<String>()
        urlsWithId?.forEach {
            val lastForwardSlashIndex = it.lastIndexOf('/')
            if (lastForwardSlashIndex == -1 || lastForwardSlashIndex == it.length - 1) {
                return emptyList()
            } else {
                idList.add(it.slice(lastForwardSlashIndex + 1 until it.length))
            }
        }
        return idList
    }
}