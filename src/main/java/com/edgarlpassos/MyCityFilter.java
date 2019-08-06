package com.edgarlpassos;

import com.edgarlpassos.model.Event;
import com.edgarlpassos.model.serialization.EventDeserializationSchema;
import com.edgarlpassos.model.serialization.EventSerializationSchema;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011;

import java.util.Properties;

public class MyCityFilter {

    public MyCityFilter(final StreamExecutionEnvironment environment, final String brokerId, final String topic) {
        final Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", brokerId);
        properties.setProperty("group.id", topic);

        final FlinkKafkaConsumer011<Event> consumer = new FlinkKafkaConsumer011<>(topic, new EventDeserializationSchema(), properties);
        final FlinkKafkaProducer011<Event> producer = new FlinkKafkaProducer011<>(brokerId, "city", new EventSerializationSchema());

        environment.addSource(consumer).filter(MyCityFilter::filter).addSink(producer);
    }

    private static boolean filter(Event event) {
        if (event.venue.city == null) return false;
        return event.venue.city.equals("Muenchen") || event.venue.city.equals("München");
    }
}

