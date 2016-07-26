<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>lcc_Luffy's blog</title>
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<!-- Begin page content -->
<div class="container">
    <div class="page-header">
        <h1>lcc_Luffy</h1>
    </div>
    <ul>
    <#list posts.content as post>
        <li>
            <a href="post/${post.id}"><h2>${post.title}</h2></a>
            <p>${post.content}</p>
        </li>
    </#list>
    </ul>
</div>

<footer class="footer">
    <div class="container">
        <p class="text-muted">©2016 fyunli</p>
    </div>
</footer>


<script src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>




