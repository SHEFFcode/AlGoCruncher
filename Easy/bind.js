Object.prototype.jeremyBind = function() {
    let callingFunction = this;
    let args = [...arguments];
    let context = args[0];
    let boundFunctionArgurments = args.splice(1);
    let boundFunction = function() {
        return callingFunction.apply(context, boundFunctionArgurments);
    }
    boundFunction.prototype = callingFunction.prototype;
    return boundFunction;
}