const inputOne = 'aaabbbaadfa'
const outputOne = 'a6b3d1f1'

function printOutputOne (inputOne) {
  const usAlpha = ['a', 'b', 'c', 'd', 'e', 'f'];
  let brain = {};
  let outputOne = '';  
  inputOne.split('').forEach((letter) => {
    if (!brain.hasOwnProperty(letter)) {
      brain[letter] = 1;
    } else {
      brain[letter]++;    
    }
  });
    
  usAlpha.forEach((letter) => {
    if (brain.hasOwnProperty(letter)) {
      outputOne += letter + brain[letter];
    }             
  })
                   
  return outputOne;
  
}
                  
console.log(printOutputOne(inputOne));