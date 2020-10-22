<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<head>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function() {
            $("#btn").click(function () {
                alert("aaaa.....");
                $.ajax({
                    url:"/spring/requestAjax",
                    type:"post",
                    data:'{"username":"zs","age":20}',
                    contentType:"application/json;"
                });
            });
        });
    </script>
</head>
<body>
<h2>hello springMVC.....</h2>
<a href="/spring/returnstring">returnstring</a>
<br>
<a href="/spring/modelAndView">modelAndView</a>
<br>
<a href="/spring/forwardvoid">forwardvoid</a>
<br>
<a href="/spring/forwardString">forwardString</a>
<br>
<a href="/spring/redirectvoid">redirectvoid</a>
<br>
<a href="/spring/redirectString">redirectString</a>
<br>


<form id="userForm" method="post" action="/spring/requestForm">
    <input type="text" name="username"/>
    <input type="text" name="age"/>
    <input type="text" name="birthday"/>
    <input type="submit" value="提交">
</form>

<button id="btn">提交</button>

<form id="fileForm" method="post" action="/spring/fileupload" enctype="multipart/form-data">
    <input type="file" name="upload"/>
    <input type="submit" value="文件提交">
</form>

<form id="fileForm1" method="post" action="/spring/fileupload2" enctype="multipart/form-data">
    <input type="file" name="upload"/>
    <input type="submit" value="跨服务起文件">
</form>
</body>
</html>
