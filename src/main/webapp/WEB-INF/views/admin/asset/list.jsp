<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Chinh sua bai viet</title>
</head>
<body>
<div class="main-content">

    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <div id="message"></div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-responsive">
                                <form action="<c:url value="/admin/asset-search"/>" method="get" id="formSearch">
                                    <input type="text" placeholder="Search.." name="search" id="search" value="">
                                    <button type="submit" onclick="fun()" id="btnSearch">Submit
                                    </button>
                                </form>

                                <form action="<c:url value="/"/>" id="formSubmit" method="get">
                                    <div class="pull-right tableTools-container">
                                        <div class="dt-buttons btn-overlap btn-group">
                                            <a flag="info"
                                               class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                               data-toggle="tooltip"
                                               title='Thêm bài viết'
                                               href='/admin/asset-edit'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
                                            </a>
                                            <button id="btnDelete" type="button" onclick="warningBeforeDelete()"
                                                    class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                                    data-toggle="tooltip" title='Xóa bài viết' >>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
                                            </button>
                                        </div>
                                    </div>
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th><input type="checkbox" id="checkAll"></th>
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
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody id="listAsset">
                                        </tbody>
                                    </table>
                                    <ul class="pagination" id="pagination"></ul>
                                    <input type="hidden" value="" id="page" name="page">
                                    <input type="hidden" value="" id="limit" name="limit">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div><!-- /.main-content -->
<script type='text/javascript' src="/template/custom/admin/js/asset/list.js"></script>
<script type='text/javascript'>
    function warningBeforeDelete() {
        swal({
            title: "Mài có chắc chắn xóa nó không ?",
            text: "Thấy câu hỏi ở trên không ,ừ chỗ này giống nó đó ,trả lời đi!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-success",
            cancelButtonClass: "btn-danger",
            confirmButtonText: "Có, Con đồng ý xóa thưa ngài!",
            cancelButtonText: "Không , Con cần thời gian suy nghĩ!",
            closeOnConfirm: false,
            closeOnCancel: false
        }).then(function (isConfirm) {
            if (isConfirm) {
                var data = {};
                data ['ids'] = $('tbody input[type=checkbox]:checked').map(function () {
                    return $(this).val();
                }).get();
                deleteAsset(data);
            }
        });
    }

    function deleteAsset(data) {
        $.ajax({
            url: `/api/v1/user/delete-user`,
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                window.location.href = '/admin/asset-list?&message=delete_success';
            },
            error: function (error) {
                window.location.href = '/admin/asset-list?&message=error!';
            },
        });
    }
</script>
</body>
</html>



