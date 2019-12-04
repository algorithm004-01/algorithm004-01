//
//  LeetCode_221_396.swift
//  
//
//  Created by chenjunzhi on 2019/11/17.
//

import UIKit
class LinkListNode: NSObject {
    var value: Int
    let key: Int
    var next: LinkListNode?
    var pre: LinkListNode?
    init(_ key: Int,_ val: Int) {
        self.value = val
        self.key = key
    }
}

class DoubleLinkList {
    var header: LinkListNode = LinkListNode(-0, -0)
    var tail: LinkListNode = LinkListNode(-10, -10)
    init() {
        header.next = tail
        tail.pre = header
    }
    
    func addToHeader(_ node: LinkListNode) {
        if header.next! == tail { //第一个插进来的节点
            tail.pre = node
        }
        node.next = header.next
        header.next?.pre = node
        
        node.pre = header
        header.next = node
    }
    
    func moveToFirst(_ node: LinkListNode) {
        if node.pre! == header {
            return
        }

        self.remove(node)
        self.addToHeader(node)
    }
    
    func remove(_ node: LinkListNode) {
        if node.next! == tail {
            node.pre?.next = tail
            tail.pre = node.pre
        } else {
            node.pre?.next = node.next
            node.next?.pre = node.pre
        }
    }
    
    func removeLast() -> LinkListNode? {
        if tail.pre! == header {
            return nil
        }
        let lastNode = tail.pre!
        lastNode.pre?.next = tail
        tail.pre = lastNode.pre
        return lastNode
    }
    
    func printLinkList() {
        var temp: LinkListNode? = header
        var result = [String]()
        while let current = temp {
            result.append("-> \(current.value)")
            temp = current.next
        }
        print("result: \(result)")
    }
}

class LRUCache {

    var cache = [Int: LinkListNode]()
    let lenght: Int
    let linkList = DoubleLinkList()

    init(_ capacity: Int) {
        lenght = capacity
    }
    
    func get(_ key: Int) -> Int {
        if let tempNode = cache[key] {
            linkList.moveToFirst(tempNode)
            // print("get \(key) \(tempNode.value)")
            // linkList.printLinkList()
            // print("cache: \(cache)")
            return tempNode.value
        }
        return -1
    }
    
    func put(_ key: Int, _ value: Int) {
        // print("put \(key)")
        //已存在缓存，移动node到第一位
        if let tempNode = cache[key] {
            if tempNode.pre != nil { //非表头，移动第一位。改变链表
                linkList.moveToFirst(tempNode)
                tempNode.value = value
            }
        } else { //不在缓存，添加到链表头，判断是否超出缓存，删除尾结点
            let node = LinkListNode(key,value)
            linkList.addToHeader(node)
            cache[key] = node
            // print("count=\(cache.keys.count), lenght:\(lenght)")
            if cache.keys.count > lenght {
                if let last = linkList.removeLast() {
                    cache[last.key] = nil
                }
            }
        }
        // linkList.printLinkList()
        // print("cache: \(cache)")
    }
}
