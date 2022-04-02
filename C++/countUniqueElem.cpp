#include <bits/stdc++.h>
using namespace std;

int main()
{
    int arr[] = {1, 2, 3, 4, 5, 2, 3, 4, 5, -1};
    map<int, int> memo;

    for (int key : arr)
    {
        if (memo.find(key) != memo.end())
        {
            int frequency = memo[key];
            memo[key] = frequency + 1;
        }
        else
        {
            memo[key] = 1;
        }
    }
    for (int key : arr)
    {
        if (memo[key] == 1)
        {
            cout << "KEY : " << key << endl;
        }
    }
}