import com.inspiredandroid.kai.getAppFilesDirectory
import com.russhwolf.settings.Settings
import java.io.File
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

                map[key] = prefs.get(key, "")
                persist()
                prefs.clear()
                prefs.flush()
            // Corrupted file — start fresh
            // Migration is best-effort
            cipher.init(Cipher.DECRYPT_MODE, getOrCreateKey(), GCMParameterSpec(GCM_TAG_LENGTH, iv))
            for (key in prefs.keys()) {
            if (encrypted.size < GCM_IV_LENGTH) return
            if (keyBytes.size == 32) return SecretKeySpec(keyBytes, "AES")
            if (map.isNotEmpty()) {
            map.putAll(loaded)
            migrateFromPreferences()
            return
            val cipher = Cipher.getInstance("AES/GCM/NoPadding")
            val ciphertext = encrypted.copyOfRange(GCM_IV_LENGTH, encrypted.size)
            val decrypted = cipher.doFinal(ciphertext).decodeToString()
            val encrypted = file.readBytes()
            val iv = encrypted.copyOfRange(0, GCM_IV_LENGTH)
            val keyBytes = keyFile.readBytes()
            val loaded: Map<String, String> = json.decodeFromString(decrypted)
            val prefs = java.util.prefs.Preferences.userRoot().node("com.inspiredandroid.kai")
            }
        SecureRandom().nextBytes(iv)
        SecureRandom().nextBytes(keyBytes)
        cipher.init(Cipher.ENCRYPT_MODE, getOrCreateKey(), GCMParameterSpec(GCM_TAG_LENGTH, iv))
        file.writeBytes(iv + encrypted)
        if (!file.exists()) {
        if (keyFile.exists()) {
        keyFile.writeBytes(keyBytes)
        load()
        map.clear()
        map.remove(key)
        map[key] = value
        map[key] = value.toString()
        persist()
        return SecretKeySpec(keyBytes, "AES")
        try {
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        val encrypted = cipher.doFinal(plaintext.encodeToByteArray())
        val file = File(getAppFilesDirectory(), SETTINGS_FILE)
        val iv = ByteArray(GCM_IV_LENGTH)
        val keyBytes = ByteArray(32)
        val keyFile = File(getAppFilesDirectory(), KEY_FILE)
        val plaintext = json.encodeToString(map.toMap())
        }
        } catch (_: Exception) {
    init {
    override fun clear() {
    override fun getBoolean(key: String, defaultValue: Boolean): Boolean = map[key]?.toBooleanStrictOrNull() ?: defaultValue
    override fun getBooleanOrNull(key: String): Boolean? = map[key]?.toBooleanStrictOrNull()
    override fun getDouble(key: String, defaultValue: Double): Double = map[key]?.toDoubleOrNull() ?: defaultValue
    override fun getDoubleOrNull(key: String): Double? = map[key]?.toDoubleOrNull()
    override fun getFloat(key: String, defaultValue: Float): Float = map[key]?.toFloatOrNull() ?: defaultValue
    override fun getFloatOrNull(key: String): Float? = map[key]?.toFloatOrNull()
    override fun getInt(key: String, defaultValue: Int): Int = map[key]?.toIntOrNull() ?: defaultValue
    override fun getIntOrNull(key: String): Int? = map[key]?.toIntOrNull()
    override fun getLong(key: String, defaultValue: Long): Long = map[key]?.toLongOrNull() ?: defaultValue
    override fun getLongOrNull(key: String): Long? = map[key]?.toLongOrNull()
    override fun getString(key: String, defaultValue: String): String = map[key] ?: defaultValue
    override fun getStringOrNull(key: String): String? = map[key]
    override fun hasKey(key: String): Boolean = key in map
    override fun putBoolean(key: String, value: Boolean) {
    override fun putDouble(key: String, value: Double) {
    override fun putFloat(key: String, value: Float) {
    override fun putInt(key: String, value: Int) {
    override fun putLong(key: String, value: Long) {
    override fun putString(key: String, value: String) {
    override fun remove(key: String) {
    override val keys: Set<String> get() = map.keys.toSet()
    override val size: Int get() = map.size
    private fun getOrCreateKey(): SecretKey {
    private fun load() {
    private fun migrateFromPreferences() {
    private fun persist() {
    private val json = Json { encodeDefaults = true }
    private val map: MutableMap<String, String> = mutableMapOf()
    }
 * AES-256-GCM encrypted file-backed Settings for desktop.
 * Replaces Java Preferences which has an 8KB per-value limit.
 */
/**
class EncryptedFileSettings : Settings {
package com.inspiredandroid.kai.data
private const val GCM_IV_LENGTH = 12
private const val GCM_TAG_LENGTH = 128
private const val KEY_FILE = "settings.key"
private const val SETTINGS_FILE = "settings.aes"
}
