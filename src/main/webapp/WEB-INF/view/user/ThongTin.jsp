<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="/WEB-INF/view/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${thong_tin }</title>
<jsp:include page="/WEB-INF/view/common/user/linkStyle.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/user/layout/websocket.css"></jsp:include>
   <!-- https://cdnjs.com/libraries/sockjs-client -->
      <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
      <!-- https://cdnjs.com/libraries/stomp.js/ -->
      <script  src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
       <link rel='stylesheet prefetch' href='https://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css'>
       <style type="text/css">
       	div.stars {
  width: 200px;
  display: inline-block;
}
 
input.star { display: none; }
 
label.star {
  float: right;
  padding: 0 10px;
  font-size: 20px;
  color: #444;
  transition: all .2s;
}
 
input.star:checked ~ label.star:before {
  content: '\f005';
  color: #FD4;
  transition: all .25s;
}
 
input.star-5:checked ~ label.star:before {
  color: #FE7;
 
}
 
input.star-1:checked ~ label.star:before { color: #F62; }
 
label.star:hover { transform: rotate(-15deg) scale(1.3); }
 
label.star:before {
  content: '\f006';
  font-family: FontAwesome;
}
.comment-top{
margin-top: 20px;
}
.user_name{
    font-size:14px;
    font-weight: bold;
}
.comments-list .media{
    border-bottom: 1px dotted #ccc;
}
.media-left img{
padding-right: 10px;
}    
</style>
</head>
<body>
<!-- header -->
    <%@ include file="/WEB-INF/view/common/user/header.jsp" %>
    <!-- header -->
 
   <div class="image_main">
        <div class="image_center">
            <div class="image">
                <img src="${comics.image }" alt="">
            </div>
            <div class="image_title">
                <div class="image_name">${comics.title }</div>
                <div class="list_thumb">
                    <ul>
                        <li><i class="fa fa-user" aria-hidden="true"></i><span>Tác giả</span> ${comics.author }
                        </li>
                        <li><i class="fa fa-rss" aria-hidden="true"></i>
                            <span>Tình Trạng</span> Đang cập nhật
                        </li>
                        <li><i class="fa fa-tags" aria-hidden="true"></i><span>Thể loại</span> ${category }
                        </li>
                        <li><i class="fa fa-eye" aria-hidden="true"></i><span>Lượt xem</span> ${comics.view }
                        </li>
                         <li><i class="fa fa-eye" aria-hidden="true"></i><span>Đánh giá</span>  <div class="stars">
						  <form action="">
						    <input class="star star-5" id="star-5" type="radio" name="star"/>
						    <label class="star star-5" for="star-5"></label>
						    <input class="star star-4" id="star-4" type="radio" name="star"/>
						    <label class="star star-4" for="star-4"></label>
						    <input class="star star-3" id="star-3" type="radio" name="star"/>
						    <label class="star star-3" for="star-3"></label>
						    <input class="star star-2" id="star-2" type="radio" name="star"/>
						    <label class="star star-2" for="star-2"></label>
						    <input class="star star-1" id="star-1" type="radio" name="star"/>
						    <label class="star star-1" for="star-1"></label>
						  </form>
						</div>
                        </li>
                       
                    </ul>
                </div>
                <div class="add_cart">
                    <div class="lib-text">Thêm vào thư viện
                    </div>
                </div>
                <div class="chap">
                    <a href="">Đọc từ đầu</a>
                    <a href="">Đọc mới nhất</a>
                </div>

            </div>

        </div>
        <div class="image_content">
            <p><i class="fa fa-file-text-o" aria-hidden="true"></i>Nội dung
                <hr>
            </p>
            <p>${comics.shortDescription }</p>
        </div>
        <div class="image_chappter">
            <p><i class="fa fa-th-list" aria-hidden="true"></i>Danh sách chương
                <hr>
            </p>
        </div>
        <div class="chaptter">
            <ul>
                <li>
                    <div class="count">Số chương</div>
                    <div class="update">Cập nhật</div>
                    <div class="view">Lượt xem</div>
                </li>
                <li>
                    <div class="count">
                        <a href="${base }/chapter">Chap 1</a>
                    </div>
                    <div class="update">1 giờ trước</div>
                    <div class="view">2000</div>
                </li>
            </ul>
        </div>
        <div class="comment-comic">
            <p><i class="fa fa-comment" aria-hidden="true"></i>Bình luận
                <hr>
            </p>
              <c:if test="${not empty  userLogined.username}">
           	
            <div id="connecting">Connecting...</div>
         <ul id="messageArea">
         </ul>
         <form id="messageForm" name="messageForm">
           <div class="input-message">
	         <div class="d-flex flex-row add-comment-section mt-4 mb-4"><img class="img-fluid img-responsive rounded-circle mr-2" src="https://i.imgur.com/qdiP4DB.jpg" width="38">
	          <input id="message"  type="text" class="form-control mr-3" placeholder="Nhập bình luận"><button class="btn btn-primary" type="submit">Gửi</button></div>
	      
            </div>
         </form>
          
          </c:if>
          <c:forEach items="${comments }" var="comment">
 <div class="container comment-top">
            <div class="row">
                <div class="col-md-8">
                  <div class="page-header">
                  </div> 
                   <div class="comments-list" id="comment-media">
                       <div class="media">                         
                            <a class="media-left" href="#">
                           
                            <c:forEach items="${users }" var="user">
                            <c:if test="${not empty user.imageUrl && user.userName == comment.userName }">
                            	 <img style="width: 70px;" src="${user.imageUrl }">
                            	 <c:set var = "check" scope = "session" value = "false"/>
                            </c:if>
                            <c:if test="${ empty user.imageUrl && user.userName == comment.userName }">
                            	  <img style="width: 70px;"  src="https://res.cloudinary.com/degm8f4tp/image/upload/v1631154083/image/ac3_b8ow0v.png">
                            </c:if>
                             </c:forEach>
                            </a>
                            <div class="media-body">
                                
                              <h4 class="media-heading user_name">${comment.userName }</h4>
                              ${comment.content }
                              
                              <p><small><a href="">Like</a> - <a href="">Share</a></small></p>
                            </div>
                             <p class="pull-right"><small>${comment.createdDate }</small></p>
                          </div>
                      
                    
                    
                    
                </div>
                 </div>
            </div>
        </div>
          </c:forEach>
        </div>
    </div>
    <!-- header -->
    <%@ include file="/WEB-INF/view/common/user/footer.jsp" %>
    <script type="text/javascript">
    'use strict';
		var messageForm = document.querySelector('#messageForm');
		var messageInput = document.querySelector('#message');
		var messageArea = document.querySelector('#messageArea');
		var connectingElement = document.querySelector('#connecting');
		
		var stompClient = null;
		var username = null;
  
 
	function connect() {
	    username = '${userLogined.username}';
	      
	    var socket = new SockJS('/ws');
	    stompClient = Stomp.over(socket);
	 
	    stompClient.connect({}, onConnected, onError);
	}
	 
	// Connect to WebSocket Server.
	connect();
	 
	function onConnected() {
	    // Subscribe to the Public Topic
	    stompClient.subscribe('/topic/publicChatRoom', onMessageReceived);
	 
	    // Tell your username to the server
	    stompClient.send("/app/chat.addUser",
	        {},
	        JSON.stringify({sender: username, type: 'JOIN'})
	    )
	 
	    connectingElement.classList.add('hidden');
	}
	 
	 
	function onError(error) {
	    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
	    connectingElement.style.color = 'red';
	}
	 
	 
	function sendMessage(event) {
	    var messageContent = messageInput.value.trim();
	    if(messageContent && stompClient) {
	        var chatMessage = {
	            sender: username,
	            content: messageInput.value,
	            type: 'CHAT'
	        };
	        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
	        messageInput.value = '';
	    }
	    event.preventDefault();
	}
	 
	 
	function onMessageReceived(payload) {
	    var message = JSON.parse(payload.body);
	 
	    var messageElement = document.createElement('li');
	 var date=new Date();
	 var nowDate=date.toUTCString();
	        
	        $('#comment-media').append('<div class="media">  <a class="media-left" href="#"><img style="width: 70px;"  src="https://res.cloudinary.com/degm8f4tp/image/upload/v1631154083/image/ac3_b8ow0v.png"></a> <div class="media-body"><h4 class="media-heading user_name">'+message.sender+'</h4>'+message.content+' <p><small><a href="">Like</a> - <a href="">Share</a></small></p> </div> <p class="pull-right"><small>'+nowDate+'</small></p></div></div>');
	    
	 
	}
	  
	  
	messageForm.addEventListener('submit', sendMessage, true);
    </script>
    <!-- header -->
</body>
</html>