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
                            <label class="col-sm-3 control-label no-padding-right" for="username"> Username </label>

                            <div class="col-sm-9">
                                <input type="text" id="username" name="username" value="" Class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="password"> Password </label>

                            <div class="col-sm-9">
                                <input type="text" id="password" name="password" value="" Class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="phoneNumber"> Phone
                                Number </label>

                            <div class="col-sm-9">
                                <input type="text" name="phoneNumber" id="phoneNumber" value=""
                                       Class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="email"> Email : </label>
                            <div class="col-sm-9">
                                <input type="text" name="email" id="email" value="" Class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="legalEntity"> Legal Entity
                                : </label>
                            <div class="col-sm-9">
                                <input type="text" name="legalEntity" id="legalEntity" value=""
                                       Class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>

                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="location"> Location
                            </label>
                            <div class="col-sm-9">
                                <input type="text" name="location" id="location" value="" Class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="site"> Site
                            </label>
                            <div class="col-sm-9">
                                <input type="text" name="site" id="site" value="" Class="col-xs-10 col-sm-5"/>
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
        <%--    DANH SACH THIET BI DUNG TEN USER NAY    --%>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>New Access Tag Id</th>
                <th>Old Access Tag Id</th>
                <th>Asset Name Model</th>
                <th>Quantity</th>
                <th>Unit Of Measurement</th>
                <th>Asset Type</th>
                <th>User Id</th>
                <th>Day</th>
                <th>Inventory</th>
                <th>status</th>
                <th>mac</th>
                <th>serviceProvider</th>
                <th>statusUpdate</th>
                <th>purchaseDate</th>
                <th>expectedLifeCycle</th>
                <th>originalCost</th>
                <th>depreciationValue</th>
                <th>expiredLifeCycleDate</th>
                <th>account</th>
                <th>sapId</th>
                <th>remainingAssetValue</th>
            </tr>
            </thead>
            <tbody id="listAsset">
            </tbody>
        </table>
        <ul class="pagination" id="pagination"></ul>
    </div>
</div>
<script type='text/javascript' src="/template/custom/admin/js/user/edit.js"></script>
<script type='text/javascript' src="/template/custom/admin/js/asset/search.js"></script>
</body>
</html>
