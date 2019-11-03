class Solution {
    func isAnagram(_ s: String, _ t: String) -> Bool {
        return s.lowercased().sorted() == t.lowercased().sorted()
    }
}
