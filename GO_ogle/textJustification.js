function justifyText(wordsWithSpaces, maxLineLength) {
  let justifiedLines = [],
    currentLine = [],
    lineLength = 0,
    words = wordsWithSpaces.split(' ');

  for (let word of words) {
    if (lineLength + word.length + currentLine.length > maxLineLength) {
      for (let i = 0; i < maxLineLength - lineLength; i++) {
        currentLine[i % (currentLine.length - 1 || 1)] += ' ';
      }
      justifiedLines.push(currentLine.join(''));
      currentLine = [];
      lineLength = 0;
    }
    currentLine.push(word); // this will be used to keep track of spaces
    lineLength += word.length;
  }

  justifiedLines.push(...currentLine)

  return justifiedLines;
}

justifyText('jeremy likes to code', 15).forEach(line => console.log(line));