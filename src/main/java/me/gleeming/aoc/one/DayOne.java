package me.gleeming.aoc.one;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * completed in:
 * part 1 - 5:35
 * part 2 - 6:38
 * global rank: 1461
 */
public class DayOne {

    public static void main(String[] args) throws Exception {
        File file = new File("input");
        Scanner scanner = new Scanner(file);

        List<Integer> amounts = new ArrayList<>();
        int currentAmount = 0;

        while(scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.equals("")){
                amounts.add(currentAmount);
                currentAmount = 0;
                continue;
            }

            currentAmount += Integer.parseInt(nextLine);
        }

        // answer to question 1
        System.out.println(amounts.stream()
                .sorted(Comparator.comparingInt(a -> -a))
                .findFirst().get().intValue()
        );

        // answer to question 2
        System.out.println(amounts.stream()
                .sorted(Comparator.comparingInt(a -> -a))
                .limit(3)
                .mapToInt(a -> a)
                .sum()
        );
    }
}