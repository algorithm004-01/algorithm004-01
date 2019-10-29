/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    const hashTable = {};
    strs.map(item=>{
        const key = item.split('').sort();
        const val = (hashTable[key] || []);
        val.push(item);
        hashTable[key] = val;
    })
    return Reflect.ownKeys(hashTable).map(item => hashTable[item])
};