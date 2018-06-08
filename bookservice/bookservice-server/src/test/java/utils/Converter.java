package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intexsoft.bookservice.web.dto.entity.PublisherDto;

import java.util.List;

public class Converter {

    public static String fromListToJson(List<PublisherDto> entities) {
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
