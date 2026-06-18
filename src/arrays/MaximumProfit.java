package arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumProfit {

    static class Pair {
        int category;
        int price;

        Pair(int category, int price) {
            this.category = category;
            this.price = price;
        }
    }

    public static long calculateProfit(List<Integer> category, List<Integer> price) {

        List<Pair> pairs = new ArrayList<>();

        for (int i = 0 ; i < category.size() ; i++) {
            Pair pair = new Pair(category.get(i), price.get(i));
            pairs.add(pair);
        }

        pairs.sort(Comparator.comparingInt(p -> p.price));

        Set<Integer> set = new HashSet<>();

        set.addAll(category);

        int totalCategory = set.size();
        int categorySoldUpto = 0;
        long totalProfit = 0;

        set.clear();

        for (Pair pair : pairs) {

            if (categorySoldUpto == 0) {
                totalProfit += pair.price;
                set.add(pair.category);
                categorySoldUpto++;
            }
            else if (set.contains(pair.category)) {
                totalProfit += pair.price*categorySoldUpto;
            } else {
                categorySoldUpto++;
                totalProfit +=  pair.price*categorySoldUpto;
                set.add(pair.category);
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        List<Integer> category = List.of(3,1,2,3);
        List<Integer> price = List.of(2,1,4,4);

        System.out.println(calculateProfit(category, price));

    }
}
