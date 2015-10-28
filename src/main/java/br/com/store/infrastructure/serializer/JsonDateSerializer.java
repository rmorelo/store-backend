package br.com.store.infrastructure.serializer;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

public class JsonDateSerializer extends JsonSerializer<Date> {

    private JsonDateConverter converter = new JsonDateConverter();

    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws
        IOException {

        String formattedDate = converter.toString(date);
        gen.writeString(formattedDate);
    }

}
