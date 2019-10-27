#include <iostream>
#include <vector>
#include <map>

using namespace std;

class Solution {
public:
    /*********
      解法1：暴力法
    ********/
    vector<int> twoSum1(vector<int>& nums, int target) {
        int i,j;
        vector<int> res;
        for(i=0;i<nums.size()-1;++i)
        {
            for(j=i+1;j<nums.size();++j)
            {
                if(nums[i] + nums[j] == target)
                {
                    res.push_back(i);
                    res.push_back(j);
                    break;
                }
            }
        }
        return res;
    }
    /***********
    解法2：两次哈希表
    ************/
    vector<int> twoSum2(vector<int>& nums, int target) {
        map<int,int> iMap;
        vector<int> res;
        int i,temp;
        for(i=0;i<nums.size();++i)
        {
            iMap[nums[i]] = i;//初始化map，值形式：{值，索引}
        }
        for(i=0;i<nums.size();++i)
        {
            temp = target - nums[i];
            if(iMap.count(temp) && iMap[temp]!=i)
            {
                res.push_back(i);
                res.push_back(iMap[temp]);
                break;
            }
        }
        return res;
    }

    /***********
    解法3：一次哈希表
    ************/
    vector<int> twoSum3(vector<int>& nums, int target) {
        map<int,int> iMap;
        vector<int> res;
        int i,temp;
        for(i=0;i<nums.size();++i)
        {
            temp = target - nums[i];
            if(iMap.count(temp))
            {
                res.push_back(i);
                res.push_back(iMap[temp]);
                break;
            }
            iMap[nums[i]] = i;
        }
        return res;
    }
};

int main()
{
    int j;
    Solution s;
    vector<int> nums,res;
    /*******
     以下测试验证
    *****/
    nums.push_back(2);
    nums.push_back(7);
    nums.push_back(11);
    nums.push_back(15);
    res=s.twoSum3(nums,9);
    for(int i=0;i<res.size();i++)
      cout<<res[i]<<",";
    cout<<endl;
    return 0;
}
