class Solution {
    // TrieNode definition
    class TrieNode {
        Map<Character, TrieNode> children;
        String word;
        
        TrieNode() {
            children = new HashMap<>();
            word = null; // will store the word if it's a valid word in the trie
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return result;
        }
        
        // Step 1: Build a Trie for the words
        TrieNode root = buildTrie(words);

        // Step 2: Backtracking to find words
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] visited = new boolean[m][n]; // To track visited cells
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtrack(board, i, j, root, visited, result);
            }
        }
        
        return result;
    }
    
    // Step 1: Build the Trie
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            }
            node.word = word; // Store word at the end node
        }
        return root;
    }
    
    // Step 2: Backtracking to find the words
    private void backtrack(char[][] board, int i, int j, TrieNode node, boolean[][] visited, List<String> result) {
        // Base cases
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        
        char c = board[i][j];
        TrieNode nextNode = node.children.get(c);
        
        // If no child node exists, return
        if (nextNode == null) {
            return;
        }
        
        // If the current node has a word, it's a valid word, so add it to the result
        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null; // To avoid duplicate words
        }
        
        // Mark the current cell as visited
        visited[i][j] = true;
        
        // Explore all four directions (up, down, left, right)
        int[] directions = {-1, 0, 1, 0, -1}; // up, right, down, left
        for (int k = 0; k < 4; k++) {
            int newI = i + directions[k];
            int newJ = j + directions[k + 1];
            backtrack(board, newI, newJ, nextNode, visited, result);
        }
        
        // Unmark the current cell as visited (backtrack)
        visited[i][j] = false;
    }
}