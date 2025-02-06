/**
 * @file 0001-TwoSum.cpp
 * @brief I remembered the overall logic of the solution to this
 * exercise, the main problem I encountered was that my for
 * loop was written backwards.
 * for (int i = 0; i++; i < nums.size())
 * instead of
 * for (int i = 0; i < nums.size(); i++)
 * this doesn't cause any compile errors -_-
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