class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        
        phone = {
            "2": ["a", "b", "c"],
            "3": ["d", "e", "f"],
            "4": ["g", "h", "i"],
            "5": ["j", "k", "l"],
            "6": ["m", "n", "o"],
            "7": ["p", "q", "r", "s"],
            "8": ["t", "u", "v"],
            "9": ["w", "x", "y", "z"]
        }
        
        
        def trackback(combination, next_digits):
            if len(next_digits) == 0:
                return res.append(combination)
            
            for letter in phone[next_digits[0]]:
                trackback(combination + letter, next_digits[1:])
                
                
        res = []
        if digits is not None:
            trackback("", digits)
        return res
            
