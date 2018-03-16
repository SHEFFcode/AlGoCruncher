/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    let lookupTable ={},
        matchedAnagrams = [],
        index = 0;

    strs.forEach((word) => {
        let sortedWord = word.split().sort();
        if (!lookupTable.hasOwnProperty(sortedWord)) {
            lookupTable[sortedWord] = index;
            matchedAnagrams[index] = [word];
            index++;
        } else {
            let index = lookupTable[sortedWord];
            matchedAnagrams[index].push(word);
        }
    });
};

/*
G: String[] group of words that could be anagrams of each other
O: String[][] anagrams grouped together
T: Any
S: Any

ex: ["eat", "tea", "tan", "ate", "nat", "bat"]
       *

eat.split().sort() === tea.split().sort() => add to array

Look @ first word, convert it to a sorted sequence of letters and assign it an array index
Look @ second word, convert it to sorted sequence of eltters and put it into array or create a new array and index


[
    []
]


 */