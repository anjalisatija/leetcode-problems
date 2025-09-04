class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        string result = "";
        
        // Handle sign
        if ((numerator < 0) ^ (denominator < 0)) result += "-";
        
        long long num = abs(static_cast<long long>(numerator));
        long long den = abs(static_cast<long long>(denominator));
        
        // Integral part
        result += to_string(num / den);
        
        long long remainder = num % den;
        if (remainder == 0) return result;  // No fractional part
        
        result += ".";
        unordered_map<long long, int> seen;
        
        while (remainder != 0) {
            if (seen.find(remainder) != seen.end()) {
                // Detected repeating pattern
                result.insert(seen[remainder], "(");
                result += ")";
                break;
            }
            
            seen[remainder] = result.size();
            remainder *= 10;
            result += to_string(remainder / den);
            remainder %= den;
        }
        
        return result;
    }
};