import java.util.*;
    public class Main {
        public static void main(String[] args) {
            Map<String, Integer> m = new LinkedHashMap<>();
                // Initialize frequency table from command line
            for (String s : args) {
                Integer freq = m.get(s);
                if (freq == null) {
                    m.put(s, 1);
                } else {
                    freq++;
                    m.put(s, freq);
                }
            }
            System.out.println(m.size() + " different words:");
            System.out.println(m);
        }
    }

