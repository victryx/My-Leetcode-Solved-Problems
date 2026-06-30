/**
 * @file 0416-PartitionEqualSubsetSum
 * @brief Dynamic Programming practice
 *
 * @author Vika
 * @date June 2026
 *
 * @note code to be improved
 */

#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;

bool canPartition(vector<int>& nums) {
    int n = nums.size();
    int N = reduce(nums.begin(), nums.end()) / 2;



    vector<vector<bool>> D(n + 1, vector<bool>(N + 1, false));

    for (int i = 0; i <= n; ++i)
        D[i][0] = true;

    for (int i = 1; i <= n; ++i) {
        int cur_w = nums[i - 1];
        for (int j = 1; j <= N; ++j) {
            if (cur_w > j) {
                D[i][j] = D[i - 1][j];
            } else {
                D[i][j] = D[i - 1][j] || D[i - 1][j - cur_w];
            }
        }
    }

    vector<int> selected;
    int i = n;
    int j = N;
    while (D[i][j] == false && j > 0)
        --j;

    while (i > 0 && j > 0) {
        if (D[i][j] == D[i - 1][j]) {
            // no se ha seleccionado el objeto i - subimos fila
            --i;
        } else {
            // se ha seleccionado el objeto i
            selected.push_back(i - 1);
            j -= nums[i - 1];
            --i;
        }
    }

    int s_a = 0;
    int s_b = 0;
    for (int k = 0; k < nums.size(); ++k) {
        s_a += nums[k] * count(selected.begin(), selected.end(), k);
        s_b += nums[k] * !count(selected.begin(), selected.end(), k);
    }

    return s_a == s_b;
}