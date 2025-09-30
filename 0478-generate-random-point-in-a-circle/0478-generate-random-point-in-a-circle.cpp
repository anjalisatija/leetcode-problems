class Solution {
public:
    Solution(double radius, double x_center, double y_center) : radius(radius), x_center(x_center), y_center(y_center) {
        std::random_device rd;
        gen = std::mt19937(rd());
        dist = std::uniform_real_distribution<double>(-radius, radius);
    }
    
    vector<double> randPoint() {
        while (true) {
            double x = dist(gen);
            double y = dist(gen);
            if (x * x + y * y <= radius * radius) {
                return {x + x_center, y + y_center};
            }
        }
    }
    
private:
    double radius, x_center, y_center;
    std::mt19937 gen;
    std::uniform_real_distribution<double> dist;
};