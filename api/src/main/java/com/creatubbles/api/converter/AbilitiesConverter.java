package com.creatubbles.api.converter;

import com.creatubbles.api.model.Ability;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.jasminb.jsonapi.JSONAPISpecConstants.ATTRIBUTES;
import static com.github.jasminb.jsonapi.JSONAPISpecConstants.ID;


public class AbilitiesConverter extends StdDeserializer<List<Ability>> {

    public AbilitiesConverter() {
        super(Ability.class);
    }

    @Override
    public List<Ability> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        JsonNode treeNode = mapper.readTree(p);

        List<Ability> abilities = new ArrayList<>(treeNode.size());
        for (JsonNode element : treeNode) {
            abilities.add(readObject(element, mapper));
        }
        return abilities;
    }

    private Ability readObject(JsonNode source, ObjectMapper mapper) throws JsonProcessingException {
        String identifier = source.get(ID).asText();
        Ability result = null;
        if (source.has(ATTRIBUTES)) {
            result = mapper.treeToValue(source.get(ATTRIBUTES), Ability.class);
        }
        if (result != null) {
            result.setId(identifier); // this requires setter, perhaps we could use reflection
        }
        return result;
    }
}
