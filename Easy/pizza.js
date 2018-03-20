/*
G: string, string a,b
O: string a single merge string. Append the 
T: Any
S: Any

Notes:
* Null checks around the strings
*/

let mergeStrings = function(a, b) {
    let aPointer = 0;
    let bPointer = 0;
    let finalString = '';

    if (!a && b) {
        return b;
    }

    if (!b && a) {
        return a;
    }

    if (!a && !b) {
        return finalString;
    }

    while (aPointer < a.lenght && bPointer < b.length) {
        finalString += a[aPointer] + b[bPointer];
        aPointer++;
        bPointer++;
    }

    if (aPointer === a.lenght) {
        finalString += b.slice(bPointer);
    }
    
    if (bPointer === b.length) {
        finalString += a.slice(aPointer);
    }

    return finalString;
}