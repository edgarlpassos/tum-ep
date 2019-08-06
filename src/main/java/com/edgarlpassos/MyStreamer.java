package com.edgarlpassos;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011;

public class MyStreamer {
    public MyStreamer(final StreamExecutionEnvironment environment, final String inputFile, final String brokerId, final String topic) {
        final DataStream<String> stream = environment.readTextFile(inputFile);
        stream.addSink(new FlinkKafkaProducer011<>(brokerId, topic, new SimpleStringSchema()));
    }
}
