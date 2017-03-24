<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/bcHeader.jsp" %>

 <div class="container">
    <div class="box-product">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>

                    <p>All the selected products in your shopping cart</p>
                </div>
            </div>
        </section>

<%--         <section ng-app="cartApp">
            <div ng-controller = "cartCtrl" ng-init="initCartId('${cartId}')">
            <div>
                <a class="btn btn-danger pull-left" ng-click="clearCart()"><span
                        class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
                <a href="<spring:url value="/order/${cartId}"/>"
                   class="btn btn-success pull-right"><span class="glyphicon-shopping-cart glyphicon"></span> Check out
                </a>
            </div> --%>

            <table class="table table-hover">
                <tr>
                    <th>Product</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${cartItems}" var="cartItem">
	                <tr>
	                    <td>${cartItem.product.productName}</td>
	                    <td>${cartItem.product.productPrice}</td>
	                    <td>${cartItem.quantity}</td>
	                    <td>${cartItem.totalPrice}</td>
	                    <td><a href="<spring:url value="/customer/cart/remove/${cartItem.product.productId}" />"
                    		><span class="glyphicon glyphicon-remove"></span>remove</a></td>
	                </tr>
                </c:forEach>
                <tr>
                    <th></th>
                    <th></th>
                    <th>Grand Total</th>
                    <th>${grandTotal}</th>
                    <th></th>
                </tr>
            </table>

            <a href="<spring:url value="/product/productList/all" />" class="btn btn-default">Continue Shopping</a>
            </div>
        </section>

    </div>
</div>

<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp" %>