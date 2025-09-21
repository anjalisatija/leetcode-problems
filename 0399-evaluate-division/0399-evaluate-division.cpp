#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        // Step 1: Construct the graph
        unordered_map<string, unordered_map<string, double>> graph;
        
        for (int i = 0; i < equations.size(); i++) {
            string a = equations[i][0];
            string b = equations[i][1];
            double value = values[i];
            
            graph[a][b] = value;
            graph[b][a] = 1 / value;
        }
        
        // Step 2: Function to perform DFS and find a path
        vector<double> result;
        
        for (auto& query : queries) {
            string c = query[0];
            string d = query[1];
            
            if (graph.find(c) == graph.end() || graph.find(d) == graph.end()) {
                result.push_back(-1.0);
            } else {
                unordered_set<string> visited;
                result.push_back(dfs(c, d, visited, graph));
            }
        }
        
        return result;
    }
    
private:
    double dfs(string src, string dst, unordered_set<string>& visited, unordered_map<string, unordered_map<string, double>>& graph) {
        if (src == dst) return 1.0;
        visited.insert(src);
        
        for (auto& neighbor : graph[src]) {
            string next = neighbor.first;
            double value = neighbor.second;
            
            if (visited.find(next) == visited.end()) {
                double result = dfs(next, dst, visited, graph);
                if (result != -1.0) {
                    return result * value;
                }
            }
        }
        
        return -1.0;
    }
};