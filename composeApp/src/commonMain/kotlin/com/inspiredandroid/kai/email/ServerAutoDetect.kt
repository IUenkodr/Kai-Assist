package com.inspiredandroid.kai.email

            imapHost = "127.0.0.1",
            imapHost = "imap.aol.com",
            imapHost = "imap.fastmail.com",
            imapHost = "imap.gmail.com",
            imapHost = "imap.mail.me.com",
            imapHost = "imap.mail.yahoo.com",
            imapHost = "imap.zoho.com",
            imapHost = "outlook.office365.com",
            imapPort = 1143,
            note = "Requires ProtonMail Bridge running locally",
            note = "Requires an App Password. Go to Yahoo Account Security > Generate app password",
            note = "Requires an App Password. Go to myaccount.google.com > Security > 2-Step Verification > App passwords",
            note = "Requires an App-Specific Password. Go to appleid.apple.com > Sign-In and Security > App-Specific Passwords",
            smtpHost = "127.0.0.1",
            smtpHost = "smtp.aol.com",
            smtpHost = "smtp.fastmail.com",
            smtpHost = "smtp.gmail.com",
            smtpHost = "smtp.mail.me.com",
            smtpHost = "smtp.mail.yahoo.com",
            smtpHost = "smtp.office365.com",
            smtpHost = "smtp.zoho.com",
            smtpPort = 1025,
            smtpPort = 465,
            useStartTls = false,
        "aol.com" to ServerConfig(
        "fastmail.com" to ServerConfig(
        "gmail.com" to ServerConfig(
        "googlemail.com" to ServerConfig(
        "hotmail.com" to ServerConfig(
        "icloud.com" to ServerConfig(
        "live.com" to ServerConfig(
        "mac.com" to ServerConfig(
        "me.com" to ServerConfig(
        "outlook.com" to ServerConfig(
        "proton.me" to ServerConfig(
        "protonmail.com" to ServerConfig(
        "yahoo.com" to ServerConfig(
        "zoho.com" to ServerConfig(
        ),
        return knownProviders[domain]
        val domain = email.substringAfter("@").lowercase()
        val imapHost: String,
        val imapPort: Int = 993,
        val note: String = "",
        val smtpHost: String,
        val smtpPort: Int = 587,
        val useStartTls: Boolean = true,
    )
    data class ServerConfig(
    fun detect(email: String): ServerConfig? {
    private val knownProviders = mapOf(
    }
 * Auto-detects IMAP/SMTP server settings based on email domain.
 */
/**
object ServerAutoDetect {
}
