<html>
<head>
    <meta charset="utf-8">
    <title>卖家后端管理</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-dismissable alert-success">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>
                    ${msg}!
                </h4> <strong>操作成功！</strong> <a href="${url}" class="alert-link">3s后自动跳转</a>
            </div>
        </div>
    </div>
</div>


<script>
    setTimeout('location.href="${url}"',3000);
</script>
</html>