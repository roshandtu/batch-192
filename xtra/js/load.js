function load(page, cont) {
    xhr = new XMLHttpRequest();
    xhr.onload = function(){
        cont.innerHTML = this.responseText;
        if(page == "links.html") {
            document.querySelectorAll('li').forEach(item => {
                item.addEventListener('click', () => {
                    console.log(item.getAttribute('data-link'));
                    load(item.getAttribute('data-link'), document.getElementById('body'))
                });
            });
        }
    }
    xhr.open('GET', page);
    xhr.send();
}

function init() {
    var nav = document.getElementById('nav'),
        head = document.getElementById('head');
        body = document.getElementById('body');

    load('head.html', head);
    load('links.html', nav);
    load('login.html', body);
}


document.addEventListener('load', init());
