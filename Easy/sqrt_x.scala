object Solution {
    def mySqrt(x: Int): Int = {
        if (x == 0 || x == 1) return x

        def calc(temp: Int): Int = {
            if (temp <= (temp + x / temp) / 2) return temp
            else calc(Math.abs((temp + x/temp)/2))
        }

        calc(x)
    }
}