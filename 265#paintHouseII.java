public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        for(int i = 1; i < costs.length; i++){
            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;
            for(int j = 0; j < costs[0].length; j++){
                if(costs[i-1][j] < first) {
                    second = first;
                    first = costs[i-1][j];
                }else if(costs[i-1][j] < second) second = costs[i-1][j];
            }
            for(int j = 0; j < costs[0].length; j++){
                costs[i][j] += (costs[i-1][j] == first ? second : first);
            }
        }
        int n = costs.length-1;
        for(int i = 1; i < costs[0].length; i++){
            costs[n][0] = Math.min(costs[n][0], costs[n][i]);
        }
        return costs[n][0];
    }
}