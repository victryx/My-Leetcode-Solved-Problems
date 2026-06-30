/**
 * @file 0198-HouseRobber.cpp
 * @brief Dynamic Programming practice
 *
 * @author Vika
 * @date June 2026
 */

#include <vector>

using namespace std;

/**
 * 1st try, backtracking solution
 */
int rob1(vector<int>& nums) {
    int sol = 0;
    rob_helper(nums, 0, 0, sol, false);
    return sol;
}

void rob_helper(const vector<int>& houses, int i, int cur_money, int& best_money, bool last_robbed) {
    if (i == houses.size()) {
        if (cur_money > best_money) {
            best_money = cur_money;
        }
        return;
    }
    if (!last_robbed) {
        rob_helper(houses, i + 1, cur_money + houses[i], best_money, true);
    }

    rob_helper(houses, i + 1, cur_money, best_money, false);

}

/**
 * dp solution
 */
int rob2(vector<int>& nums) {
    int n = nums.size();
    if (n == 1) {
        return nums[0];
    }
    if (n == 2) {
        return nums[0] > nums[1] ? nums[0] : nums[1];
    }

    vector<int> cache(n);
    cache[0] = nums[0];
    cache[1] = nums[0] > nums[1] ? nums[0] : nums[1];
    for (int i = 2; i < n; i++) {
        cache[i] = max(
            cache[i - 1],
            cache[i - 2] + nums[i]
        );
    }
    return cache[n - 1];
}

/**
 * dp solution (improved)
 */
int rob3(vector<int>& nums) {
    int n = nums.size();
    if (n == 1) {
        return nums[0];
    }
    if (n == 2) {
        return nums[0] > nums[1] ? nums[0] : nums[1];
    }

    int last = nums[0];
    int cur = nums[0] > nums[1] ? nums[0] : nums[1];
    int next;

    for (int i = 2; i < n; i++) {
        next = max(
            cur,
            last + nums[i]
        );

        last = cur;
        cur = next;
    }
    return next;
}