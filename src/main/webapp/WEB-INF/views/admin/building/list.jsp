<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="formUrl" value="/admin/building-list"/>
<%--<c:url var="formAjax" value="/api/user"/>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
        <%--        <spring:message code="label.user.list"/>--%>
        Danh sách Tòa nhà
    </title>
    <style type="text/css">
        .btn-size {
            width: 78px !important;
        }
        select#staffStr
    </style>
</head>

<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="<c:url value="/admin/home"/>">
                        <%--<spring:message code="label.home"/>--%>
                        Trang chủ
                    </a>
                </li>
                <li class="active">
                    <%--<spring:message code="label.user.list"/>--%>
                    Danh sách tòa nhà
                </li>
            </ul>
            <!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${messageResponse!=null}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <!-- PAGE CONTENT BEGINS -->
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="widget-box table-filter">
                                <div class="widget-header">
                                    <h4 class="widget-title">
                                        <%--<spring:message code="label.search"/>--%>
                                        Tìm kiếm
                                    </h4>
                                    <div class="widget-toolbar">
                                        <a href="#" data-action="collapse">
                                            <i class="ace-icon fa fa-chevron-up"></i>
                                        </a>
                                    </div>
                                </div>
                                <form:form commandName="model" action="${formUrl}" id="listForm" method="GET">
                                <div class="widget-body">
                                    <div class="widget-main">
                                        <div class="form-horizontal">
                                            <br class="form-group">
                                            <!-- Row 1-->
                                            <div class="col-sm-6">
                                                <div>
                                                    <label>Building name</label>
                                                    <form:input type="text" cssClass="form-control" path="name"/>
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div>
                                                    <label>Floor Erea</label>
                                                    <form:input type="number" cssClass="form-control"
                                                                path="floorArea"/>
                                                </div>
                                            </div>

                                            <!-- ROW 2-->
                                            <div class="col-sm-4" id="profile">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right">Distrit</label>
                                                    <div class="col-sm-9">
                                                        <form:select path="districtIDStr">
                                                            <form:option value="" label="--- Chọn Quận ---"/>
                                                            <form:options items="${district}" itemValue="id"
                                                                          itemLabel="name"/>
                                                        </form:select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div>
                                                    <label>Ward</label>
                                                    <form:input type="text" cssClass="form-control" path="ward"/>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div>
                                                    <label>Street</label>
                                                    <form:input type="text" cssClass="form-control" path="street"/>
                                                </div>
                                            </div>
                                            <!-- ROW 3-->
                                            <div class="col-sm-4">
                                                <div>
                                                    <label>Basement Number</label>
                                                    <form:input type="number" cssClass="form-control"
                                                                path="numberOfBasement"/>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div>
                                                    <label>Direction</label>
                                                    <form:input type="number" cssClass="form-control"
                                                                path="direction"/>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div>
                                                    <label>Level</label>
                                                    <form:input type="text" cssClass="form-control" path="level"/>
                                                </div>
                                            </div>
                                            <!-- ROW 4-->
                                            <div class="col-sm-3">
                                                <div>
                                                    <label>Area From</label>
                                                    <form:input type="number" cssClass="form-control"
                                                                path="rentAreaFrom"/>
                                                </div>
                                            </div>

                                            <div class="col-sm-3">
                                                <div>
                                                    <label for="rentAreaTo">Area to</label>
                                                    <form:input type="number" cssClass="form-control"
                                                                path="rentAreaTo"/>
                                                </div>
                                            </div>
                                            <div class="col-sm-3">
                                                <div>
                                                    <label for="rentPriceFrom">Cost Rent from</label>
                                                    <form:input type="number" cssClass="form-control"
                                                                path="rentPriceFrom"/>
                                                </div>
                                            </div>


                                            <div class="col-sm-3">
                                                <div>
                                                    <label for="rentPriceTo">Cost Rent to</label>
                                                    <form:input type="number" cssClass="form-control"
                                                                path="rentPriceTo"/>
                                                </div>
                                            </div>
                                            <!-- ROW 5-->
                                            <div class="col-sm-4">
                                                <div>
                                                    <label for="managerName">Manager name</label>
                                                    <form:input type="text" cssClass="form-control"
                                                                path="managerName"/>
                                                </div>
                                            </div>

                                            <div class="col-sm-4">
                                                <div>
                                                    <label for="managerPhone">Manager phone number</label>
                                                    <form:input type="number" cssClass="form-control"
                                                                path="managerPhone"/>
                                                </div>
                                            </div>
                                            <div class="profile">
                                                <div class="form-group">
                                                    <label class="col-sm-1 control-label no-padding-right">Nhân
                                                        Viên </label>
                                                    <div class="col-sm-9">
                                                        <form:select path="staffStr">
                                                            <form:option value="" label="--- Chọn nhân viên ---"/>
                                                            <form:options items="${staff}" itemValue="id"
                                                                          itemLabel="fullName"/>
                                                        </form:select>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-sm-12 pull-right">
                                                <form:checkboxes path="listType" items="${renttype}"
                                                                 itemValue="code" itemLabel="name"/>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label"></label>
                                                <div class="col-sm-8">
                                                    <button id="btnSearch" type="button"
                                                            class="btn btn-sm btn-success">
                                                            <%--spring:message code="label.search"/>--%>
                                                        Tìm kiếm
                                                        <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </form:form>
                            <div class="table-btn-controls">
                                <div class="pull-right tableTools-container">
                                    <div class="dt-buttons btn-overlap btn-group">
                                        <a flag="info"
                                           class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                           data-toggle="tooltip"
                                        <%--title='<spring:message code="label.user.add"/>'--%>
                                           title="Thêm Tòa Nhà"
                                           href='<c:url value="/admin/building-edit"/>'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
                                        </a>
                                        <button id="btnDelete" type="button" disabled
                                                class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                                data-toggle="tooltip"
                                                title="Xóa bài viết" onclick="warningBeforeDelete()">
															<span>
																<i class="fa fa-trash-o bigger-110 pink"></i>
															</span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-responsive">
                                <display:table name="model.listResult" cellspacing="0" cellpadding="0"
                                               requestURI="${formUrl}" partialList="true" sort="external"
                                               size="${model.totalItems}" defaultsort="2" defaultorder="ascending"
                                               id="tableList" pagesize="${model.maxPageItems}"
                                               export="false"
                                               class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                               style="margin: 3em 0 1.5em;">
                                    <display:column title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell"
                                                    headerClass="center select-cell">
                                        <fieldset>
                                            <input type="checkbox" name="checkList" value="${tableList.id}"
                                                   id="checkbox_${tableList.id}" class="check-box-element"/>
                                        </fieldset>
                                    </display:column>
                                    <display:column headerClass="text-left" property="createdDate" title="ngày"/>
                                    <display:column headerClass="text-left" property="name"
                                                    title="Tên Sản Phẩm"/>
                                    <display:column headerClass="text-left" property="address" title="Địa Chỉ"/>
                                    <display:column headerClass="text-left" property="managerName"
                                                    title="Tên Quản Lý"/>
                                    <display:column headerClass="text-left" property="managerPhone"
                                                    title="Số Điện Thoại"/>
                                    <display:column headerClass="text-left" property="floorArea" title="DT Sàn"/>
                                    <display:column headerClass="text-left" title="DT Trống"/>
                                    <display:column headerClass="text-left" property="rentPrice" title="Giá Thuê"/>
                                    <display:column headerClass="text-left" property="serviceFee"
                                                    title="Phí Dịch Vụ"/>
                                    <display:column headerClass="text-left" title="Phí MG"/>
                                    <display:column headerClass="col-actions" title="Thao tác">
                                        <button onclick="assingmentBuilding()" type="button"
                                                class="btn btn-success btn-sm popup" onclick="myFunction()"
                                                data-toggle="tooltip; modal" title="Delevery Buildings!"
                                                data-target="#myModal">
                                            <i class="ace-icon fa fa-tasks"></i>
                                        </button>
                                        <button type="button" class="btn btn-info btn-sm"
                                                data-toggle="tooltip"
                                                title="Edit Buildings!"><i
                                                class="ace-icon fa fa-pencil bigger-120"></i>
                                        </button>
                                        <button id="btnDelete" type="button" disabled
                                                class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                                data-toggle="tooltip"
                                                title="Xóa Tòa Nhà" onclick="warningBeforeDelete()">
															<span>
																<i class="fa fa-trash-o bigger-110 pink"></i>
															</span>
                                        </button>
                                        <%--                                            <button type="button" class="btn btn-default btn-sm"--%>
                                        <%--                                                    data-toggle="tooltip"--%>
                                        <%--                                                    title="Delete Buildings!"><img width="12"--%>
                                        <%--                                                                                   src="edit_80px.png"/>--%>
                                        </button>
                                        <%--                                            <c:if test="${tableList.roleCode != 'ADMIN'}">--%>
                                        <%--                                                &lt;%&ndash;                                                <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"&ndash;%&gt;--%>
                                        <%--                                                &lt;%&ndash;                                                   title="Cập nhật người dùng"&ndash;%&gt;--%>
                                        <%--                                                &lt;%&ndash;                                                   href='<c:url value="/admin/user-edit-${tableList.id}"/>'>&ndash;%&gt;--%>
                                        <%--                                                &lt;%&ndash;                                                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i>&ndash;%&gt;--%>
                                        <%--                                                &lt;%&ndash;                                                </a>&ndash;%&gt;--%>

                                        <%--                                                <td>--%>
                                        <%--                                                    <button onclick="assingmentBuilding()" type="button"--%>
                                        <%--                                                            class="btn btn-success btn-sm popup" onclick="myFunction()"--%>
                                        <%--                                                            data-toggle="tooltip; modal" title="Delevery Buildings!"--%>
                                        <%--                                                            data-target="#myModal">--%>
                                        <%--                                                        <i class="ace-icon fa fa-tasks"></i>--%>
                                        <%--                                                    </button>--%>
                                        <%--                                                    <button type="button" class="btn btn-info btn-sm"--%>
                                        <%--                                                            data-toggle="tooltip"--%>
                                        <%--                                                            title="Delevery Buildings!"><i--%>
                                        <%--                                                            class="ace-icon fa fa-pencil bigger-120"></i></button>--%>
                                        <%--                                                    <button type="button" class="btn btn-default btn-sm"--%>
                                        <%--                                                            data-toggle="tooltip"--%>
                                        <%--                                                            title="Delete Buildings!"><img width="12"--%>
                                        <%--                                                                                           src="edit_80px.png"/>--%>
                                        <%--                                                    </button>--%>

                                        <%--                                                </td>--%>
                                        <%--                                            </c:if>--%>
                                        <%--                                            <c:if test="${tableList.roleCode == 'ADMIN'}">--%>
                                        <%--                                                <p>Không đươc thao tác</p>--%>
                                        <%--                                            </c:if>--%>
                                    </display:column>
                                </display:table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


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
                        <display:table name="staff" cellspacing="0" cellpadding="0"
                                       requestURI="${formUrl}" partialList="true" sort="external"
                                       size="${model.totalItems}" defaultsort="2" defaultorder="ascending"
                                       id="tableList" pagesize="${model.maxPageItems}"
                                       export="false"
                                       class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                       style="margin: 3em 0 1.5em;">
                            <display:column title="Chọn nhân viên" class="center select-cell"
                                            headerClass="center select-cell">
                                <fieldset>
                                    <input type="checkbox" name="checkList" value="${tableList.id}"
                                           id="checkbox_${tableList.id}" class="check-box-element"/>
                                </fieldset>
                            </display:column>
                            <display:column headerClass="text-left" value="id" property="fullName"
                                            title="Tên Nhân Viên"/>
                        </display:table>
                        <%--                                        <form:checkboxes path="staffAssignment" items="${staff}"--%>
                        <%--                                                         itemValue="id" itemLabel="fullName"/>--%>
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

    <script type="text/javascript">
        $(document).ready(function () {
            var someJsVar = "<c:out value='${addOrEditNews}'/>";
            $('#btnSearch').click(function () {
                $('#listForm').submit();
            });
        });

        function warningBeforeDelete() {
            showAlertBeforeDelete(function () {
                event.preventDefault();
                var dataArray = $('tbody input[type=checkbox]:checked').map(function () {
                    return $(this).val();
                }).get();
                deleteUser(dataArray);
            });
        }

        function deleteUser(data) {
            $.ajax({
                url: '${formAjax}/',
                type: 'DELETE',
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (res) {
                    window.location.href = "<c:url value='/admin/user-list?message=delete_success'/>";
                },
                error: function (res) {
                    console.log(res);
                    window.location.href = "<c:url value='/admin/user-list?message=error_system'/>";
                }
            });
        }
    </script>
</body>

</html>