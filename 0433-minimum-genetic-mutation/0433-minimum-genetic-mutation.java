class Node {
    private String gene;
    private int depth;

    public Node(String gene, int depth) {
        this.gene = gene;
        this.depth = depth;
    }

    public String getGene() {
        return this.gene;
    }

    public int getDepth() {
        return this.depth;
    }
}

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // Represent genes and mutations as a graph
        // Each gene is a node
        // Each mutation is an edge

        // Traverse the graph from startGene to endGene. 
        // Need to maintain the depth of the node - easiest and cleanest to do this with a Node class.

        // Approach #1: Start with what is in the bank. 
        // Generate edges time: O(bank.length^2)
        // Traverse time: O(bank.length + edgeCount)
        // Go through the genes in the bank (nodes) and discover edges (mutations) that connect them
        // An edge exists between two genes if has a substring match on 7 characters
        // Then traverse the graph to find the path.

        // Approach #2: Try to generate all the mutations from each gene and check if it exists in the bank
        // Each gene (node) will have fixed number of possible mutations (edges)
        // Each index in the gene string - 8
        // Multiplied by each possible character change for the string index - 3
        // => So each gene has node has 24 possible mutations
        // => ie, each node has 24 edges.
        // First, parse all the genes into a HashSet<String> for O(1) look up of valid genes
        HashSet<String> bankSet = new HashSet<>();
        for (String g : bank) {
            bankSet.add(g);
        }

        // Optimization 1: Return early if the bankSet doesn't contain the endGene
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        // Optimization 2: If the number of character changes required exceeds the length of the bankSet, return early
        int minRequiredMutations = 0;
        for (int i=0; i < startGene.length(); i++) {
            if (startGene.charAt(i) != endGene.charAt(i)) {
                minRequiredMutations++;
            }
        }
        if (minRequiredMutations > bankSet.size()) {
            return -1;
        }

        // Otherwise, run a BFS starting from the startGene
        // Create a queue of valid genes you want to continue exploring
        char[] geneChars = new char[]{'A', 'C', 'G', 'T'};
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(startGene, 0));
        
        while(!q.isEmpty()) {
            Node geneNode = q.poll();
            String gene = geneNode.getGene();
            int currentDepth = geneNode.getDepth();

            // Explore each mutation
            for (int i = 0; i < gene.length(); i++) {
                // Have to try from each index even if gene.charAt(i) == endGene.charAt(i). In order to "hop through" mutations to get to the endGene.
                char currentChar = gene.charAt(i);

                // Replace the value of this index with the other 3 valid gene characters
                // If it is in the geneSet and equals the endGene, then you are done!
                // Otherwise if it is a valid gene, add it to the queue to explore later
                for (int j = 0; j < geneChars.length; j++) {
                    StringBuilder geneBuilder = new StringBuilder(gene);
                    if (currentChar != geneChars[j]) {
                        geneBuilder.setCharAt(i, geneChars[j]);
                        String geneCandidate = geneBuilder.toString();

                        if (bankSet.contains(geneCandidate)) {
                            if (geneCandidate.equals(endGene)) {
                                return currentDepth + 1;
                            }

                            q.add(new Node(geneCandidate, currentDepth +1));
                        }
                    }
                }
            }
        }
        
        // Default case
        return -1;
    }
}