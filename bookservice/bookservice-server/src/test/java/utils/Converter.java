package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Converter<T> {

    public String fromListToJson(List<T> entities) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonLine = "";
        try {
            jsonLine = mapper.writeValueAsString(entities);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonLine;
    }
}
