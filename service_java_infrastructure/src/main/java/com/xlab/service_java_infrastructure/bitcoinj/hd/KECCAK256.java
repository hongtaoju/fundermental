package com.xlab.service_java_infrastructure.bitcoinj.hd;

import org.spongycastle.crypto.digests.KeccakDigest;

public class KECCAK256 {
    private static final int keccak256_DIGEST_LENGTH = 32;

    public static byte[] keccak256(byte[] bytes) {
        return keccak256(bytes, 0, bytes.length);
    }

    public static byte[] keccak256(byte[] bytes, int offset, int size) {
        KeccakDigest keccakDigest = new KeccakDigest(256);
        keccakDigest.update(bytes, offset, size);
        byte[] keccak256 = new byte[keccak256_DIGEST_LENGTH];
        // TODO: 2018/10/19 有 BUG
        keccakDigest.doFinal(keccak256, offset);
        return keccak256;
    }
}
