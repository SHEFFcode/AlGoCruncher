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

  delete(word) {
    let cNode = this.root;
    let tempContainer = [];
    for (let char of prefix) {
      if (!cNode.children.hasOwnProperty(char)) {
        return false;
      }
      cNode = cNode.children[char];
      tempContainer.push(cNode, char);
    }

    if (!cNode.isWord) {
      return false;
    }

    cNode.isWord = false;
    
    if (Object.keys(cNode.children).length > 0) {
      return true;
    }

    while (tempContainer.length > 0) {
      cNode = tempContainer.pop();
      let char = tempContainer.pop();
      if (Object.keys(cNode.children).length === 0) {
        delete cNode.children[char];
      }
    }
    return true;
  }

  deleteWordsWithPrefix(prefix) {

  }
}