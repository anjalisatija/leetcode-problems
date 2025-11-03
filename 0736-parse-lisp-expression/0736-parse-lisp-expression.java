class Solution {
    private String expr;
    private int ix;
    private HashMap<String, Deque<Integer>> env;

    public String takeAtom() {
        int endIx = ix;
        for (; expr.charAt(endIx) > ')'; endIx++);
        String var = expr.substring(ix, endIx);
        ix = endIx;
        return var; 
    }
    public int evalNextExpr() {
        char firstChar = expr.charAt(ix);
        while (firstChar == ' '){
            ix++;
            firstChar = expr.charAt(ix);
        }
        if (firstChar >= 'a'){
            return env.get(takeAtom()).peekFirst();
        }
        else if (firstChar >= '-'){
            return Integer.valueOf(takeAtom());
        }
        int returnValue = 0; 
        char opChar = expr.charAt(ix  + 1);
        ix += 5;
        if (opChar == 'l'){
            List<String> setVars = new ArrayList<>(); 
            boolean valueKnown = false;   
            while('a' <= expr.charAt(ix)){
                String varName = takeAtom();
                if (expr.charAt(ix) == ')') {
                    returnValue = env.get(varName).peekFirst(); 
                    valueKnown = true; 
                    break; 
                }
                int varValue = evalNextExpr();
                Deque<Integer> varStore = env.get(varName);
                if (varStore == null){
                    varStore = new ArrayDeque<>();
                    env.put(varName, varStore);
                }
                varStore.addFirst(varValue);
                setVars.add(varName);
                ix++; 
            }
            if (!valueKnown){
                returnValue = evalNextExpr(); 
            }
            for (String var : setVars){
                env.get(var).removeFirst(); 
            }
        }
        else {
            int left = evalNextExpr();
            int right = evalNextExpr(); 
            switch (opChar) {
                case 'a':
                    returnValue =  left + right;
                    break;
                case 'm':
                    returnValue =  left * right; 
            }
        }
        ix++;
        return returnValue; 
    }
    public int evaluate(String expression) {
        this.expr = expression; 
        this.ix = 0;
        this.env = new HashMap<>();
        return evalNextExpr();
    }
}