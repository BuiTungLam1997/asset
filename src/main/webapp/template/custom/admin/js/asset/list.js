jQuery(function ($) {
    $(document).ready(function () {
        let init = async () => {
            getData("");
        }
        let getData = (url) => {
            if (!url) url = `/api/v1/asset/list`;
            $.ajax({
                url: url,
                type: 'GET',
                contentType: 'application/json',
                dataType: 'json',
                success: function (result) {
                    mapTable(result.data);
                    paging(url, result.totalPages, result.currentPage, result.limit);
                },
            });
        }
        let mapTable = (data) => {
            let row = '';
            $.each(data, function (i, v) {
                row += `<tr>`
                row += ` <td><input type="checkbox" id="checkbox_${v.id}"
                               value="${v.id}">`
                row += `</td>`
                row += `<td>${v.id}</td>`
                row += `<td>${v.newAccessTagId}</td>`
                row += `<td>${v.oldAccessTagId}</td>`
                row += `<td>${v.assetNameModel}</td>`
                row += `<td>${v.quantity}</td>`
                row += `<td>${v.unitOfMeasurement}</td>`
                row += `<td>${v.assetType}</td>`
                row += `<td>${v.userId}</td>`
                row += `<td>${v.day}</td>`
                row += `<td>${v.inventory}</td>`
                row += `<td>${v.status}</td>`
                row += `<td>${v.mac}</td>`
                row += `<td>${v.serviceProvider}</td>`
                row += `<td>${v.statusUpdate}</td>`
                row += `<td>${v.purchaseDate}</td>`
                row += `<td>${v.expectedLifeCycle}</td>`
                row += `<td>${v.originalCost}</td>`
                row += `<td>${v.depreciationValue}</td>`
                row += `<td>${v.expiredLifeCycleDate}</td>`
                row += `<td>${v.account}</td>`
                row += `<td>${v.sapId}</td>`
                row += `<td>${v.remainingAssetValue}</td>`
                row += `<td>
                        <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                           title="Cập nhật user" href='/admin/asset-edit?id=${v.id}'><i
                            class="fa fa-pencil-square-o" aria-hidden="true"></i>
                        </a>                   
                        <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                           title="Báo cáo công việc user" href='/admin/report-asset?id=${v.id}'>
                            <i class="fa fa-clipboard" aria-hidden="true"></i>
                        </a>

                    </td>`
                row += `</tr>`
            })
            $('#listAsset').empty().append(row);
        };

        let paging = (url, totalPages, currentPage, limit) => {
            $(function () {
                window.pagObj = $('#pagination').twbsPagination({
                    totalPages: totalPages,
                    visiblePages: limit,
                    startPage: currentPage,
                    onPageClick: function (event, page) {
                        if (currentPage !== page) {
                            getData(`${url}?page=${page}&limit=${limit}`);
                            currentPage = page;
                        }
                    }
                });
            });
        };

        init();
    });
});