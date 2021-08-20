<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="formUrl" value="/api/building"/>
<html>
<head>
    <title>Chỉnh sửa Tòa Nhà</title>
</head>
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
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa Tòa Nhà</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">

                    <form:form class="form-horizontal" role="form" id="formEdit" commandName="model">
                        <!-- PAGE CONTENT BEGINS -->

                        <!-- Row 1-->
                        <div class="col-sm-12 form-group">
                            <label>Building name</label>
                            <div class="col-sm-10 pull-right">
                                <form:input type="text" class="form-control" path="name"/>
                            </div>
                        </div>

                        <div class="col-sm-12 form-group">
                            <label>Manager</label>
                            <div class="col-sm-10 pull-right">
                                <form:input type="text" class="form-control" path="managerName"/>
                            </div>
                        </div>

                        <div class="col-sm-12 form-group">
                            <label>Distrit</label>
                            <div class="col-sm-10 pull-right">
                                <div class="dropdown">
                                    <form:select path="districtIDStr">
                                        <form:option value="" label="--- Chọn Quận ---"/>
                                        <form:options items="${district}" itemValue="id"
                                                      itemLabel="name"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>

                        <div class="space-4"></div>
                        <div class="col-sm-12 form-group">
                            <label>Commune</label>
                            <div class="col-sm-10 pull-right">
                                <input type="text" class="form-control">
                            </div>
                        </div>

                        <div class="space-4"></div>
                        <div class="col-sm-12 form-group">
                            <label>Street</label>
                            <div class="col-sm-10 pull-right">
                                <form:input type="text" class="form-control" path="street"/>
                            </div>
                        </div>

                        <div class="col-sm-12 form-group">
                            <label>Structure</label>
                            <div class="col-sm-10 pull-right">
                                <form:input type="text" class="form-control" path="structure"/>
                            </div>
                        </div>

                        <div class="col-sm-12 form-group">
                            <label>Basement Numbers</label>
                            <div class="col-sm-10 pull-right">
                                <form:input type="number" class="form-control" path="numberOfBasement"/>
                            </div>
                        </div>

                        <div class="col-sm-12 form-group">
                            <label>Area Floor</label>
                            <div class="col-sm-10 pull-right">
                                <form:input type="number" class="form-control" path="floorArea"/>
                            </div>
                        </div>


                        <div class="col-sm-12 form-group">
                            <label>Diration</label>
                            <div class="col-sm-10 pull-right">
                                <form:input type="text" class="form-control" path="direction"/>
                            </div>
                        </div>

                        <div class="col-sm-12 form-group">
                            <label>Rater</label>
                            <div class="col-sm-10 pull-right">
                                <form:input type="text" class="form-control" path="level"/>
                            </div>
                        </div>

                        <%--                    <div class="col-sm-12 form-group">--%>
                        <%--                        <label>Rent Area</label>--%>
                        <%--                        <div class="col-sm-10 pull-right">--%>
                        <%--                            <form:input class="form-control" path="rentArea"/>--%>
                        <%--                        </div>--%>
                        <%--                    </div>--%>

                        <div class="col-sm-12 form-group">
                            <label>Describe Area</label>
                            <div class="col-sm-10 pull-right">
                                    <%--                            <form:input type="text" class="form-control" path="rentAreaDescription"/>--%>
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-12 form-group">
                            <label>Cost rent</label>
                            <div class="col-sm-10 pull-right">
                                <input type="text" class="form-control">
                            </div>
                        </div>

                        <div class="col-sm-12 form-group">
                            <label>Service charge</label>
                            <div class="col-sm-10 pull-right">
                                <input type="number" class="form-control">
                            </div>
                        </div>

                        <div class=" col-sm-12 form-group">
                            <label>Cost Car</label>
                            <div class="col-sm-10 pull-right">
                                <input type="number" class="form-control">
                            </div>
                        </div>

                        <div class="col-sm-12 form-group">
                            <label>Cost motor</label>
                            <div class="col-sm-10 pull-right">
                                <input type="number" class="form-control">
                            </div>
                        </div>

                        <div class="col-sm-12 form-group">
                            <label>Overtime cost</label>
                            <div class="col-sm-10 pull-right">
                                <input type="number" class="form-control">
                            </div>
                        </div>

                        <div class="col-sm-12 form-group">
                            <label>Money electricity</label>
                            <div class="col-sm-10 pull-right">
                                <input type="number" class="form-control">
                            </div>
                        </div>


                        <div class="col-sm-12 form-group">
                            <label>Deposits</label>
                            <div class="col-sm-10 pull-right">
                                <input type="number" class="form-control">
                            </div>
                        </div>

                        <div class="col-sm-12 form-group">
                            <label>Payment</label>
                            <div class="col-sm-10 pull-right">
                                <input type="number" class="form-control">
                            </div>
                        </div>

                        <div class="col-sm-12 form-group">
                            <label>Duration rent</label>
                            <div class="col-sm-10 pull-right">
                                <input type="text" class="form-control">
                            </div>
                        </div>

                        <div class="col-sm-12 form-group">
                            <label>Manager Name</label>
                            <div class="col-sm-10 pull-right">
                                <input type="text" class="form-control">
                            </div>
                        </div>

                        <div class="col-sm-12 form-group">
                            <label>Building Types</label>
                            <form>
                                <div class="col-sm-9 pull-right">
                                    <form:checkboxes path="listType" items="${renttype}"
                                                     itemValue="code" itemLabel="name"/>
