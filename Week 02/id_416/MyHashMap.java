package com.leetcode.week02.util;

/**
 * @param <K>
 * @param <V>
 * @author qing
 * HashMap的数据形式key-value，HashMap底层将key-value封装成了Entry对象。Entry对象存放在一个数组中。
 */
public class MyHashMap<K, V> implements MyMap<K, V> {
    //定义一个默认长度为16 = 2^4次幂数组
    private static  int defaultInitialCapacity = 1 << 4; //16

    //定义一个数组，来存放Entry对象，Entry对象存放key-value的数据，它本身是一个链表
    private Entry<K, V>[] table = null;

    //HashMap数据的个数
    private int size;

    //加载因子0.75
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public MyHashMap() {

    }

    public MyHashMap(int initSize) {
        this.defaultInitialCapacity = initSize;
    }

    @Override
    public V put(K key, V value) {
        if (null == table) {
            table = new Entry[this.defaultInitialCapacity];//初始化数组
        }
        //扩容
        reSize();

        //通过hashcode 取 & 获取数组下标
        int j = getIndex(key);
        //下标对应数据，也就是链表的第一个数据
        MyMap.Entry<K, V> currentEntry = table[j];
        //判断是否覆盖数据？循环遍历判断链表中是否包含当前key
        while (null != currentEntry) {
            if (currentEntry.getKey().equals(key)) {
                currentEntry.setValue(value);
                return value;
            }
            currentEntry = currentEntry.getNext();
        }
        //判断结果不包含当前key,直接添加一个对象，将新对象的next指向旧值，如果table[j] == null 也就是当前栈的第一个元素
        table[j] = new Entry<K, V>(key, value, table[j]);
        size++;
        return value;
    }

    /**
     * HashMap数组扩容，增加长度为原来的2倍，并且重新散列，因为散列之后的hash值是根据数组的长度而得出的结果
     * 现在数组的长度变了，所以散列的hash值也会改变
     * 如果不改变的话，由于数组长度变化，相同key，getIndex()方法获取
     * 的值就会不一样了，那么之前的数据将会找不到了。
     */
    private void reSize() {
        if (size >= DEFAULT_LOAD_FACTOR * table.length) {
            System.out.println("----开始扩容-----");
            Entry<K, V>[] newTable = new Entry[table.length << 1];//扩容是之前长度的2倍
            for (MyMap.Entry<K, V> entry : table) {//循环之前的数组，将链表中所有的key准备重新散列，并将重新散列的值当做新的下标放入新的数组中
                while (null != entry) {
                    int i = getIndex(entry.getKey());//获取新的下标
                    MyMap.Entry<K, V> oldValue = entry.getNext();//之前i下标的下一个元素
                    entry.setNext(newTable[i]);//设置下一个Entry的指针为上一个元素
                    newTable[i] = (Entry<K, V>) entry;
                    entry = oldValue;//循环当前链表的下一个元素
                }
            }
            table = newTable;
        }
    }

    /**
     * 通过key的hashCode值和数组的长度进行 & 运算
     *
     * @param key
     * @return
     */
    private int getIndex(K key) {
        if (null == key) {//HashMap的key和value是可以存放null值的，如果是null的话，肯定是存放在第一个位置
            return 0;//返回第一个数组下标
        }
        /**
         * 当前数组的长度必须是2^n - 1，因为2^n -1 对应的二进制后面全部是11111111，所以最大的情况也就是2^n -1的值
         * 所以按照 & 运算 获取的数据是小于等于table.length - 1的数值
         */
        return key.hashCode() & table.length - 1;
    }

    @Override
    public V get(K key) {
        if (null != table) {
            int i = getIndex(key);//获取hash值
            MyMap.Entry<K, V> entry = table[i];
            while (null != entry) {
                //当前数组下标的数据是一个链表，所以需要循环遍历链表，直到链表中的Entry的key和当前传入进来的key的值相同，则表明当前的Entry就是要找到的Entry
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                } else {
                    entry = entry.getNext();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    static class Entry<K, V> implements MyMap.Entry<K, V> {
        K key;
        V value;
        MyMap.Entry<K, V> next;

        public Entry(K key, V value, MyMap.Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public MyMap.Entry<K, V> getNext() {
            return this.next;
        }

        @Override
        public MyMap.Entry<K, V> setNext(MyMap.Entry<K, V> next) {
            MyMap.Entry<K, V> oldEntry = this.next;
            this.next = next;
            return oldEntry;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, String> myHashMap = new MyHashMap();
        myHashMap.put("zhangqing", "张庆");
        myHashMap.put("zhangqing1", "张庆1");
        myHashMap.put("zhangqing2", "张庆2");
        myHashMap.put("zhangqing3", "张庆3");
        myHashMap.put("zhangqing4", "张庆4");
        myHashMap.put("zhangqing41", "张庆4");
        myHashMap.put("zhangqing11", "张庆4");
        myHashMap.put("12", "张庆4");
        myHashMap.put("23", "张庆4");
        myHashMap.put("43", "张庆4");
        myHashMap.put("123", "张庆4");
        myHashMap.put("321", "张庆4");
        myHashMap.put("111", "张庆4");
        myHashMap.put("44", "张庆4");
        myHashMap.put("444", "张庆4");
        myHashMap.put("123321123", "张庆4");
        myHashMap.put("1", "三生三世");
        myHashMap.put("2", "三生三世");
        myHashMap.put("3", "三生三世");
        myHashMap.put("4", "三生三世");
        myHashMap.put("5", "三生三世");
        myHashMap.put("6", "三生三世");
        myHashMap.put("7", "三生三世");
        myHashMap.put("8", "三生三世");
        myHashMap.put("9", "三生三世");

        String a = myHashMap.get("321");
        myHashMap.put("123321123", "三生三世123");
    }
}
