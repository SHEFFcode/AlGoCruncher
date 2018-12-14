class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        if (asteroids.length < 2) {
            return asteroids;
        }

        int[] newAsteroids = asteroids;

        for (int i = 0, j = i + 1; i < asteroids.length && j < asteroids.length; i++, j++) {
            if (asteroids[i] <= 0) {
                continue;
            }
            if (asteroids[j] < 0) {
                if (Math.abs(asteroids[i]) != Math.abs(asteroids[j])) {
                    int winner = Math.abs(asteroids[i]) > Math.abs(asteroids[j]) ? asteroids[i] : asteroids[j];
                    newAsteroids = new int[asteroids.length - 1];
                    int newStart = 0;
                    for (int start = 0; start < newAsteroids.length; start++) {
                        if (start == i) {
                            newAsteroids[start] = winner;
                            newStart++;
                        } else {
                            newAsteroids[start] = asteroids[newStart];
                        }
                        newStart++;
                    }

                    return asteroidCollision(newAsteroids);
                } else {
                    newAsteroids = new int[asteroids.length - 2];
                    int newStart = 0;
                    for (int start = 0; start < asteroids.length; start++) {
                        if (start == i || start == j) {
                            continue;
                        }
                        newAsteroids[newStart] = asteroids[start];
                        newStart++;
                    }

                    return asteroidCollision(newAsteroids);
                }
            }
        }
        return newAsteroids;
    }
}

// [-2,1,-2,-1]

/**
 * Better Solution
 */

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length < 2) {
            return asteroids;
        }

        int l = -1, r = 0;
        while (r < asteroids.length) {
            if (l >= 0 && asteroids[l] > 0 && asteroids[r] < 0) {
                if (asteroids[l] > -asteroids[r])
                    r++;
                else if (asteroids[l] < -asteroids[r])
                    l--;
                else {
                    r++;
                    l--;
                }
                continue;
            }

            asteroids[++l] = asteroids[r++];
        }

        return Arrays.copyOf(asteroids, l + 1);
    }
}