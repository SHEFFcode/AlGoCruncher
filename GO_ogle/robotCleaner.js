/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * function Robot() {
 *
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     @return {boolean}
 *     this.move = function() {
 *         ...
 *     };
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     @return {void}
 *     this.turnLeft = function() {
 *         ...
 *     };
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     @return {void}
 *     this.turnRight = function() {
 *         ...
 *     };
 *
 *     // Clean the current cell.
 *     @return {void}
 *     this.clean = function() {
 *         ...
 *     };
 * };
 */
/**
 * @param {Robot} robot
 * @return {void}
 */

var cleanRoom = function(robot) {
  robot.clean()
  const robotCleaner = new RobotCleaner(robot)
  robotCleaner.clean()
}

class RobotCleaner {
  constructor(robot) {
    this.robot = robot
    this.COORDINATE = {
      UP: 0,
      LEFT: 1,
      DOWN: 2,
      RIGHT: 3,
    }
    this.cameFrom = 0

    this.currentCoordinate = [0, 0]
    this.location = {
      [JSON.stringify(this.currentCoordinate)]: true,
    }
    this.robotDirection = this.COORDINATE.UP
  }

  clean() {
    for (let i = 0; i < 4; i++) {
      this.faceDirection(this.robot, i) // I want to face in the direction i
      this.cameFrom = (i + 2) % 4
      this.explore(this.robot, i, this.currentCoordinate) // I want to go i n the direction i
    }
  }

  explore(robot, direction, currentCoordinate) {
    let movedToPosition = this.calculateNextPosition(
      currentCoordinate,
      direction,
    )
    if (!this.location[JSON.stringify(movedToPosition)]) {
      if (robot.move()) {
        this.cameFrom = (direction + 2) % 4
        console.log(`Came from ${this.cameFrom}`)
        currentCoordinate = this.updateCurrentCoordinate(
          movedToPosition,
          this.cameFrom,
        )
        robot.clean()
        for (let i = 0; i < 4; i++) {
          this.faceDirection(robot, i) // faceing left
          this.explore(robot, i, currentCoordinate) // want to go left
        }
        console.log(
          `I should move in direction ${
            this.location[JSON.stringify(currentCoordinate)]
          }`,
        )
        let reverseDirection = parseInt(
          this.location[JSON.stringify(currentCoordinate)],
        )
        currentCoordinate = this.calculateNextPosition(
          currentCoordinate,
          reverseDirection,
        )
        console.log(`Moved back to coordinate ${currentCoordinate}`)
        this.faceDirection(robot, reverseDirection)
        robot.move()
      }
    }
  }

  calculateNextPosition(currentCoordinate, direction) {
    switch (parseInt(direction)) {
      case this.COORDINATE.UP:
        return [currentCoordinate[0], currentCoordinate[1] + 1]
      case this.COORDINATE.LEFT:
        return [currentCoordinate[0] - 1, currentCoordinate[1]]
      case this.COORDINATE.RIGHT:
        return [currentCoordinate[0] + 1, currentCoordinate[1]]
      case this.COORDINATE.DOWN:
        return [currentCoordinate[0], currentCoordinate[1] - 1]
    }
  }

  updateCurrentCoordinate(newCoordinate, cameFrom) {
    if (!this.location[JSON.stringify(newCoordinate)]) {
      this.location[JSON.stringify(newCoordinate)] = cameFrom.toString()
    }
    console.log(JSON.stringify(this.location))
    return newCoordinate
  }

  faceDirection(robot, directionIWantToFace) {
    if (this.robotDirection === directionIWantToFace) {
      return
    }
    this.robotDirection = (this.robotDirection + 1) % 4
    robot.turnLeft()
    this.faceDirection(robot, directionIWantToFace)
  }
}
