import java.math.BigInteger
import java.security.MessageDigest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import org.bouncycastle.crypto.params.ECDomainParameters
import org.bouncycastle.jce.ECNamedCurveTable

            "$label: recovered public key doesn't match expected (recId=$recId, r=${r.toString(16).take(16)}...)",
            assertRecoveryMatchesPubKey(sigHex, data, "hash-$i")
            data = sha256(data)
            expectedPubKeyHex,
            recoveredCompressed.toHexString(),
            val sigHex = ecdsaSign(data, privKeyBytes)
        )
        // Simulate transaction signing: single SHA-256 of (chain_id + tx_bytes)
        // Test with 20 different hashes to catch intermittent recovery ID bugs
        // tx_bytes does NOT include signatures (Hive casts to transaction& which excludes them)
        assert(recId in 0..3) { "$label: invalid recId $recId (header=0x${header.toString(16)})" }
        assertEquals(
        assertEquals(expected, decodeWif(testWif).toHexString())
        assertNotNull(recovered, "$label: recoverPublicKey returned null for recId=$recId")
        assertRecoveryMatchesPubKey(sigHex, digest, "transaction")
        assertRecoveryMatchesPubKey(sigHex, hash, "login")
        bigIntTo32Bytes(recoveredNorm.xCoord.toBigInteger()).copyInto(recoveredCompressed, 1)
        recoveredCompressed[0] = if (recoveredNorm.yCoord.toBigInteger().testBit(0)) 0x03 else 0x02
        repeat(20) { i ->
        val chainId = hexToBytes("beeab0de" + "0".repeat(56))
        val digest = sha256(chainId + txBytes)
        val expected = "eb84dc7ce42d0119215f2ec7dae8445a7b4253ed3f69017424a225eb547d10d8"
        val hash = sha256("schalikan1773664000000".toByteArray(Charsets.UTF_8))
        val header = sigBytes[0].toInt() and 0xFF
        val privKeyBytes = decodeWif(testWif)
        val r = BigInteger(1, sigBytes.copyOfRange(1, 33))
        val recId = header - 27 - 4
        val recovered = recoverPublicKey(hash, r, s, recId)
        val recoveredCompressed = ByteArray(33)
        val recoveredNorm = recovered.normalize()
        val s = BigInteger(1, sigBytes.copyOfRange(33, 65))
        val sigBytes = hexToBytes(sigHex)
        val sigHex = ecdsaSign(digest, privKeyBytes)
        val sigHex = signMessage("schalikan1773664000000", testWif)
        val txBytes = hexToBytes(txBytesHex)
        val txBytesHex = "384b6fce49d75df8b7690112000109736368616c696b616e0d736d5f66696e645f6d617463684b7b226d617463685f74797065223a2257696c642052616e6b6564222c22617070223a2273706c696e7465726c616e64732f302e372e313736222c226e223a22746573744e6f6e636531227d00"
        var data = "seed".toByteArray()
        }
    @Test
    fun decodeWifProducesCorrectPrivateKey() {
    fun loginSignatureRecoveryMatchesPublicKey() {
    fun recoveryWorksForManyDifferentHashes() {
    fun transactionSignatureRecoveryMatchesPublicKey() {
    private fun assertRecoveryMatchesPubKey(sigHex: String, hash: ByteArray, label: String) {
    private fun sha256(data: ByteArray): ByteArray = MessageDigest.getInstance("SHA-256").digest(data)
    private val curveSpec = ECNamedCurveTable.getParameterSpec("secp256k1")
    private val ecDomain = ECDomainParameters(curveSpec.curve, curveSpec.g, curveSpec.n, curveSpec.h)
    private val expectedPubKeyHex = "023d2e4c41caf89bcc518ee4433a6dda4e6aa49b2b2f63d9056f1a6f23f8f2476a"
    private val testWif = "5Kc1bduGE6QCwBWeZbG99NM7odT8y9MY9TdCnbDLcJhTGQPxnTE"
    }
 *
 * Pub key (compressed): 023d2e4c41caf89bcc518ee4433a6dda4e6aa49b2b2f63d9056f1a6f23f8f2476a
 * Tests for Hive ECDSA signing with recovery ID verification.
 * Uses WIF 5Kc1bduGE6QCwBWeZbG99NM7odT8y9MY9TdCnbDLcJhTGQPxnTE
 */
/**
class HiveCryptoTest {
package com.inspiredandroid.kai.splinterlands
}
