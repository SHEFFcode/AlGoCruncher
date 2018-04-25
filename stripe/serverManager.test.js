// const assert = require('assert');
const { assert } = require('chai');  // Using Assert style
const { expect } = require('chai');  // Using Expect style
const { should } = require('chai');  // Using Should style
const ServerManager = require('./serverManager');

let serverManager;

beforeEach(() => {
  serverManager = new ServerManager();
});

describe('ServerManager', () => {
  describe('#allocateKey()', () => {
    it('Should return a string', () => {
      let serverHandle = serverManager.allocateKey('apiBox');
      expect(serverHandle).to.be.a('string');
    });

    it('Should allocate a key that increments by 1 every time', () => {
      let serverHandle = serverManager.allocateKey('apiBox');
      expect(serverHandle).to.equal('apiBox1');
    });

    it('Should not allocate above the server threshhold', () => {
      for (let i = 0; i < 999; i++) {
        serverManager.allocateKey('apiBox');
      }

      let serverHandle = serverManager.allocateKey('apiBox');
      expect(serverHandle).to.be.a('number');
      expect(serverHandle).to.eq(-1);
    });
  });

  describe('#deAllocateKey()', () => {
    it('Should not deallocate below 0', () => {
      serverManager.deAllocateKey('apiBox');
      let serverHandle = serverManager.allocateKey('apiBox');
      expect(serverHandle).to.equal('apiBox1');
    });
  })
});