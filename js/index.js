const url = "http://localhost:8080/api/v1/template/ti_list?properties=TITLE&size=10&page=0&sort=ASC";

getTemplates(url);

async function getTemplates(url) {

    fetch(url)
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            console.log(data);
            let selector = document.querySelector('#templates');
            let out = "";
            let templates = data.data;
            for (let template of templates) {
                out += `
                    <div class="col-4 my-4">
                <div class="col-12">
                    <img src='${template.imagePath}' width="90%" alt="no img">
                </div>
                <div class="col-12">
                    <h4>${template.category}</h4> <!-- category -->
                    <h2>${template.title}</h2> <!-- title -->   
                </div>
                <a href="http://localhost:63342/elbar-CVGen-rest/cv_gen/js/resume_view.html?id=${template.id}">Edit</a>
            </div>
                `;
            }
            selector.innerHTML = out;
        });
}



