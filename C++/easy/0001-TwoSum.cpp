/**
 * @file 0001-TwoSum.cpp
 * @brief
 *
 * @author vic
 * @date January 2025
 */

#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

vector<int> twoSum(vector<int> &nums, int target)
{
    unordered_map<int, int> numMap;
    for (int i = 0; i < nums.size(); i++)
    {
        int complement = target - nums[i];
        if (numMap.count(nums[i])) /* contains */
        {
            return {i, numMap[nums[i]]};
        }
        numMap[complement] = i;
    }
    return {};
}