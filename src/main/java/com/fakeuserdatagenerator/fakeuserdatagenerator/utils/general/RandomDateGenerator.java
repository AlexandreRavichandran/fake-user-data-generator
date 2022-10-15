package com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Component
public class RandomDateGenerator {

    public String getRandomFutureDate(String format) {

        Calendar calendar = this.generateFutureDate(java.util.Calendar.getInstance());
        calendar.setLenient(true);
        return this.formatDate(calendar.getTime(), format);
    }

    public String getRandomPastDate(String format){
        Calendar calendar = this.generatePastDate(java.util.Calendar.getInstance());
        calendar.setLenient(true);
        return this.formatDate(calendar.getTime(), format);
    }
    public String formatDate(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    private Calendar generatePastDate(Calendar calendar) {
        Random r = new Random();
        calendar.set(Calendar.MONTH, Math.abs(r.nextInt()) % 12);
        calendar.set(Calendar.DAY_OF_MONTH, Math.abs(r.nextInt()) % 30);
        calendar.set(Calendar.YEAR, Math.abs(Calendar.getInstance().get(Calendar.YEAR)) - r.nextInt(80));

        return calendar;
    }

    private Calendar generateFutureDate(Calendar calendar) {
        Random r = new Random();
        calendar.set(Calendar.MONTH, Math.abs(r.nextInt()) % 12);
        calendar.set(Calendar.DAY_OF_MONTH, Math.abs(r.nextInt()) % 30);
        calendar.set(Calendar.YEAR, Math.abs(Calendar.getInstance().get(Calendar.YEAR)) + r.nextInt(4));

        return calendar;
    }
}
