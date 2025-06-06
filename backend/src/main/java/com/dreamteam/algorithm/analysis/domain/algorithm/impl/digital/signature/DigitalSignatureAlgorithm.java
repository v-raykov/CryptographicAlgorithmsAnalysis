package com.dreamteam.algorithm.analysis.domain.algorithm.impl.digital.signature;

import com.dreamteam.algorithm.analysis.domain.algorithm.base.Algorithm;
import com.dreamteam.algorithm.analysis.domain.algorithm.base.AlgorithmType;
import com.dreamteam.algorithm.analysis.model.test.key.pair.AlgorithmKeyPair;
import org.bouncycastle.crypto.CryptoException;

import java.io.IOException;
import java.lang.reflect.Field;

public interface DigitalSignatureAlgorithm extends Algorithm {
    byte[] sign(byte[] data, byte[] privateKey) throws CryptoException, IOException;

    boolean verify(byte[] data, byte[] signature, byte[] publicKey) throws IOException;

    AlgorithmKeyPair generateKeyPair();

    @Override
    default AlgorithmType getType() {
        return AlgorithmType.DIGITAL_SIGNATURE;
    }

    @Override
    default Field[] getFields() {
        return AlgorithmKeyPair.class.getDeclaredFields();
    }
}
