class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] arr1 = extraction(num1);
        int[] arr2 = extraction(num2);
        return ( ( (arr1[0] * arr2[0]) - (arr1[1] * arr2[1]) ) + "+" + ( (arr1[0] * arr2[1]) + (arr1[1] * arr2[0]) ) + "i" );
    }
    private static int[] extraction(String numStr) {
        numStr = numStr.replace(" ","").trim().replaceAll("i","").replace("--","+");
        int l = numStr.length();
        int j = -1;
        for (int i = l - 1; i >= 0; i--) {
            char ch = numStr.charAt(i);
            if (ch == '+' || ch == '-') {
                j = i;
                break;
            }
        }
        int index = j;
        if (j - 1 >= 0) {
            char c = numStr.charAt(j - 1);
            if (c == '+' || c == '-') {
                index = j - 1;
            }
        }
        String String_real = numStr.substring(0, index);
        String String_img = numStr.substring(index + 1);
        int real = Integer.parseInt(String_real);
        int img = Integer.parseInt(String_img);
        return new int[]{ real, img };
    }
}