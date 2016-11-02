public class Solution {
    public boolean isReflected(int[][] points) {
        HashSet<Integer> pointSet = new HashSet<>();
        int sum;
        int maxX, minX;
        
        minX = Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;
        for(int[] point:points) {
            maxX = Math.max(maxX, point[ 0 ]);
            minX = Math.min(minX, point[ 0 ]);
            pointSet.add(Arrays.hashCode(point));
        }
        
        sum = maxX+minX;
        for(int[] point:points) {
            if(!pointSet.contains(Arrays.hashCode(new int[]{sum-point[ 0 ], point[ 1 ]}))) {
                return false;
            }
        }
        return true;
    }
}