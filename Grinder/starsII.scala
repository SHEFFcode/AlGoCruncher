object Solution extends App {
  def steps(nSteps: Int) = {
    def stepsBuilder(nSteps: Int, row: Int, cStep: String): Unit = {
      if (nSteps == row) {
        return ()
      }

      if (nSteps == cStep.length()) {
        println(cStep)
        return stepsBuilder(nSteps, row + 1, "")
      }

      val add = if (cStep.length <= row) "#" else " "
      stepsBuilder(nSteps, row, cStep + add)
    }

    stepsBuilder(nSteps, 0, "")
  }

  steps(3)
}
