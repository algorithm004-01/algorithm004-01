public class LeetCode_146_LruCache {
    public static void main(String[] args) {
        // Solution solution = new LeetCode_146_LruCache().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        private float loadFactor = 1.0f;
        private LinkedHashMap<Integer, Integer> cache;
        private int cacheSize;

        public LRUCache(int capacity) {

            this.cacheSize = capacity;
            this.cache = new LinkedHashMap<Integer, Integer>(capacity, loadFactor, true) {

                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > LRUCache.this.cacheSize;
                }
            };
        }

        public int get(int key) {

            return cache.getOrDefault(key, -1);
        }

        public void put(int key, int value) {

            cache.put(key, value);
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}