


var btnContainer = document.getElementById("btnContainer");
var btns = btnContainer.getElementsByClassName("button");
for (var i = 0; i < btns.length; i++) {
    btns[i].addEventListener("click", function () {
        var current = btnContainer.getElementsByClassName("active");
        if (current.length > 0)
            current[0].className = current[0].className.replace(" active", "");
        this.className += " active";
    });
}
selection("etudiant");
function selection(c) {
    var x, i;
    x = document.getElementsByClassName("div-box");
    for (i = 0; i < x.length; i++) {
        if (x[i].className.indexOf(c) > -1)
            addClass(x[i], "show");
        else {
            removeClass(x[i], "show");
        }
    }
}

function addClass(element, name) {
    var i, array1, array2;
    array1 = element.className.split(" ");
    array2 = name.split(" ");
    for (i = 0; i < array2.length; i++) {
        if (array1.indexOf(array2[i]) === -1) {
            element.className += " " + array2[i];
        }
    }
}

function removeClass(element, name) {
    var i, array1, array2;
    array1 = element.className.split(" ");
    array2 = name.split(" ");
    for (i = 0; i < array2.length; i++) {
        while (array1.indexOf(array2[i]) > -1) {
            array1.splice(array1.indexOf(array2[i]), 1);
        }
    }
    element.className = array1.join(" ");
}

function envoyer(str) {
    if (!validateForm())
        return false;
    document.getElementById(str + "Form").submit();
    return true;
}

function validateForm() {
    var x, y, i, valid = true;
    x = document.getElementsByClassName("show");
    y = x[0].getElementsByTagName("input");
    for (i = 0; i < y.length; i++) {
        if (y[i].value === "" && y[i].name !== "password") {
            y[i].className += " invalid";
            valid = false;
        }
    }
    return valid;
}
            