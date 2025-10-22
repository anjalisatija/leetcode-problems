# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: list[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class Solution:
    def getImportance(self, employees: list[Employee], id: int) -> int:
        # Create a dictionary for quick ID-to-Employee lookup
        emp_map = {e.id: e for e in employees}

        def dfs(emp_id: int) -> int:
            emp = emp_map[emp_id]
            total = emp.importance  # Include current employee's importance
            for sub_id in emp.subordinates:  # Visit each subordinate
                total += dfs(sub_id)
            return total

        return dfs(id)