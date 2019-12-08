class Solution1 {
public:
    //解法1：单向bfs
    int minMutation(string start, string end, vector<string>& bank) {
        //1: 判读极端情况
        if(start.empty() || end.empty() || bank.empty()) return -1;
        
        if(find(bank.begin(), bank.end(), end) == bank.end())
            return -1; //目标基因不在基因库中
        
        //2: bfs的初始化工作: 初始化步长，初始化queue，将start入队列，用vecotr来标记已经访问过的点。
        vector<int> visit(bank.size(),0);
        int step=0;
        queue<string> q;
        q.push(start);
        
        //3: 进行bfs : 先将步长+1，然后确定每次bfs的长度size，寻找目标基因，然后出栈入栈等操作
        while (!q.empty()) {
            step++;
            int n = q.size();//确定每次bfs的宽度
            for (int i = 0; i < n; ++i) {
                string &temp = q.front(); q.pop();//获得队头元素
                for (int j = 0; j < bank.size(); ++j) {//遍历整个基因库,访问未标记的基因；找到某个字符变异的基因添加标记，并进入队列即可
                    if (visit[j] == 0) {
                        int diff = 0;
                        for (int k = 0; k < temp.size(); ++k)
                            if (temp[k] != bank[j][k]) diff++;
                        
                        if (diff == 1) { //找到某个字符编译的基因
                            if (bank[j] == end) return step;//若该下标j代表的基因为目标基因，则直接返回步长
                            visit[j] = 1;//标记下标为j的基因已访问
                            q.push(bank[j]);
                        }
                    }
                }
            }
        }
        return -1;
    }
};

/*
 * - 由于单向bfs类似金字塔，越到底层，塔基越大（而众多塔基中只有一点end满足条件），而且其回溯路径也少。
 *   所以我们采用双向bfs,即既从begin->end遍历，又从end->begin遍历，当然每次我们都选用较短队列进行遍历，这样可减少用时。
 * - 循环结束的条件是两个bfs碰头。每个单词遍历的方向，1由前向后遍历，2由后向前遍历，3两个bfs碰头。
 *   公式：0|1=1、0|2=2、1|2=3和i&i=i、i&0=0
 * */
class Solution2 {
public:
    //解法2：双向bfs
    int minMutation(string start, string end, vector<string>& bank) {
        //1:建立hashmap表，顺便去掉重复元素
        unordered_map<string,int> mp;
        for (const auto& b : bank) mp[b] = 0;
        
        //2:排除极端情况，end不在基因库中
        if (mp.count(end) == 0) return -1;
        
        //3:bfs的初始化工作
        queue<string> q1({start}), q2({end});//前向队列，后向队列
        int step=0;
        const char table[4]={'A','C','G','T'};//基因的字符
        //或1表示前向队列由前往后遍历，或2表示后向队列由后向前遍历，每次我们选用较小的队列进行遍历
        for (mp[start] |= 1,mp[end] |= 2; q1.size() && q2.size(); ++step) {//每遍历完一次，步长+1
            bool first = q1.size() < q2.size();
            queue<string> &q = first ? q1 : q2;//选择较小的队列进行遍历节约时间
            int flag = first ? 1 : 2;//此次遍历的方式
            
            for (int n = q.size(); n--; q.pop()) {
                string& temp = q.front();
                if (mp[temp] == 3) return step; //两个队列碰头，返回步长
                for (int i = 0; i < temp.size(); ++i) {
                    for (int j = 0; j < 4; ++j) {
                        string s = temp;
                        if (s[i] == table[j]) continue; //重复字符，跳出循环，寻找下一个字符
                        s[i] = table[j];
                        //该单词不在map中或该单词已经被遍历过了，跳出循环，寻找下一个单词
                        if (mp.count(s) == 0 || mp[s] & flag) continue;
                        mp[s] |= flag;//标记该单词已经被遍历过了
                        q.push(s);
                    }
                }
            }
        }
        return -1;
    }
};
