
// ['cat', 'act', 'fan', 'bart', 'brat', 'single']
// ['cat', 'antoher', 'act', 'cat', 'duplicate', 'brat', 'bart', 'cat', 'tarb']
// .  *      ^ .    ^ .    ^ .      ^ .    ^
let input = ['cat', 'act', 'fan', 'bart', 'brat', 'single'];

function findAnagrams(input) {
    let anogramList = {};

    for (let i = 0; i < input.length; i++) {
        const item = input[i].split('').sort().join('');

        if (item in anogramList) {
            anogramList[item].push(input[i]);
        } else {
            anogramList[item] = [input[i]];
        }
    }

    return anogramList;
}

function printAnogram() {
    let anogramsList = findAnagrams(input)
    for (key in anogramsList) {
        console.log(`key: ${key}, values: ${anogramsList[key]}`);
    }
}

printAnogram();


/*
Anagram is basically same letters, so if we sort the input we can compare it with the rest of the inputs.
That would make it pretty easy to add to the array.

*/

/*
 * AnagramContainer[]
 * 
 * 
 * cat act
 *   *
 * { c: 1, a: 1, t: 1 }   value is the frequency of occurance in the string
 * 
 * Anagram1: ['cat', 'act']
 * 
 * [['cat', 'act'], '']
 * 
 */



// {act: ['cat', 'act', 'act'], aehnrt: ['another']}

// function start(input) {
//     let anogramList = {};

//     for (let i = 0; i < input.length; i++) {
//         const item = input[i].sort();
//         if (anogramList.hasOwnProperty(item)) {
//             anogramList.push(input[i]);
//         } else {
//             anogramList.push([input[i]]);
//         }
//     }

//     const keys = Object.keys(anogramList);
//     for (let i = 0; i < keys.length; i++) {
//         console.log(`Anagram ${i}`);
//         for (let j = 0; j < anogramList[i]) {

//             //anogramList[i][j].forEach((item) => {
//             console.log(`   ${anogramList[keys[i]][j]}}`);
//             //})
//         }
//     }


//     function findEncapsolatedRange(input) {

//         let anagramContainer = [];
//         let visitedWords = [];

//         for (let i = 0; i < input.length - 1; i++) {
//             if (i in visitedWords) {
//                 continue;
//             }
//             let currentWordContainer = [input[i]]; // this container is the actual words that are anagrams of each other
//             for (let j = i + 1; j < input.length; j++) {
//                 if (isAnagram(input[i], input[j])) {
//                     currentWordContainer.push(input[j]);
//                     visitedWords.push(j);
//                 }
//             }



//         }

//         // anagramContainer.forEach




//         function isAnagram(wordOne, wordTwo) {
//             if (wordOne.length !== wordTwo.length) {
//                 return false;
//             }

//             let anagramDictionary = {};

//             wordOne.forEach((letter) => {
//                 if (anagramDictionary.hasOwnProperty(letter)) {
//                     anagramDictionary[letter] += 1;
//                 } else {
//                     anagramDictionary[letter] = 1;
//                 }
//             });

//             wordTwo.forEach((letter) => {
//                 if (anagramDictionary.hasOwnProperty(letter)) {
//                     anagramDictionary[letter] -= 1;
//                     if (anagramDictionary[letter] === 0) {
//                         delete anagramDictionary[letter];
//                     }
//                 }
//             });

//             if (Object.keys(anagramDictionary).length === 0) {
//                 return true;
//             } else {
//                 return false;
//             }
//         }

//     }