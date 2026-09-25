package com.inspiredandroid.kai.splinterlands
import com.inspiredandroid.kai.httpClient
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import java.io.ByteArrayOutputStream
import java.math.BigInteger
import java.security.MessageDigest
import java.time.Instant
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.bouncycastle.crypto.digests.SHA256Digest
import org.bouncycastle.crypto.params.ECDomainParameters
import org.bouncycastle.crypto.signers.HMacDSAKCalculator
import org.bouncycastle.jce.ECNamedCurveTable
import org.bouncycastle.math.ec.ECAlgorithms
import org.bouncycastle.math.ec.ECPoint

            ((refBlockPrefixBytes[1].toInt() and 0xFF) shl 8) or
            ((refBlockPrefixBytes[2].toInt() and 0xFF) shl 16) or
            ((refBlockPrefixBytes[3].toInt() and 0xFF) shl 24)
            continue
            header("Content-Type", "application/json")
            if (nonce > 100) throw RuntimeException("Could not find canonical signature")
            nonce++
            setBody("""{"jsonrpc":"2.0","method":"condenser_api.get_dynamic_global_properties","params":[],"id":1}""")
        // BIP-62 low-S normalization
        // Build the custom_json operation JSON
        // Compute R = k*G to get recovery ID
        // Fetch dynamic global properties for ref_block
        // Generate k using RFC 6979, with nonce counter mixed in for retries
        // Recovery ID: bit 0 = y parity of R, adjusted for s-negation
        // Serialize transaction bytes
        // Single SHA-256: Hive/Graphene signing protocol (NOT double like Bitcoin)
        buf.write((v and 0x7F) or 0x80)
        bytes.size == 32 -> bytes
        bytes.size > 32 -> bytes.copyOfRange(bytes.size - 32, bytes.size)
        client.close()
        data[i] = ((Character.digit(hex[i * 2], 16) shl 4) + Character.digit(hex[i * 2 + 1], 16)).toByte()
        else -> ByteArray(32 - bytes.size) + bytes
        if (!isCanonical(rBytes, sBytes)) {
        if (digit < 0) throw IllegalArgumentException("Invalid base58 character: $c")
        if (sNegated) recId = recId xor 1
        if (sNegated) s = ecDomain.n.subtract(s)
        kCalc.init(ecDomain.n, privKey, hashForK)
        num = num.multiply(BigInteger.valueOf(58)).add(BigInteger.valueOf(digit.toLong()))
        rBytes.copyInto(sig, 1)
        return """{"ref_block_num":$refBlockNum,"ref_block_prefix":$refBlockPrefixUnsigned,"expiration":"$expirationStr","operations":[$operation],"extensions":[],"signatures":["$sigHex"]}"""
        return sig.toHexString()
        sBytes.copyInto(sig, 33)
        sig[0] = (27 + recId + 4).toByte()
        v = v shr 7
        val digest = sha256(hexToBytes(HIVE_CHAIN_ID) + txBytes)
        val digit = BASE58_ALPHABET.indexOf(c)
        val escapedJson = jsonPayload.replace("\\", "\\\\").replace("\"", "\\\"")
        val expiration = Instant.now().plusSeconds(60)
        val expirationStr = expiration.toString().substringBefore(".").substringBefore("Z")
        val hashForK = if (nonce == 0) hash else sha256(hash + ByteArray(4) { ((nonce shr (it * 8)) and 0xFF).toByte() })
        val headBlockId = result["head_block_id"]!!.jsonPrimitive.content
        val headBlockNumber = result["head_block_number"]!!.jsonPrimitive.content.toLong()
        val k = kCalc.nextK()
        val kCalc = HMacDSAKCalculator(SHA256Digest())
        val operation = """["custom_json",{"required_auths":[],"required_posting_auths":["$username"],"id":"$opId","json":"$escapedJson"}]"""
        val propsJson = Json.parseToJsonElement(propsResp.bodyAsText()).jsonObject
        val propsResp = client.post("https://api.hive.blog") {
        val r = rPoint.xCoord.toBigInteger().mod(ecDomain.n)
        val rBytes = bigIntTo32Bytes(r)
        val rPoint = ecDomain.g.multiply(k).normalize()
        val refBlockNum = (headBlockNumber and 0xFFFF).toInt()
        val refBlockPrefix = (refBlockPrefixBytes[0].toInt() and 0xFF) or
        val refBlockPrefixBytes = hexToBytes(headBlockId.substring(8, 16))
        val refBlockPrefixUnsigned = refBlockPrefix.toLong() and 0xFFFFFFFFL
        val result = propsJson["result"]!!.jsonObject
        val sBytes = bigIntTo32Bytes(s)
        val sNegated = s > halfN
        val sig = ByteArray(65)
        val sigHex = ecdsaSign(digest, decodeWif(postingKeyWif))
        val txBytes = serializeTransaction(refBlockNum, refBlockPrefix, expiration.epochSecond.toInt(), username, opId, jsonPayload)
        var recId = if (rPoint.yCoord.toBigInteger().testBit(0)) 1 else 0
        var s = k.modInverse(ecDomain.n).multiply(BigInteger(1, hash).add(privKey.multiply(r))).mod(ecDomain.n)
        }
    !(r[0].toInt() == 0 && (r[1].toInt() and 0x80) == 0) &&
    !(s[0].toInt() == 0 && (s[1].toInt() and 0x80) == 0)
    (s[0].toInt() and 0x80) == 0 &&
    // custom_json op type = 18
    // expiration: uint32 LE
    // extensions: empty
    // id
    // json payload
    // operations count: varint(1)
    // ref_block_num: uint16 LE
    // ref_block_prefix: uint32 LE
    // required_auths: empty
    // required_posting_auths: [username]
    bigIntTo32Bytes(x).copyInto(encoded, 1)
    buf.write((expirationSecs shr 16) and 0xFF)
    buf.write((expirationSecs shr 24) and 0xFF)
    buf.write((expirationSecs shr 8) and 0xFF)
    buf.write((refBlockNum shr 8) and 0xFF)
    buf.write((refBlockPrefix shr 16) and 0xFF)
    buf.write((refBlockPrefix shr 24) and 0xFF)
    buf.write((refBlockPrefix shr 8) and 0xFF)
    buf.write(bytes)
    buf.write(expirationSecs and 0xFF)
    buf.write(refBlockNum and 0xFF)
    buf.write(refBlockPrefix and 0xFF)
    buf.write(v and 0x7F)
    encoded[0] = if (yOdd) 0x03 else 0x02
    expirationSecs: Int,
    for (c in input) {
    for (i in data.indices) {
    if (!rPoint.multiply(n).isInfinity) return null
    if (x >= prime) return null
    jsonPayload: String,
    opId: String,
    postingKeyWif: String,
    refBlockNum: Int,
    refBlockPrefix: Int,
    return ByteArray(leadingZeros) + stripped
    return ECAlgorithms.sumOfTwoMultiplies(ecDomain.g, eInv.multiply(rInv).mod(n), rPoint, s.multiply(rInv).mod(n))
    return buf.toByteArray()
    return data
    return ecDomain.curve.decodePoint(encoded)
    return ecdsaSign(msgHash, keyBytes)
    return raw.copyOfRange(1, 33)
    return when {
    try {
    username: String,
    val buf = ByteArrayOutputStream()
    val bytes = n.toByteArray()
    val bytes = num.toByteArray()
    val bytes = s.toByteArray(Charsets.UTF_8)
    val client = httpClient()
    val curve = ecDomain.curve
    val data = ByteArray(hex.length / 2)
    val e = BigInteger(1, hash)
    val eInv = BigInteger.ZERO.subtract(e).mod(n)
    val encoded = ByteArray(33)
    val halfN = ecDomain.n.shiftRight(1)
    val keyBytes = decodeWif(postingKeyWif)
    val leadingZeros = input.takeWhile { it == '1' }.length
    val msgHash = sha256(message.toByteArray(Charsets.UTF_8))
    val n = ecDomain.n
    val prime = curve.field.characteristic
    val privKey = BigInteger(1, privKeyBytes)
    val rInv = r.modInverse(n)
    val rPoint = decompressPoint(x, recId and 1 == 1)
    val raw = base58Decode(wif)
    val stripped = if (bytes.isNotEmpty() && bytes[0].toInt() == 0) bytes.copyOfRange(1, bytes.size) else bytes
    val x = r.add(BigInteger.valueOf((recId / 2).toLong()).multiply(n))
    var nonce = 0
    var num = BigInteger.ZERO
    var v = value
    while (true) {
    while (v >= 0x80) {
    writeVarString(buf, jsonPayload)
    writeVarString(buf, opId)
    writeVarString(buf, username)
    writeVarint(buf, 0)
    writeVarint(buf, 1)
    writeVarint(buf, 18)
    writeVarint(buf, bytes.size)
    }
    } finally {
 * BouncyCastle secp256k1 primitives through plain JVM APIs, and a signature that differs
 * Hive/Graphene transaction signing, shared by Android and desktop. Both reach the same
 * between the two builds is by definition a bug — so there is one implementation, not one
 * per source set. iOS and wasm have no Hive support and stub the expects instead.
 */
): ByteArray {
): String {
/*
actual fun signMessage(message: String, postingKeyWif: String): String {
actual suspend fun buildSignedCustomJson(
internal fun ByteArray.toHexString(): String = joinToString("") { "%02x".format(it) }
internal fun bigIntTo32Bytes(n: BigInteger): ByteArray {
internal fun decodeWif(wif: String): ByteArray {
internal fun ecdsaSign(hash: ByteArray, privKeyBytes: ByteArray): String {
internal fun hexToBytes(hex: String): ByteArray {
internal fun recoverPublicKey(hash: ByteArray, r: BigInteger, s: BigInteger, recId: Int): ECPoint? {
private const val BASE58_ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"
private const val HIVE_CHAIN_ID = "beeab0de00000000000000000000000000000000000000000000000000000000"
private fun base58Decode(input: String): ByteArray {
private fun decompressPoint(x: BigInteger, yOdd: Boolean): ECPoint {
private fun isCanonical(r: ByteArray, s: ByteArray): Boolean = (r[0].toInt() and 0x80) == 0 &&
private fun serializeTransaction(
private fun sha256(data: ByteArray): ByteArray = MessageDigest.getInstance("SHA-256").digest(data)
private fun writeVarString(buf: ByteArrayOutputStream, s: String) {
private fun writeVarint(buf: ByteArrayOutputStream, value: Int) {
private val curveSpec = ECNamedCurveTable.getParameterSpec("secp256k1")
private val ecDomain = ECDomainParameters(curveSpec.curve, curveSpec.g, curveSpec.n, curveSpec.h)
}
