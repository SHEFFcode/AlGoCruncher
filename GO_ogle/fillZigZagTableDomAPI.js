function zigZagCells(row, reverse, ivalue) {
	for (let j = 0; j < 5; j++) {
		let cell = row.insertCell(j);
    cell.style.border = '1px solid black';

		if (reverse) {
  		cell.innerHTML = (ivalue * 5) + (5 - j);
  	} else {
      cell.innerHTML = (ivalue * 5) + (j + 1);
  	}
  }
}

function createTable () {
  let table = document.createElement('TABLE');
  table.style.border = '1px solid black';
  let reverse = false;
  
  for (let i = 0; i < 5; i++) {
    let row = table.insertRow(i);
    zigZagCells(row, reverse, i);
    reverse = !reverse;
  }
  
  document.body.appendChild(table);
}