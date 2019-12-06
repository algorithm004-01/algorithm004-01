//
//  Trie.swift
//  algorithm
//
//  Created by pingan on 2019/11/21.
//  Copyright © 2019 pingan. All rights reserved.
//

import Foundation
//208. 实现 Trie (前缀树)
class TrieNode {
    private let R = 26;
    private var links: [TrieNode?];
    private var endValue: Bool;
    
    init() {
        links = Array(repeating: nil, count: R);
        endValue = false;
    }
    
    public func getIndex(_ ch: Character) -> Int {
        return Int(ch.asciiValue! - Character("a").asciiValue!);
    }
    
    public func containsKey(_ ch: Character) -> Bool {
        return links[self.getIndex(ch)] != nil;
    }
    
    public func get(_ ch: Character) -> TrieNode {
        return links[self.getIndex(ch)]!;
    }
    
    public func put(_ ch: Character, _ node: TrieNode) {
        links[self.getIndex(ch)] = node;
    }
    
    public func setEnd() {
        self.endValue = true;
    }
    
    public func isEnd() -> Bool {
        return endValue;
    }
}

class Trie {
    private var root: TrieNode;
    
    init() {
        root = TrieNode();
    }
    
    public func insert(_ word: String) {
        var node = root;
        for ch in word {
            if !node.containsKey(ch) {
                node.put(ch, TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    public func search(_ word: String) -> Bool{
        let node = searchPrefix(word);
        return node != nil && node!.isEnd();
    }
    
    public func searchPrefix(_ word: String) -> TrieNode? {
        var node = root;
        for ch in word {
            if node.containsKey(ch) {
                node = node.get(ch);
            }else{
                return nil;
            }
        }
        return node;
    }
    
    public func startsWith(_ prefix: String) -> Bool {
        let node = searchPrefix(prefix);
        return node != nil;
    }
}
