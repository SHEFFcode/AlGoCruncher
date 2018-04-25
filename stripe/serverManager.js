class ServerManager {
  constructor() {
    this.keyContainer = {};
    this.MAX_SERVER_COUNT = 999;
  }

  allocateKey(key) {
    if (this.keyContainer.hasOwnProperty(key)) {
      if (this.keyContainer[key] === this.MAX_SERVER_COUNT) {
        return -1;
      }
      this.keyContainer[key]++;
    } else {
      this.keyContainer[key] = 1;
    }
    return `${key}${this.keyContainer[key]}`;
  }

  deAllocateKey(key) {
    if (this.keyContainer.hasOwnProperty(key) && this.keyContainer[key] > 0) {
      this.keyContainer[key]--;
    }
  }
}

let serverManager = new ServerManager();

console.log(serverManager.allocateKey('apiBox'));
console.log(serverManager.allocateKey('apiBox'));
console.log(serverManager.allocateKey('apiBox'));
console.log(serverManager.deAllocateKey('apiBox'));
console.log(serverManager.deAllocateKey('siteBox'));
console.log(serverManager.deAllocateKey('siteBox'));

module.exports = ServerManager;