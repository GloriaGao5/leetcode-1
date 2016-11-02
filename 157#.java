/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean EOF = false;
        int curRead = 0;
        char[] buffer = new char[4];
        while(!EOF && curRead < n){
            int cur = read4(buffer);
            if(cur < 4) EOF = true;
            int len = Math.min(n-curRead, cur);
            for(int i = curRead; i < curRead+len; i++){
                buf[i] = buffer[i-curRead];
            }
            curRead += len;
        }
        return curRead;
    }
}