class Solution {
    func isAnagram(_ s: String, _ t: String) -> Bool {
    
        func strToDict(_ str: String) -> [Character: Int] {
            var dict = [Character: Int]()
            str.forEach { (ch) in
                if let count = dict[ch] {
                    dict[ch] = count + 1
                } else {
                    dict[ch] = 0
                }
            }
            return dict
        }
    
        return strToDict(s) == strToDict(t)
    }
}






