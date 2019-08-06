package com.edgarlpassos.model.serialization;

import com.edgarlpassos.model.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.api.common.serialization.SerializationSchema;

public class EventSerializationSchema implements SerializationSchema<Event> {
    ObjectMapper objectMapper;

    @Override
    public byte[] serialize(Event event) {
        if (this.objectMapper == null) {
            this.objectMapper = new ObjectMapper();
        }

        try {
            return this.objectMapper.writeValueAsBytes(event);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }
}
