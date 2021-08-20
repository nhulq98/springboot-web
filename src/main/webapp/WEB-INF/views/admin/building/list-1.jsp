<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
<%--	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />--%>
<%--	<meta charset="utf-8" />--%>
<%--	<title>Dashboard - Ace Admin</title>--%>

<%--	<meta name="description" content="overview &amp; stats" />--%>
<%--	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />--%>


<%--	<!-- bootstrap & fontawesome -->--%>
<%--	<link rel="stylesheet" href="assets/css/bootstrap.min.css" />--%>
<%--	<link rel="stylesheet" href="assets/font-awesome/4.2.0/css/font-awesome.min.css" />--%>

<%--	<!-- page specific plugin styles -->--%>

<%--	<!-- text fonts -->--%>
<%--	<link rel="stylesheet" href="assets/fonts/fonts.googleapis.com.css" />--%>

<%--	<!-- ace styles -->--%>
<%--	<link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />--%>

<%--	<!--[if lte IE 9]>--%>
<%--			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />--%>
<%--		<![endif]-->--%>

<%--	<!--[if lte IE 9]>--%>
<%--		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />--%>
<%--		<![endif]-->--%>

<%--	<!-- inline styles related to this page -->--%>

<%--	<!-- ace settings handler -->--%>
<%--	<script src="assets/js/ace-extra.min.js"></script>--%>

<%--	<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->--%>

<%--	<!--[if lte IE 8]>--%>
<%--		<script src="assets/js/html5shiv.min.js"></script>--%>
<%--		<script src="assets/js/respond.min.js"></script>--%>
		<![endif]-->

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>
		<%--<spring:message code="label.user.list"/>--%>
		Danh sách Tòa Nhà
	</title>
</head>

<body class="no-skin">
<%--	<div id="navbar" class="navbar navbar-default">--%>
<%--		<script type="text/javascript">--%>
<%--			try {--%>
<%--				ace.settings.check('navbar', 'fixed')--%>
<%--			} catch (e) {}--%>
<%--		</script>--%>

<%--		<div class="navbar-container" id="navbar-container">--%>
<%--			<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">--%>
<%--				<span class="sr-only">Toggle sidebar</span>--%>

<%--				<span class="icon-bar"></span>--%>

<%--				<span class="icon-bar"></span>--%>

<%--				<span class="icon-bar"></span>--%>
<%--			</button>--%>

<%--			<div class="navbar-header pull-left">--%>
<%--				<a href="index.html" class="navbar-brand">--%>
<%--					<small>--%>
<%--						<i class="fa fa-leaf"></i>--%>
<%--						Building Admin--%>
<%--					</small>--%>
<%--				</a>--%>
<%--			</div>--%>

<%--			<div class="navbar-buttons navbar-header pull-right" role="navigation">--%>
<%--				<ul class="nav ace-nav">--%>
<%--					<li class="light-blue">--%>
<%--						<a data-toggle="dropdown" href="#" class="dropdown-toggle">--%>
<%--							<img class="nav-user-photo" src="assets/avatars/user.jpg" alt="Jason's Photo" />--%>
<%--							<span class="user-info">--%>
<%--								<small>Welcome,</small>--%>
<%--								Jason--%>
<%--							</span>--%>

<%--							<i class="ace-icon fa fa-caret-down"></i>--%>
<%--						</a>--%>

<%--						<ul--%>
<%--							class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">--%>
<%--							<li>--%>
<%--								<a href="#">--%>
<%--									<i class="ace-icon fa fa-cog"></i>--%>
<%--									Settings--%>
<%--								</a>--%>
<%--							</li>--%>

<%--							<li>--%>
<%--								<a href="profile.html">--%>
<%--									<i class="ace-icon fa fa-user"></i>--%>
<%--									Profile--%>
<%--								</a>--%>
<%--							</li>--%>

<%--							<li class="divider"></li>--%>

