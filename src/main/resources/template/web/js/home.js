var count = 1;
setInterval(function() {
    document.getElementById("radio" + count).checked = true;
    count++;
    if (count > 4) {
        count = 1;
    }
}, 4000);

$('.add_cart').on('click', function() {
    $(".lib-text").css("background-color", "red");
    $(".lib-text").text("Đã thêm vào thư viện");
    var lib = '<div class="introduce-comic">'+
            '<div class="item">'+
                '<a href="../html/ThongTin.html ">'+
                    '<div class="title-comic ">'+
                        '<p>Câu lạc bộ công chúa <br> bị nguyền rủa</p>'+
                        '<div class="view ">'+'<i class="fa fa-heart " aria-hidden="true "></i>'+'14.3M'+
                        '</div>'+
                        '<div class="up ">up</div>'+
                    '</div>'+
                    '<img src="../image/main-img1.PNG " alt=" ">'+
                    '<div class="category ">hài kịch</div>'+
                    '<div class="comic-thumnail ">'+
                        '<p>Câu lạc bộ công chúa <br> bị nguyền rủa</p>'+
                        '<hr>'+ 'Gặp gỡ Gwendolyn - bằng chứng sống rằng các công chúa không phải lúc nào cũng có tất cả. Thấy chưa, mặc dù cô ấy sốn...'+'</div>'
                +'</a>'+

            '</div>'+
        '</div>';
        $('.introduce-comic').append(lib);

});