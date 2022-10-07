package com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Component
public class RandomDateGenerator {

    public Date getRandomDateGenerator(){
        Random r = new Random();
        Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(Calendar.MONTH, Math.abs(r.nextInt()) % 12);
        calendar.set(Calendar.DAY_OF_MONTH, Math.abs(r.nextInt()) % 30);
        calendar.set(Calendar.YEAR, Math.abs(Calendar.getInstance().get(Calendar.YEAR)) + r.nextInt(4));
        calendar.setLenient(true);
        return calendar.getTime();
    }
}
