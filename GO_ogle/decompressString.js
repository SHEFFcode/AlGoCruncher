function decompressString(string) {
  let brain = buildBrain(string, {});
  let expandedString = _expandString(string, brain);
  let x = 0;
}

function _expandString(string, brain) {
  for (let i = 0; i < string.length; i++) {
    if (string[i] === '{') {
      let repeatCount = Number.parseInt(string.substring(i + 1, string.indexOf('}', i + 1)));
      let stringToRepeat = string.substring(brain[i - 1] + 1, i - 1);
       repeatedString = stringToRepeat.repeat(repeatCount);
       string = string.substring(0, brain[i - 1] + 1) + repeatedString + string.substring(i - 2 + repeatedString.length);
    }
  }
  return string;
}

function buildBrain(string, brain) {
  let stack = [];
  for (let i = 0; i < string.length; i++) {
    if (string[i] === '(') {
      stack.push(i);
    } else if (string[i] === ')') {
      let start = stack.pop();
      let end = i;
      brain[end] = start;
    }
  }
  return brain;
}

decompressString('a(b(c){2}){2}d');