class Solution {
    func solveNQueens(_ n: Int) -> [[String]] {
        var res = [[String]]()
        let row = [Character](repeating:".", count: n)
        var board = [[Character]](repeating: row, count: n)
        dfs(&board, &res, 0)
        return res
    }


    func dfs(_ board:inout [[Character]], _ res: inout [[String]], _ col: Int){
        if col == board.count{
            res.append(build(board));
            return
        }
        
        for i in 0..<board.count{
            if valid(board, i, col){
                board[i][col] = "Q"
                dfs(&board, &res, col+1)
                board[i][col] = "."
            }
        }
    }

    func build(_ board:[[Character]]) -> [String]{
        var res = [String]()
        for row in board{
            res.append(String(row))
        }
        return res
    }

    func valid(_ board:[[Character]], _ x:Int, _ y: Int) -> Bool{
        for i in 0..<board.count{
            for j in 0...y{
                if board[i][j] == "Q" && (i == x || j == y || x + y == i + j || x - y == i - j){
                    return false
                }
            }
        }
        return true
    }

}
