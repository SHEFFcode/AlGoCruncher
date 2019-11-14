/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n == 2 && !knows(0, 1) && !knows(1, 0)) return -1;
        int potentialCeleb = -1;
        
        for (int i = 0; i < n; i++) {
            if (!knows(i, (i + 1) % n)) {
                if (potentialCeleb == -1) {
                    potentialCeleb = i;
                } else {
                    if (!knows(i, potentialCeleb) && !knows(potentialCeleb, i)) {
                        potentialCeleb = -1;
                    } else if (knows(potentialCeleb, i)) {
                        potentialCeleb = i;
                    }q
                }
            }
        }

        if (potentialCeleb == -1) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            if (i != potentialCeleb) {
                if (knows(potentialCeleb, i)) {
                    return -1;
                }
            }
        }

        return potentialCeleb;
    }
}