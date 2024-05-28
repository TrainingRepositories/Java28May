package com.ksa.jodayn.services;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class DateUtilService {
    public int calcYearOfBirth(int age) {
        return Calendar.getInstance().get(Calendar.YEAR) - age;
    }
}
