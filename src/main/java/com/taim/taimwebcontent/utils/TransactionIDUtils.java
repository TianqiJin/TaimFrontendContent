package com.taim.taimwebcontent.utils;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class TransactionIDUtils {
    public static final Integer QUOTATION_ID_COUNT = 12;

    public String generateRandomString(String prefix, int length, String suffix) {
        StringBuilder idBuilder = new StringBuilder();

        if (prefix != null) {
            idBuilder.append(prefix);
        }
        if (length > 0) {
            idBuilder.append(RandomStringUtils.randomAlphabetic(length));
        }
        if (suffix != null) {
            idBuilder.append(suffix);
        }

        return idBuilder.toString();
    }

}
