public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int left = searchRow(y, 0, y, true, image);
        int right = searchRow(y, y, image[0].length-1, false, image);
        int top = searchCol(x, 0, x, true, image);
        int bottom = searchCol(x, x, image.length-1, false, image);
        return (right - left) * (bottom - top);
    }
    
    private int searchRow(int y, int left, int right, boolean leftDirect, char[][] image){
        while(left < right){
            int mid = left + ((right - left) >> 1);
            int runner = 0;
            while(runner < image.length && image[runner][mid] == '0'){ runner++; }
            if((runner == image.length) == leftDirect) // all '0'
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    
    private int searchCol(int x, int top, int bottom, boolean upDirect, char[][] image){
        while(top < bottom){
            int mid = top + ((bottom - top) >> 1);
            int runner = 0;
            while(runner < image[0].length && image[mid][runner] == '0'){ runner++; }
            if((runner == image.length) == upDirect) // all '0'
                top = mid + 1;
            else
                bottom = mid;
        }
        return top;
    }
    
}