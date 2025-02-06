/**
 * @file 0242-ValidAnagram.cpp
 * @brief This one is easy, but I had some difficulties because I
 * forgot to initialize the array and because I failed on guessing
 * the number of letters in the alphabet
 *
 * @author vic
 * @date February 2025
 */

#include <iostream>
#include <string>
using namespace std;

bool isAnagram(string s, string t)
{
    if (s.size() != t.size())
    {
        return false;
    }

    int letters[26] = {0};
    for (int i = 0; i < s.size(); i++)
    {
        letters[s[i] - 'a']++;
        letters[t[i] - 'a']--;
    }

    for (int i = 0; i < 26; i++)
    {
        if (letters[i] != 0)
        {
            return false;
        }
    }
    return true;
}

int main()
{
    cout << isAnagram("anagram", "nagaram") << endl;
}