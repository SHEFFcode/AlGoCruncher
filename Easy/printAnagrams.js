
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

