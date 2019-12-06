/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    if (s.length === 0 || t.length === 0) return "";
    let tMap = new Map(); // 目标子串t的辅助map，用于记录t中每个字符的出现次数
    // 对tMap进行初始化，记录每一个字符出现的次数
    for (let i = 0; i < t.length; i++) {
        let char = t[i];
        if (tMap.has(char)) {
            tMap.set(char, tMap.get(char) + 1);
        } else {
            tMap.set(char, 1);
        }
    }

    let windowMap = new Map(); // 滑动窗口的辅助map，用于记录当前滑动窗口中各个字符出现的次数
    let matchNum = 0; // 记录滑动窗口中对应字符匹配到t中字符的个数

    let left = 0, right = 0; // 定义左右指针

    let miniLength = -1, // 记录最小长度
        miniLeft = 0, // 长度最小是左指针下标
        miniRight = 0; // 长度最小时右指针下标

    while (right < s.length) {
        let char = s[right];
        // 对windowMap进行初始化
        if (windowMap.has(char)) {
            windowMap.set(char, windowMap.get(char)+1);
        } else {
            windowMap.set(char, 1);
        }

        // 如果某一个字符的次数匹配成功，则matchNum个数加1
        if (tMap.has(char) && windowMap.get(char) === tMap.get(char)) {
            matchNum++
        }

        // 如果已匹配成功字符的个数等于tMap的长度，则说明当前滑动窗口中已经存在t
        // 则对滑动窗口进行优化
        while (matchNum === tMap.size) {
            char = s[left];
            // 只有当滑动窗口长度小于当前最小覆盖子串的长度时，才重新计算miniLeft和miniRight
            // 第一次时需要计算
            if (miniLength === -1 || right - left + 1 < miniLength) {
                miniLength = right- left + 1;
                miniLeft = left;
                miniRight = right;
            }

            // 删除滑动窗口中的char，修改windowMap中char的个数
            windowMap.set(char, windowMap.get(char) - 1);

            // 如果当前字符的个数小于t中需求的个数，则匹配到的字符个数matchNum减1
            if (tMap.has(char) && windowMap.get(char) < tMap.get(char)) {
                matchNum--;
            }
            left++;
        }
        right++;
    }
    return miniLength === -1 ? "" : s.substring(miniLeft, miniRight+1);
};
