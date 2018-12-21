object Solution {
    def mySqrt(x: Int): Int = {
        if (x == 0 || x == 1) return x

        def calc(candidate: Int): Int = {
            if (candidate <= (candidate + x / candidate) / 2) candidate
            else calc(Math.abs((candidate + x / candidate) / 2))
        }

        calc(x)
    }
}

/*
Explanation:
I believe only this line requires an explanation

if (candidate <= (candidate + x / candidate) / 2) return candidate
The idea here is as follows, let's say candidate is the result of the previous candidate calculation. Then we can dig deeper into this portion:

candidate <= (candidate + x / candidate) / 2
Here we can do some refactoring without changing the underlying equation

candidate * candidate <= (candidate * candidate + (x / candidate) * candidate) / 2
now we get

candidate ^ 2 <= (candidate ^ 2 + x) / 2
But x in theory is also candidate * candidate, as if that is the case we satisfy our condition of the candidate being the square root of x, so

candidate ^ 2 <= (candidate ^ 2 + candidate ^ 2) / 2
Now it's abundantly clear that if the left hand side is equal to the right hand side we found the solution. Of course if it is less, we are not below the solution, which, because we are looking for an integer result, is also the right solution. Hope this helps.

*/