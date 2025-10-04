class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        # Helper function to convert time in "HH:MM" format to minutes
        def timeToMinutes(time: str) -> int:
            hours, minutes = map(int, time.split(":"))
            return hours * 60 + minutes
        
        # Convert all time points to minutes
        minutesList = sorted([timeToMinutes(time) for time in timePoints])
        
        # Initialize the minimum difference as the maximum possible (1440 minutes in a day)
        minDiff = 1440
        
        # Compare consecutive time points
        for i in range(1, len(minutesList)):
            minDiff = min(minDiff, minutesList[i] - minutesList[i - 1])
        
        # Compare the difference between the last and first time point (taking into account the circular nature of the clock)
        minDiff = min(minDiff, 1440 + minutesList[0] - minutesList[-1])
        
        return minDiff