/**
 * @file 0238-ProductExceptSelf.cpp
 * @brief I had to check my old Java submissions for solving this one.
 *
 * @author vic
 * @date February 2025
 */

#include <iostream>
#include <vector>
using namespace std;

// Brute force Solution. Trying to be smart I ended up with the brute force solution
vector<int> productExceptSelf(vector<int> &nums)
{
    int size = nums.size();
    vector<int> result(size, 1);
    vector<int> complement(size - 1, 1);

    for (int i = 1; i < size; i++)
    {
        complement[i - 1] = nums[i];
    }

    int complementIndex;
    for (int i = 0; i < size; i++)
    {
        int product = 1;
        for (int j = 0; j < size - 1; j++)
        {
            product *= complement[j];
        }
        result[i] = product;

        if (i != size - 1)
        {
            complement[i] = nums[i];
        }
    }

    return result;
}

// Prefix/postfix solution
vector<int> productExceptSelf(vector<int> &nums)
{
    int size = nums.size();
    vector<int> result(size, 1);

    int prefix = 1;
    for (int i = 0; i < size; i++)
    {
        result[i] = prefix;
        prefix *= nums[i];
    }

    int postfix = 1;
    for (int i = size - 1; i >= 0; i--)
    {
        result[i] *= postfix;
        postfix *= nums[i];
    }

    return result;
}

int main() {
    
}