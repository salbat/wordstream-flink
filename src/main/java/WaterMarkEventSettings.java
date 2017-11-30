import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

public class WaterMarkEventSettings {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<InputPair> counts = env
                .socketTextStream("localhost", 9999)
                .map(new MapFunction<String, InputPair>() {
                    private String[] tokens;

                    @Override
                    public InputPair map(String value) throws Exception {
                        tokens = value.split(",");
                        return new InputPair(tokens[0],
                                Double.parseDouble(tokens[1]));
                    }
                })
                .keyBy("k")
                .timeWindow(Time.seconds(10), Time.seconds(5))
                .sum("v");

        counts.print();

        env.execute("WaterMarkEvent Strings");

    }
}
