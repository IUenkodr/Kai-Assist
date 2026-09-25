
// The browser build keeps conversations in localStorage-backed settings: the
// sql.js web worker driver is in-memory only, so SQLite would lose data there.
actual fun createConversationSqlDriver(): SqlDriver? = null
import app.cash.sqldelight.db.SqlDriver
package com.inspiredandroid.kai.data
