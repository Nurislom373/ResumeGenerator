let addButton = document.querySelector('.add');

let skillsDiv = document.querySelector('.skills');

let skill = document.querySelector('.skill');

function removeInput(i) {
    console.log(i);
    if (i !== "1") {
        let element = document.getElementById(i);
        element.remove();
    }
}

function addInput() {
    let sId = skillsDiv.lastElementChild.id;
    console.log(sId);

    let newId = parseInt(sId) + 1;
    let mb3 = document.createElement("div");
    mb3.className = "mb-3";
    console.log(newId);
    mb3.id = newId;

    let row = document.createElement("div");
    row.className = "row";

    let inputElement1 = document.createElement("input");
    inputElement1.className = "form-control";
    inputElement1.type = "text";
    inputElement1.name = "skill";
    inputElement1.required = true;

    let col10 = document.createElement("div");
    col10.className = "col-10";
    col10.appendChild(inputElement1);

    let iElement = document.createElement("i");
    iElement.style = "font-size: 30px; color: black";
    iElement.className = "bi bi-dash-circle-fill";

    let aElement = document.createElement("a");
    aElement.href = "#";
    aElement.className = "remove";
    aElement.setAttribute("onclick", "removeInput('" + newId + "')");
    aElement.appendChild(iElement);

    let col2 = document.createElement("div");
    col2.className = "col-2";
    col2.appendChild(aElement);

    row.appendChild(col10);
    row.appendChild(col2);
    mb3.appendChild(row);

    skillsDiv.appendChild(mb3);
}

addButton.addEventListener("click", addInput);