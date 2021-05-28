object Solution extends App {
  def auditGroups(related: Array[String]): Int = {
    if (related.length == 0) return 0
    val len = related.length // we know it's a square
    val matrix = Array.ofDim[Int](len, len) // square matrix

    related.zipWithIndex.foldLeft(matrix) {
      case (matrix, (rowString, row)) => {
          rowString.zipWithIndex.foreach {
            case (char, col) => matrix(row)(col) = char - '0'
          }
        }
        matrix
    }

    val brain = scala.collection.mutable.HashSet[String]()
    var count = related.length
    for (i <- 0 until len) {
      for (j <- 0 until len) {
        if (i != j && !brain.contains(s"$j,$i")) {
          if (matrix(i)(j) == 1 && matrix(j)(j) == 1) {
            brain += s"$i,$j"
            count -= 1
          }
        }
      }
    }

    count
  }

  println(auditGroups(Array("1100", "1110", "0110", "0001")))
}

/*
Q: Amazon is working on grouping people in audible groups. You are given a list of integers which are pictorially repesented as 2D matrix

Input List
110, 110, 001

Return the number of groups

public int groups(List users){

}

Matrix representation
col 0 col1 col2
row 0 1 1 0
row 1 1 1 0
row 2 0 0 1

M[i][j] = 1 represents user a and user b are connected. Each user knows himself
For instance in above example user 0 knows user 0 and 1 so(matrix[0][0] = 0 and matrix[0][1] =1)
Similaraly user 1 knows user 0 and 1so(matrix[1][0] = 0 and matrix[1][1] =1)
user 2 knows no one so matrix[2][2] = 2
Find the number of groups. in this example there are 2 groups {0,1} and {2}

When I saw the question in first pass this seems like number of island question but there was a variation which I didn't pay attention to. The question also said users can be directly known to each other or transitively.

Consider below example which was hidden test case

Matrix representation
col 0 col1 col2 col3
row 0 1 1 0 0
row1 1 1 0 1
row2 0 0 1 0
row3 0 0 0 1

In above case the expected grouping is user 0 knows user 0(himself) and 1
User 1 knows user 0, 1 and in addition knows user 3 since matrix[1][3] = 1 . User 3 is connected to user 1 directly and since user 0 and 1 are connected already, user 3 and user 0 are connected transitively .

In this case also the expected output is 2 groups {0,1,3} and {2} but my code was returing 3 groups {0,1} {2} and {3} . By the time I understood this and tried to solve using Union Find I ran out of time. So my submission passed only 3/10 cases


["1100","1110","0110","0001"]
 */
