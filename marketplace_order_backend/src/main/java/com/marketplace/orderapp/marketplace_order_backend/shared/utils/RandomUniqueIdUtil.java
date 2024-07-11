package com.marketplace.orderapp.marketplace_order_backend.shared.utils;

import java.time.LocalDate;
import java.util.Random;

public class RandomUniqueIdUtil {
    private static final int RANDOM_NUMBER_LENGTH = 6;

       public static String generateUniqueId(String eventCode) {
        LocalDate currentDate = LocalDate.now();
        String datePrefix = currentDate.format(java.time.format.DateTimeFormatter.BASIC_ISO_DATE);
        String randomNumber = generateRandomNumber(RANDOM_NUMBER_LENGTH);

        return datePrefix + eventCode + randomNumber;
    }

    private static String generateRandomNumber(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }
}