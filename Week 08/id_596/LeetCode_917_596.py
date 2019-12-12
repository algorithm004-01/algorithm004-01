class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        chars = list(S)
        low, high = 0, len(chars) - 1
        while low < high:
            if not chars[low].isalpha():
                low += 1
            elif not chars[high].isalpha():
                high -= 1
            else:
                chars[low], chars[high] = chars[high], chars[low]
                low += 1
                high -= 1
        return "".join(chars)