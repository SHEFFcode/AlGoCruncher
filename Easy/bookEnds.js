// def   tim   pood   donkey   gh   i   k  hkj
// - -   - -   -  -   -    -   --   -   -  _  _
//                                           *


function bookends(callback, wait) {
    let inDebounceState; // false
    let timerID;

    return function (e) {
        let isFirstValue; // true
        if (!inDebounceState) {
            callback(e);
            inDebounceState = true;
            isFirstValue = inDebounceState;
        } else {
            isFirstValue = false;
        }

        clearTimeout(timerID);
        timerID = setTimeout(() => {
            if (!isFirstValue) {
                callback(e);
            }

            inDebounceState = false;
        }, wait);
    }
}
