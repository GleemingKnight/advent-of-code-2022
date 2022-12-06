package me.gleeming.aoc.six;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * completed in:
 * part 1 - 8:10
 * part 2 - 8:44
 * global rank: 3707
 */
public class DaySix {
    public static void main(String[] args) throws Exception {
        File file = new File("input");
        Scanner scanner = new Scanner(file);

        List<String> chars = new ArrayList<>();
        int num = 0;

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            for (String s : nextLine.split("")) {
                if (chars.size() == 14) {
                    chars.remove(0);
                    chars.add(s);

                    boolean matches = false;
                    for (String a : new ArrayList<>(chars)) {
                        chars.remove(a);

                        if (chars.contains(a)) {
                            matches = true;
                        }

                        chars.add(a);
                    }

                    if (!matches) {
                        System.out.println(num + 1);
                        return;
                    }
                } else {
                    chars.add(s);
                }

                num++;
            }

        }
    }
}
