function readFromFile() {
    $.get("http://" + window.location.host + "/laptops", function (laptopSpecificationList) {

        var listLength = laptopSpecificationList.length;

        var text = "<table id='laptop-spec' class='table'><thead> <th scope='col'>Producent</th> <th scope='col'>Przekątna</th> <th scope='col'>Rozdzielczość</th> <th scope='col'>Typ matrycy</th> <th scope='col'>Touchpad</th> <th scope='col'>Procesor</th> <th scope='col'>Rdzenie</th> <th scope='col'>Taktowanie</th> <th scope='col'>RAM</th> <th scope='col'>Rozmiar dysku</th>  <th scope='col'>Typ dysku</th>  <th scope='col'>Karta graficzna</th>  <th scope='col'>VRAM</th>  <th scope='col'>System operacyjny</th> <th scope='col'>DVD</th> </thead><tbody class='table-data' )";
        for (var laptop in laptopSpecificationList) {
            text += "<tr>" +
                "<td contenteditable='true'>" + laptopSpecificationList[laptop].name + "</td>" +
                "<td contenteditable='true'>" + laptopSpecificationList[laptop].displaySize + "</td>" +
                "<td contenteditable='true'>" + laptopSpecificationList[laptop].resolution + "</td>" +
                "<td contenteditable='true'>" + laptopSpecificationList[laptop].screenType + "</td>" +
                "<td contenteditable='true'>" + laptopSpecificationList[laptop].touchpad + "</td>" +
                "<td contenteditable='true'>" + laptopSpecificationList[laptop].cpu + "</td>" +
                "<td contenteditable='true'>" + laptopSpecificationList[laptop].cores + "</td>" +
                "<td contenteditable='true'>" + laptopSpecificationList[laptop].freq + "</td>" +
                "<td contenteditable='true'>" + laptopSpecificationList[laptop].ram + "</td>" +
                "<td contenteditable='true'>" + laptopSpecificationList[laptop].space + "</td>" +
                "<td contenteditable='true'>" + laptopSpecificationList[laptop].discType + "</td>" +
                "<td contenteditable='true'>" + laptopSpecificationList[laptop].gpu + "</td>" +
                "<td contenteditable='true'>" + laptopSpecificationList[laptop].gpuRam + "</td>" +
                "<td contenteditable='true'>" + laptopSpecificationList[laptop].os + "</td>" +
                "<td contenteditable='true'>" + laptopSpecificationList[laptop].dvd + "</td></tr>";
        }
        text += "</tbody></table>";

        $("body").append(text);
    });
}

function saveToFile() {
    console.log("start")
    var rowCounter = parseInt(document.getElementById("laptop-spec").rows.length);

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
    console.log(laptopArray);

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