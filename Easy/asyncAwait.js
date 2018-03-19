function loadJson(url) {
  return fetch(url)
    .then(response => {
      if (response.status == 200) {
        return response.json();
      } else {
        throw new Error(response.status);
      }
    })
}

loadJson('no-such-user.json') // (3)
  .catch(alert); // Error: 404


async function loadJson(url) {
  let response =  await fetch(url);
  if (response.status == 200) {
    return response.json();
  } else {
    throw new Error(response.status);
  }
}