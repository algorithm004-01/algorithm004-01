/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if(s.length !== t.length) return false;
    const s1 = s.split('').sort().join('');
    const b1 = t.split('').sort().join('');
    return s1 === b1;
};