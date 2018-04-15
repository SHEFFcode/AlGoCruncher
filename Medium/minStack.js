/**
 * initialize your data structure here.
 */
var MinStack = function() {
    this.container = [];
};

/** 
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
    
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    return this.container.pop();
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this.container[0];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.container[this.container.length - 1];
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = Object.create(MinStack).createNew()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */