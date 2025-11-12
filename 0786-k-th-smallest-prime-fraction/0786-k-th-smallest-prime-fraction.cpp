class Solution {
public:
    std::vector<int> kthSmallestPrimeFraction(std::vector<int>& primes, int k) {
        int size = primes.size();  // Number of prime numbers in the array
        double left = 0.0, right = 1.0;  // Define the search space
        std::vector<int> result;  // The result containing the prime fraction

        while (left <= right) {
            double mid = left + (right - left) / 2;  // Calculate the midpoint
            int totalFractions = 0;  // Count of fractions smaller than 'mid'
            int numerator = 0, denominator = 0;  // To track the maximum fraction
            double maxFraction = 0.0;  // The maximum fraction found
            int j = 1;  // Start of the inner loop for the second index
            
            // Iterate over each prime as the numerator
            for (int i = 0; i < size; ++i) {
                // Move `j` to the point where the fraction is just greater than 'mid'
                while (j < size && primes[i] > primes[j] * mid) {
                    ++j;  // Increment `j` to find the first fraction greater than 'mid'
                }
                
                // Count the total number of fractions smaller than 'mid'
                totalFractions += size - j;

                // Check if the current fraction is larger than the current `maxFraction`
                if (j < size && maxFraction < static_cast<double>(primes[i]) / primes[j]) {
                    maxFraction = static_cast<double>(primes[i]) / primes[j];
                    numerator = i;  // Update the numerator index
                    denominator = j;  // Update the denominator index
                }
            }

            // If we've found exactly 'k' fractions, we've got our result
            if (totalFractions == k) {
                result = {primes[numerator], primes[denominator]};
                break;  // Exit the loop, as we found the kth smallest fraction
            }

            // If we have more than 'k' fractions, adjust the search space
            if (totalFractions > k) {
                right = mid;  // Search in the left half
            } else {
                left = mid;  // Search in the right half
            }
        }

        return result;  // Return the found fraction as the result
    }
};