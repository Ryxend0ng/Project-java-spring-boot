<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${fall_in_love }</title>
<jsp:include page="/WEB-INF/view/common/user/linkStyle.jsp"></jsp:include>
<link href="${pageContext.request.contextPath}/template/web/css/Theroyal.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
<!-- header -->
    <%@ include file="../common/user/header.jsp" %>
    <!-- header -->
   <div class="the_royal">
        <div class="royal_name">MANGA WE MUST NEVER FALL IN LOVE! CHÍNH THỨC KHÉP LẠI</div>
        <div class="royal_view">21:44 18/09/2021 8,489 lượt xem</div>
        <div class="royal_gener">Thể loại: Tin tức manga</div>
        <div class="royal_title">Volume thứ 8 của manga We Must Never Fall in Love! (Zettai ni Tokimeite wa Ikenai!) của Haru Tsukishima đã tiết lộ rằng manga sẽ kết thúc với Volume thứ 9 vào tháng 11 năm nay. .
        </div>
        <div class="image"> <img src="${pageContext.request.contextPath}/template/web/image/faainlove.jpg" alt=""></div>
        <div class="royal_thumbnail">
            Bộ truyện nói về Sakura, cô đã cảm thấy vô cùng tồi tệ sau một màn tỏ tình thất bại với người con trai mà cô mê mệt từ lâu. Đã vậy, dường như còn có người nhìn thấy cảnh cô bị từ chối. Điều duy nhất khiến cô có thể vượt qua là việc cô sắp được gặp lại
            cậu em trai dễ thương của mình. Cho đến khi hóa ra "cậu em trai dễ thương" của cô ấy không chỉ là một anh chàng cao ráo, đẹp trai trong lớp, mà anh còn là người đã chứng kiến màn tỏ tình của cô. Giờ Sakura lại phải giả vờ mọi thứ vẫn rất bình
            thường, nhưng với một "cậu em trai" luôn bảo vệ cô quá mức, luôn coi Sakura là người tuyệt nhất, và người cô ấy thầm thương trước đó lại bắt đầu có hứng thú với cô, cuộc sống trung học của Sakura sẽ chẳng dễ dàng gì!
            <br>Tsukishima đã cho ra mắt manga trên tạp chí Kodansha's Dessert vào tháng 9 năm 2017.
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