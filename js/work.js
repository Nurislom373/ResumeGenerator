let addWorkBtn = document.querySelector(".addWork");
let works = document.querySelector(".works");
const workPositionLabelFor = "exampleWorkPosition";
const workCompanyLabelFor = "exampleWorkCompany";
const workLocationLabelFor = "exampleWorkLocation";
const workStartDateLabelFor = "exampleWorkStartDate";
const workEndDateLabelFor = "exampleWorkEndDate";
const workDescriptionLabelFor = "exampleWorkDescription";

function addWork() {
    let id = works.lastElementChild.id;
    console.log(id);
    let substring = id.substring(id.length - 1, id.length);
    let newId = parseInt(substring) + 1;

    let card = document.createElement("div");
    card.className = "card work mb-3";
    card.id = "work-" + newId;

    let cardBody = document.createElement("div");
    cardBody.className = "card-body mb-3";

    let mb3 = document.createElement("div");
    mb3.className = "mb-3";

    let workLabel = document.createElement("label");
    workLabel.className = "form-label";
    workLabel.textContent = "Position";
    workLabel.setAttribute("for", workPositionLabelFor + newId);

    let workInput = document.createElement("input");
    workInput.className = "form-control mb-3";
    workInput.type = "text";
    workInput.id = workPositionLabelFor + newId;

    let deleteBtn = document.createElement("a");
    deleteBtn.className = "btn btn-dark";
    deleteBtn.href = "#";
    deleteBtn.textContent = "Delete";
    deleteBtn.setAttribute("onclick", "removeWork('" + ("work-" + newId) + "')");

    mb3.appendChild(workLabel);
    mb3.appendChild(workInput);
    mb3.appendChild(returnRowCL(newId));
    mb3.appendChild(returnRowSTD(newId));
    mb3.appendChild(returnDescDiv(newId));
    cardBody.appendChild(mb3);
    cardBody.appendChild(deleteBtn);
    card.appendChild(cardBody);
    works.appendChild(card);
}

function removeWork(work) {
    console.log(work);
    if (work !== "work-1") {
        let element = document.getElementById(work);
        element.remove();
    }
}

addWorkBtn.addEventListener("click", addWork);

// This function return Company and Location Div;
function returnRowCL(newId) {
    let col12F = document.createElement("div");
    col12F.className = "col-6";
    let col12FLabel = document.createElement("label");
    col12FLabel.className = "form-label";
    col12FLabel.textContent = "Company"
    col12FLabel.setAttribute("for", workCompanyLabelFor + newId);
    let col12FInput = document.createElement("input");
    col12FInput.className = "form-control";
    col12FInput.type = "text";
    col12FInput.id = workCompanyLabelFor + newId;
    col12F.appendChild(col12FLabel);
    col12F.appendChild(col12FInput);

    let col12S = document.createElement("div");
    col12S.className = "col-6";
    let col12SLabel = document.createElement("label");
    col12SLabel.className = "form-label";
    col12SLabel.textContent = "End Date";
    col12FLabel.setAttribute("for", workLocationLabelFor + newId);
    let col12SInput = document.createElement("input");
    col12SInput.className = "form-control";
    col12SInput.type = "text";
    col12SInput.id = workLocationLabelFor + newId;
    col12S.appendChild(col12SLabel);
    col12S.appendChild(col12SInput);

    let row = document.createElement("div");
    row.className = "row mb-3";
    row.appendChild(col12F);
    row.appendChild(col12S);

    return row;
}

function returnRowSTD(newId) {
    let col12F = document.createElement("div");
    col12F.className = "col-6";
    let col12FLabel = document.createElement("label");
    col12FLabel.className = "form-label";
    col12FLabel.textContent = "Start Date"
    col12FLabel.setAttribute("for", workStartDateLabelFor + newId);
    let col12FInput = document.createElement("input");
    col12FInput.className = "form-control";
    col12FInput.type = "date";
    col12FInput.id = workStartDateLabelFor + newId;
    col12F.appendChild(col12FLabel);
    col12F.appendChild(col12FInput);

    let col12S = document.createElement("div");
    col12S.className = "col-6";
    let col12SLabel = document.createElement("label");
    col12SLabel.className = "form-label";
    col12SLabel.textContent = "End Date";
    col12FLabel.setAttribute("for", workEndDateLabelFor + newId);
    let col12SInput = document.createElement("input");
    col12SInput.className = "form-control";
    col12SInput.type = "date";
    col12SInput.id = workEndDateLabelFor + newId;
    col12S.appendChild(col12SLabel);
    col12S.appendChild(col12SInput);

    let row = document.createElement("div");
    row.className = "row mb-3";
    row.appendChild(col12F);
    row.appendChild(col12S);

    return row;
}

function returnDescDiv(newId) {
    let descriptionLabel = document.createElement("label");
    descriptionLabel.className = "form-label";
    descriptionLabel.textContent = "Description";
    descriptionLabel.setAttribute("for", workDescriptionLabelFor + newId);

    let descriptionTextarea = document.createElement("textarea");
    descriptionTextarea.className = "form-control";
    descriptionTextarea.rows = 4;
    descriptionTextarea.id = workDescriptionLabelFor + newId;

    let description = document.createElement("div");
    description.className = "mb-3";
    description.appendChild(descriptionLabel);
    description.appendChild(descriptionTextarea);

    return description;
}

