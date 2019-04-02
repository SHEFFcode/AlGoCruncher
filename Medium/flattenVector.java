class Vector2D {
  private int[][] vector;
  private int i = 0;
  private int j = 0;

  public Vector2D(int[][] v) {
    this.vector = v;
    i = 0;
    j = 0;
  }

  public int next() {
    int val = this.vector[i][j];
    if (++j == this.vector[i].length) {
      j = 0;
      i++;
    }
    return val;
  }

  public boolean hasNext() {
    if (this.vector == null || this.vector.length == 0) {
      return false;
    }
    while (i < this.vector.length && j == this.vector[i].length) {
      j = 0;
      i++;
    }

    return i < this.vector.length;
  }
}

/**
 * Your Vector2D object will be instantiated and called as such: Vector2D obj =
 * new Vector2D(v); int param_1 = obj.next(); boolean param_2 = obj.hasNext();
 */