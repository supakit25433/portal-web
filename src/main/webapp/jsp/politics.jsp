<%@ page language="java" contentType="text/html; charset=TIS-620"
	pageEncoding="TIS-620"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
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
<meta charset="TIS-620">
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
				<a href="/v1/politics/localoffice/location"><button type="button" class="btn btn-primary" style="width:352px; height:121px; font-size: 24px"><span style="font-family: 'Roboto', sans-serif;">������ʶҹ����駢ͧ�ӹѡ�ҹ��ͧ��蹨ѧ��Ѵ</span></button></a>
			</div>
			<div class="col-3">
				<a href="/v1/politics/organizationoffice/location"><button type="button" class="btn btn-primary" style="width:352px; height:121px; font-size: 24px"><span style="font-family: 'Roboto', sans-serif;">������ʶҹ����駢ͧ�ӹѡ�ҹͧ��û���ͧ��ǹ��ͧ���</span></button></a>
			</div>
			<div class="col-3">
				<a href="/v1/politics/organizationoffice/website"><button type="button" class="btn btn-primary" style="width:352px; height:121px; font-size: 24px"><span style="font-family: 'Roboto', sans-serif;">���������䫵�ͧ��û���ͧ��ǹ��ͧ���</span></button></a>
			</div>
		</div>
	</div>
	<div class="container-fluid" style="margin-top: 20px">
		<div class="row justify-content-center">
			<div class="col-3">
				<a href="/v1/politics/organizationoffice/code"><button type="button" class="btn btn-primary" style="width:352px; height:121px; font-size: 24px"><span style="font-family: 'Roboto', sans-serif;">���� ͻ�. ����ҵðҹࢵ��û���ͧ�ͧ�� ��¨ѧ��Ѵ</span></button></a>
			</div>
		</div>
	</div>
	<div class="container-fluid" style="margin-top: 20px">
		<div class="row justify-content-between">
			<div class="col-5" style="text-align: right; font-family: 'Roboto', sans-serif; font-weight: bold;">
				Politics and Governance ( ������ͧ��С�û���ͧ )
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
	<c:if test="${search == \"Location of Provincial Local Office\"}">
			<div class="container-fluid" style="margin-top: 20px">
				<div class="row justify-content-center" >
					<div class="col-9" >
						<table class="table table-bordered" style="width:1300px">
							<tr>
								<th>Key</th>
								<th>Response</th>
							</tr>
							<tr>
								<td>Data</td>
								<td>${Response}</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${search == \"Location of Local Administrative Organization Office\"}">
			<div class="container-fluid" style="margin-top: 20px">
				<div class="row justify-content-center" >
					<div class="col-9" >
						<table class="table table-bordered" style="width:1300px">
							<tr>
								<th>Key</th>
								<th>Response</th>
							</tr>
							<tr>
								<td>Data</td>
								<td>${Response}</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${search == \"Website of Provincial Local Office\"}">
			<div class="container-fluid" style="margin-top: 20px">
				<div class="row justify-content-center" >
					<div class="col-9" >
						<table class="table table-bordered" style="width:1300px">
							<tr>
								<th>Key</th>
								<th>Response</th>
							</tr>
							<tr>
								<td>Data</td>
								<td>${Response}</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${search == \"Code of Provincial Local Office\"}">
			<div class="container-fluid" style="margin-top: 20px">
				<div class="row justify-content-center" >
					<div class="col-9" >
						<table class="table table-bordered" style="width:1300px">
							<tr>
								<th>Key</th>
								<th>Response</th>
							</tr>
							<tr>
								<td>Data</td>
								<td>${Response}</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</c:if>
</body>
</html>