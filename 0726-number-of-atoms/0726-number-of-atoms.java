class Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> counts = countAtoms(formula);
        
        StringBuilder result = new StringBuilder();
        List<String> atoms = new ArrayList<>(counts.keySet());
        Collections.sort(atoms);
        for (String atom : atoms) {
            result.append(atom);
            if (counts.get(atom) > 1) {
                result.append(counts.get(atom));
            }
        }
        
        return result.toString();
    }
    
    private Map<String, Integer> countAtoms(String formula) {
        Map<String, Integer> counts = new HashMap<>();
        Stack<Map<String, Integer>> stack = new Stack<>();
        int i = 0;
        
        while (i < formula.length()) {
            char c = formula.charAt(i);
            i++;
            
            if (c == '(') {
                stack.push(counts);
                counts = new HashMap<>();
            } else if (c == ')') {
                int j = i;
                while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                    j++;
                }
                int multiplier = (j > i) ? Integer.parseInt(formula.substring(i, j)) : 1;
                i = j;
                
                Map<String, Integer> poppedCounts = counts;
                counts = stack.pop();
                for (String atom : poppedCounts.keySet()) {
                    counts.put(atom, counts.getOrDefault(atom, 0) + poppedCounts.get(atom) * multiplier);
                }
            } else {
                int j = i;
                while (j < formula.length() && Character.isLowerCase(formula.charAt(j))) {
                    j++;
                }
                String atom = formula.substring(i - 1, j);
                i = j;
                
                j = i;
                while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                    j++;
                }
                int count = (j > i) ? Integer.parseInt(formula.substring(i, j)) : 1;
                counts.put(atom, counts.getOrDefault(atom, 0) + count);
                i = j;
            }
        }
        
        return counts;
    }
}