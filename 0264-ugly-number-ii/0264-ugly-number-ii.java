class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n]; // `n` size ka array banaya
        arr[0] = 1; // Pehla ugly number 1 hota hai, to usse direct `arr[0]` mein store kar diya
        
        int n1 = 0, n2 = 0, n3 = 0; // Yeh teen variables indices hain, jo `arr` ke andar multiples of 2, 3, aur 5 ko track karenge
        int i = 1; // Yeh `i` loop ka counter hai

        while (i < n) { // Loop tab tak chalega jab tak `i` `n` se chota hai
            int nextUgly = Math.min(2 * arr[n1], Math.min(3 * arr[n2], 5 * arr[n3])); 
            // `2*arr[n1]`, `3*arr[n2]`, aur `5*arr[n3]` ka minimum value calculate kiya aur usse next ugly number bana diya
            
            arr[i] = nextUgly; // Next ugly number ko `arr[i]` mein store kar diya
            
            if (nextUgly == 2 * arr[n1]) n1++; // Agar next ugly number `2*arr[n1]` se bana hai, toh `n1` ko increment kar do
            if (nextUgly == 3 * arr[n2]) n2++; // Agar `3*arr[n2]` se bana hai, toh `n2` ko increment kar do
            if (nextUgly == 5 * arr[n3]) n3++; // Agar `5*arr[n3]` se bana hai, toh `n3` ko increment kar do
            
            i++; // `i` ko increment karte rahenge
        }

        return arr[n-1]; // Last mein `nth` ugly number return karenge
    }
}