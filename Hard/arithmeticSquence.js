// let sequence = [100, 0, 1, 0, 1, 0, 1, 0];
// let sequence = [1, 7, 10, 15, 27, 29];
let sequence = [5, 10, 15, 20, 25, 30];

/*
  [1, 7, 10, 15, 27, 29]
   *
*/

function arithmeticSequence(sequence) {
  if (sequence.length < 3) {
    return sequence;
  }
  let brain = {};
  let visited = {};
  let maxLength = 0;

  for (let i = 0; i < sequence.length; i++) {
    for (let j = i + 1; j < sequence.length; j++) {
      let key = sequence[i] - sequence[j];
      if (key === 0) {
        key = `${key}, ${sequence[i] < sequence[j] ? sequence[i] : sequence[j]}`
      }
      if (!brain.hasOwnProperty(key)) {
        brain[key] = 2;
        visited[`${i < j ? i : j},${key}`] = true;
      } else {
        if (!visited.hasOwnProperty(`${i < j ? i : j},${key}`)) {
          brain[key]++;
          visited[`${i < j ? i : j},${key}`] = true;
          if (brain[key] > maxLength) {
            maxLength = brain[key];
          }
        }
      }
    }
  }

  return maxLength;
}

console.log(arithmeticSequence(sequence));