const url = "http://localhost:8080/api/v1/template/get/" + getParameter("id");

getTemplate(url);

function getTemplate(url) {
    fetch(url)
        .then((response) => {
            return response.json();
        })
        .then(data => {
            console.log(data);
            let templateData = data.data;
            let resume = document.querySelector('#resume');
            resume.innerHTML = templateData.html;
        });
}

function getParameter(name) {
    let parameters = new URLSearchParams(window.location.search);
    return parameters.get(name);
}