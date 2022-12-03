package me.gleeming.aoc.three;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * completed in:
 * part 1 - 11:50
 * part 2 - 15:50
 * global rank: 2644
 */
public class DayThree {

    private static final List<String> values = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        File file = new File("input");
        Scanner scanner = new Scanner(file);

        List<String> commonChars = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();

            String first = nextLine.substring(0, nextLine.length() / 2);
            String second = nextLine.substring(nextLine.length() / 2);

            List<String> firstChars = Arrays.stream(first.split("")).collect(Collectors.toList());
            List<String> secondChars = Arrays.stream(second.split("")).collect(Collectors.toList());

            for (String c : firstChars) {
                if (secondChars.contains(c)) {
                    commonChars.add(c);
                    break;
                }
            }
        }

        System.out.println(commonChars.stream().mapToInt(c -> {
            boolean uppercase = c.toUpperCase().equals(c);
            int value = values.indexOf(c.toLowerCase()) + 1;
            if (uppercase) {
                value += 26;
            }

            return value;
        }).sum());

        commonChars = new ArrayList<>();
        scanner = new Scanner(file);
        List<String> added = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            added.add(nextLine);

            if (added.size() == 3) {
                String first = added.get(0);
                String second = added.get(1);
                String third = added.get(2);

                List<String> firstChars = Arrays.stream(first.split("")).collect(Collectors.toList());
                List<String> secondChars = Arrays.stream(second.split("")).collect(Collectors.toList());
                List<String> thirdChars = Arrays.stream(third.split("")).collect(Collectors.toList());

                for (String c : firstChars) {
                    if (secondChars.contains(c) && thirdChars.contains(c)) {
                        commonChars.add(c);
                        break;
                    }
                }

                added.clear();
            }
        }

        System.out.println(commonChars.stream().mapToInt(c -> {
            boolean uppercase = c.toUpperCase().equals(c);
            int value = values.indexOf(c.toLowerCase()) + 1;
            if (uppercase) {
                value += 26;
            }

            return value;
        }).sum());
    }

    static {
        values.add("a");
        values.add("b");
        values.add("c");
        values.add("d");
        values.add("e");
        values.add("f");
        values.add("g");
        values.add("h");
        values.add("i");
        values.add("j");
        values.add("k");
        values.add("l");
        values.add("m");
        values.add("n");
        values.add("o");
        values.add("p");
        values.add("q");
        values.add("r");
        values.add("s");
        values.add("t");
        values.add("u");
        values.add("v");
        values.add("w");
        values.add("x");
        values.add("y");
        values.add("z");
    }

}
