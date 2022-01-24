package Easy;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 0 };
        System.out.println(canPlaceFlowers(arr, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for (int i = 0; i < len && n > 0; i++) {
            int pre = i == 0 ? 0 : i - 1; // handle pre for out of boundaries
            int next = i == len - 1 ? len - 1 : i + 1; // handle next for out of boundaries
            if (flowerbed[pre] != 1 && flowerbed[i] != 1 && flowerbed[next] != 1) {
                n--;
                i++;
            }
        }
        return n <= 0;
    }
}
