class Solution:
    def game(self, guess: List[int], answer: List[int]) -> int:
        return sum(guess[i]==answer[i] for i in range(len(guess)))