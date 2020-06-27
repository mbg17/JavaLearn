package json;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class JsonTest {
    @Test
    /**
     * json转java对象
     */
    public void test1() throws IOException {
        String json = "{\"name\":\"luyusn\",\"age\":100}";
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json, Person.class);
        System.out.println(person);
    }

    @Test
    /**
     * java对象转json
     */
    public void test3() throws JsonProcessingException {
        Person person = new Person();
        person.setAge(10);
        person.setName("jack");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(person);
        System.out.println(s);
    }
}
