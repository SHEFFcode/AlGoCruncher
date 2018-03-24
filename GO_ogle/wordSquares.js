class TrieNode {
  constructor() {
    this.children = {};
    this.isWord = false;
  }
}

class WordSquares {
  constructor() {
    this.root = new TrieNode();
  }

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
    let root = this.root;

    for (let word of words) {
      let current = root;
        
      for (let char of word) {
        if (!current.children.hasOwnProperty(char)) {
          current.children[char] = new TrieNode();
        }
        current = current.children[char];
      }
      current.isWord = true;
    }
    return root;
  }

  search(root, prefix) {
    let current = root;
    for (let char of prefix) {
      if (!current.children.hasOwnProperty(char)) {
        return null;
      }
      current = current.children[char];
    }
    return current;
  }

  wordSquaresLong(root, len, square, squares) {
    if (square.length === len) {
      squares.push(square.slice());
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

    for (let child of Object.keys(node.children)) {
      this.getChildren(node.children[child], str + child, children);
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

wordSquares(['ball', 'lady', 'lead', 'area']);