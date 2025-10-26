# Import random module for generating random numbers
import random
# Import List type for type hinting
from typing import List

class Solution:
    def __init__(self, n: int, blacklist: List[int]):
        # Store total range size
        self.n = n
        # Convert blacklist to a set for O(1) lookups
        self.blacklist = set(blacklist)
        # Initialize mapping for blacklisted indices
        self.mapping = {}
        # Store number of blacklisted indices
        self.m = len(blacklist)
        # Calculate size of the valid range n - num_blacklisted
        self.range_size = n - self.m
        
        # Initialize last valid index start from the end
        last = n - 1
        # Iterate over blacklisted indices
        for b in blacklist:
            # Check if blacklisted index is within the valid range
            if b < self.range_size:
                # Find the next valid index skip over blacklisted ones
                while last in self.blacklist:
                    last -= 1
                # Map blacklisted index to the found valid index
                self.mapping[b] = last
                # Move to the previous index
                last -= 1

    # Method to randomly pick a valid index
    def pick(self) -> int:
        # Generate a random index within the valid range
        index = random.randint(0, self.range_size - 1)
        # Return the mapped index if blacklisted, otherwise return the original index
        return self.mapping.get(index, index)