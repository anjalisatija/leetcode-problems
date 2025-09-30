class Solution {
public:
    string licenseKeyFormatting(string s, int k) {
        // Remove all dashes and convert to uppercase
        string formatted = "";
        for (char c : s) {
            if (c != '-') {
                formatted += toupper(c);
            }
        }

        // Determine the size of the first group
        int mod = formatted.size() % k;
        string result;

        // Add the first group if it's not empty
        if (mod > 0) {
            result = formatted.substr(0, mod) + "-";
        }

        // Add remaining groups of size 'k'
        for (int i = mod; i < formatted.size(); i += k) {
            result += formatted.substr(i, k) + "-";
        }

        // Remove trailing dash if present
        if (!result.empty() && result.back() == '-') {
            result.pop_back();
        }

        return result;
    }
};
