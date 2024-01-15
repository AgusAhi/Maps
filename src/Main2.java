import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = readCSV();
        Scanner scanner = new Scanner(System.in);



        while (true) {
            System.out.println("Enter the Spanish lastname:");
            String lastname = scanner.nextLine().toUpperCase();
            if (lastname.equals("")) {
                break;
            }
            Integer freq = map.get(lastname);
            if (freq == null) {
                System.out.println(lastname + " doesn't exist");
            } else {
                System.out.println("Frequecy: " + freq);
            }
        }
    }

    public static Map<String, Integer> readCSV() throws IOException {
        BufferedReader input = null;
        Map<String, Integer> map = new HashMap<>();
        try {
            input = new BufferedReader(new FileReader("LastnameFrequencies.csv"));
            String line;
            while ((line = input.readLine()) != null) {
                String [] items = line.split(",");
                String lastName = items[0];
                String freqStr = items[1].replaceAll("\\.","");
                Integer freq = Integer.parseInt(freqStr);
                map.put(lastName, freq);
            }
            return map;
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
}
