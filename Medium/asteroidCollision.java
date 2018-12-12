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
                    for (int start = 0; start < newAsteroids.length; start++) {
                        if (start == i) {
                            System.out.println("I made it here");
                            System.out.println(winner);
                            System.out.println("Start is ");
                            System.out.println(i);
                            newAsteroids[start] = winner;
                        } else {
                            newAsteroids[start] = asteroids[start];
                        }
                    }
                    System.out.println(Arrays.toString(newAsteroids));

                    return asteroidCollision(newAsteroids);

                } else {
                    newAsteroids = new int[asteroids.length - 2];
                    for (int start = 0; start < newAsteroids.length; start++) {
                        if (start == i || start == j) {
                            continue;
                        }
                        newAsteroids[start] = asteroids[start];
                    }
                    System.out.println(Arrays.toString(newAsteroids));

                    return asteroidCollision(newAsteroids);

                }
            }
        }
        System.out.println(Arrays.toString(newAsteroids));
        return newAsteroids;
    }
}
