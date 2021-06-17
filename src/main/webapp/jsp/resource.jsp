<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet">
<meta charset="utf-8">
<title>Portal API</title>
</head>
<body style="font-family: 'Roboto', sans-serif;">
	<div class="container-fluid"
		style="background-color: #C4C4C4; height: 50px">
		<div class="row justify-content-between">
			<div class="col-2" style="font-size: 24px; margin: 6px;">
				<a href="/v1/index" style="color: black">Portal API</a>
			</div>
			<div class="col-2"
				style="font-size: 24px; color: #646464; margin: 6px">Date :
				${Date.date}/${Date.month+1}/${1900+Date.year}</div>
		</div>
	</div>
	<div class="container-fluid" style="margin-top: 20px">
		<div class="row justify-content-center">
			<div class="col-3">
				<a href="/v1/resource/get/airdata"><button type="button" class="btn btn-primary" style="width:352px; height:121px; font-size: 24px"><span style="font-family: 'Roboto', sans-serif;">ข้อมูลอากาศชั้นบน<br>และดัชนีอากาศ</span></button></a>
			</div>
			<div class="col-3">
				<a href="/v1/resource/get/royalrain"><button type="button" class="btn btn-primary" style="width:352px; height:121px; font-size: 24px"><span style="font-family: 'Roboto', sans-serif;">ข้อมูลผู้ขอรับบริการฝนหลวง</span></button></a>
			</div>
		</div>
	</div>
	<div class="container-fluid" style="margin-top: 20px">
		<div class="row justify-content-between">
			<div class="col-4" style="text-align: right; font-family: 'Roboto', sans-serif; font-weight: bold;">
				Natural Resource ( ทรัพยากรธรรมชาติและสิ่งแวดล้อม )
			</div>
			<div class="col-4">
				Search : <input readonly="readonly" value="${search}">
			</div>
		</div>
	</div>
	<div class="container-fluid" style="margin-top: 20px">
		<div class="row justify-content-center" >
			<div class="col-9" >
				<table class="table table-bordered" style="width:1300px">
					<tr>
						<th>Key</th>
						<th>Response</th>
					</tr>
					<c:forEach items="${Map}" var="m">
						<tr>
							<td>${m.key}</td>
							<td>${m.value}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>