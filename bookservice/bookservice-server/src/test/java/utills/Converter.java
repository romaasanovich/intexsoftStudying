package utills;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intexsoft.bookservice.dao.entity.Publisher;
import com.intexsoft.bookservice.dao.entity.aentity.AbstractEntity;

import java.util.List;

public class Converter {


    public  String fromListToJson(List<Publisher> entities){
        ObjectMapper mapper = new ObjectMapper();
        String jsonLine ="";
        try {
            jsonLine = mapper.writeValueAsString(entities);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonLine;
    }
}
