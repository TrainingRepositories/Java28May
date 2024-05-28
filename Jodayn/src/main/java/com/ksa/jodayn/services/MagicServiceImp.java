package com.ksa.jodayn.services;

import org.springframework.stereotype.Service;

@Service
public class MagicServiceImp implements MagicService {

    @Override
    public int number(int startingValue) {
        startingValue += 9 - startingValue % 10;
        for (int i = startingValue; true; i += 10) {
            if (testMagicNumber(i)) {
                return i;
            }
        }
    }

    public boolean testMagicNumber(int number) {
        for (int j = 2; j <= 10; j++) {
            if (number % j != j - 1) {
                return false;
            }
        }
        return true;
    }
}
