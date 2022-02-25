<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${tinh-cam}</title>
<jsp:include page="/WEB-INF/view/common/user/linkStyle.jsp"></jsp:include>
</head>
<body>
<!-- header -->
    <%@ include file="/WEB-INF/view/common/user/header.jsp" %>
    <!-- header -->
 <div class="main_gener">
  <div class="list_gener">
             <ul>
                <li>
                    <a href="/kich">Kịch</a>
                </li>
                <li>
                    <a   href="/hai-huoc">Hài Hước</a>
                </li>
                <li>
                    <a   href="/hanh-dong">Hành Động</a>
                </li>
                <li>
                    <a href="/superhero">Superhero</a>
                </li>
                <li>
                    <a  class="active" href="/tinh-cam">Tình Cảm</a>
                </li>
                <li>
                    <a  href="/kinh-di">Kinh Dị</a>
                </li>
                <li>
                    <a  href="/sieu-nhien ">Siêu Nhiên</a>
                </li>
            </ul>
        </div>
    <div class="main-category ">
   
            <div class="introduce">
                <div class="introduce-comic">
                    <div class="item item1">
                        <a href="../html/ThongTin.html">
                            <div class="title-comic">
                                <p>Mùa hường</p>
                                <div class="view"><i class="fa fa-heart" aria-hidden="true"></i>14.3M
                                </div>
                                <div class="up">up</div>

                            </div>
                            <img src="${pageContext.request.contextPath}/template/web/image/tc1.PNG" alt="">

                            <div class="comic-thumnail">
                                <p>Mùa hường</p>
                                <hr> Gặp gỡ Gwendolyn - bằng chứng sống rằng các công chúa không phải lúc nào cũng có tất cả. Thấy chưa, mặc dù cô ấy sốn...</div>
                        </a>

                    </div>
                    <div class="item">
                        <a href="../html/ThongTin.html">
                            <div class="title-comic" id="white">
                                <p>Những chàng trai</p>

                                <div class="view"><i class="fa fa-heart" aria-hidden="true"></i>2.2M
                                </div>
                                <div class="up">up</div>

                            </div>
                            <img src="${pageContext.request.contextPath}/template/web/image/tc2.PNG" alt="">

                            <div class="comic-thumnail bg-blue" id="bg-blue">
                                <p>Những chàng trai</p>
                                <hr> Sau khi bị mắc kẹt trong 12 một tòa tháp đầy quái vật tái sinh Hyeonu Kim mạnh hơn bất kỳ con người hay quái vật nào trên Trái đất. Bây giờ anh ấy đã tự do, anh ấy quyết tâm tìm hiểu ...</div>
                        </a>


                    </div>

                    <div class="item item3">
                        <a href="../html/ThongTin.html">
                            <div class="title-comic">
                                <p>Nụ hôn cắn</p>
                                <div class="view"><i class="fa fa-heart" aria-hidden="true"></i>5.3M
                                </div>
                                <div class="up">up</div>

                            </div>
                            <img src="${pageContext.request.contextPath}/template/web/image/tc3.PNG" alt="">

                            <div class="comic-thumnail bg-blue" id="bg-blue">
                                <p>Nụ hôn cắn</p>
                                <hr> Khi em gái út của gia đình Yu kết thúc cuộc đời mình, anh trai cô bắt đầu...</div>
                        </a>

                    </div>

                    <div class="item item4">
                        <a href="../html/ThongTin.html">
                            <div class="title-comic">
                                <p>Tẩy trang</p>
                                <div class="view"><i class="fa fa-heart" aria-hidden="true"></i>999.4K
                                </div>
                                <div class="up">up</div>

                            </div>
                            <img src="${pageContext.request.contextPath}/template/web/image/introdcue-3.PNG" alt="">

                            <div class="comic-thumnail bg-red" id="bg-red">
                                <p>Tẩy trang</p>

                                <hr> Sau nhiều năm được yêu cầu tập trung vào việc học, Yeseul cảm thấy lạc lõng khi cô bắt đầu học đại học và đột nhiên được mong đợi ...</div>
                        </a>

                    </div>
                    <div class="item item5">
                        <a href="../html/ThongTin.html">
                            <div class="title-comic">
                                <p>Bạn trai của <br>Dead</p>
                                <div class="view"><i class="fa fa-heart" aria-hidden="true"></i>1.9M
                                </div>
                                <div class="up">up</div>

                            </div>
                            <img src="${pageContext.request.contextPath}/template/web/image/introduce-5.PNG" alt="">

                            <div class="comic-thumnail">
                                <p>Bạn trai của <br>Dead</p>
                                <hr> Cô ấy là một phụ nữ trẻ thông minh, độc lập, người đang đá đít và đấu tranh để vượt qua ...
                            </div>
                        </a>

                    </div>
                    <div class="item item6">
                        <a href="../html/ThongTin.html">
                            <div class="title-comic">
                                <p>Mùa hoa</p>
                                <div class="view"><i class="fa fa-heart" aria-hidden="true"></i>463K
                                </div>
                                <div class="up">up</div>

                            </div>
                            <img src="${pageContext.request.contextPath}/template/web/image/introduce-6.PNG" alt="">

                            <div class="comic-thumnail bg-green" id="bg-green">
                                <p>Mùa hoa</p>
                                <hr> Ồ, để trẻ trung và yêu. Ôi, hoang dã và vô tư. Mùa xuân của cuộc sống rất dữ dội, hỗn loạn, và đôi khi, oh soo ...
                            </div>
                        </a>

                    </div>
                    <div class="item item7">
                        <a href="../html/ThongTin.html">
                            <div class="title-comic">
                                <p>Thực Tế</p>
                                <div class="view"><i class="fa fa-heart" aria-hidden="true"></i>2.1M
                                </div>
                                <div class="up">up</div>

                            </div>
                            <img src="${pageContext.request.contextPath}/template/web/image/introduce-7.PNG" alt="">

                            <div class="comic-thumnail bg-red" id="bg-red">
                                <p>Thực Tế</p>
                                <hr> Kade sống một mình và không bị xáo trộn... cho đến khi một cô gái ngoài hành tinh dễ thương đâm vào sân sau của mình! ...</div>
                        </a>

                    </div>
                    <div class="item item8">
                        <a href="../html/ThongTin.html">
                            <div class="title-comic">
                                <p>Từ yêu gia đình</p>
                                <div class="view"><i class="fa fa-heart" aria-hidden="true"></i>56.3M
                                </div>
                                <div class="up">up</div>

                            </div>
                            <img src="${pageContext.request.contextPath}/template/web/image/tc4.PNG" alt="">

                            <div class="comic-thumnail">
                                <p>Từ yêu gia đình</p>
                                <hr> Không ai chú ý nhiều đến John - chỉ là một thiếu niên bình thường tại một trường trung học nơi giới thượng lưu xã hội tình cờ sở hữu ...</div>
                        </a>

                    </div>
                    <div class="item item9">
                        <a href="../html/ThongTin.html">
                            <div class="title-comic">
                                <p>Tiếng sét ái ềm</p>
                                <div class="view"><i class="fa fa-heart" aria-hidden="true"></i>8.3M
                                </div>
                                <div class="up">up</div>

                            </div>
                            <img src="${pageContext.request.contextPath}/template/web/image/tc5.PNG" alt="">

                            <div class="comic-thumnail" id="bg-blue">
                                <p>Tiếng sét ái ềm</p>
                                <hr> Jiwoo là một chàng trai trẻ tốt bụng, người khai thác phản xạ nhanh như chớp của một con mèo để bí mật làm cho thế giới trở nên tốt đẹp hơn ...</div>
                        </a>
                    </div>
                    <div class="item item9">
                        <a href="../html/ThongTin.html">
                            <div class="title-comic">
                                <p>Chiếm hữu</p>
                                <div class="view"><i class="fa fa-heart" aria-hidden="true"></i>8.3M
                                </div>
                                <div class="up">up</div>

                            </div>
                            <img src="${pageContext.request.contextPath}/template/web/image/tc6.PNG" alt="">

                            <div class="comic-thumnail bg-blue" id="bg-blue">
                                <p>Chiếm hữu</p>
                                <hr> Jiwoo là một chàng trai trẻ tốt bụng, người khai thác phản xạ nhanh như chớp của một con mèo để bí mật làm cho thế giới trở nên tốt đẹp hơn ...</div>
                        </a>
                    </div>

                </div>
            </div>
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>

        </div>
        </div>
        <!-- header -->
    <%@ include file="/WEB-INF/view/common/user/footer.jsp" %>
    <!-- header -->
</body>
</html>