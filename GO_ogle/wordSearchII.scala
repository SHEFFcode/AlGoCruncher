import scala.collection.mutable.{ListBuffer, HashMap}

object Solution {
  private type CharMatrix = Array[Array[Char]]
  private type StringBuffer = ListBuffer[String]
  private final val offsets = Array((-1, 0), (0, 1), (1, 0), (0, -1))
  def findWords(
      board: Array[Array[Char]],
      words: Array[String]
  ): List[String] = {
    val root = constructTrie(words, new TrieNode())
    val result = ListBuffer[String]()

    for (i <- 0 until board.length) {
      for (j <- 0 until board(0).length) {
        if (root.children.contains(board(i)(j))) {
          // if there is a trie starting at char, backtrack
          backTrack(i, j, root, board, result)
        }
      }
    }

    result.toList
  }

  private def backTrack(
      row: Int,
      col: Int,
      parent: TrieNode,
      brd: CharMatrix,
      result: StringBuffer
  ): Unit = {
    val letter = brd(row)(col)
    val cNode = parent.children(letter)

    // base case found a word
    if (cNode.word != null) { // found a full word
      result += cNode.word
      cNode.word = null // don't need this word again
    }

    // mark current letter as explored
    brd(row)(col) = '#' // random non letter symbol

    //explore neighbor cells: up, right, down, left
    for (i <- 0 until 4) {
      val newRow = row + offsets(i)._1
      val newCol = col + offsets(i)._2
      if (validSpot(newRow, newCol, brd.length, brd(0).length)) {
        if (cNode.children.contains(brd(newRow)(newCol))) {
          backTrack(newRow, newCol, cNode)
        }
      }
    }

    // end exploration
    brd(row)(col) = letter

    // Optimization: incrementally remove the leaf nodes
    if (cNode.children.isEmpty) {
      parent.children.remove(letter)
    }
  }

  private def validSpot(row: Int, col: Int, len: Int, width: Int): Boolean = {
    row > -1 && row < len && col > -1 && col < width
  }

  private def constructTrie(words: Array[String], root: TrieNode): TrieNode = {
    for (word <- words) {
      var cNode = root // all nodes children of root
      for (c <- word) {
        if (cNode.children.contains(c)) cNode = cNode.children(c) // move down
        else {
          val newNode = new TrieNode()
          cNode.children(c) = newNode // add a new node for a brand new letter
          cNode = newNode // move down
        }
      }
      cNode.word = word // once finished all letters, add a word, can only be 1
    }

    root
  }
}

case class TrieNode() {
  val children = HashMap[Char, TrieNode]() // hashmap of children
  var word: String = null // can exist or not
}

/*
G: board: Array[Array[Char]], words: Array[String]
O: allWords: List[String]
T: O(nm * nm) each starting point with exhaustive array search
S: O(nm)

Notes:
  - Each word must be constructed from cells where adjacent cells are horizontally or vertically
  - The same letter cell may not be used more than once in a word.

Ex:
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []


 */
