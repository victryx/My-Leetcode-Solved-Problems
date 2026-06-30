/**
 * @file 0072-EditDistance.cpp
 * @brief Dynamic Programming practice
 *
 * @author Vika
 * @date June 2026
 */

#include <iostream>

using namespace std;

int minDistance(string word1, string word2) {
    int n = word1.size() + 1;
    int m = word2.size() + 1;
    int dp[n][m];

    // base cases
    for (int i = 0; i < n; i++) {
        dp[i][0] = i;
    }
    for (int j = 0; j < m; j++) {
        dp[0][j] = j;
    }

    for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
            if (word1[i - 1] == word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                dp[i][j] = 1 + min(min(
                    dp[i - 1][j - 1], // replace
                    dp[i][j - 1]),  // insert
                    dp[i - 1][j]    // delete
                );
            }
        }
    }

    return dp[n - 1][m - 1];
}


int main() {

}