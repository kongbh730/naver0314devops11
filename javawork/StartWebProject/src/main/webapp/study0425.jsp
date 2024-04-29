<%@page import="test.data.CarDto"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
body * {
	font-family: 'Jua';
}

div.car {
	float: left;
	margin: 20px;
	border: 2px solid black;
	border-radius: 20px;
	padding: 10px;
	width: 200px;
	height: 350px;
}

div.car img {
	width: 170px;
	height: 150px;
	border-radius: 20px;
}
</style>
<script>
	
</script>
</head>
<%
List<CarDto> list = new Vector<>();
//5개의 상품을 리스트에 등록해보자
list.add(new CarDto("BMW", "mycar1.png", 5000, 4, "lightgray"));
list.add(new CarDto("AUDI", "mycar3.png", 4000, 2, "red"));
list.add(new CarDto("MINI", "mycar5.png", 2300, 5, "green"));
list.add(new CarDto("VOLKSWAGEN", "mycar12.png", 3500, 1, "yellow"));
%>
<body>
	<%
	//상품출력
	for (CarDto dto : list) 
	{%>
	<div class="car" style="background-color: <%=dto.getColor()%>">
		<img src="./car/<%=dto.getPhoto()%>"><br><br>
		<h6>
			모델명 :<%=dto.getModel()%>
		</h6>
		<h6>
			가격 :<%=dto.getPrice()%>만원
		</h6>
		<h6>
			수량 :<%=dto.getCount()%>대
		</h6>
		<!-- <button class="purchasebtn" onclick="purchaseCar(this)">구매</button> -->
		<button class="purchasebtn" data-model="<%=dto.getModel()%>" data-price="<%=dto.getPrice()%>" data-count="<%=dto.getCount()%>" onclick="purchaseCar(this)">구매</button>
	</div>
	<%}
	%>

	<script>
	/*
	function purchaseCar(car){
		let count = document.querySElector("")
		alert("구매했습니다.");
	};
	*/
	function purchaseCar(button) {
        var model = button.getAttribute("data-model");
        var price = button.getAttribute("data-price");
        var count = button.getAttribute("data-count");
        if(count > 0)
        {
        	count--;
        	button.setAttribute("data-count", count);
        	alert("구매했습니다!" + " 재고 수 : " + count);	
        }
        else
        {
        	alert("재고가 부족합니다!");
        }
        //alert("모델명: " + model + ", 가격: " + price + "만원, 수량: " + count + "대를 구매했습니다.");
    }
	</script>
</body>
</html>

<!-- 
문제

"자동차 상점" 웹 페이지를 만드는 JSP 파일을 작성하십시오. 페이지에는 다양한 자동차(예: 세단, SUV, 스포츠카, 트럭)가 포함된 목록이 표시되어야 합니다. 각 자동차는 사진, 모델명, 가격, 수량을 포함해야 하며, 배경색은 자동차 유형에 따라 달라져야 합니다.

### 기본 설정

- 각 자동차는 `CarDto`라는 Java 클래스의 인스턴스로 표현됩니다. 이 클래스는 다음 속성을 가집니다:
  - `model`: 모델명 (문자열)
  - `photo`: 사진 파일의 이름 (문자열)
  - `price`: 가격 (정수)
  - `count`: 재고 수량 (정수)
  - `color`: 배경색 (문자열)

- 자동차 목록은 `ArrayList`로 관리하며, 초기에 네 가지 유형의 자동차로 채워집니다.

### 구현해야 할 항목

1. `CarDto` 클래스를 정의합니다.
2. 자동차 정보를 저장할 `ArrayList`를 생성하고, 초기 자동차 데이터로 채웁니다.
3. 각 자동차를 웹 페이지에 표시하기 위해 JSP에서 `ArrayList`를 반복 처리합니다.
4. 각 자동차를 독립된 `<div>` 태그 안에 배치하며, 해당 자동차의 배경색으로 설정된 색상으로 `<div>`의 배경색을 지정합니다.
5. 각 `<div>` 안에는 자동차의 사진, 모델명, 가격, 수량이 표시됩니다. 사진은 `<img>` 태그를 사용하여 표시합니다.


1. 각 자동차 목록에 "구매" 버튼을 추가합니다.
2. 버튼을 클릭하면 자바스크립트 함수를 호출하여, 해당 자동차의 모델명, 가격, 수량을 포함한 상세 정보를 페이지 하단에 동적으로 표시합니다.
3. 상세 정보와 함께 "구매하였습니다" 메시지를 표시합니다.

구현 상세
* JavaScript 함수 추가: purchaseCar라는 함수를 정의하고, 이 함수는 자동차 객체의 id를 매개변수로 받습니다. 이 함수는 해당 자동차의 상세 정보를 가져와 페이지 하단에 표시합니다.
* 자동차 정보 동적 표시: 선택한 자동차의 모델명, 가격, 수량 정보를 <div> 태그 내에 표시하며, "구매하였습니다" 메시지를 추가합니다.
* HTML 수정: 각 <div class="shop"> 안에 <button> 태그를 추가하여 "구매" 버튼을 만듭니다. 이 버튼은 onclick 이벤트에 purchaseCar() 함수를 호출하도록 설정합니다.

 -->