package br.com.store.infrastructure.serializer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateHelper {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public String parseToString(Date date) throws ParseException {
        return dateTimeFormat.format(date);
    }

    public Date parseToDate(String dateStr) throws ParseException {
        return dateFormat.parse(dateStr);
    }

    public Date parseToDateTime(String dateStr) throws ParseException {
        return dateTimeFormat.parse(dateStr);
    }
}
