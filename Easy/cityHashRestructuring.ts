export interface RawCityArray {
    Name: string;
    Region: string;
    Year: string;
    Population: number;
    AvgPollutionIndex: number;
    DaysOfRain: number;
}

export interface City {
    Name: string;
    Population: number;
    AvgPollutionIndex: number;
    DaysOfRain: number;
}

function main() {
    const rawCityList: RawCityArray[] = [
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

function myFunction(theRegionifiedList: Object, yearSelected: string, region: string): City[] {
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

function regionifyCityList(cities): void {
  
	let theRegionifiedList = {};
  let possibleYears = [];
  let possibleRegions = [];
  
  cities.forEach((city) => {
    // theRegionifiedList.hasOwnProperty('2007')
    //possibleYears.push(city.Year);
    //possibleRegions.push(city.Region);
    
    if (!(city.Year in theRegionifiedList))
    
    if (!theRegionifiedList.hasOwnProperty(city.Year)) {
    	theRegionifiedList[city.Year] = {};
  	}
                 
   if (!theRegionifiedList[city.Year].hasOwnProperty(city.Region)) {
    theRegionifiedList[city.Year][city.Region] = [];
  }
                 
  theRegionifiedList[city.Year][city.Region].push(city);
                 
  });
  

  /* {
  2018:{
  'NW USA': [{"Name":"Seattle","Region":"NW USA","Year":"2018","Population":1000000,"AvgPollutionIndex":2,"DaysOfRain":300},  {"Name":"Portland","Region":"NW USA","Year":"2018","Population":800000,"AvgPollutionIndex":4,"DaysOfRain":200}]
  }
  
  2017: {
  'WEST USA': [{firstCity}]
  }
  } */
  
  
  cities.forEach((city, index) => {
    possibleYears.forEach((year) => {
    	theRegionifiedList[year] = 
    });
    
  });
}

main();