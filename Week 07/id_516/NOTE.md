1. # Week07

   

   ## 位运算

   - 位运算符
   - 算数移位与逻辑移位
   - 位运算的应用

   

   > | : 按位或 : 有1则为1
   >
   > & : 按位与 : 有0则为0
   >
   > ~ : 按位取反 ： 取反
   >
   > ^ : 按位异或 ： 相同为0不同为1

   

   ###  XOR-异或

   > 异或：相同为0，不同为1，也可以用『不进位加法』来理解
   >
   > 异或操作的一些特点：
   >
   > x ^ 0 = x
   >
   > x ^ 1s = ~x // 1s = ~0
   >
   > x ^ (~x) = 1s
   >
   > x ^ x = 0
   >
   > c = a ^ b = > a ^ c = b,b ^ c = a //交换两个数
   >
   > a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c // associative

   

   ### 指定位置的位运算

   1. 将x最右边的n位清零： x & (~0 << n)  => x & (1\*(64-n)0\*n)
   2. 获取x的第n位值 （0 或者 1）： (x >> n) & 1
   3. 获取x的第n位的幂值: x & (1 << (n - 1))
   4. 仅将第n位置为1： x | (1 << n)
   5. 仅将第n位置为0： x & (~(1 << n))
   6. 将x最高位至第n位(含) 清零: x & ((1 << n) - 1)
   7. 将第n位至第0位(含)清零： x & (~((1 << (n + 1)) - 1))

   

   ### 实战位运算要点

   - 判断奇偶性
     - x % 2 == 1 -> (x & 1) == 1
     - x % 2 == 0 -> (x & 1) == 0
   - 除以2 乘以 2
     - x /= 2 -> x = x >> 1
     - x *= 2 -> x = x << 1
   - x = x & (x - 1) 清零最低位的1
     - x = 0110 1000 -> x - 1 = 0110 0111
     - 0110 0000
   - x & -x 得到最低位的1
   - x & ~x = 0

   

   ### 题目

   

   ```java
   public int hammingWeigth(int n) {
     int sum = 0;
     while (n != 0) {
       sum ++;
       n &= (n - 1);
     }
     return sum;
   }
   ```

   

   ```java
   public boolean isPowerOfTwo(int n) {
     if (n < 0) return false;
     int sum = 0;
     while(n != 0) {
       if (sum > 1)  return false;
       sum ++;
       n &= (n - 1);
     }
     return sum == 1;
   }
   ```

   

   ```java
   public int reverssseBits(int n) {
     int ans = 0;
     for (int i = 0; i < 32 ;i++) {
       ans = (ans << 1) + (n & 1);
       n >>= 1;
     }
     return ans >>> 0;
   }
   ```

     

   ```python
   def totalNQueens(self, n):
     if n < 1: return []
     self.count = 0
     self.DFS(n, 0, 0, 0, 0)
     return self.count
   
   def DFS(self, n, row, cols, pie, na):
     if row >= n:
       self.count += 1
       return
     bits = (~(cols | pie | na)) & ((1 << n) - 1) # 得到当前所有的空位
     while bits:
       p = bits & -bits
       bits = bits & (bits - 1)
       self.DFS(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)
       
   ```

   

   ```java
   class Solution {
     private int size;
     private int count;
     
     private void solve(int row,int ld,int rd) {
       if (row == size) {
         count ++;
         return;
       }
       int pos = size & (~(row | ld | rd));
       while (pos != 0) {
         int p = pos & (-pos);
         pos -= p;
         solve(row | p, (ld | p) << 1, (rd | p) >> 1);
       }
     }
     
     public int totalNQueens(int n) {
     	count = 0;
       size = (1 << n) - 1;
       solve(0,0,0);
       return count;
     }
   }
   ```

   

   338 

   ```c++
   vector<int> countBits(int num) {
     vector<int> bits(num+1, 0);
     for (int i = 1; i <= num; i++) {
       bits[i] += bits[i & (i - 1)] + 1;
     }
     return bits;
   }
   ```

   

   

   

   ## Bloom Filter

   > 一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检测一个元素是否在一个集合中。
   >
   > 优点是 空间效率和查询时间都远远超过一般的算法。
   >
   > 缺点是有一定的误识别率和删除困难

   

   ```python
   from bitarray import bitarray
   import mmh3
   
   class BloomFilter:
     def __init__(self, size, hash_num):
       self.size = size
       self.hash_num = hash_num
       self.bit_array = bitarray(size)
       self.bit_array.setall(0)
       
     def add(self, s):
       for seed in range(self.hash_num):
         result = mmh3.hash(s, seed) % self.size
         self.bit_array[result] = 1
     def lookup(self, s):
       for seed in range(self.hash_num):
         if self.bit_array[result] == 0:
           return "Nope"
       return "Probably"
   
   bf = BloomFilter(500000,7)
   bf.add("dantezhao")
   print(bf.lookup("dantezhao"))
   print(bf.lookup("yyj"))
   ```

   

   

   ```java
   public class BloomFilter implements Cloneable {
     private BitSet hashes;
     private RandomInRange prng;
     private int k;
     private static final double LN2 = 0.6931471805599453;
     
     public BloomFilter(int n,int m) {
       k = (int) Math.rount(LN2 * m / n);
       if (k <= 0) k = 1;
       this.hashes = new BitSet(m);
       this.prng = new RandomInRange(m,k);
     }
     
     public BloomFilter(int n) {
       this(n,1024 * 1024 * 8);
     }
     
     
    	public void add(Object o) {
       prng.init(o);
       for (RandomInRange r: prng) hashes.set(r.value);
     }
     
     public boolean contains(Object o) {
       prng.init(o);
       for (RandomInRange r: prng)
         if (!hashes.get(r.value))
           return false;
       return true;
     }
     
     
     public void clear() {
       hashes.clear();
     }
     
     public BloomFilter clone() throws CloneNotSupportedException {
       return (BloomFilter) super.clone();
     }
     
     
     public int hashCode() {
       return hashes.hashCode() ^ k;
     }
     
     public boolean equals(BloomFilter other) {
       return this.hashes.equals(other.hashes) && this.k == other.k;
     }
     
     
     public void merge(BloomFilter other) {
       if (other.k != this.k || other.hashes.size() != this.hashes.size()) {
         throw new IllegalArgumentException("Incompatible bloom filters");
       }
       this.hashes.or(other.hashes);
     }
     
     
     private class RandomInRange implements Iterable<RandomInRange>,Iterator<RandomInRange> {
       private Random prng;
       private int max;
       private int count;
       private int i = 0;
       private int value;
       
       RandomInRange(int maximum, int k) {
         max = maximum;
         count = k;
         prng = new Random();
       }
       
       public void init(Object o) {
         prng.setSeed(o.hashCode());
       }
       
       
       public Iterator<RandomInRange> iterator() {
         i = 0;
         return this;
       }
       
       
       public RandomInRange next() {
         i ++;
         value = prng.nextInt() % max;
         if (value < 0) value = -value;
         return this;
       }
       
       public boolean hasNext() {
         return i < count;
       }
       
       public void remove() {
         throw new UnsupportedOperationException();
       }
     }
   }
   ```

   

   

   ## LRU Cache

   > lease recent used Cache 
   >
   > 两个要素： 大小、替换策略
   >
   > Hash Table + Doulbe LinkedList
   >
   > O(1) 查询
   >
   > O(1) 修改、更新

   

   ### 替换策略

   > https://en.wikipedia.org/wiki/Cache_replacement_policies

   

   ```python
   class LRUCache(object):
     def __init__(self, capacity):
       self.dic = collections.OrderedDict()
       self.remain = capacity
       
     def get(self, key):
       if key not in self.dic:
         return -1
       v = self.dic.pop(key)
       self.dic[key] = v
       return v
     
     def put(self, key, value):
       if key in self.dic:
         self.dic.pop(key)
       else:
         if self.remain > 0:
           self.remain -= 1
         else:
           self.dic.popitem(last=False)
       self.dic[key] = value
   
   ```

   

   

   ## 排序

   1. 比较类排序

      通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn),因此也称为非线性时间比较类排序。

   2. 非比较类排序

      不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。

   

   ### 初级排序

   1. 选择排序

      ```java
      public int[] selectSort(int[] arr]) {
        int len = arr.length;
        int minIndex,temp;
        
        for (int i = 0; i < len - 1;i++) {
          minIndex = i;
          for (int j = i + 1; j < len;j++ ) {
            if (arr[j] < arr[minIndex]) {
              minIndex = k;
            }
          }
          temp = arr[i];
          arr[i] = arr[minIndex];
          arr[minIndex] = temp;
        }
        return arr;
      }
      
      ```

      

   2. 插入排序

      ```java
      public int[] insertionSort(int[] arr) {
        int len = arr.length;
        int preIndex,current;
        for (int i = 1;i < len;i++) {
          preIndex = i - 1;
          current = arr[i];
          while ( preIndex >= 0 && arr[preIndex] > current) {
            arr[preIndex + 1] = arr[preIndex];
            preIndex --;
          }
          arr[preIndex + 1] = current;
        }
        return arr;
      }
      
      ```

      

   3. 冒泡排序

   

   

   ### 高级排序

   1. 快速排序

      > 数组取标杆pivot，将小元素放在pivot左边，大元素放右边，然后依次对右边和右边的子数组继续快排；以达到整个序列有序。

      ```java
      public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return ;
       	int pivot = partition(array, begin, end);
        quickSort(array, begin, privot - 1);
        quickSort(array, pivot + 1, end);
      }
      
      public int partition(int[] a, int begin, int end){
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
          if (a[i] < a[pivot]) {
            int temp = a[counter]; 
            a[counter] = a[i];
            a[i] = temp;
            count++;
          }
        }
        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
        return counter;
      }
      
      ```

      

   2. 归并排序

      > 分治
      >
      > 1. 把长度为n的输入序列分成两个长度为n/2的子序列；
      > 2. 对这两个子序列分别采用归并排序；
      > 3. 将两个排序好的子序列合并成一个最终的排序序列。

      ```java
      public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
      }
      
      public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
          temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
       	while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (int p = 0; p < temp.length; p++) {
          arr[left + p] = temp[p];
        }
      }
      
      ```

      

   3. 堆排序

      > 堆排序(Heap sort) -堆插入 O(logN),取最大、小值 O(1)
      >
      > 1. 数组元素依次建立小顶堆
      > 2. 依次取顶堆元素，并删除

      ```c++
      public static void heapSort(int[] array) {
        if (array.length == 0) return ;
        int length = array.length;
        for (int i = length / 2 - 1; i>= 0; i--)
          heapify(array, length, i);
        
        for (int i = length - 1; i >= 0; i--) {
          int temp = array[0]; array[0] = array[i]; array[i] temp;
          heapify(array, i, 0);
        }
      }
      
      static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largetest = i;
        if (left < length && array[left] > array[largest]) {
          largest = leftChild;
        }
        if (right < length && array[right] > array[largest]) {
          largest = right;
        }
        if (largest != i) {
          int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
          heapify(array, length, largest);
        }
      }
      
      ```

   

   ### 特殊排序

   

   1. 计数排序
   2. 桶排序
   3. 基排序

   

   

   

   ## 题目

   1. [242 ]() 

      > 给定两个字符串s和t，编写一个函数来判断t是否是s的字母异位词。

      

   2. [56 合并区间]()

      > 合并区间

   3. [493 翻转对]()

      ```java
      public class Solution {
        public int reversePairs(int[] nums) {
          return mergeSort(nums, 0, nums.length - 1);
        }
        
        private int mergeSort(int[] nums,int s,int e) {
          if (s >= e) return 0;
          int mid = s + (e - s) / 2;
          int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e);
          for (int i = s, j = mid + 1; i <= mid; i++) {
            while (j <= e && nums[i] / 2.0 > nums[j]) j++;
            cnt += j - (mid + 1);
          }
          Arrays.sort(nums, s, e + 1);
          return cnt;
        }
      }
      
      ```

      ```java
      public class Solution {
        public int reversePairs(int[] nums) {
          if (nums == null || nums.length == 0) return 0;
          return mergeeSort(nums, 0, nums.length - 1);
        }
        
        private int mergeSort(int[] nums,int l ,int r) {
          if (l >= r) return 0;
          int mid = l + (r - 1) / 2;
          int count = mergeSort(nums, l, mid) + mergeeSort(nums, mid + 1,r);
          int[] cache = new int[r - l + 1];
          for (int j = mid + 1, j <= r ; j ++,c++) {
            while (i <= mid && nums[i] <= 2 * (long) nums[j]) i++;
            while (t <= mid && nums[t] < nums[j]) cache[c++] = nums[t++];
            cache[c] = nums[j];
            count += mid - i + 1;
          }
          while (t <= mid) cache[c++] = nums[t++];
          System.arraycopy(cache, 0, nums, l, r - l + 1);
          return count;
        }
      }
      
      ```

      

      ## 总结

      这周感觉不是很难，花的时间也不是特别多，自身的事情也有点多，希望复习上周的课程也没有能实现。时间还是需要在平时多多挤出来，才能有成效哦。