package br.com.store.infrastructure.formatter;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateFormatter {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    public static final String CUBUS_SUPPORT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String STANDARD_BR_DATE_FORMAT = "dd/MM/yyyy HH:mm";

    public String getStandardDateFromSupportFormat(Date supportDate) {
        simpleDateFormat.applyPattern(STANDARD_BR_DATE_FORMAT);
        return simpleDateFormat.format(supportDate);
    }
    
    public DateFormat getDateFormat() {
        SimpleDateFormat dateFormater = new SimpleDateFormat();
        dateFormater.applyPattern(CUBUS_SUPPORT_DATE_FORMAT);
        return dateFormater;
    }

}
