
class Solution {
    private long[] getPrefixSum(int[] stations) {
            int n = stations.length;
            long[] prefixSum = new long[n];
            prefixSum[0] = stations[0];

            for (int i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i - 1] + stations[i];
            }
            return prefixSum;
        }

        private long[] getPowerOfCities(long[] prefixSum, int r) {
            int n = prefixSum.length;
            long[] power = new long[n];

            //calculate the power of each city using prefixSum
            for (int i = 0; i < n; i++) {
                int minRadius = i - r - 1;
                int maxRadius = Math.min(n - 1, i + r); // if i+r goes beyond the right boundary, reset to last element

                long excludedPower = minRadius < 0 ? 0 : prefixSum[minRadius];

                power[i] = prefixSum[maxRadius] - excludedPower;
            }

            return power;
        }

        public long maxPower(int[] stations, int r, int k) {
            int n = stations.length;

            //get the power of each city using a prefix sum aka power of each station,  prefix sum so that we can compute the power of each city with [i-r, i+r] range in O(1) time. 
            long[] prefixSum = getPrefixSum(stations);
            long[] power = getPowerOfCities(prefixSum, r);

            long low = 0, high = prefixSum[n - 1] + k;
            long result = 0;
            while (low <= high) {

                long mid = (low + high) >>> 1;

                if (isPossible(stations, power, r, k, mid)) {
                    result = mid;
                    low = mid + 1; //we need to maximum possible minimum power 
                } else {
                    high = mid - 1; // mid-power is not possible even with additional k plants, hence decrease it
                }
            }
            return result;
        }

        private boolean isPossible(int[] stations, long[] powerOfEachCity, int r, int availablePowerStations,
                                   long minimumPower) {

            int n = stations.length;
            long power = 0; // power of ith city 

            // Here we will add the additional power we get during computation. We also reduce all such power which goes out of the window [i-r, i+r]
            long[] additionalPower = new long[n];

            for (int i = 0; i < n; i++) {

                //get current power of the ith city
                power = powerOfEachCity[i];

                //add the additional power for the current city, added by previous city when computed already. 
                //This is because as we add plants, the power of ith city will increase by the number of plants we added. Which will benifits its adjacent cities. 
                if (i > 0)
                    additionalPower[i] += additionalPower[i - 1];

                //now this city will have 'power' power
                power += additionalPower[i];

                // if power >= minimumPower then no additional power station required, hence ith city has enough power
                if (power < minimumPower) {

                    //see does this city have enough power;  if not, then we need to add additional power stations 
                    long requiredPowerStations = minimumPower - power;

                    if (requiredPowerStations > availablePowerStations) {
                        //we need more power stations to make ith city has minimumPower
                        return false;
                    }

                    //means this city does not enough power to meet 'minimumPower,' however, we have enough power stations to plant
                    availablePowerStations -= requiredPowerStations;

                    //since the ith city has minimumPower now, let's add it to additional power which we added to ith city requiredPowerStations = additionalPower added for ith city
                    additionalPower[i] += requiredPowerStations;

                    //we need to remove all the additional power which will goes out of a window. 
                    // if we have placed the power plant at ith, this will allow to power i+r the city extra only, however, if we had placed 
                    // it on (i+r) then the current ith city also gets this power and ( i+r+r ) city as well but not beyond that. 
                    // hence we need to remove the 'requiredPowerStations' for all the cities which is i+r+r+1 away 
                    int awayCity = i + 2 * r + 1;
                    if (awayCity < n)
                        additionalPower[awayCity] -= requiredPowerStations;
                }

            }

            return true; // we are able to get the minimumPower to each city. 

        }

}