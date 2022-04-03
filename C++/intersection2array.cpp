#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    vector<int> intersection(vector<int> &nums1, vector<int> &nums2)
    {
        vector<int> ans;

        map<int, bool> memo;

        for (int key : nums1)
        {
            if (memo.find(key) == memo.end())
            {
                memo[key] = true;
            }
        }

        for (int key : nums2)
        {
            if (memo.find(key) != memo.end() && memo[key] == true)
            {
                ans.push_back(key);
                memo[key] = false;
            }
        }

        return ans;
    }
};
/*class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        vector<int> ans;

        map<int,int> memo;

        for(int key : nums1)
        {
            if(memo.find(key)!=memo.end())
            {
                int freq =  memo[key];
                memo[key] = freq + 1;
            }
            else
            {
                memo[key] = 1;
            }
        }

        for (int num: nums2)
        {
            if(memo.find(num) != memo.end())
            {
                ans.push_back(num);
                memo.erase(num);
            }
        }

        return ans;
    }
};*/