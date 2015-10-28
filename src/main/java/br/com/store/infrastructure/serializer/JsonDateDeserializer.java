package br.com.store.infrastructure.serializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;

public class JsonDateDeserializer extends JsonDeserializer<Date> {

    private JsonDateConverter converter = new JsonDateConverter();


    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {

        String date = jsonParser.getText();
        return converter.fromString(date);
    }

}
