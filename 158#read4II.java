/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    char[] remainBuf = new char[4];
    int remainCount = 0;
    boolean EOF = false;
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int readBytes = 0;
        
        if(remainCount > 0){
            int count = Math.min(n, remainCount);
            int i = 0;
            for(; i < count; i++){
                buf[readBytes + i] = remainBuf[i];
                remainCount--;
            }
            readBytes += count;
            if(remainCount != 0){
                for(int j = 0; j < remainCount; j++){
                    remainBuf[j] = remainBuf[j+i];
                }
            }
        }
        
        int curRemain = 0;
        int readTo = 0;
        while(readBytes < n && !EOF){
            int curReadBytes = read4(buffer);
            if(curReadBytes != 4) EOF = true;
            curRemain = curReadBytes;
            int count = Math.min(n - readBytes, curReadBytes);
            int i = 0;
            for(; i < count; i++){
                buf[readBytes + i] = buffer[i];
                curRemain --;
            }
            readTo = i;
            readBytes += count;
        }
        
        if(curRemain != 0){
            for(int i = 0; i < curRemain; i++){
                remainBuf[i] = buffer[i+readTo];
            }
            remainCount = curRemain;
        }
        
        return readBytes;
    }