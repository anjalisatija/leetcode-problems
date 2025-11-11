#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<string> basicCalculatorIV(string expression, vector<string>& evalvars, vector<int>& evalints) {
        unordered_map<string,int> evalmap;
        for (int i = 0; i < (int)evalvars.size(); ++i) evalmap[evalvars[i]] = evalints[i];

        vector<string> tokens = tokenize(expression);
        map<vector<string>, int> poly = parseExpression(tokens, evalmap);

        vector<pair<vector<string>, int>> vec(poly.begin(), poly.end());
        sort(vec.begin(), vec.end(), [](const auto &a, const auto &b){
            if (a.first.size() != b.first.size()) return a.first.size() > b.first.size();
            return a.first < b.first;
        });

        vector<string> ans;
        for (auto &p : vec) {
            int coeff = p.second;
            if (coeff == 0) continue;
            string s = to_string(coeff);
            for (auto &v : p.first) s += "*" + v;
            ans.push_back(s);
        }
        return ans;
    }

private:
    vector<string> tokenize(const string &expr) {
        vector<string> tokens;
        string cur;
        for (char ch : expr) {
            if (isalnum(ch)) cur.push_back(ch);
            else {
                if (!cur.empty()) { tokens.push_back(cur); cur.clear(); }
                if (ch == '+' || ch == '-' || ch == '*' || ch == '(' || ch == ')') tokens.push_back(string(1, ch));
            }
        }
        if (!cur.empty()) tokens.push_back(cur);
        return tokens;
    }

    map<vector<string>, int> parseExpression(vector<string> &tokens, unordered_map<string,int> &evalmap) {
        stack<map<vector<string>,int>> vals;
        stack<string> ops;
        unordered_map<string,int> prec = {{"+",1}, {"-",1}, {"*",2}};

        for (string &tok : tokens) {
            if (tok == "(") ops.push(tok);
            else if (tok == ")") {
                while (!ops.empty() && ops.top() != "(") applyOp(vals, ops);
                if(!ops.empty()) ops.pop();
            } else if (prec.count(tok)) {
                while (!ops.empty() && prec.count(ops.top()) && prec[ops.top()] >= prec[tok]) applyOp(vals, ops);
                ops.push(tok);
            } else {
                vals.push(parseToken(tok, evalmap));
            }
        }
        while (!ops.empty()) applyOp(vals, ops);
        return vals.empty() ? map<vector<string>,int>() : vals.top();
    }

    map<vector<string>,int> parseToken(const string &tok, unordered_map<string,int> &evalmap) {
        map<vector<string>,int> m;
        bool isNumber = !tok.empty() && (isdigit(tok[0]) || (tok[0]=='-' && tok.size()>1 && isdigit(tok[1])));
        if (isNumber) m[{}] = stoi(tok);
        else if (evalmap.count(tok)) m[{}] = evalmap[tok];
        else m[{tok}] = 1;
        return m;
    }

    void applyOp(stack<map<vector<string>,int>> &vals, stack<string> &ops) {
        string op = ops.top(); ops.pop();
        auto b = vals.top(); vals.pop();
        auto a = vals.top(); vals.pop();
        if (op == "+") vals.push(add(a,b));
        else if (op == "-") vals.push(sub(a,b));
        else vals.push(mul(a,b));
    }

    map<vector<string>,int> combine(map<vector<string>,int> &m) {
        map<vector<string>,int> res;
        for (auto &kv : m) if (kv.second != 0) res[kv.first] += kv.second;
        // remove zeros (map won't hold them anyway)
        return res;
    }

    map<vector<string>,int> add(map<vector<string>,int> a, map<vector<string>,int> &b) {
        for (auto &kv : b) a[kv.first] += kv.second;
        return combine(a);
    }

    map<vector<string>,int> sub(map<vector<string>,int> a, map<vector<string>,int> &b) {
        for (auto &kv : b) a[kv.first] -= kv.second;
        return combine(a);
    }

    map<vector<string>,int> mul(map<vector<string>,int> &a, map<vector<string>,int> &b) {
        map<vector<string>,int> res;
        for (auto &pa : a) {
            for (auto &pb : b) {
                vector<string> merged = pa.first;
                merged.insert(merged.end(), pb.first.begin(), pb.first.end());
                sort(merged.begin(), merged.end());
                res[merged] += pa.second * pb.second;
            }
        }
        return combine(res);
    }
};