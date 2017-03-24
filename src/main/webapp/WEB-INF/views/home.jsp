<%@include file="/WEB-INF/views/template/bcHeader.jsp"%>
<!-- Carousel
================================================== -->
<div class="container">

	<div class="row">
		<div class="box">
			<div class="col-lg-12 text-center">
				<div id="carousel-example-generic" class="carousel slide">
					<!-- Indicators -->
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img class="first-slide home-image"
								src="<c:url value="/resources/images/braque6.jpg" />"
								alt="First slide">

							<div class="container">
								<div class="carousel-caption">
									<h1>The better I get to know men, the more I find myself loving dogs.</h1>
									<p color:#fff>-Charles de Gaulle (former President of the French Republic)</p>
								</div>
							</div>
						</div>
						<div class="item">
							<img class="second-slide home-image"
								src="<c:url value="/resources/images/braque2.jpg" />"
								alt="Second slide">

							<div class="container">
								<div class="carousel-caption">
									<h1>Dogs are not our whole life, but they make our lives whole.</h1>

									<!-- Going with the flow is one thing, being at the mercy of the river is another -->

								</div>
							</div>
						</div>
						<div class="item">
							<img class="third-slide home-image"
								src="<c:url value="/resources/images/braque3.jpg" />"
								alt="Third slide">

							<div class="container">
								<div class="carousel-caption">
									<h1>The world would be a nicer place if everyone had the ability to love as unconditionally as a dog.</h1>
								</div>
							</div>
						</div>
					</div>
					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

	<!-- Three columns of text below the carousel -->
	<div class="row">
		<div class="col-lg-4">
			<a class="btn btn-default"
				href="<c:url value="/product/productList?searchCondition=Apparrel" />"
				role="button"> <img class="img-circle"
				src="<c:url value="/resources/images/dog2.jpg" />"
				alt="Instrument
                Image" width="140" height="140"></a>

			<h2>Apparrel</h2>
			<p>Dog Coats and Apparrel.</p>

		</div>
		<!-- /.col-lg-4 -->



		<div class="row">
			<div class="col-lg-4">
				<a class="btn btn-default"
					href="<c:url value="/product/productList?searchCondition=Gear" />"
					role="button"> <img class="img-circle"
					src="<c:url value="/resources/images/dogbackpack.jpg" />"
					alt="Instrument
                Image" width="140" height="140"></a>

				<h2>Gear</h2>
				<p>Backpacks and other Gear</p>

			</div>
			<!-- /.col-lg-4 -->

			<div class="row">
				<div class="col-lg-4">
					<a class="btn btn-default"
						href="<c:url value="/product/productList?searchCondition=Accessory" />"
						role="button"> <img class="img-circle"
						src="<c:url value="/resources/images/dogleash.jpg" />"
						alt="Instrument
                Image" width="140" height="140"></a>

					<h2>Accessories</h2>
					<p>Collars, leashes and leads</p>

				</div>
				<!-- /.col-lg-4 -->


			</div>
			<!-- /.row -->
	</div>
	</div>
	</div>
			<%@include file="/WEB-INF/views/template/footer.jsp"%>