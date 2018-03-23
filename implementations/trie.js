class TrieNode {
  constructor() {
    this.children = {};
    this.isWord = false;
  }
}

class Trie {
  constructor() {
    this.root = new TrieNode();
  }

  insert(word) {
    let cNode = this.root;
    for (let char of word) {
      if (!cNode.children.hasOwnProperty(char)) {
        cNode.children[char] = new TrieNode();
      }
      cNode = cNode.children[char];
    }
    cNode.isWord = true;
  }

  search(word) {
    let cNode = this.root;
    for (let char of word) {
      if (!cNode.children.hasOwnProperty(char)) {
        return false;
      }
      cNode = cNode.children[char];
    }
    return cNode.isWord;
  }

  startsWith(prefix) {
    let cNode = this.root;
    for (let char of prefix) {
      if (!cNode.children.hasOwnProperty(char)) {
        return false;
      }
      cNode = cNode.children[char];
    }
    return true;
  }
}