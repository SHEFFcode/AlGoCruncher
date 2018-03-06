let rawCityList = [
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

function myFunction(theRegionifiedList, yearSelected, region) {
    if (!(yearSelected in theRegionifiedList)) {
        return null;
    }

    if (!(region in theRegionifiedList[yearSelected])) {
        return null;
    }

    return theRegionifiedList[yearSelected][region];
}


/*
{
    2018: {
        'NW USA': [city]
    }

}


*/

function regionifyCityList(cities) {
    let regionifiedCityList = {};
    cities.forEach((city) => {
        if (!(city.Year in regionifiedCityList)) {
            regionifiedCityList[city.Year] = {}; 
        }
        
        if (!(city.Region in regionifiedCityList[city.Year]))  {
            regionifiedCityList[city.Year][city.Region] = [city];
        } else {
            regionifiedCityList[city.Year][city.Region].push(city)
        }
    });
    return regionifiedCityList;
};
