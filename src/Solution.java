import java.util.Arrays;

public class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;

        for (int i = 0; i <= k; i++) {
            //clone the costs array t use for this iteration
            int[] temp = costs.clone();
            for (int[] flight : flights) {
                int usrc = flight[0], vdest = flight[1], cost = flight[2];
                // If the source node u is not reachable within the urrent kth iteration
                if (costs[usrc] == Integer.MAX_VALUE) {
                    continue;
                }
                if (temp[vdest] > costs[usrc] + cost) {
                    temp[vdest] = costs[usrc] + cost;
                }
            }
            costs = temp;
        }
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];       
    }

}
