<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${the_royal }</title>
<jsp:include page="/WEB-INF/view/common/user/linkStyle.jsp"></jsp:include>
<link href="${pageContext.request.contextPath}/template/web/css/Theroyal.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
<!-- header -->
    <%@ include file="../common/user/header.jsp" %>
    <!-- header -->
<div class="the_royal">
        <div class="royal_name">MANGA THE ROYAL TUTOR CỦA HIGASA AKAI CHUẨN BỊ ĐI ĐẾN HỒI KẾT</div>
        <div class="royal_view">22:44 18/04/20213,449 lượt xem</div>
        <div class="royal_gener">Thể loại: Tin tức manga</div>
        <div class="royal_title">Số mới nhất của tạp chí G Fantasy đã thông báo rằng manga Oshitsu Kyoshi Heine (The Royal Tutor) của Higasa Akai sẽ kết thúc vào ngày 18 tháng 5. Hình ảnh manga sẽ xuất hiện trên trang bìa số mới nhất của tờ tạp chí, bao gồm một trang truyện màu
            và một tấm poster cỡ B3 do Akai vẽ.</div>
        <div class="image"> <img src="${pageContext.request.contextPath}/template/web/image/royal1.jpg" alt=""></div>
        <div class="royal_thumbnail">
            Câu chuyện kể về Heine Wittgenstein, được đích thân vua Grannzreich mời đến cung điện để nhậm chức Gia sư Hoàng gia, dạy học cho 4 vị hoàng tử trẻ là Kai, Bruno, Leonhard, và Licht, cả 4 đều là những ứng cử viên cho ngai vàng. Với những cá tính riêng
            biệt và tính cách có phần kỳ quái, đã có rất nhiều gia sư trước đây đã phải xin từ chức, vậy số phận của Heine sẽ ra sao?
            <br> Akai đã cho ra mắt bộ manga trong tạp chí G Fantasy vào tháng 11 năm 2013, và Square Enix đã xuất bản Volume thứ 16 của manga vào ngày 27 tháng 1 năm 2021. Manga cũng đã có 2 bộ anime chuyển thể vào các năm 2017 và 2019.


        </div>
        <div class="comment-comic">
            <p><i class="fa fa-comment" aria-hidden="true"></i>Bình luận
                <hr>
            </p>
            <form action="" method="POST">
                <input class="comment-input" type="text" name="comment" placeholder="Nhập bình luận tại đây!">
                <input type="submit" value="Gửi">
            </form>
        </div>
    </div>
    <!-- header -->
    <%@ include file="../common/user/footer.jsp" %>
    <!-- header -->
</body>
</html>