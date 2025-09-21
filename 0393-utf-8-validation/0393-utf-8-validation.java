class Solution {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        int i = 0;
        
        while (i < n) {
            int numBytes = getNumBytes(data[i]);
            
            if (numBytes == 0) {
                return false; // Invalid leading byte
            }
            
            // Check if there are enough continuation bytes
            if (i + numBytes - 1 >= n) {
                return false; // Not enough continuation bytes
            }
            
            // Check if continuation bytes are valid
            for (int j = 1; j < numBytes; j++) {
                if (!isContinuationByte(data[i + j])) {
                    return false; // Invalid continuation byte
                }
            }
            
            i += numBytes;
        }
        
        return true;
    }
    
    // Get the number of bytes based on the leading byte
    private int getNumBytes(int num) {
        if ((num & 0b10000000) == 0) {
            return 1; // 1-byte character
        } else if ((num & 0b11100000) == 0b11000000) {
            return 2; // 2-byte character
        } else if ((num & 0b11110000) == 0b11100000) {
            return 3; // 3-byte character
        } else if ((num & 0b11111000) == 0b11110000) {
            return 4; // 4-byte character
        } else {
            return 0; // Invalid leading byte
        }
    }
    
    // Check if the byte is a continuation byte
    private boolean isContinuationByte(int num) {
        return (num & 0b11000000) == 0b10000000;    
    }
}