package com.reihaneh.personalexpenses.web.rest.util;

import com.auth0.jwt.algorithms.Algorithm;

public class CustomUtilities {

    public static Algorithm getHMAC256Algorithm(String secret){
        return Algorithm.HMAC256(secret.getBytes());
    }
}
