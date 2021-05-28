object Solution {
  def isRobotBounded(instructions: String): Boolean = {
    val north = 0
    var (x, y) = (0, 0)

    val facingInEnd = instructions.foldLeft(north) {
      case (direction, instruction) => {
        instruction match {
          case 'G' => {
            direction match {
              case 0 => x += 1
              case 2 => x -= 1
              case 1 => y += 1
              case 3 => y -= 1
            }
            direction
          }
          case 'L' => ((direction + 4) - 1) % 4 // turn left
          case 'R' => ((direction + 4) + 1) % 4 // turn right
        }
      }
    }

    facingInEnd != north || (x == 0 && y == 0)
  }
}
