/**
 * @file 0051-NQueens.cpp
 * @brief Backtracking practice
 *
 * @author Vika
 * @date June 2026
 */

#include <vector>
#include <string>

using namespace std;

vector<vector<string>> solveNQueens(int n) {
        vector<vector<int>> valid_sols;
        vector<int> cur_sol(n, -1);
        n_queens(valid_sols, cur_sol, 0, n);

        int n_sols = valid_sols.size();
        string line(n,'.');
        vector<vector<string>> out(n_sols, vector<string>(n,line));

        for (int i = 0; i < n_sols; ++i) {
            for (int j = 0; j < n; ++j) {
                out[i][j][valid_sols[i][j]] = 'Q';
            }
        }

        return out;
    }

    bool factible(const vector<int>& sol, int k) {
        if (k <= 1) // no hay reinas o solo hay una
            return true;

        // comprobamos solo la última reina colocada (en k-1)
        int last = k - 1;
        for (int i = 0; i < last; ++i) {
            if (sol[i] == sol[last])
                return false; // columna ya ocupada

            int dif_filas = abs(sol[i] - sol[last]);
            int dif_columnas = abs(i - last);
            if (dif_filas == dif_columnas)
                return false; // conflicto de diagonal
        }

        return true;
    }

    void n_queens(vector<vector<int>>& valid_sols, vector<int>& cur_sol, int k,
                  int n) {
        if (!factible(cur_sol, k)) {
            return;
        }
        if (k == n) {
            valid_sols.push_back(cur_sol);
            return;
        }

        // elegir columna para la reina k
        for (int i = 0; i < n; ++i) {
            cur_sol[k] = i;
            n_queens(valid_sols, cur_sol, k + 1, n);
            cur_sol[k] = -1;
        }
    }