class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> ans = new HashSet<>();
        List<Integer>[] parens = new ArrayList[2];
        Arrays.setAll(parens, o -> new ArrayList<>());
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length();++i){
            if (s.charAt(i) == '('){
                parens[0].add(i); // indexes for '('
            }else if (s.charAt(i) == ')'){
                parens[1].add(i); // indexes for ')'
            }
        }
        int m = parens[0].size();
        int n = parens[1].size();
        for (int i=0;ans.isEmpty()&&i<=Math.min(n,m);i++){ // try from the lowest until ans is filled with something or we reach min of '(' and ')' count.
            int[] rev = new int[]{Math.max(0,m-n)+i,Math.max(0,n-m)+i};
            solve(0, 0, rev, arr, parens, ans);
        }
        return new ArrayList<>(ans);
    }

    private void solve(int i, int mode, int[] remain, char[] arr, List<Integer>[] parens, Set<String> ans){
        if (remain[mode]==0){
            if (mode==0){ // open parens done, now backtrack on close parens.
                solve(0, mode^1, remain, arr, parens, ans);
            }else if(ok(arr)){ // close parens done, now get the answer
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < arr.length;k++){
                    if (arr[k]!='.'){
                        sb.append(arr[k]);
                    }
                }
                ans.add(sb.toString());
            }
            return;
        }
        if (i >= parens[mode].size()){
            return;
        }
        if (parens[mode].size()-i>remain[mode]){ // can only skip when there are enough left.
            solve(i+1,mode,remain,arr,parens,ans);
        }
        if (remain[mode]>0){ // only take when we need to.
            char tmp = arr[parens[mode].get(i)];
            arr[parens[mode].get(i)]='.';
            --remain[mode];
            solve(i+1,mode,remain,arr,parens,ans);
            arr[parens[mode].get(i)]=tmp;
            ++remain[mode];
        }
    }

    private boolean ok(char[] arr){
        int open = 0;
        for (char ch : arr){
            if (ch == '('){
                open++;
            }
            if (ch == ')' && --open<0){
                return false;
            }
        }
        return open==0;
    }
}