object Solution {
    def numRollsToTarget(d: Int, f: Int, target: Int): Int = {

      d match {
        case 
      }

      (1 to f).toList.foldLeft(0) { (acc, i) => {
        if (i == target) {
          acc += 1
        } else {
          acc
        }
      }}

    }
}

/*
d = 1, f = 6, target = 3

box1 1 | 2 | 3 | 4 | 5 | 6
             v


d = 2, f = 6, target = 7

box1 1 | 2 | 3 | 4 | 5 | 6
box2 1 | 2 | 3 | 4 | 5 | 6

1, 6
2, 5
3, 4
4, 3
5, 2
6, 1


d = 3, f = 6, target = 12

box1 1 | 2 | 3 | 4 | 5 | 6
box2 1 | 2 | 3 | 4 | 5 | 6
box3 1 | 2 | 3 | 4 | 5 | 6


*/