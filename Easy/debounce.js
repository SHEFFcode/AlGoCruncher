let debounce = function (action, timeout) {  // accepts the function to run && timeout
    var timeoutId;  // we keep track of the timeout id in the closure scope
    return function () {  // we return a debounced version of the original
        let self = this; // keep track of this context @ execution time
        let args = [...arguments];  // convert into a proper array
        clearTimeout(timeoutId); // clears timeout
        timeoutId = setTimeout(() => action.apply(this, args), timeout); // sets timeout
    }
}
