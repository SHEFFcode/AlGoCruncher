const portmanteaus = ['Brangelina', 'bromance'];
const words = ['Brad', 'Angelina', 'brother', 'romance'];

function findComponents(words, portmanteaus) {
  let portmanteausHash = {};
  const FORWARD = 'forward';
  const BACKWARD = 'backward';

  portmanteaus.forEach((portmanteau) => {
    _buildHash(portmanteau);
  });

  function _buildHash(portmanteau) {
    let candidateForward = ['', -1];
    let candidateBackward = ['', -1];
    let matchLength = 0;

    _populateCandidate(FORWARD, candidateForward, portmanteau);
    _populateCandidate(BACKWARD, candidateBackward, portmanteau);

    portmanteausHash[portmanteau] = [candidateForward[0], candidateBackward[0]];
  }

  function _populateCandidate(direction, candidate, portmanteau) {
    let wordsCopy = words.slice();

    let i = 0;
    for (let j = 0; j < wordsCopy.length; j++) {
      wordsCopy = _filterWrapper(wordsCopy, direction, i, portmanteau);
      if (wordsCopy.length > 0) {
        candidate[0] = wordsCopy[0];
        candidate[1] = i + 1;
      } else {
        break;
      }
      i++;
    }
  }

  function _filterWrapper(wordsCopy, direction, i, portmanteau) {
    if (direction === FORWARD) {
      return wordsCopy.filter((item) => item[i] === portmanteau[i]);
    } else {
      return wordsCopy.filter((item) => item[item.length - 1 - i] === portmanteau[portmanteau.length - 1 - i]);
    }
  }

  return portmanteausHash;
}

findComponents(words, portmanteaus);