<%--                                    <label>--%>
<%--                                        <input type="checkbox" name="buildingTypes" value="GROUND_FLOOR">--%>
<%--                                        Ground floor--%>
<%--                                    </label>--%>
<%--                                    <label>--%>
<%--                                        <input type="checkbox" name="buildingTypes" value="WHOLE_HOUSE">--%>
<%--                                        Whole house--%>
<%--                                    </label>--%>
<%--                                    <label>--%>
<%--                                        <input type="checkbox" name="buildingTypes" value="FURNITURE">--%>
<%--                                        Furniture--%>
<%--                                    </label>--%>
                                </div>
                            </form>
                        </div>
<%--                        <div class="col-sm-12 pull-right">--%>
<%--                            <form:checkboxes path="listType" items="${renttype}"--%>
<%--                                             itemValue="code" itemLabel="name"/>--%>
<%--                        </div>--%>
                        <div class="clearfix form-group">
                            <div class="col-md-offset-8 col-sm-9">
                                <button class="btn btn-info" id="btnAddOrUpdateBuildings" type="button">
                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                    Submit
                                </button>

                                &nbsp; &nbsp; &nbsp;
                                <button class="btn" type="reset">
                                    <i class="ace-icon fa fa-undo bigger-110"></i>
                                    Reset
                                </button>
                            </div>
                        </div>
                        <form:hidden path="id" id="buildingId"/>
                    </form:form>
                </div>

            </div><!-- /.col -->
            <!--END page CONTENT-->
        </div><!-- ROW-->
    </div>
</div>
<script>
    $("#btnAddOrUpdateBuildings").click(function (event) {
        event.preventDefault();
        var formData = $("#formEdit").serializeArray();
        var dataArray = {};
        $.each(formData, function (i, v) {
            dataArray["" + v.name + ""] = v.value;
        });
        if ($('#buildingId').val() != "") {//update
            var buildingId = $('#buildingId').val();
            // var roleCode = dataArray['roleCode'];
            updateUser(dataArray, $('#buildingId').val());
            <%--if (roleCode != '') {--%>
            <%--    updateUser(dataArray, $('#userId').val());--%>
            <%--} else {--%>
            <%--    window.location.href = "<c:url value='/admin/user-edit-"+userId+"?message=role_require'/>";--%>
            <%--}--%>
        } else {//add
            $('#loading_image').show();
            addBuilding(dataArray);
            <%--var userName = dataArray['userName'];--%>
            <%--var roleCode = dataArray['roleCode'];--%>
            <%--if (userName != '' && roleCode != '') {--%>
            <%--    $('#loading_image').show();--%>
            <%--    addUser(dataArray);--%>
            <%--} else {--%>
            <%--    window.location.href = "<c:url value='/admin/user-edit?message=username_role_require'/>";--%>
            <%--}--%>
        }
    });

    $('#btnResetPassword').click(function (event) {
        event.preventDefault();
        $('#loading_image').show();
        resetPassword($('#userId').val());
    });

    function addBuilding(data) {
        $.ajax({
            url: '${formUrl}',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                $('#loading_image').hide();
               console.log('success');
            },
            error: function (res) {
                console.log('failed');
                console.log(res);
            }
        });
    }

    function updateUser(data, id) {
        $.ajax({
            url: '${formUrl}/' + id,
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                window.location.href = "<c:url value='/admin/user-edit-"+res.id+"?message=update_success'/>";
            },
            error: function (res) {
                window.location.href = "<c:url value='/admin/user-edit-"+id+"?message=error_system'/>";
            }
        });
    }

    function resetPassword(id) {
        $.ajax({
            url: '${formUrl}/password/' + id + '/reset',
            type: 'PUT',
            dataType: 'json',
            success: function (res) {
                $('#loading_image').hide();
                window.location.href = "<c:url value='/admin/user-edit-"+res.id+"?message=reset_password_success'/>";
            },
            error: function (res) {
                window.location.href = "<c:url value='/admin/user-edit-"+id+"?message=error_system'/>";
            }
        });
    }
</script>
</body>
</html>