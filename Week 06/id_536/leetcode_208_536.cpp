#include <iostream>
#include <string.h>

using namespace std;
/*****
 1����ʾINSERT "cp"
 ROOT(this)
 isEnd = false
 abcdefghijklmnopqrstuvwxyz
   | next[c-'a']
 ---------------------------
 isEnd = false
 abcdefghijklmnopqrstuvwxyz
                | next[p-'a']
 ---------------------------
 isEnd = true
 p = new Trie(); ���һ�ڵ�
 abcdefghijklmnopqrstuvwxyz

 2����ʾINSERT "apple"
 ROOT(this)
 isEnd = false
 abcdefghijklmnopqrstuvwxyz
 | next[a-'a']
 ---------------------------
 isEnd = false
 abcdefghijklmnopqrstuvwxyz
                | next[p-'a']
 --------------------------
 isEnd = false
 abcdefghijklmnopqrstuvwxyz
                | next[p-'a']
 --------------------------
 isEnd = false
 abcdefghijklmnopqrstuvwxyz
            | next[l-'a']
 --------------------------
 isEnd = false
 abcdefghijklmnopqrstuvwxyz
     | next[e-'a']
 --------------------------
 isEnd = true
 p = new Trie();
 abcdefghijklmnopqrstuvwxyz
******/

class Trie {
    Trie *next[26];
    bool isEnd;
public:
    /** Initialize your data structure here. */
    Trie() {
        isEnd = false;//ָ���ڵ��Ƕ�Ӧ���Ľ�β����ֻ�Ǽ�ǰ׺
        memset(next,0,sizeof(next));
    }

    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie *p = this;//p��ʼ��Ϊ�����ָ��root
        for(char c : word) {
            if(!p->next[c-'a']) {
                p->next[c-'a'] = new Trie();
            }
            p = p->next[c-'a'];
        }
        p->isEnd = true;         //ָ���ڵ��Ƕ�Ӧ���Ľ�β
    }

    /** Returns if the word is in the trie. */
    bool search(string word) {
       Trie *p = this;
       for(char c : word) {
           if(!p->next[c-'a']){
              return false;
           }
           p = p->next[c-'a'];
       }
       return p->isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie *p = this;
       for(char c : prefix) {
           if(!p->next[c-'a']){
              return false;
           }
           p = p->next[c-'a'];
       }
       return true;
    }
};


int main()
{
    Trie* obj = new Trie();
    obj->insert("apple");
    cout << obj->search("apple") <<endl;   // returns true
    cout << obj->search("app") <<endl;     // returns false
    cout << obj->startsWith("app") <<endl; // returns true
    obj->insert("app");
    cout << obj->search("app") <<endl;     // returns true
    return 0;
}
