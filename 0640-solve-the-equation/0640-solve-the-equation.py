class Solution:
    def solveEquation(self, eq: str) -> str:
        def extract(eq):
            coeff=0
            nums=0
            i=0
            while i<len(eq):
                if eq[i]=="+":
                    sign = 1 
                    i+=1
                elif eq[i]=="-":
                    sign=-1
                    i+=1
                else:
                    sign=1
                num=""
                while i<len(eq) and eq[i].isdigit():
                    num+=eq[i]
                    i+=1
                if i<len(eq) and eq[i]=="x":
                    coeff+=int(num)*sign if num else sign
                    i+=1
                else:
                    nums+=int(num)*sign if num else 0
            return coeff,nums
        l,r=eq.split("=")
        lc,ln=extract(l)
        rc,rn=extract(r)
        tc=lc-rc
        tn=ln-rn
        if tc==0:
            return "Infinite solutions" if tn==0 else "No solution"
        return "x="+str(-tn//tc)