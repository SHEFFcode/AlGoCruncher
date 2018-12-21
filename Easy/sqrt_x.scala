object Solution {
    def mySqrt(x: Int): Int = {
        if (x == 0 || x == 1) return x

        def calc(mid: Int): Int = {
            if (mid <= (mid + x / mid) / 2) return mid
            else calc(Math.abs((mid + x / mid) / 2))
        }

        calc(x)
    }
}

/*
input: 8

if (8 <= (8 + 8/8) / 2) => (8 < (8 + 1) / 2) => (8 < 9 / 2) => 8 < 4
if (4 <= (4 + 8 / 4) / 2) => (4 <= (4 + 2) / 2) => (4 < 6 / 2) => 4 < 3
if (3 <= (3 + (8 / 3) / 2) => (3 < (3 + 2) / 2) => (3 < 5 / 2) => 3 < 2
if (2 <= (2 + (8 / 2) / 2) => (2 < (2 + 4) / 2) => (2 < 6 / 2) => 2 < 3 => 2


(mid + x / mid) / 2

(mid * mid + x) / 2

(mid^2 + x) / 2

mid ^ 2 == x

(mid ^ 2 + mid ^ 2) / 2, which gets us the actual midpoint. So if the mid ^ 2 is less then the expression, we passed the solution

*/