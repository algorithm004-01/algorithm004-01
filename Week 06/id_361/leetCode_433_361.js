// 433. 最小基因变化

/**
 * BFS
 /**
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
var minMutation = function(start, end, bank) {
    if(start == end){
        return 0;
    }
    var bankSet = new Map();
    for(var i = 0;i<bank.length;i++){
        bankSet.set(bank[i],true);
    }
    var genes = ['A','C','G','T'];
    var level = 0;
    var queue = [[start,0]];
    while(queue.length != 0){
        var curr = queue.pop();
        level = curr[1]
        if(curr[0] == end){
            return level;
        }
        var arrCurr = curr[0];
        for(var i = 0;i<arrCurr.length;i++){
            for(var r = 0;r<genes.length;r++){
                if(genes[r] != arrCurr[i]){
                    var strCurr = (arrCurr.slice(0,i))+genes[r]+(arrCurr.slice(i+1));
                    if(bankSet.has(strCurr)){
                        queue.unshift([strCurr,level+1]);
                        bankSet.delete(strCurr);
                    }
                }
            }
        }
    }
    return -1;
};

/**
 * DFS
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
var minMutation = function(start, end, bank) {
    if(start == end){
        return 0;
    }else if(!bank || bank.length == 0){
        return -1;
    }
    var visited = new Map();
    var minLevel = Number.MAX_SAFE_INTEGER;
    var level = 0;
    function recurse(start,level){
        if(start == end){
            minLevel = Math.min(minLevel,level);
        }
        for(var i = 0;i<bank.length;i++){
            var tmpBank = bank[i];
            var diff = 0;
            for(var r = 0;r<tmpBank.length;r++){
                if(start[r] != tmpBank[r]){
                    diff++;
                    if(diff > 1){
                        break;
                    }
                }
            }
            if(diff == 1 && !visited.has(tmpBank)){
                visited.set(tmpBank,true);
                recurse(tmpBank,level+1);
                visited.delete(tmpBank);
            }
        }
    }
    recurse(start,level);
    return (minLevel ^ Number.MAX_SAFE_INTEGER) == 0 ? -1 : minLevel;
};

