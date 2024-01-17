jQuery(function ($) {
    $(document).ready(function () {
        let init = async () => {
            getData("");
        }
        let getData = (url) => {
            let search = document.getElementById('search').value;
            if (!url) url = `/api/v1/user/search/{search}`;
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
                row += `<td>${v.username}</td>`
                row += `<td>${v.password}</td>`
                row += `<td>${v.phoneNumber}</td>`
                row += `<td>${v.email}</td>`
                row += `<td>${v.legalEntity}</td>`
                row += `<td>${v.location}</td>`
                row += `<td>${v.site}</td>`
                row += `<td>
                        <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                           title="Cập nhật user" href='/admin/user-edit?id=${v.id}'><i
                            class="fa fa-pencil-square-o" aria-hidden="true"></i>
                        </a>                   
                        <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                           title="Báo cáo công việc user" href='/admin/report-user?id=${v.id}'>
                            <i class="fa fa-clipboard" aria-hidden="true"></i>
                        </a>

                    </td>`
                row += `</tr>`
            })
            $('#listUser').empty().append(row);
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