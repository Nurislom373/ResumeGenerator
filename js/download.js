const downloadBtn = document.querySelector('.download');

downloadBtn.addEventListener("click", request);

function request() {
    let personalDetails = getPersonalDetails();
    let contact = getContact();
}

function getPersonalDetails() {
    let exampleInputFullname1 = document.getElementsByName('exampleInputFullname1');
    let exampleInputEmail1 = document.getElementsByName('exampleInputEmail1');
    let exampleInputHeadline1 = document.getElementsByName('exampleInputHeadline1');
    let exampleInputPhoneNumber1 = document.getElementsByName('exampleInputPhoneNumber1');
    let exampleInputAbout1 = document.getElementsByName('exampleInputAbout1');

    let fullName = getValueWithValues(exampleInputFullname1);
    let email = getValueWithValues(exampleInputEmail1);
    let headline = getValueWithValues(exampleInputHeadline1);
    let phoneNumber = getValueWithValues(exampleInputPhoneNumber1);
    let about = getValueWithValues(exampleInputAbout1);

    return {
        "fullName": fullName,
        "email": email,
        "headline": headline,
        "phoneNumber": phoneNumber,
        "about": about
    };
}

function getContact() {
    let exampleGithub = document.getElementsByName('exampleGithub');
    let exampleTelegram = document.getElementsByName('exampleTelegram');

    let github = getValueWithValues(exampleGithub);
    let telegram = getValueWithValues(exampleTelegram);

    return {
        "github": github,
        "telegram": telegram
    };
}

function getValueWithValues(values) {
    for (let value of values.values()) {
        return value.value;
    }
}
