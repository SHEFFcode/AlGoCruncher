class Dispatcher {
  constructor() {
    this.events = {}; // container for the events
  }

  /**
   * Registers an event listener callback
   * @param {String} event 
   * @param {Function} callback 
   */
  addListener(event, callback) {
    if (getType(callback) !== 'Function') {
      console.log("Listener callback must be a function.");
      return false;
    }

    if (getType(event) !== 'String') {
      console.log("Event destription must be a string");
      return false;
    }

    if (!this.events[event]) {
      this.events[event] = {
        listeners: []
      }
    }

    this.events[event].listeners.push(callback);
  }

  /**
   * Deregisters a specific listener
   * @param {String} event 
   * @param {Function} callback 
   */
  removeListener(event, callback) {
    if (!this.events[event]) {
      console.log('This event does not exist');
    }

    this.events[event].listeners = this.events[event].listeners.filter((listener) => {
      return listener.toString() === callback.toString();
    });
  }

  /**
   * Dispatches an event (all callbacks associated with it run).
   * @param {String} event 
   * @param {Any} details 
   */
  dispatch(event, details) {
    if (!this.events[event]) {
      console.log('event does not exist');
      return false;
    }

    this.events[event].listeners.forEach((listener) => {
      listener(details)
    });
  }
}

function getType (elem) {
  return Object.prototype.toString.call(elem).slice(8, -1);
}


/*=======================================================================
                          Dispatcher Usage
========================================================================*/

import Dispatcher from 'dispatcher';
const dispatcher = new Dispatcher();
// Add a listener to "getUserInfo" event 
dispatcher.addListener('getUserInfo', (details) => {  
    console.log(details);
});
// Calling the API and dispatch the response data
dispatcher.dispatch('getUserInfo', {    
    username: 'John',    
    accountType: 'admin'
});