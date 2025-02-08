/**
 * @file 0128-LongestConsecutive.cpp
 * @brief I remembered the set solution
 *
 * @author vic
 * @date February 2025
 */

#include <iostream>
#include <vector>
#include <set>

using namespace std;

// My solution, using a set
int longestConsecutive(vector<int> &nums)
{
    set<int> numsSet;
    int maxLength = 0;

    for (int i = 0; i < nums.size(); i++)
    {
        numsSet.insert(nums[i]);
    }

    for (int num : numsSet)
    {
        // 1. check if num is the start of a sequence
        if (!numsSet.count(num - 1))
        {
            int i = num;
            // 2. follow sequence
            while (numsSet.count(i))
            {
                i++;
            }
            int length = i - num;
            maxLength = length > maxLength ? length : maxLength;
        }
    }

    return maxLength;
}

// Neetcode solution
// https://www.youtube.com/watch?v=P6RZZMu_maU
int longestConsecutive2(vector<int> &nums) {

}

int main() {

}
