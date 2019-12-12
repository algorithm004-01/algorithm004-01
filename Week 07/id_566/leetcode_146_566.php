<?php
/**
 * 146. LRU缓存机制
 * https://leetcode-cn.com/problems/lru-cache/#/
 * Author:show
 */
// 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
// 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
class LRUCache {
    
    private $capacity;
    private $map = [];
    private $list = [];
    
    function __construct($capacity) {
        $this->capacity = $capacity;
    }
  
    function get($key) {
        if(array_key_exists($key,$this->map)){
            unset($this->list[array_search($key,$this->list)]);
            array_push($this->list,$key);
            return $this->map[$key];
        }else{
            return -1;
        }
    }

    function put($key, $value) {
        if(array_key_exists($key,$this->map)){
            unset($this->list[array_search($key,$this->list)]);
        }else{
            if(count($this->list) == $this->capacity){
                $dkey = array_shift($this->list);
                unset($this->map[$dkey]);
            }
        }
        $this->map[$key] = $value;
        array_push($this->list,$key);
    }
}
?>