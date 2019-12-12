public class TrieNode {
    public var children: [String: TrieNode]
    public var isWord: Bool
    public var word: String?
    
    public init() {
        self.children = [String: TrieNode]()
        self.isWord = false
        self.word = nil
    }
}

public class Trie {
    private var root: TrieNode
    
    public init() {
       self.root = TrieNode()
    }
    
    public func insert(_ word: String) {
        var current = self.root
        for letter in word {
            current = current.children[String(letter)]!
        }
        current.isWord = true
    }
    
    public func search(_ word: String) -> Bool {
        var current = self.root
        for letter in word {
            if let currentNode = current.children[String(letter)] {
                current = currentNode
            } else {
                return false
            }
        }
        return current.isWord
    }
    
    public func startsWith(_ prefix: String) -> Bool {
        var current = self.root
        for letter in prefix {
            if let currentNode = current.children[String(letter)] {
                current = currentNode
            } else {
                return false
            }
        }
        return true
    }
}
