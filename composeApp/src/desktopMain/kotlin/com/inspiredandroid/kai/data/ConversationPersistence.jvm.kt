import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.inspiredandroid.kai.db.KaiDatabase
import com.inspiredandroid.kai.getAppFilesDirectory
import java.io.File

    file.parentFile?.mkdirs()
    return JdbcSqliteDriver(url = "jdbc:sqlite:${file.absolutePath}", schema = KaiDatabase.Schema)
    val file = File(getAppFilesDirectory(), "conversations.db")
actual fun createConversationSqlDriver(): SqlDriver? {
package com.inspiredandroid.kai.data
}