<%--							<li>--%>
<%--								<a href="#">--%>
<%--									<i class="ace-icon fa fa-power-off"></i>--%>
<%--									Logout--%>
<%--								</a>--%>
<%--							</li>--%>
<%--						</ul>--%>
<%--					</li>--%>
<%--				</ul>--%>
<%--			</div>--%>
<%--		</div><!-- /.navbar-container -->--%>
<%--	</div>--%>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {}
		</script>

		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {}
					</script>

					<ul class="breadcrumb">
						<li>
							<i class="ace-icon fa fa-home home-icon"></i>
							<a href="#">Home</a>
						</li>
						<li class="active">Dashboard</li>
					</ul><!-- /.breadcrumb -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							Dashboard
							<small>
								<i class="ace-icon fa fa-angle-double-right"></i>
								overview &amp; stats
							</small>
						</h1>
					</div><!-- /.page-header -->

					<div class="row">
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">Search</h4>

								<div class="widget-toolbar">
									<a href="#" data-action="collapse">
										<i class="ace-icon fa fa-chevron-up"></i>
									</a>

									<!-- <a href="#" data-action="close">
										<i class="ace-icon fa fa-times"></i>
									</a> -->
								</div>
							</div>
							<div class="widget-body">
								<div class="widget-main">
									<div class="row">
										<div class="col-xs-12">
											<!-- PAGE CONTENT BEGINS -->
											<form class="form-horizontal" role="form" id="formEdit">

												<!-- Row 1-->
												<div class="col-sm-6">
													<div>
														<label for="buildingName">Building name</label>
														<input type="text" class="form-control" id="buildingName">
													</div>
												</div>
												<div class="col-sm-6">
													<div>
														<label for="floorErea">Floor Erea</label>
														<input type="number" class="form-control" id="floorErea">
													</div>
												</div>

												<!-- ROW 2-->

												<div class="col-sm-4">
													<div>
														<label for="name">Distrit</label>
														<!-- <input type="text" class="form-control" id="name"> -->
														<div class="dropdown">
															<button class="btn btn-primary btn-sm dropdown-toggle"
																type="button" data-toggle="dropdown">Choice Distrit
																<span class="caret"></span></button>
															<ul class="dropdown-menu">
																<li><a href="#">HTML</a></li>
																<li><a href="#">CSS</a></li>
																<li><a href="#">JavaScript</a></li>
															</ul>
														</div>

													</div>
												</div>
												<div class="col-sm-4">
													<div>
														<label for="ward">Ward</label>
														<input type="text" class="form-control" id="ward">
													</div>
												</div>
												<div class="col-sm-4">
													<div>
														<label for="street">Street</label>
														<input type="text" class="form-control" id="street">
													</div>
												</div>
												<!-- ROW 3-->
												<div class="col-sm-4">
													<div>
														<label for="basementNumber">Basement Number</label>
														<input type="number" class="form-control" id="basementNumber">
													</div>
												</div>
												<div class="col-sm-4">
													<div>
														<label for="direction">Direction</label>
														<input type="number" class="form-control" id="direction">
													</div>
												</div>
												<div class="col-sm-4">
													<div>
														<label for="rate">Rate</label>
														<input type="text" class="form-control" id="rate">
													</div>
												</div>
												<!-- ROW 4-->
												<div class="col-sm-3">
													<div>
														<label for="areaFrom">Area From</label>
														<input type="number" class="form-control" id="areaFrom">
													</div>
												</div>


												<div class="col-sm-3">
													<div>
														<label for="areaTo">Area to</label>
														<input type="number" class="form-control" id="areaTo">
													</div>
												</div>
												<div class="col-sm-3">
													<div>
														<label for="costRentFrom">Cost Rent from</label>
														<input type="number" class="form-control" id="costRentFrom">
													</div>
												</div>


												<div class="col-sm-3">
													<div>
														<label for="costRentTo">Cost Rent to</label>
														<input type="number" class="form-control" id="costRentTo">
													</div>
												</div>
												<!-- ROW 5-->
												<div class="col-sm-4">
													<div>
														<label for="managerName">Manager name</label>
														<input type="number" class="form-control" id="managerName">
													</div>
												</div>

												<div class="col-sm-4">
													<div>
														<label for="managerPhoneNumber">Manager phone number</label>
														<input type="number" class="form-control"
															id="managerPhoneNumber">
													</div>
												</div>

												<div class="col-sm-4">
													<div>
														<label for="name">choice staff assitant</label>
														<!-- <input type="text" class="form-control" id="name"> -->
														<div class="dropdown">
															<button class="btn btn-primary btn-sm dropdown-toggle"
																type="button" data-toggle="dropdown">Choice Staff
																<span class="caret"></span></button>
															<ul class="dropdown-menu">
																<li><a href="#">HTML</a></li>
																<li><a href="#">CSS</a></li>
																<li><a href="#">JavaScript</a></li>
															</ul>
														</div>
													</div>
												</div>
												<div class="col-sm-12 pull-right">
													<form>
														<div class="checkbox">
															<label><input type="checkbox" value="">Ground floor</label>
															<label><input type="checkbox" value="">Whole house</label>
															<label><input type="checkbox" value="">Furniture</label>
														</div>

													</form>
												</div>

												<div class="col-sm-12">
													<div class="pull-left" style="margin-top: 5px;">
														<button type="button"
															class="btn btn-primary btn-sm btn-block">Search</button>
													</div>
												</div>


												<!--END page CONTENT-->
											</form>
										</div><!-- /.col -->
									</div>


								</div>
							</div>
						</div>
					</div><!-- /.row -->

					<div class="row">
						<div class="col-sm-6">
							<!-- <span class="bigger-110"></span> -->
						</div><!-- /.span -->

						<div class="col-sm-6 no-padding-right">
							<span class="pull-right inline">
								<span class="btn-toolbar inline middle no-margin">
									<span id="chosen-multiple-style" data-toggle="buttons" class="btn-group no-margin">
										<button type="button" class="btn btn-success btn-sm" data-toggle="tooltip"
											title="Add Building!"><i class="fa fa-plus-circle"
												aria-hidden="true"></i></button>
										<button type="button" class="btn btn-danger btn-sm" data-toggle="tooltip"
											title="Delete Buildings!"> <i class="fa fa-trash"></i></button>


									</span>
								</span>
							</span>
						</div><!-- /.span -->
					</div>

					<!-- PAGE CONTENT BEGINS -->
					</br>
					<div class="row">
						<table id="simple-table" class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center">
										<label class="pos-rel">
											<input type="checkbox" class="ace" />
											<span class="lbl"></span>
										</label>
									</th>
									<th>Product Name</th>
									<th>Adress</th>
									<th>Manager Name</th>

									<th>Phone number</th>
									<th>Floor Erea</th>

									<th> Rent cost </th>
									<th> servive Charge </th>
									<th> manipulation </th>
								</tr>
							</thead>

							<tbody>
								<tr>
									<td class="center">
										<label class="pos-rel">
											<input type="checkbox" class="ace" />
											<span class="lbl"></span>
										</label>
									</td>

									<td> Product Name</td>
									<td>$45</td>
									<td class="hidden-480">3,330</td>
									<td>Feb 12</td>

									<td class="hidden-480">
										<span class="label label-sm label-warning">Expiring</span>
									</td>


									<td>Add Edit </td>
									<td>Add Edit </td>
									<td>
										<button onclick="assingmentBuilding()" type="button"
											class="btn btn-success btn-sm popup" onclick="myFunction()"
											data-toggle="tooltip; modal" title="Delevery Buildings!"
											data-target="#myModal">
											<i class="ace-icon fa fa-tasks"></i>
										</button>
										<button type="button" class="btn btn-info btn-sm" data-toggle="tooltip"
											title="Delevery Buildings!"> <i
												class="ace-icon fa fa-pencil bigger-120"></i></button>
										<button type="button" class="btn btn-default btn-sm" data-toggle="tooltip"
											title="Delete Buildings!"> <img width="12" src="edit_80px.png" /></button>

									</td>
								</tr>
							</tbody>
						</table>

					</div><!-- /.span -->
				</div><!-- /.row -->

			</div><!-- /.page-content -->
		</div><!-- /.main-content -->
	</div>

	<div class="footer">
		<div class="footer-inner">
			<div class="footer-content">
				<span class="bigger-120">
					<span class="blue bolder">Ace</span>
					Application &copy; 2013-2014
				</span>

				&nbsp; &nbsp;
				<span class="action-buttons">
					<a href="#">
						<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
					</a>

					<a href="#">
						<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
					</a>

					<a href="#">
						<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
					</a>
				</span>
			</div>
		</div>
	</div>

	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
		<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	</a>
	</div><!-- /.main-container -->

	<!-- basic scripts -->

	<div class="container">

		<!-- Modal -->
		<div class="modal fade" id="assingmentBuildingModal" role="dialog">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">List Employee</h4>
					</div>
					<div class="modal-body">
						<p>Some text in the modal.</p>
					</div>
					<div class="modal-footer">

						<button type="button" class="btn btn-default" data-dismiss="modal">Assingment Building</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

	</div>

	<!--BEGIN Script dialog -->
	<script>
		function assingmentBuilding() {
			openModalAssingmentBuilding();
		}

		function openModalAssingmentBuilding() {
			$('#assingmentBuildingModal').modal();
		}
	</script>
	<!--END Script dialog -->

	<!--[if !IE]> -->
	<script src="assets/js/jquery.2.1.1.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->

	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery || document.write("<script src='assets/js/jquery.min.js'>" + "<" + "/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement) document.write(
			"<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
	</script>
	<script src="assets/js/bootstrap.min.js"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
	<script src="assets/js/jquery-ui.custom.min.js"></script>
	<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="assets/js/jquery.easypiechart.min.js"></script>
	<script src="assets/js/jquery.sparkline.min.js"></script>
	<script src="assets/js/jquery.flot.min.js"></script>
	<script src="assets/js/jquery.flot.pie.min.js"></script>
	<script src="assets/js/jquery.flot.resize.min.js"></script>

	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function ($) {form-group
			$('.easy-pie-chart.percentage').each(function () {
				var $box = $(this).closest('.infobox');
				var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') :
					'rgba(255,255,255,0.95)');
				var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
				var size = parseInt($(this).data('size')) || 50;
				$(this).easyPieChart({
					barColor: barColor,
					trackColor: trackColor,
					scaleColor: false,
					lineCap: 'butt',
					lineWidth: parseInt(size / 10),
					animate: /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()) ? false : 1000,
					size: size
				});
			})

			$('.sparkline').each(function () {
				var $box = $(this).closest('.infobox');
				var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
				$(this).sparkline('html', {
					tagValuesAttribute: 'data-values',
					type: 'bar',
					barColor: barColor,
					chartRangeMin: $(this).data('min') || 0
				});
			});


			//flot chart resize plugin, somehow manipulates default browser resize event to optimize it!
			//but sometimes it brings up errors with normal resize event handlers
			$.resize.throttleWindow = false;

			var placeholder = $('#piechart-placeholder').css({
				'width': '90%',
				'min-height': '150px'
			});
			var data = [{
					label: "social networks",
					data: 38.7,
					color: "#68BC31"
				},
				{
					label: "search engines",
					data: 24.5,
					color: "#2091CF"
				},
				{
					label: "ad campaigns",
					data: 8.2,
					color: "#AF4E96"
				},
				{
					label: "direct traffic",
					data: 18.6,
					color: "#DA5430"
				},
				{
					label: "other",
					data: 10,
					color: "#FEE074"
				}
			]

			function drawPieChart(placeholder, data, position) {
				$.plot(placeholder, data, {
					series: {
						pie: {
							show: true,
							tilt: 0.8,
							highlight: {
								opacity: 0.25
							},
							stroke: {
								color: '#fff',
								width: 2
							},
							startAngle: 2
						}
					},
					legend: {
						show: true,
						position: position || "ne",
						labelBoxBorderColor: null,
						margin: [-30, 15]
					},
					grid: {
						hoverable: true,
						clickable: true
					}
				})
			}
			drawPieChart(placeholder, data);

			/**
			we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
			so that's not needed actually.
			*/
			placeholder.data('chart', data);
			placeholder.data('draw', drawPieChart);


			//pie chart tooltip example
			var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo(
				'body');
			var previousPoint = null;

			placeholder.on('plothover', function (event, pos, item) {
				if (item) {
					if (previousPoint != item.seriesIndex) {
						previousPoint = item.seriesIndex;
						var tip = item.series['label'] + " : " + item.series['percent'] + '%';
						$tooltip.show().children(0).text(tip);
					}
					$tooltip.css({
						top: pos.pageY + 10,
						left: pos.pageX + 10
					});
				} else {
					$tooltip.hide();
					previousPoint = null;
				}

			});

			/////////////////////////////////////
			$(document).one('ajaxloadstart.page', function (e) {
				$tooltip.remove();
			});




			var d1 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.5) {
				d1.push([i, Math.sin(i)]);
			}

			var d2 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.5) {
				d2.push([i, Math.cos(i)]);
			}

			var d3 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.2) {
				d3.push([i, Math.tan(i)]);
			}


			var sales_charts = $('#sales-charts').css({
				'width': '100%',
				'height': '220px'
			});
			$.plot("#sales-charts", [{
					label: "Domains",
					data: d1
				},
				{
					label: "Hosting",
					data: d2
				},
				{
					label: "Services",
					data: d3
				}
			], {
				hoverable: true,
				shadowSize: 0,
				series: {
					lines: {
						show: true
					},
					points: {
						show: true
					}
				},
				xaxis: {
					tickLength: 0
				},
				yaxis: {
					ticks: 10,
					min: -2,
					max: 2,
					tickDecimals: 3
				},
				grid: {
					backgroundColor: {
						colors: ["#fff", "#fff"]
					},
					borderWidth: 1,
					borderColor: '#555'
				}
			});


			$('#recent-box [data-rel="tooltip"]').tooltip({
				placement: tooltip_placement
			});

			function tooltip_placement(context, source) {
				var $source = $(source);
				var $parent = $source.closest('.tab-content')
				var off1 = $parent.offset();
				var w1 = $parent.width();

				var off2 = $source.offset();
				//var w2 = $source.width();

				if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';
				return 'left';
			}


			$('.dialogs,.comments').ace_scroll({
				size: 300
			});


			//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
			//so disable dragging when clicking on label
			var agent = navigator.userAgent.toLowerCase();
			if ("ontouchstart" in document && /applewebkit/.test(agent) && /android/.test(agent))
				$('#tasks').on('touchstart', function (e) {
					var li = $(e.target).closest('#tasks li');
					if (li.length == 0) return;
					var label = li.find('label.inline').get(0);
					if (label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation();
				});

			$('#tasks').sortable({
				opacity: 0.8,
				revert: true,
				forceHelperSize: true,
				placeholder: 'draggable-placeholder',
				forcePlaceholderSize: true,
				tolerance: 'pointer',
				stop: function (event, ui) {
					//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
					$(ui.item).css('z-index', 'auto');
				}
			});
			$('#tasks').disableSelection();
			$('#tasks input:checkbox').removeAttr('checked').on('click', function () {
				if (this.checked) $(this).closest('li').addClass('selected');
				else $(this).closest('li').removeClass('selected');
			});


			//show the dropdowns on top or bottom depending on window height and menu position
			$('#task-tab .dropdown-hover').on('mouseenter', function (e) {
				var offset = $(this).offset();

				var $w = $(window)
				if (offset.top > $w.scrollTop() + $w.innerHeight() - 100)
					$(this).addClass('dropup');
				else $(this).removeClass('dropup');
			});

		})
	</script>
</body>

</html>
