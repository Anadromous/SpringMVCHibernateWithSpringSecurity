<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>

            <p class="lead">This is the administrator page!</p>
        </div>
		<sec:authorize access="authenticated" var="authenticated"></sec:authorize>
		<c:if test="${authenticated}">
			<h2>
				Welcome	<sec:authentication property="name" />
				<a id="logout" href="#">Logout</a>
				<form id="logout-form" action="<c:url value="/logout"/>" method="POST">
					<sec:csrfInput />
				</form>
			</h2>
		</c:if>

		<h3>
			<a href="<c:url value="/admin/productInventory" />">Product
				Inventory</a>
		</h3>

		<p>Here you can view, check and modify the product inventory!</p>

        <br><br>

        <h3>
            <a href="<c:url value="/admin/customer" />" >Customer Managementy</a>
        </h3>

        <p>Here you can view the customer information!</p>

		<%@include file="/WEB-INF/views/template/footer.jsp"%>