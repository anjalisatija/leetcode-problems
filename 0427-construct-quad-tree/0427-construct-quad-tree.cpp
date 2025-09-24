class Solution {
public:
    Node* divide(Node* currentNode, int regionSize, vector<vector<int>> &grid, int startRow, int startCol) {
        if (regionSize == 1) {
            return new Node(grid[startRow][startCol], true);
        }

        int countZero = 0;
        int countOne = 0;

        for (int i = startRow; i < startRow + regionSize; i++) {
            for (int j = startCol; j < startCol + regionSize; j++) {
                if (grid[i][j] == 1) {
                    countOne++;
                } else {
                    countZero++;
                }
            }
        }

        if (countOne == regionSize * regionSize) {
            currentNode = new Node();
            currentNode->val = 1;
            currentNode->isLeaf = true;
        } else if (countZero == regionSize * regionSize) {
            currentNode = new Node();
            currentNode->val = 0;
            currentNode->isLeaf = true;
        } else {
            currentNode = new Node();
            currentNode->val = 1;
            currentNode->isLeaf = false;

            currentNode->topLeft = divide(currentNode->topLeft, regionSize / 2, grid, startRow, startCol);
            currentNode->topRight = divide(currentNode->topRight, regionSize / 2, grid, startRow, startCol + (regionSize / 2));
            currentNode->bottomLeft = divide(currentNode->bottomLeft, regionSize / 2, grid, startRow + (regionSize / 2), startCol);
            currentNode->bottomRight = divide(currentNode->bottomRight, regionSize / 2, grid, startRow + (regionSize / 2), startCol + (regionSize / 2));
        }

        return currentNode;
    }

    Node* construct(vector<vector<int>>& grid) {
        int gridSize = grid.size();

        if (gridSize == 0) return nullptr;

        Node* rootNode = nullptr;
        return divide(rootNode, gridSize, grid, 0, 0);
    }
};