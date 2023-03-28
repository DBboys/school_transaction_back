package com.song.config.json.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.song.util.DateUtil;

import java.io.IOException;
import java.util.Date;

/**
 * @author shizuku
 * @date 2020/4/24 21:57
 */
public class JavaDateJsonSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String string = null;
        if (date != null) {
            string = DateUtil.getYYYYMMDD(date);
        }
        jsonGenerator.writeString(string);
    }

}
