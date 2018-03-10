var debounce = (method, timeout) => {
    let timeout;
    return function() {
        let context = this, args = arguments;
        let later = function() {
            timeout = null;
            method.apply(context, args);
        }
        clearTimeout(timeout);
        timeout = setTimeout(later, wait);
    }
}