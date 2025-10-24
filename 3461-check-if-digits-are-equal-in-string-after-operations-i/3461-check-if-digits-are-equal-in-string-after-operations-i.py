class Solution:
    def hasSameDigits(self, s: str) -> bool:
        while len(s)>2:
            n=""
            for i in range(0,len(s)-1):
                dig=(int(s[i])+int(s[i+1]))%10
                n+=str(dig)
            s=n
        return len(s)==2 and s[0]==s[1]

         