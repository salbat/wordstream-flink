import java.io.Serializable;

public class InputPair implements Serializable {

        public String k;
        public Double v;

        public InputPair() {
        }

        public InputPair(String k, Double v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public String toString() {
            return "InputPair{" +
                    "Key='" + k + '\'' +
                    ", Value=" + v +
                    '}';
        }
}
