class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCap = 0;
        int maxCap = 0;
        for(int weight : weights){
            minCap = Math.max(minCap , weight);

            maxCap += weight;
        }
        while(minCap < maxCap){
            int mid = minCap +(maxCap - minCap)/2;

            if(canLoad(weights, days, mid)){
                maxCap = mid;
            }
            else{
                minCap = mid + 1;
            }
        }
        return minCap;
    }

    private boolean canLoad(int[] weights, int days, int capacity){
        int d = 1;
        int currentLoad = 0;
        for(int weight : weights){
            if(currentLoad + weight > capacity){
                d++;
                currentLoad = weight;
            }else{
                currentLoad += weight;
            }
        }
        return d <= days;
    }
}