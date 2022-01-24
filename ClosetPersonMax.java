public class ClosetPersonMax {

    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 0, 1 };
        System.out.println(maxDistToClosest(arr));
    }

    public static int maxDistToClosest(int[] seats) {
        int last = -1;
        int resMax = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (last == -1) {
                    resMax = Math.max(resMax, i);
                } else {
                    resMax = Math.max(resMax, (i - last) / 2);
                }
                last = i;
            }
        }
        resMax = Math.max(resMax, (seats.length - 1 - last));
        return resMax;
    }
}
