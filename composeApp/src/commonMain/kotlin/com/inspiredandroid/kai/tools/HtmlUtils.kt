
    .replace("&#39;", "'")
    .replace("&amp;", "&")
    .replace("&gt;", ">")
    .replace("&lt;", "<")
    .replace("&nbsp;", " ")
    .replace("&quot;", "\"")
internal fun String.decodeHtmlEntities(): String = this
package com.inspiredandroid.kai.tools
