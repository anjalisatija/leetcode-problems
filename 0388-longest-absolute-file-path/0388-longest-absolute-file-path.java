class Solution {
    public int lengthLongestPath(String input) {
        int res = -1;
        List<String> ls = splitString(input, "\n");
        
        for (int i = 0; i < ls.size(); i++) {
            int val = recFun(ls.get(i), 1);
            if (val != -1) {
                res = Math.max(res, val);
            }
        }
        
        return res == -1 ? 0 : res - 1;
    }

    public static int recFun(String input, int level) {
        String seperator = "\n";
        for (int i = 0; i < level; i++) {
            seperator += "\t";
        }

        List<String> ls = splitString(input, seperator);

        if (ls.size() == 1) {
            return ls.get(0).contains(".") ? ls.get(0).length() + 1 : -1;
        }

        int res = -1;
        for (int i = 1; i < ls.size(); i++) {
            int val = recFun(ls.get(i), level + 1);
            if (val != -1) {
                res = Math.max(res, val);
            }
        }

        if (res != -1) {
            res += ls.get(0).length() + 1;
        }

        return res;
    }

    public static List<String> splitString(String input, String seperator) {
        List<String> ls = new ArrayList<>();
        int s = 0;
        int l = seperator.length();
        int index = 0;

        while (s + l < input.length()) {
            boolean flag = true;
            for (int i = 0; i < l; i++) {
                if (input.charAt(s + i) != seperator.charAt(i)) {
                    flag = false;
                    break;
                }
            }

            if (flag && (input.charAt(s + l) != '\n' && input.charAt(s + l) != '\t')) {
                ls.add(input.substring(index, s));
                index = s + l;
            }

            s++;
        }

        ls.add(input.substring(index));
        return ls;
    }


}