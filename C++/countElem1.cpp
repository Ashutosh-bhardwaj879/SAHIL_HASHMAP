#include <bits/stdc++.h>
using namespace std;

int main()
{
    map<int, int> mp;

    int arr[] = {1, 2, 3, 4, 5, -1, 0, 23, 1, 2, 3};

    for (int key : arr)
    {
        if (mp.find(key) != mp.end())
        {
            int value = mp[key];
            mp[key] = value + 1;
        }
        else
        {
            mp[key] = 1;
        }
    }
    map<int, int>::iterator it;
    for (it = mp.begin(); it != mp.end(); it++)
    {
        cout << it->first << " " << it->second << endl;
    }
    for (auto &elem : mp)
    {
        cout << elem.first << " " << elem.second << "\n";
    }
}
//TC - O(N)
