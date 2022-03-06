package Medium;

import java.util.*;

/*
Given a sorted integer array arr, two integers k and x,
return the k closest integers to x in the array.
The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b

Example 1:

Input: arr = [1,2,4,5], k = 2, x = 3
Output: [2,4]

*/

public class FindKClosetSum {
    public static void main(String[] args) {
        int[] arr = { 1, 7, 3, 6, 5, 6 };
        System.out.println(findClosestElements(arr, 2, 4));
    }

    static class Pair implements Comparable<Pair> {
        int val, gap;

        Pair() {
        }

        Pair(int val, int gap) {
            this.val = val;
            this.gap = gap;
        }

        public int compareTo(Pair o) {
            if (this.gap != o.gap)
                return this.gap - o.gap;
            else
                return this.val - o.val;
        }
    }

    // Using Priority Queue - but not optimised way
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            if (pq.size() < k) {
                pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
            } else if (pq.peek().gap > Math.abs(arr[i] - x)) {
                pq.remove();
                pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (pq.size() > 0) {
            Pair p = pq.remove();
            ans.add(p.val);
        }
        Collections.sort(ans);
        return ans;
    }
}
