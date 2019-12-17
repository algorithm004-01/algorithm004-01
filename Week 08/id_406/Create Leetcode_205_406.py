class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        s2t = {}
        mapped_t = set()
        for i in range(len(s)):
            if s[i] in s2t:
                if s2t[s[i]] != t[i]:
                    return False
            else:
                if t[i] in mapped_t:
                    return False
                mapped_t.add(t[i])
                s2t[s[i]] = t[i]
        return True


def reverse(s,k):
	a = list(s)
	for i in xrange(0, len(a), 2*k):
		a[i:i+k] = reversed(a[i:i+k])
	return "".join(a)
