/* The knows API is defined in the parent class Relation.
      def knows(a: Int, b: Int): Boolean = {} */

class Solution extends Relation {
  def findCelebrity(n: Int): Int = {
    val potentialCeleb = (1 until n).foldLeft(0) {
      case (pCeleb, partier) => if (knows(pCeleb, partier)) partier else pCeleb
    }

    (0 until n).foldLeft(potentialCeleb) {
      case (pCeleb, partier) =>
        if (
          pCeleb != partier && knows(pCeleb, partier) || !knows(partier, pCeleb)
        ) return -1
        else pCeleb
    }
  }
}

/*
G: n: Int => number of partiers
O: celebrity: Int => the index of the celebrity
T: O(N)
S: O(1)

Notes:
  - A celebrity is someone who does not know anyone else, but everyone else knows them.

Ex:

 */
