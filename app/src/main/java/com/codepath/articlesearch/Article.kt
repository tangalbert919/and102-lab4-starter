package com.codepath.articlesearch

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class SearchNewsResponse(
    @SerialName("response")
    val response: BaseResponse?
)

@Keep
@Serializable
data class BaseResponse(
    @SerialName("docs")
    val docs: List<Article>?
)

@Keep
@Serializable
data class Article(
    @SerialName("abstract")
    var abstract: String?,

    @SerialName("byline")
    var byline: Byline?,

    @SerialName("headline")
    var headline: Headline?,

    @SerialName("multimedia")
    var multimedia: List<MultiMedia>?
): java.io.Serializable {
    val mediaImageUrl = "https://www.nytimes.com/${multimedia?.firstOrNull { it.url != null }?.url ?: ""}"
}

@Keep
@Serializable
data class Headline(
    @SerialName("main")
    var main: String?,
    @SerialName("print_headline")
    var print_headline: String?
) : java.io.Serializable

@Keep
@Serializable
data class Byline(
    @SerialName("original")
    var original: String?
) : java.io.Serializable

@Keep
@Serializable
data class MultiMedia(
    @SerialName("url")
    val url: String?
) : java.io.Serializable
