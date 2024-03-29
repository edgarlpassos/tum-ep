package com.edgarlpassos.model.serialization;

import com.edgarlpassos.model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;

import java.io.IOException;

public class EventDeserializationSchema implements DeserializationSchema<Event> {
    static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Event deserialize(byte[] bytes) throws IOException {
        return objectMapper.readValue(bytes, Event.class);
    }

    @Override
    public boolean isEndOfStream(Event event) {
        return false;
    }

    @Override
    public TypeInformation<Event> getProducedType() {
        return TypeInformation.of(Event.class);
    }
}
