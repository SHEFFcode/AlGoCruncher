"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
function main() {
    const rawCityList = [
        { Name: 'Seattle', Region: 'NW USA', Year: '2018', Population: 1000000, AvgPollutionIndex: 2, DaysOfRain: 300 },
        { Name: 'Seattle', Region: 'NW USA', Year: '2017', Population: 1000000, AvgPollutionIndex: 2, DaysOfRain: 290 },
        { Name: 'Portland', Region: 'NW USA', Year: '2018', Population: 800000, AvgPollutionIndex: 4, DaysOfRain: 200 },
        { Name: 'Vancouver', Region: 'NW CANADA', Year: '2018', Population: 1000000, AvgPollutionIndex: 1, DaysOfRain: 310 },
        { Name: 'Atlanta', Region: 'SE USA', Year: '2017', Population: 1000000, AvgPollutionIndex: 8, DaysOfRain: 100 },
    ];
    const sortedList = regionifyCityList(rawCityList);
    // [{"Name":"Seattle","Region":"NW USA","Year":"2018","Population":1000000,"AvgPollutionIndex":2,"DaysOfRain":300},
    //  {"Name":"Portland","Region":"NW USA","Year":"2018","Population":800000,"AvgPollutionIndex":4,"DaysOfRain":200}]
    console.log(JSON.stringify(myFunction(sortedList, '2018', 'NW USA')));
    // [{"Name":"Vancouver","Region":"NW CANADA","Year":"2018","Population":1000000,"AvgPollutionIndex":1,"DaysOfRain":310}]
    console.log(JSON.stringify(myFunction(sortedList, '2018', 'NW CANADA')));
    // [{"Name":"Seattle","Region":"NW USA","Year":"2017","Population":1000000,"AvgPollutionIndex":2,"DaysOfRain":290}]
    console.log(JSON.stringify(myFunction(sortedList, '2017', 'NW USA')));
    // [{"Name":"Atlanta","Region":"SE USA","Year":"2017","Population":1000000,"AvgPollutionIndex":8,"DaysOfRain":100}]
    console.log(JSON.stringify(myFunction(sortedList, '2017', 'SE USA')));
}
function myFunction(theRegionifiedList, yearSelected, region) {
    if (!(yearSelected in theRegionifiedList)) {
        return null;
    }
    if (!(region in theRegionifiedList[yearSelected])) {
        return null;
    }
    return theRegionifiedList[yearSelected][region];
}
// 1. {}
// -> { Name: 'Seattle', Region: 'NW USA', Year: '2018', Population: 1000000, AvgPollutionIndex: 2, DaysOfRain: 300 }
// 2.
// {2018: NW USA: [{ Name: 'Seattle', Region: 'NW USA', Year: '2018', Population: 1000000, AvgPollutionIndex: 2, DaysOfRain: 300]}
function regionifyCityList(cities) {
    let regionifiedCities = {};
    cities.forEach((city) => {
        if (!regionifiedCities.hasOwnProperty(city.year)) { //{2018: {}}
            regionifiedCities[city.year] = {};
        }
        if (!regionifiedCities[city.year].hasOwnProperty(city.region)) { //{2018: {Northwest: []}}
            regionifiedCities[city.year][city.region] = [city];
        }
        else {
            regionifiedCities[city.year][city.region].push(city);
        }
    });
    return regionifiedCities;
}
main();
//# sourceMappingURL=cityHashRestructuring.js.map