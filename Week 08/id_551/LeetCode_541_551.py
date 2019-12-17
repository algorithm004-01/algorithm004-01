class Solution:
def reverseStr(self, s: str, k: int) -> str:
    lists=[]
    a=0
    while a<len(s):
        lists.append(s[a:a+k])
        a+=k
    for i in range(len(lists)):
        if i%2==0:
            lists[i]=lists[i][::-1]
    
    res=''
    for j in lists:
        res+=j
    return res
