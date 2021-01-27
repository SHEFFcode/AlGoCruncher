object Solution {
  private type Image = Array[Array[Int]]
  def floodFill(
      image: Array[Array[Int]],
      sr: Int,
      sc: Int,
      newColor: Int
  ): Array[Array[Int]] = {
    val color = image(sr)(sc)
    if (color == newColor) image
    else explore(image, sr, sc, color, newColor)
  }

  private def explore(image: Image, i: Int, j: Int, c: Int, nc: Int): Image = {
    if (isValid(i, j, image, c)) {
      image(i)(j) = nc
      explore(image, i + 1, j, c, nc)
      explore(image, i - 1, j, c, nc)
      explore(image, i, j + 1, c, nc)
      explore(image, i, j - 1, c, nc)
    }
    image
  }

  private def isValid(i: Int, j: Int, image: Image, c: Int): Boolean = {
    i > -1 && j > -1 &&
    i < image.length && j < image(0).length &&
    image(i)(j) == c
  }
}

/*
G: image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int
O: modifiedImage: Array[Array[Int]]
T: O(n)
S: O(n)

Notes:

Ex:
  - An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
  - (sr, sc) representing the starting pixel (row and column)
  - pixel value newColor
  - To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to
    the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally
    to those pixels (also with the same color as the starting pixel), and so on.
    Replace the color of all of the aforementioned pixels with the newColor.

 */
