function curry(funcToCurry) {
  let arityOfOriginalFunction = funcToCurry.length;
  function curriedFunction () { // no arguments here, but this would be add(a)
    if (arityOfOriginalFunction <= arguments.length) {  // we have all the arguments of the original function
      return funcToCurry.apply(null, [...arguments]);
    }

    return curriedFunction.bind(null, [...arguments]);
  }
  return curriedFunction;
}