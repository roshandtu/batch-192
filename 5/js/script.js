
document.getElementsByTagName('h1')[0].innerText += " world!";


function clickme() {
    alert('welcome');
}

var p = parseInt(prompt('Enter a number'));

if (isNaN(p)) {
    p = parseInt(prompt('Enter a number'));
}

else if (p == 0) {
    document.getElementsByTagName('h1')[0].innerText = "zero";
}

else if (p % 2 == 0) {
    document.getElementsByTagName('h1')[0].innerText = "even";
}


else if (p % 2 != 0) {
    document.getElementsByTagName('h1')[0].innerText = "odd";
}

