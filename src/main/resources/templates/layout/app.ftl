<#macro app>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>lcc_luffy's blog</title>
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">lcc_luffy</a>
            <ul class="nav navbar-nav">
                <li><a href="/">Link</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/login">登陆</a></li>
                <li><a href="/register">注册</a></li>
            </ul>
        </div>
    </nav>

    <div class="page-header">
        <h1>lcc_luffy</h1>
    </div>
    <#nested>
    <footer class="footer">
        <div class="container">
            <p class="text-muted">©2016 lcc_luffy</p>
        </div>
    </footer>
    <script src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
</#macro>


