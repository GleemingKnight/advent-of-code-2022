package me.gleeming.aoc.four;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * completed in:
 * part 1 - 6:00
 * part 2 - 7:03
 * global rank: 1134
 */
public class DayFour {

    public static void main(String[] args) throws Exception {
        File file = new File("input");
        Scanner scanner = new Scanner(file);

        int amount = 0;
        int overLapAtAll = 0;

        while(scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            String[] initialSplit = nextLine.split(",");

            String[] firstElf = initialSplit[0].split("-");
            String[] secondElf = initialSplit[1].split("-");

            List<Integer> firstElfCleaning = new ArrayList<>();
            List<Integer> secondElfCleaning = new ArrayList<>();

            int firstStart = Integer.parseInt(firstElf[0]);
            int firstEnd = Integer.parseInt(firstElf[1]);

            for (int i = firstStart; i <= firstEnd; i++) {
                firstElfCleaning.add(i);
            }

            int secondStart = Integer.parseInt(secondElf[0]);
            int secondEnd = Integer.parseInt(secondElf[1]);

            for (int i = secondStart; i <= secondEnd; i++) {
                secondElfCleaning.add(i);
            }

            boolean matches = true;
            for (int num : firstElfCleaning) {
                if (!secondElfCleaning.contains(num)) {
                    matches = false;
                    break;
                }
            }

            if (!matches) {
                matches = true;
                for (int num : secondElfCleaning) {
                    if (!firstElfCleaning.contains(num)) {
                        matches = false;
                        break;
                    }
                }
            }

            if (matches) {
                amount++;
            }

            if (secondElfCleaning.stream().anyMatch(firstElfCleaning::contains)) {
                overLapAtAll++;
            }
        }

        // first answer
        System.out.println(amount);

        // second answer
        System.out.println(overLapAtAll);
    }
}