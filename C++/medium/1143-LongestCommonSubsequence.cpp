/**
 * @file 1143-LongestCommonSubsequence.cpp
 * @brief Dynamic Programming practice
 *
 * @author Vika
 * @date June 2026
 */

#include <iostream>
#include <vector>

using namespace std;

int longestCommonSubsequence(string text1, string text2) {
    int n = text1.size() + 1;
    int m = text2.size() + 1;
    vector<vector<int>> cache(n, vector<int>(m, 0));

    for (int i = 1; i < n; ++i) {
        for (int j = 1; j < m; ++j) {
            if (text1[i - 1] == text2[j - 1]) {
                cache[i][j] = 1 + cache[i - 1][j - 1];
            } else {
                cache[i][j] = max(
                    cache[i - 1][j],
                    cache[i][j - 1]
                );
            }
        }
    }

    return cache[n - 1][m - 1];
}

int main() {

}