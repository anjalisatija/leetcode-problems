class Spreadsheet {
    private int[][] grid; // [row][col] where row is 0-indexed, col is 0-indexed (A=0, B=1, etc.)
    private int rows;
    
    public Spreadsheet(int rows) {
        this.rows = rows;
        this.grid = new int[rows][26]; // 26 columns A-Z
        // All cells are initially 0 by default
    }
    
    public void setCell(String cell, int value) {
        int[] position = parseCell(cell);
        int row = position[0];
        int col = position[1];
        grid[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int[] position = parseCell(cell);
        int row = position[0];
        int col = position[1];
        grid[row][col] = 0;
    }
    
    public int getValue(String formula) {
        // Remove the '=' prefix
        String expression = formula.substring(1);
        
        // Find the '+' operator
        int plusIndex = expression.indexOf('+');
        if (plusIndex == -1) {
            throw new IllegalArgumentException("Invalid formula format");
        }
        
        String left = expression.substring(0, plusIndex).trim();
        String right = expression.substring(plusIndex + 1).trim();
        
        int leftValue = evaluateOperand(left);
        int rightValue = evaluateOperand(right);
        
        return leftValue + rightValue;
    }
    
    private int evaluateOperand(String operand) {
        // Check if it's a cell reference (starts with letter)
        if (Character.isLetter(operand.charAt(0))) {
            int[] position = parseCell(operand);
            int row = position[0];
            int col = position[1];
            return grid[row][col];
        } else {
            // It's a number
            return Integer.parseInt(operand);
        }
    }
    
    private int[] parseCell(String cell) {
        // Parse cell reference like "A1", "B10", etc.
        int col = cell.charAt(0) - 'A'; // A=0, B=1, etc.
        int row = Integer.parseInt(cell.substring(1)) - 1; // Convert to 0-indexed
        
        if (row < 0 || row >= rows || col < 0 || col >= 26) {
            throw new IllegalArgumentException("Invalid cell reference: " + cell);
        }
        
        return new int[]{row, col};
    }
}


/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */