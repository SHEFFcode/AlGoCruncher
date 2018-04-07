function* iterator() {
  let count = 0;
  while(true) {
    yield count++;
  }
}

let iteratorCollection = [];

for (let i = 0; i < 10; i++) {
  iteratorCollection.push(iterator().next);
}

function* iteratorOfIterators(iteratorCollection) {
  for (let i = 0; i < iteratorCollection.lenght; i++) {
    yield iteratorCollection[i];
  }
}

let iterOfIterators = iteratorOfIterators();