var a;
function load(page, cont, own = null) {
    xhr = new XMLHttpRequest();
    xhr.onload = function () {
        cont.innerHTML = this.responseText;
        if (own != null) {
            document.querySelector('.nav-item.active').classList.remove('active')
            while(own.parentElement.tagName.toUpperCase() != 'LI'){
                own = own.parentElement;
            }
            own.parentElement.classList.add('active');
        }
    }
    xhr.open('GET', page);
    xhr.send();
}

function init() {
    load('home.html', document.getElementsByClassName('container')[0]);
}

document.addEventListener('load', init());

document.querySelectorAll('a.nav-link').forEach(function (item) {
    const a = item.getAttribute('data-href');
    if (a != null) {
        item.addEventListener('click', function () {

            if (a !== '#') {
                load(a, document.getElementsByClassName('container')[0], this);
            }
        });
    }
});
