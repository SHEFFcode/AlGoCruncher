/*
G: string substring, which is a movie title 
O: string[] sorted titles of the moveis from XMLHTTPREQUEST response
T: Any
S: Any
 */

let movies = [];

 let requestHandler = function(movie) {
    movie = JSON.parse(movie);
    movie.data.forEach((movieItem) => {
        movies.push(movieItem.Title);
    });
    if (movie.page && movie.page < movie.total_pages) {
        getMovieTitles(url + `&page=${parseInt(movie.page)++}`);
    }
 }

 let getMovieTitles = function(url) {
    let requester = new XMLHttpRequest();
    requester.addEventListener('load', requestListener);
    requester.open('GET', url);
    requester.send();
 }

 let returnMovieTitles = function(title) {
    getMovieTitles(`http://sampleurl.com/api/movies/search/?Title=${title}`);
    return movies.sort();
 }