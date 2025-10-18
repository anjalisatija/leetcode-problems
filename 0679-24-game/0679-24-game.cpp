class Solution {
public:
    const double ep = 1e-6;
    bool compute(vector<double>& num) {
        if (num.size() == 1)
            return fabs(num[0] - 24) < ep;

        for (int i = 0; i < num.size(); i++) {
            for (int j = 0; j < num.size(); j++) {
                if (i == j)
                    continue;
                vector<double> newnum;
                for (int k = 0; k < num.size(); k++) {
                    if (k != i && k != j)
                        newnum.push_back(num[k]);
                }
                double a = num[i], b = num[j];
                newnum.push_back(a + b);
                if (compute(newnum))
                    return true;
                newnum.pop_back();

                newnum.push_back(a - b);
                if (compute(newnum))
                    return true;
                newnum.pop_back();

                newnum.push_back(b - a);
                if (compute(newnum))
                    return true;
                newnum.pop_back();

                newnum.push_back(a * b);
                if (compute(newnum))
                    return true;
                newnum.pop_back();

                if (fabs(b) > ep) {
                    newnum.push_back(a / b);
                    if (compute(newnum))
                        return true;
                    newnum.pop_back();
                }

                if (fabs(a) > ep) {
                    newnum.push_back(b / a);
                    if (compute(newnum))
                        return true;
                    newnum.pop_back();
                }
            }
        }
        return false;
    }
    bool judgePoint24(vector<int>& cards) {
        vector<double> nums(cards.begin(), cards.end());
        return compute(nums);
    }
};