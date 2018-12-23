object Solution {
    def maxWidthRamp(A: Array[Int]): Int = {
        var difference = 0
        
        for {
            i <- 0 to A.length - 1
            j <- i + 1 to A.length - 1
        } yield {
            val diff = j - i
            if (A(i) <= A(j) && difference < diff) difference = diff
        }
        
        difference
    }
}

/**
failing due to time limit  
*/