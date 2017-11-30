import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * Created by sbata on 30/11/2017.
 */
public class FilterSettings {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Long> dataStream = env
                .socketTextStream("localhost", 9999)
                .filter(new Filter())
                .map(new RoundDouble());

        dataStream.print();

        env.execute("FilterSettings Strings");

    }

    public static class RoundDouble implements MapFunction<String, Long> {
        public Long map(String input) throws Exception {
            return Math.round(Double.parseDouble(input.trim()));
        }

    }

    public static class Filter implements FilterFunction<String> {

        public boolean filter(String input) throws Exception {
            try {
                Double.parseDouble(input.trim());

                return true;
            } catch (Exception ex) {

            }
            return false;
        }
    }

}
