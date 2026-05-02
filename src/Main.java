import java.util.*;

public class Main {

    // Task 1
    public static void checkAnagram(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (Arrays.equals(arr1, arr2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    // Task 2
    public static int kthSmallest(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }

    // Task 3
    public static int medianElement(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }

    // Task 4
    public static int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;


        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static boolean canShip(int[] weights, int days, int capacity) {
        int currentWeight = 0;
        int requiredDays = 1;

        for (int w : weights) {
            if (currentWeight + w > capacity) {
                requiredDays++;
                currentWeight = 0;
            }
            currentWeight += w;
        }

        return requiredDays <= days;
    }

    public static void main(String[] args) {

        // Task 1
        System.out.println("Task 1:");
        checkAnagram("listen", "silent");

        // Task 2
        System.out.println("\nTask 2:");
        int[] arr1 = {7, 2, 9, 4, 1, 5};
        int k = 3;
        System.out.println(kthSmallest(arr1, k));

        // Task 3
        System.out.println("\nTask 3:");
        int[] arr2 = {2, 2, 1, 2, 3, 2, 2};
        System.out.println(medianElement(arr2));

        // Task 4
        System.out.println("\nTask 4:");
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }
}