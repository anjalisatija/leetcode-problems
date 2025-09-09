class Solution {
private:
    void heapify(vector<int>& nums, int i, int n) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < n && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums[i], nums[largest]);
            heapify(nums, largest, n);
        }
    }
public:
    int findKthLargest(vector<int>& nums, int k) {
        int n = nums.size();
        int nonleafindex = (n / 2) - 1;
        for (int i = nonleafindex; i >= 0; i--) {
            heapify(nums, i, n);
        }
        for (int i = n - 1; i > n - k; i--) {
            swap(nums[0], nums[i]);
            heapify(nums, 0, i);
        }
        return nums[0];
    }
};