const id = "id";

let parameter = getParameter(id);

const url = "http://localhost:8080/api/v1/template/get/" + parameter;

sendRequest(url);

function getParameter(name) {
    let parameters = new URLSearchParams(window.location.search);
    return parameters.get(name);
}

function sendRequest(url) {
    fetch(url)
        .then(response => response.json())
        .then((data) => {
            console.log(data);
            let selector = document.querySelector('#template');
            let out = "";
            let template = data.data;
            out += template.html;
            selector.innerHTML = out;
        });
}