|

public class Q605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int c = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRightPlot = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                if (emptyLeftPlot && emptyRightPlot) {
                    //Mark as planted
                    flowerbed[i] = 1;
                    c++;

                    //optimizaton 
                    if (c >= n) {
                        return true;
                    }
                }
            }
        }

        return c >= n;

    }

    public static void main(String[] args) {
        Q605_CanPlaceFlowers s = new Q605_CanPlaceFlowers();
        int[] input = { 1, 0, 0, 0, 1 };
        System.out.println(s.canPlaceFlowers(input, 1));
    }
}
