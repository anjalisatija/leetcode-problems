class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
    # Create a 3D array 'dp' to store the probabilities of the knight being at each cell after each move.
        dp = [[[0] * n for _ in range(n)] for _ in range(k + 1)]
    # Define the possible directions the knight can move in one step.
        directions = [(1, 2), (2, 1), (2, -1), (1, -2), (-1, -2), (-2, -1), (-2, 1), (-1, 2)]

    # Function to check if the knight is inside the chessboard.
        def is_inside(x, y):
            return 0 <= x < n and 0 <= y < n

    # Set the initial probability of the knight being at the starting cell to 1 (since it starts there).
        dp[0][row][column] = 1

    # Use dynamic programming to calculate probabilities after each move.
        for move in range(1, k + 1):
            for i in range(n):
                for j in range(n):
                    for dx, dy in directions:
                    # Check the possible cells the knight can move to from the current cell (i, j).
                        x, y = i + dx, j + dy
                    # If the cell (x, y) is inside the chessboard, add the probability of reaching it
                    # to the probability of being at cell (i, j) after (move - 1) moves.
                        if is_inside(x, y):
                            dp[move][i][j] += dp[move - 1][x][y] / 8

    # Calculate the overall probability of the knight being anywhere on the chessboard after 'k' moves.
        probability = sum(dp[k][i][j] for i in range(n) for j in range(n))
        return probability
