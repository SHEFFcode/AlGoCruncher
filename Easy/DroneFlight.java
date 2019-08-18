import java.io.*;
import java.util.*;

class Solution {

  static int calcDroneMinEnergy(int[][] route) {
    int minEnergyRequired = 0;
    int energyLeftOver = 0;

    for (int i = 0, j = 1; j < route.length; i++, j++) {
      energyLeftOver += route[i][2] - route[j][2];
      if (energyLeftOver < 0) {
        minEnergyRequired = Math.min(minEnergyRequired, energyLeftOver);
      }
    }

    return Math.abs(minEnergyRequired);
  }

  public static void main(String[] args) {

  }

}