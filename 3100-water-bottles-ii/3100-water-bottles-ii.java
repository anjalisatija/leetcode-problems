class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int sum=numBottles;
        int empty=numBottles;
        while(numBottles>=numExchange){
            numBottles-=numExchange;
            numExchange++;
            sum++;
            numBottles++;
        }
        return sum;
    }
}