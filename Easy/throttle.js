let throttle = function(action, timeout) { // takes an aciton and a timeout
  let inThrottle = false;  // initially funciton is not throttled
  return function() { // returns a throttled version of the original
   let self = this;  // this context is bound to the context @ runtime
    let args = [...arguments]; // converts arguments into propert array
    if (!inThrottle) {  // if we are not in throttle, execute
      action.apply(self, args); //execute via args array
      inThrottle = true;  // set inThrotte to true
    	setTimeout(() => inThrottle = false, timeout);  // se a timeout
    }
  }
}