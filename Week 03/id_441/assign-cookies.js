// https://leetcode-cn.com/problems/assign-cookies/
var findContentChildren = function (g, s) {
    let res = 0;
    s = s.sort((a, b) => a - b)

    g = g.sort((a, b) => a - b)

    g.forEach(item => {
        while (s.length) {
            if (item <= s.shift()) {
                res++
                break
            }
        }
    })
    return res
}

var findContentChildren = function (g, s) {
    s = s.sort((a, b) => a - b)

    g = g.sort((a, b) => a - b)

    let g_i = 0;
    let s_i = 0;
    let count = 0;
    while (g_i < g.length && s_i < s.length) {
        if (g[g_i] <= s[s_i]) {
            g_i++;
            s_i++;
            count += 1
        } else {
            s_i++
        }
    }

    return count
}