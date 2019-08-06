package com.edgarlpassos;

import com.edgarlpassos.model.Event;
import com.edgarlpassos.model.serialization.EventDeserializationSchema;
import com.edgarlpassos.model.serialization.EventSerializationSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011;

import java.util.Properties;

public class MyCountryFilter {
    public MyCountryFilter(final StreamExecutionEnvironment environment, final String brokerId, final String topic) {
        final Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", brokerId);
        properties.setProperty("group.id", topic);

        final FlinkKafkaConsumer011<Event> consumer = new FlinkKafkaConsumer011<>(topic, new EventDeserializationSchema(), properties);
        final FlinkKafkaProducer011<Event> producer = new FlinkKafkaProducer011<>(brokerId, "country", new EventSerializationSchema());

        environment.addSource(consumer).filter(MyCountryFilter::filter).addSink(producer);
    }

    private static boolean filter(Event event) {
        if (event.venue == null) return false;
        if (event.venue.country == null) return false;
        return event.venue.country.equals("de");
    }
}
