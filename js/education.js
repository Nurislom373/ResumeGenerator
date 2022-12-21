let educations = document.querySelector(".educations");
let addEducationBtn = document.querySelector(".addEducation");
const educationLabelFor = "exampleEducationName";
const educationStartDateLabelFor = "exampleEducationStartDate";
const educationEndDateLabelFor = "exampleEducationEndDate";
const educationDescriptionLabelFor = "exampleEducationDescription";

function addEducation() {
    let id = educations.lastElementChild.id;
    console.log(id);
    let s = id.substring(id.length - 1, id.length);
    console.log(s);
    let newId = parseInt(s) + 1;
    console.log(newId);

    let card = document.createElement("div");
    card.className = "card education mb-3";
    card.id = "education-" + newId;

    let cardBody = document.createElement("div");
    cardBody.className = "card-body mb-3";

    let mb3 = document.createElement("div");
    mb3.className = "mb-3";

    let educationLabel = document.createElement("label");
    educationLabel.className = "form-label";
    educationLabel.textContent = "Education";
    educationLabel.setAttribute("for", educationLabelFor + newId);

    let educationInput = document.createElement("input");
    educationInput.className = "form-control mb-3";
    educationInput.type = "text";
    educationInput.id = educationLabelFor + newId;


    let col12F = document.createElement("div");
    col12F.className = "col-6";
    let col12FLabel = document.createElement("label");
    col12FLabel.className = "form-label";
    col12FLabel.textContent = "Start Date"
    col12FLabel.setAttribute("for", educationStartDateLabelFor + newId);
    let col12FInput = document.createElement("input");
    col12FInput.className = "form-control";
    col12FInput.type = "date";
    col12FInput.id = educationStartDateLabelFor + newId;
    col12F.appendChild(col12FLabel);
    col12F.appendChild(col12FInput);

    let col12S = document.createElement("div");
    col12S.className = "col-6";
    let col12SLabel = document.createElement("label");
    col12SLabel.className = "form-label";
    col12SLabel.textContent = "End Date";
    col12FLabel.setAttribute("for", educationEndDateLabelFor + newId);
    let col12SInput = document.createElement("input");
    col12SInput.className = "form-control";
    col12SInput.type = "date";
    col12SInput.id = educationEndDateLabelFor + newId;
    col12S.appendChild(col12SLabel);
    col12S.appendChild(col12SInput);

    let row = document.createElement("div");
    row.className = "row mb-3";
    row.appendChild(col12F);
    row.appendChild(col12S);


    let descriptionLabel = document.createElement("label");
    descriptionLabel.className = "form-label";
    descriptionLabel.textContent = "Description";
    descriptionLabel.setAttribute("for", educationDescriptionLabelFor + newId);

    let descriptionTextarea = document.createElement("textarea");
    descriptionTextarea.className = "form-control";
    descriptionTextarea.rows = 4;
    descriptionTextarea.id = educationDescriptionLabelFor + newId;

    let description = document.createElement("div");
    description.className = "mb-3";
    description.appendChild(descriptionLabel);
    description.appendChild(descriptionTextarea);

    let deleteBtn = document.createElement("a");
    deleteBtn.className = "btn btn-dark";
    deleteBtn.href = "#";
    deleteBtn.textContent = "Delete"
    deleteBtn.setAttribute("onclick", "removeEducation('" + ("education-" + newId) + "')")

    mb3.appendChild(educationLabel);
    mb3.appendChild(educationInput);
    mb3.appendChild(row);
    mb3.appendChild(description);
    cardBody.appendChild(mb3);
    cardBody.appendChild(deleteBtn);
    card.appendChild(cardBody);
    educations.appendChild(card);
}

function removeEducation(i) {
    console.log(i);
    if (i !== "education-1") {
        let id = document.getElementById(i);
        id.remove();
    }
}

addEducationBtn.addEventListener("click", addEducation);