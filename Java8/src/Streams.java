import java.util.*;
import java.util.concurrent.TimeUnit;

public class Streams {



    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection.stream().filter((s) -> s.startsWith("a")).forEach(elem -> System.out.println(elem));

        System.out.println();

        stringCollection.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);

        System.out.println();

        stringCollection.stream().sorted().filter(s -> s.startsWith("a")).forEach(System.out::println);

        System.out.println();

        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a,b) -> b.compareTo(a))
                .forEach(System.out::println);

        System.out.println();

        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch(s -> s.startsWith("a"));
        System.out.println(anyStartsWithA); // true

        System.out.println();

        boolean allStartWithA =
                stringCollection
                        .stream()
                        .allMatch(s -> s.startsWith("a"));
        System.out.println(allStartWithA); // false

        System.out.println();

        boolean noneStartWithZ =
                stringCollection
                        .stream()
                        .noneMatch(s -> s.startsWith("z"));
        System.out.println(noneStartWithZ); // true

        System.out.println();

        long startsWithB = stringCollection.stream().filter(s -> s.startsWith("b")).count();
        System.out.println(startsWithB); // 3

        System.out.println();

        Optional<String> reduced = stringCollection.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);

        System.out.println();

        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> sum = arr.stream().reduce(Integer::sum);
        Optional<Integer> prod = arr.stream().reduce((a, b) -> a*b);
        sum.ifPresent(System.out::println);
        prod.ifPresent(System.out::println);
        System.out.println();

        // parallel streams vs sequential streams
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        // sequential streams
        long t0 = System.nanoTime();
        long count = values.stream().sorted().sorted((a,b) -> b.compareTo(a)).count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        //parallel streams
        t0 = System.nanoTime();
        count = values.parallelStream().sorted().sorted((a,b) -> b.compareTo(a)).count();
        System.out.println(count);
        t1 = System.nanoTime();
        millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));

        System.out.println();

        // MAPS
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        map.forEach((id, val) -> System.out.println(val));

    }
}
