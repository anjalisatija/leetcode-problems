from fractions import Fraction

class Solution:
    def fractionAddition(self, expression: str) -> str:
        # Split the expression into components
        fractions = []
        num = ""
        for c in expression:
            if c in "+-":
                if num:
                    fractions.append(num)
                num = c

            else:
                num += c

        fractions.append(num)
        # Convert string to int & sum
        sum = Fraction(0)

        # Sum the fractions as a fraction
        for frac in fractions:
            sum+=Fraction(frac)

        # Handle the special case where the sum is 0
        if sum.denominator == 1:
            return f"{sum.numerator}/1"
        else:
            return str(sum)


        