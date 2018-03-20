function getType (elem) {
    return Object.prototype.toString.call(elem).slice(8, -1);
}