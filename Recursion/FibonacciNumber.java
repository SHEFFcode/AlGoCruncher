import java.util.Map;

class Solution {
    public int fib(int N) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 0);
        cache.put(1, 1);
        return fibWithCache(N, cache); // not sure what the reasonable size is but i'm sure we can calculate, perhaps N is a reasonable size
    }

    private int fibWithCache(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int fibAtN = fibWithCache(n - 1, cache) + fibWithCache(n - 2, cache);

        cache.put(n, fibAtN);

        return fibAtN;
    }
}

/**
 * 
 */