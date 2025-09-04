class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> oper;
        for (auto a : tokens) {
            if (a == "+" || a == "-" || a == "*" || a == "/") {
                int right = oper.top(); oper.pop();
                int left = oper.top(); oper.pop();
                
                if (a == "+") oper.push(left + right);
                else if (a == "-") oper.push(left - right);
                else if (a == "*") oper.push(left * right);
                else oper.push(left / right);
            } else {
                oper.push(stoi(a));
            }
        }
        return oper.top();
    }
};