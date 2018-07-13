<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="from/css/style.css" />
<link rel="stylesheet" type="text/css" href="from/css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="from/css/skin_/form.css" />
<link href="from/umeditor/themes/default/_css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="from/js/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript">
function AddOk(){
	var n_title = $("#n_title").val();
	var n_time = $("#n_time").val();
	var n_thing = $("#n_thing").val();
	var n_image = $("img_url").val();
	alert(n_title);
	var req_data = {};
	req_data["n_title"] = n_title;
	req_data["n_time"] = n_time;
	req_data["n_thing"] = n_thing;
	req_data["n_image"] = n_image;
	fajax("AddNewsServlet",req_data,function(data){
		window.location.href="NewsServlet";
	})
}
</script>
<title>基础信息</title>
</head>

<body>
<form action=AddNewsServlet method="post" enctype="multipart/form-data">
<div id="container">
	<div id="hd">
    </div>
    <div id="bd">
    	<div id="main">
            <h2 class="subfild">
            	<span>基本信息</span>
            </h2>
            <div class="subfild-content base-info">
            	<div class="kv-item ue-clear">
                	<label><span class="impInfo">*</span>帖子标题</label>
                	<div class="kv-item-content">
                		<input type="text" Name="n_title" placeholder="帖子标题">		
                    </div>
                    <span class="kv-item-tip">标题字数限制在35个字符</span>
                </div>
                <div class="kv-item ue-clear time">
                	<label><span class="impInfo">*</span>发布时间</label>
                	<div class="kv-item-content">
                    	<input type="text" name="n_time" placeholder="发布时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" >
                        <i class="time-icon"></i>
                    </div>
                   
                </div>
                <div class="kv-item ue-clear">
                	<label><span class="impInfo">*</span>缩略图</label>
					<input type="file" name="img_url" id="img_url">
                </div>
            </div>
            
            <h2 class="subfild">
            	<span>备注资料</span>
            </h2>
            
            <div class="subfild-content remarkes-info">
            	<div class="kv-item ue-clear">
                	<label><span class="impInfo">*</span>帖子内容</label>
                	<div class="kv-item-content">
                    	<textarea name="n_thing" placeholder="帖子内容" id="n_thing" style="width:800px;height:240px;"></textarea>
                    </div>
                </div>
            </div>
            
            <div class="buttons">
                <input class="button" type="submit" value="确认发布"/>
            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>
