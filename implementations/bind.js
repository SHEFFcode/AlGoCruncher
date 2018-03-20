Object.prototype.jeremyBind = function() {  // set it on the object prototype
    let callingFunction = this;  // this is the refence to calling function
    let args = [...arguments];  // convert to proper array
    let context = args[0];  // get the this keyword
    let boundFunctionArgurments = args.splice(1);  // get all the other params
    let boundFunction = function() {  // create the bound function 
        return callingFunction.apply(context, boundFunctionArgurments); // return like original
    }
    boundFunction.prototype = callingFunction.prototype;  // make sure to handle the prototype
    return boundFunction; // return the bound function
}