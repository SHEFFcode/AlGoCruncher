function timer() {
  this.count = 0;
  setInterval(() => {
    (function () {
      console.log(this.count++);
    }).apply(this);
  }, 1000);
}