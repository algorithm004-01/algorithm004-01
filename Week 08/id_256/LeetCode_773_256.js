/*
 * @lc app=leetcode.cn id=773 lang=javascript
 *
 * [773] 滑动谜题
 */

// @lc code=start
/**
 * @param {number[][]} board
 * @return {number}
 */
var slidingPuzzle = function(board) {
    // BFS
    let R = board.length;
    if(R == 0) return 0;
    let C = board[0].length;
    if(C == 0) return 0;
    let sr = 0;
    let sc = 0;
    search:
    for(sr = 0; sr < board.length; sr++) {
        for(sc = 0; sc < board[sr].length; sc++) {
            if(board[sr][sc] == 0) {
                break search;
            }
        }
    }
    let queue = [];
    let strQueue = [];
    let start = new Node(board, sr, sc, 0);
    queue.push(start);
    strQueue.push(start.boardStr);
    let direction = [[-1,0],[1,0],[0,-1],[0,1]];
    let target = "1,2,3,4,5,0";
    while(queue.length > 0) {
        let tempNode = queue.shift();
        if(tempNode.boardStr == target) {
            return tempNode.depth;
        }
        for(let i = 0; i < direction.length; i++) {
            let nei_r = direction[i][0] + tempNode.nei_r;
            let nei_c = direction[i][1] + tempNode.nei_c;
            if((Math.abs(nei_r - tempNode.nei_r) + Math.abs(nei_c - tempNode.nei_c) != 1) || nei_r < 0 || nei_c < 0 || nei_r >= R || nei_c >= C) continue;
            //创建新board
            let newBoard = JSON.parse(JSON.stringify(tempNode.board));
            newBoard[tempNode.nei_r][tempNode.nei_c] = newBoard[nei_r][nei_c];
            newBoard[nei_r][nei_c] = 0;
            let newNode = new Node(newBoard, nei_r, nei_c, tempNode.depth + 1);
            if(strQueue.indexOf(newNode.boardStr) >= 0) continue;
            strQueue.push(newNode.boardStr);
            queue.push(newNode);
        }
    }
    return -1;
};
class Node {
    //board [][]
    //nei_r nei_c 0所以索引
    //depth 深度
    constructor(board, nei_r, nei_c, depth) {
        this.board = board;
        this.nei_r = nei_r;
        this.nei_c = nei_c;
        this.depth = depth;
        this.boardStr = board.toString();
    }
}

