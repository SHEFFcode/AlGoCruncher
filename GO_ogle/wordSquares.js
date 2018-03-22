class TrieNode {
  constructor() {
    this.isWord = false;
    this.children = new Array(26);
  }
}

class WordSquares {
  wordSquares(words) {
    let root = this.buildTrie(words);
    let squares = [];

    for (let word of words) {
      let square = [];
      square.push(word);
      this.wordSquaresLong(root, word.length, square, squares);
    }
    return squares;
  }

  buildTrie(words) {
    let root = new TrieNode();

    for (let word of words) {
      let current = root;
        
      for (let char of word.split('')) {
        let index = char.charCodeAt(0) - 'a'.charCodeAt(0);
        if (!current.children[index]) {
          current.children[index] = new TrieNode();
        }
        current = current.children[index];
      }
      current.isWord = true;
    }
    return root;
  }

  search(root, prefix) {
    let current = root;
    for (let char in prefix.split('')) {
      let index = char.charCodeAt(0) - 'a'.charCodeAt(0);
      if (!current.children[index]) {
        return null;
      }
      current = current.children[index];
    }
    return current;
  }

  wordSquaresLong(root, len, square, squares) {
    if (square.length === len) {
      squares.push([square]);
      return;
    }
    let prefix = this.getPrefix(square, square.length);
    let node = this.search(root, prefix);
    if (!node) {
      return;
    }

    let children = [];
    this.getChildren(node, prefix, children);

    for (let child of children) {
      square.push(child);
      this.wordSquaresLong(root, len, square, squares);
      square.splice(square.length - 1, 1);
    }
  }

  getPrefix(square, index) {
    let prefix = '';
    for (let i = 0; i < index; i++) {
      prefix += square[i][index];
    }
    return prefix;
  }

  getChildren(node, str, children) {
    if (node.isWord) {
      children.push(str);
      return;
    }

    for (let i = 0; i < 26; i++) {
      if(node.children[i]) {
        this.getChildren(node.children[i], String.fromCharCode('a'.charCodeAt(0) + i), children);
      }
    }
  }
}


/**
 * @param {string[]} words
 * @return {string[][]}
 */
var wordSquares = function(words) {
    let wordSquaresClass = new WordSquares();
    return wordSquaresClass.wordSquares(words);
};

