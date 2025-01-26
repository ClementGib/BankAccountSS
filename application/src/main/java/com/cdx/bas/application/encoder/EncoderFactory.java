package com.cdx.bas.application.encoder;

import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;

public class EncoderFactory {

    /**
     * Create an encoder for the given class type.
     *
     * @param clazz The class for which the encoder is to be created.
     * @param <T>   The type of the class.
     * @return An encoder for the given class type.
     */
    public static <T> Encoder<T> createEncoder(Class<T> clazz) {
        return Encoders.bean(clazz);
    }
}
