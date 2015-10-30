package br.com.store.backend.infrastructure.serializer;

import java.util.Date;

public class JsonDateConverter {

    private DateHelper dateHelper;
    public JsonDateConverter() {
        dateHelper = new DateHelper();
    }

    public Date fromString(String content) {

        try {
            return dateHelper.parseToDateTime(content);
        } catch (Exception ex1) {

            try {
                return dateHelper.parseToDate(content);
            } catch (Exception ex2) {
                throw new IllegalArgumentException("Unparsable date format " + content);
            }
        }
    }

    public String toString(Date date) {

        try {
            return dateHelper.parseToString(date);
        } catch (Exception ex1) {
            throw new IllegalArgumentException("Unparsable date format " + date);
        }
    }

}
