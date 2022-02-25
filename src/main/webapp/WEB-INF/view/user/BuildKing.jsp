<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${build_king }</title>
<jsp:include page="/WEB-INF/view/common/user/linkStyle.jsp"></jsp:include>
<link href="${pageContext.request.contextPath}/template/web/css/Theroyal.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
<!-- header -->
    <%@ include file="../common/user/header.jsp" %>
    <!-- header -->
   <div class="the_royal">
        <div class="royal_name">MANGA BUILD KING ĐI ĐẾN HỒI KẾT</div>
        <div class="royal_view">12:44 17/05/2021 8,449 lượt xem</div>
        <div class="royal_gener">Thể loại: Tin tức manga</div>
        <div class="royal_title">Tạp chí Weekly Shonen Jump đã đăng chương cuối cùng cho bộ manga Build King của Mitsutoshi Shimabukuro. Volume thứ 2 của manga sẽ được phát hành vào ngày 4 tháng 6 và Volume thứ 3 sẽ được phát hành vào ngày 3 tháng 9. Volume thứ 3 sẽ bao gồm những
            nội dung không xuất hiện trong tạp chí.
        </div>
        <div class="image"> <img src="${pageContext.request.contextPath}/template/web/image/buildKing.jpg" alt=""></div>
        <div class="royal_thumbnail">
            Câu chuyện kể về 2 anh em Tonkachi và Renge, sống trên Đảo Hammer bí ẩn, có những sinh vật kỳ quái đang sinh sống. Hai người là những người thợ mộc xây nhà cho cư dân trên đảo, đây cũng là cách mà thế giới này sinh tồn trước sự khắc nghiệt của thiên nhiên
            và lũ quái vật nguy hiểm. Quá trình xây dựng những siêu công trình sẽ là khởi đầu cho một cuộc phiêu lưu cực kỳ gay cấn trong bộ manga này!
            <br>Tác giả Shimabukuro cho ra mắt manga Build King trên tạp chí Weekly Shonen Jump vào ngày 16 tháng 11 năm 2020. Volume đầu tiên của bộ truyện được xuất bản vào ngày 2 tháng 4 năm 2021.
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