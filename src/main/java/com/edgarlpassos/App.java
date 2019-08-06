package com.edgarlpassos;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import static java.lang.String.format;

public class App {
    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            throw new IllegalArgumentException(format("Invalid number of arguments, expected 3, got %d", args.length));
        }

        final String kafkaBroker = args[0];
        final String kafkaTopic = args[1];
        final String inputFile = args[2];

        final StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();

        new MyStreamer(environment, inputFile, kafkaBroker, kafkaTopic);
        new MyCountryFilter(environment, kafkaBroker, kafkaTopic);
        new MyCityFilter(environment, kafkaBroker, "country");

        environment.execute();
    }
}
