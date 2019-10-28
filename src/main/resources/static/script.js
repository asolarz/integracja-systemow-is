function readFromFile() {
    $.get("http://" + window.location.host + "/laptops/file", specificationTable);
}

function specificationTable(laptopSpecificationList) {

    $('#laptop-spec').remove();
    var text = "<table id='laptop-spec' class='table'><thead> <th scope='col'>Producent</th> <th scope='col'>Przekątna</th> <th scope='col'>Rozdzielczość</th> <th scope='col'>Typ matrycy</th> <th scope='col'>Touchpad</th> <th scope='col'>Procesor</th> <th scope='col'>Rdzenie</th> <th scope='col'>Taktowanie</th> <th scope='col'>RAM</th> <th scope='col'>Rozmiar dysku</th>  <th scope='col'>Typ dysku</th>  <th scope='col'>Karta graficzna</th>  <th scope='col'>VRAM</th>  <th scope='col'>System operacyjny</th> <th scope='col'>DVD</th> </thead><tbody class='table-data' )";
    for (var index in laptopSpecificationList) {
        var currentSpec = laptopSpecificationList[index];
        text += "<tr>";
        for (var propIndex in currentSpec) {
            if (propIndex == 'id') continue;
            if (currentSpec[propIndex] == null) {
                text += "<td contenteditable='true'>" + "brak" + "</td>";
            } else {
                text += "<td contenteditable='true'>" + currentSpec[propIndex] + "</td>";
            }
        }
        text += "</tr>";
    }
    text += "</tbody></table>";

    $("body").append(text);
}

function saveToFile() {

    var laptop = [];
    var laptopArray = [];
    var table = document.getElementById("laptop-spec");
    for (var i = 1, row; row = table.rows[i]; i++) {

        for (var j = 0, col; col = row.cells[j]; j++) {
            laptop.push(col.innerText);
        }
        laptopArray.push(laptop);
        laptop = [];
    }


    var data = JSON.stringify(laptopArray);
    $.ajax({
        type: "POST",
        url: "http://" + window.location.host +
            "/laptops",
        data: data,
        dataType: "json",
        contentType: "application/json"
    });
}

function readFromDatabase() {
    $.get("http://" + window.location.host + "/laptops/database", specificationTable);
}