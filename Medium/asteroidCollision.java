class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length < 2) {
            return asteroids;
        }
        
        for (int i = 0, j = 0; i < asteroids.length && j < asteroids.length; i++, j++) {
            if (asteroids[i] < 0) {
                continue;
            }
            j = i + 1;
        }
    }
}