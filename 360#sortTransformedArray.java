public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] parms = new int[]{a, b, c};
        int[] res = new int[n];
        int index = a > 0 ? n - 1 : 0;
        int i = 0, j  = n - 1;
        while(i <= j){
            int ires = compute(nums[i], parms);
            int jres = compute(nums[j], parms);
            if(a > 0){
                res[index --] = ires > jres ? ires : jres; 
                if(ires > jres){
                    i ++;
                }else{
                    j --;
                }
            }else{
                res[index ++] = ires < jres ? ires : jres;
                if(jres > ires){
                    i ++;
                }else{
                    j --;
                }
             }
        }
        return res;
    }
    
    private int compute(int x, int[] parms){
        return parms[0] * x * x + parms[1] * x + parms[2];
    }
}