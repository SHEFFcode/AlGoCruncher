def maxPathSum(root: TreeNode): Int = {
      def findMaxPath(cNode: TreeNode): (Int, Int) = {
        val left: Option[(Int, Int)] = if (cNode.left != null) Some(findMaxPath(cNode.left)) else None
        val right: Option[(Int, Int)] = if (cNode.right != null) Some(findMaxPath(cNode.right)) else None
        val self: Int = cNode.value

        val max = (
          Seq(self) ++
            left.map(maxCmax => maxCmax._1 + self).toSeq ++
            right.map(maxCmax => maxCmax._1 + self).toSeq
          ).max // we find the max between self, global left max and global right max to be our new global max.

        val cMax = (
          left.map(leftMaxCmax => Seq(leftMaxCmax._1, leftMaxCmax._2)).getOrElse(Seq.empty) ++
            right.map(rightMaxCmax => Seq(rightMaxCmax._1, rightMaxCmax._2)).getOrElse(Seq.empty) ++
            Seq(self) ++
            (for {
              leftMax <- left.map(_._1)
              rightMax <- right.map(_._1)
            } yield leftMax + rightMax + self).toSeq
          ).max // get the current cMax from leftMax, leftCmax, rightcMax, rightcMax, self, leftMax + rightMax + self

        (max, cMax)
      }

      val (max: Int, cMax: Int) = findMaxPath(root)
      Math.max(max, cMax)
    }