# NOTE
20191021-1027 week2
1.本周主要学习了hashmap tree等数据结构的基础概念。
2.学习了递归的思想与编写模板，同时学习了分治回溯的问题解决思想。
3.其中树作为二维数据结构，遍历方式主要使用递归的方式，递归编写是需要注意不能使用人脑递归的方式，同时要注意寻找重复子问题与数学归纳法的证明。
4.递归的编写模板范式如下
    public void recur(int level, int param) { 

    // terminator 
    if (level > MAX_LEVEL) { 
        // process result 
        return; 
    } 

    // process current logic 
    process(level, param); 

    // drill down 
    recur( level: level + 1, newParam); 

    // restore current status 
    
    }


HashMap源码分析
主要阅读了hashmap中put get 方法的实现方式
  

