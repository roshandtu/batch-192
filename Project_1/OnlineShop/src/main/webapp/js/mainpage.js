$(document).ready(function() {
    $("#brand-category li a").click(function(e) {
        e.preventDefault();
        $(".brand-bg").hide(300);
        this.parentNode.parentElement.getElementsByClassName("active")[0].classList.remove("active");
        var link = this.dataset["link"];
        $("#brand-" + link).show(200);
        this.parentElement.classList.add("active");
    });
});