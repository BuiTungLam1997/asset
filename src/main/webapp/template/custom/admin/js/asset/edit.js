jQuery(function ($) {
    $(document).ready(function () {
        let init = async () => {
            getData("");
        }
        init();
    });
    let getData = (url) => {
        let id = document.getElementById(`id`).value;
        if (!url) url = `/api/v1/asset/get/${id}`;
        $.ajax({
            url: url,
            type: 'GET',
            contentType: 'application/json',
            dataType: 'json',
            success: function (result) {
                mapTable(result.data);
                responseMessage(result.status, result.message);
            },
        });
    }

    let responseMessage = (status, message) => {
        let row = ``;
        if (status === '200') {
            row += `<div class="alert alert-success">`;
            row += ` <a>${message}</a>`;
            row += `</div>`;
        } else if (status !== '200') {
            row += `<div class="alert alert-danger">`;
            row += `<a>${message}</a>`;
            row += `</div>`;
        }
        $('#message').empty().append(row);
    }
    let mapTable = (data) => {
        $('#newAccessTagId').val(data.newAccessTagId);
        $('#oldAccessTagId').val(data.oldAccessTagId);
        $('#assetNameModel').val(data.assetNameModel);
        $('#quantity').val(data.quantity);
        $('#unitOfMeasurement').val(data.unitOfMeasurement);
        $('#assetType').val(data.assetType);
        $('#userId').val(data.userId);
        $('#day').val(data.day);
        $('#inventory').val(data.inventory);
    };

    $(".alert").delay(2000).slideUp(200, function () {
        $(this).alert('close');
    });

    $('#btnAdd').click(function (e) {
        e.preventDefault();
        const formData = $('#formGroup').serializeArray();
        const data = {};
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
        data ['userIds'] = $('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
    });

    $('#btnAddOrUpdateNew').click(function (e) {
        let id = document.getElementById(`id`).value;
        e.preventDefault();
        const formData = $('#formSubmit').serializeArray();
        const data = {};
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
        if (!id) {
            add(data)
        } else {
            update(data);
        }
    });

    function update(data) {
        let id = document.getElementById(`id`).value;
        $.ajax({
            url: '/api/v1/asset/update-asset',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = '/admin/asset-list?&message=update_success';
            },
            error: function (error) {
                window.location.href = '/admin/asset-edit/{id}?message=error_system';
            },
        });
    }

    function add(data) {
        $.ajax({
            url: '/api/v1/asset/create-asset',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = '/admin/asset-list?&message=insert_success';
            },
            error: function (error) {
                window.location.href = '/admin/asset-edit?message=error_system';
            },
        });
    }
});