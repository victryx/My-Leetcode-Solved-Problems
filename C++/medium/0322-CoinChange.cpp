/**
 * @file 0322-CoinChange.cpp
 * @brief DP programming practice
 *
 * @author Vika
 * @date May 2026
 */

#include <algorithm>
#include <vector>
using namespace std;

const int INF = 10e4 + 1;

int coinChange(vector<int>& coins, int amount) {
    int num_coins = coins.size();
    vector<vector<int>> dp_table(num_coins + 1, vector<int>(amount + 1, 0));
    for (int i = 1; i < num_coins + 1; ++i) {
        int cur_coin = coins[i - 1];
        for (int j = 1; j < amount + 1; ++j) {
            if (i == 1 && j < cur_coin) {
                dp_table[i][j] = INF;
            } else if (i == 1) {
                dp_table[i][j] = 1 + dp_table[i][j - cur_coin];
            } else if (j < cur_coin) {
                dp_table[i][j] = dp_table[i - 1][j];
            } else {
                int prev = dp_table[i - 1][j];
                int next = 1 + dp_table[i][j - cur_coin];
                dp_table[i][j] = min(prev, next);
            }
        }
    }
    if (dp_table[num_coins][amount] >= INF) {
        return -1;
    }
    return dp_table[num_coins][amount];
}