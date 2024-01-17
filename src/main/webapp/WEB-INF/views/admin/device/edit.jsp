<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Chỉnh sửa nhân viên</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>

                <li>
                    <a href="#">Forms</a>
                </li>
                <li class="active">Form Elements</li>
            </ul><!-- /.breadcrumb -->

            <div class="nav-search" id="nav-search">
                <form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input"
                                           id="nav-search-input" autocomplete="off"/>
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
                </form>
            </div><!-- /.nav-search -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1>
                    Form Elements
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        Common form elements and layouts
                    </small>
                </h1>
            </div><!-- /.page-header -->

            <div class="row">
                <div class="col-xs-12">
                    <div id="message"></div>
                    <!-- PAGE CONTENT BEGINS -->
                    <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="newAccessTagId"> New Access Tag Id :</label>

                            <div class="col-sm-9">
                                <input type="text" id="newAccessTagId" name="newAccessTagId" value="" Class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="oldAccessTagId"> Old Access Tag Id :</label>

                            <div class="col-sm-9">
                                <input type="text" id="oldAccessTagId" name="oldAccessTagId" value="" Class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="assetNameModel"> Asset Name Model </label>

                            <div class="col-sm-9">
                                <input type="text" name="assetNameModel" id="assetNameModel" value=""
                                       Class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="quantity"> Quantity : </label>
                            <div class="col-sm-9">
                                <input type="text" name="quantity" id="quantity" value="" Class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="unitOfMeasurement"> Unit Of Measurement
                                : </label>
                            <div class="col-sm-9">
                                <input type="text" name="unitOfMeasurement" id="unitOfMeasurement" value=""
                                       Class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>

                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="assetType"> Asset Type :
                            </label>
                            <div class="col-sm-9">
                                <input type="text" name="assetType" id="assetType" value="" Class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="userId"> User Id
                            </label>
                            <div class="col-sm-9">
                                <input type="text" name="userId" id="userId" value="" Class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="day"> Day
                            </label>
                            <div class="col-sm-9">
                                <input type="text" name="day" id="day" value="" Class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="inventory"> Inventory
                            </label>
                            <div class="col-sm-9">
                                <input type="text" name="inventory" id="inventory" value="" Class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="space-4"></div>
                        <div class="clearfix form-actions">
                            <div class="col-md-offset-3 col-md-9">
                                <c:if test="${not empty id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Update
                                    </button>
                                </c:if>
                                <c:if test="${empty id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Create
                                    </button>
                                </c:if>
                                <input class="btn" type="reset">
                                </input>
                            </div>
                        </div>
                        <div class="hr hr-24"></div>
                        <input type="hidden" name="id" id="id" value="${id}"/>
                    </form:form>
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.page-content -->
        <ul class="pagination" id="pagination"></ul>
    </div>
</div>
<script type='text/javascript' src="/template/custom/admin/js/device/edit.js"></script>
</body>
</html>
