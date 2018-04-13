/*

List of employees

start and end date



startYear
endYear

 */

class Employee {
  constructor(startYear, endYear) {
    this.start = startYear;
    this.end = endYear;
  }
}


/**
 * 
 * @param {any} people 
 * @returns {string[]}
 */
function findHayDay(people) {
  let hayDayMap = {};
  people.forEach((person, index) => {
    let start = person.start;
    let end = person.end;

    for (let i = start; i <= end; i++) {
      if (hayDayMap.hasOwnProperty(i)) {
        hayDayMap[i]++;
      } else {
        hayDayMap[i] = 1;
      }
    }
  });

  let highestHayDayYear = -1;
  let hayDayCount = -1;
  let hayDayPeriod = [];

  for (let year of Object.keys(hayDayMap)) {
    if (hayDayMap[year] >= hayDayCount) {
      if (hayDayMap[year] > hayDayCount) {
        hayDayPeriod.length = 0;
      }
      hayDayCount = hayDayMap[year];
      highestHayDayYear = year;
      hayDayPeriod.push(highestHayDayYear);
    }
  }

  return hayDayPeriod;
}

console.log(findHayDay([
  new Employee(1940, 1962),
  new Employee(1960, 1990),
  new Employee(1960, 1962)

  // {start: 1940, end: 1962}, 
  // {start: 1960, end: 1990}, 
  // {start: 1960, end: 1962},
  // {start: 2000, end: 2000},
  // {start: 2000, end: 2000},
  // {start: 2000, end: 2000},
]));



