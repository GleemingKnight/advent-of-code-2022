package me.gleeming.aoc.five;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * completed in:
 * part 1 - n/a
 * part 2 - n/a
 * global rank: n/a
 * fell asleep before puzzle opened
 */
public class DayFive {

    public static void main(String[] args) throws Exception {
        File file = new File("input");
        Scanner scanner = new Scanner(file);

        Map<Integer, List<String>> mapped = new HashMap<>();

        AtomicInteger currentlyOn = new AtomicInteger(1);

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();

            if (nextLine.equals("")) {
                continue;
            }

            int add = 0;

            if (nextLine.contains("[")) {
                for (String split : nextLine.split(" ")) {
                    if (!split.contains("[")) {
                        if (add == 3) {
                            currentlyOn.incrementAndGet();
                            add = 0;
                            continue;
                        }
                        add++;
                        continue;
                    }

                    String str = split.replaceAll("\\[", "").replaceAll("\\]", "");
                    List<String> a = mapped.getOrDefault(currentlyOn.get(), new ArrayList<>());
                    a.add(str);
                    System.out.println("added " + str + " to " + currentlyOn.get());
                    mapped.put(currentlyOn.getAndIncrement(), a);
                }

                currentlyOn.set(1);
                continue;
            }

            if (!nextLine.startsWith("move")) {
                new HashMap<>(mapped).forEach((a, b) -> {
                    Collections.reverse(b);
                    mapped.put(a, b);
                });
                continue;
            }

            nextLine = nextLine.substring(5);
            String[] split = nextLine.split(" ");

            System.out.println(Arrays.toString(split));

            int amount = Integer.parseInt(split[0]);
            int from = Integer.parseInt(split[2]);
            int to = Integer.parseInt(split[4]);

            List<String> fromList = mapped.get(from);
            List<String> toList = mapped.get(to);

            System.out.println(fromList.toString() + " " + amount);

            List<String> goingToAdd = new ArrayList<>();

            for (int i = 0; i < amount; i++) {
                goingToAdd.add(fromList.get(fromList.size() - 1));
                fromList.remove(fromList.size() - 1);
            }

            Collections.reverse(goingToAdd);
            toList.addAll(goingToAdd);

            mapped.put(from, fromList);
            mapped.put(to, toList);
        }

        StringBuilder answer = new StringBuilder();
        mapped.keySet().stream()
                .sorted(Comparator.comparingInt(a -> a))
                .forEach(key -> {
                    List<String> str = mapped.get(key);
                    answer.append(str.get(str.size() - 1));
                });

        System.out.println(answer);
    }

}
