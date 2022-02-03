//
//  LeetCode_221_396.swift
//  
//
//  Created by chenjunzhi on 2019/11/17.
//

import UIKit

class TrieNode {

    private var childs: [Character: TrieNode] = [:]
    private var isEndBool = false


    func contain(_ char: Character) -> Bool {
        return childs.keys.contains(char)
    }

    func get(_ char: Character) -> TrieNode? {
        return childs[char]
    }

    func add(_ char: Character) {
        childs[char] = TrieNode()
    }

    func isEnd() -> Bool {
        return isEndBool
    }

    func setEnd() {
        isEndBool = true
    }

}

class Trie {

    let root = TrieNode()

    init() {

    }

    /** Inserts a word into the trie. */
    func insert(_ word: String) {
        var currentNode = root
        for char in word {
            if !currentNode.contain(char) {
                currentNode.add(char)
            }
            currentNode = currentNode.get(char)!
        }
        currentNode.setEnd()
    }

    func search(_ word: String) -> Bool {
        var currentNode = root;
        for char in word {
            if currentNode.contain(char) {
                currentNode = currentNode.get(char)!
            } else {
                return false
            }
        }
        return currentNode.isEnd()
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    func startsWith(_ prefix: String) -> Bool {
        var currentNode = root;
        for char in prefix {
            if currentNode.contain(char) {
                currentNode = currentNode.get(char)!
            } else {
                return false
            }
        }
        return true
    }
}
