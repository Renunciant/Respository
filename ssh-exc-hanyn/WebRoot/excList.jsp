<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'excList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script>
  //上一页
    function periousPage(pageIndex){
         if(pageIndex == 1) {
           alert("已经到首页");
         return false;
      }
       document.getElementById("pageIndexID").value=pageIndex - 1;
       document.getElementById("pageForm").submit();
      }
  //下一页  
    function nextPage(pageIndex, pageTotal){
	     if(pageIndex == pageTotal) {
		  alert("已经到末页");
		 return false;
	  }
	   document.getElementById("pageIndexID").value=pageIndex + 1;
	   document.getElementById("pageForm").submit();
    }
  //首页
    function homePage(pageIndex){
      document.getElementById("pageIndexID").value=pageIndex;
      document.getElementById("pageForm").submit();  
    }
  //尾页
    function lastPage(pageIndex){
      document.getElementById("pageIndexID").value=pageIndex ;
	  document.getElementById("pageForm").submit();
    }
  //点击页数
    function currentPage(pageIndex){
      document.getElementById("pageIndexID").value=pageIndex;
      document.getElementById("pageForm").submit();
    }
  //queryPageSize
    function  queryPageSize(pageIndex){
      var pageSizeValue = document.getElementById("selectPageSizeID").value;
            alert(pageSizeValue);
      document.getElementById("pageSizeID").value = pageSizeValue;
      document.getElementById("pageForm").submit();
    }
</script>
  
  <script type="text/javascript">
   //下载图片
              function downAdd(headPhoto){
		            headPhoto = headPhoto.substr(7);
		       location.href = "downloadHeadPhotoAction.action?headImgFileName="+headPhoto ;
             }
             
  //批量删除
   function deleteAll(){
      var ids="";
      var fxk = document.getElementsByName("fxk");
      for(var i =0;i<fxk.length;i++){
        if(fxk[i].checked){
           ids+=fxk[i].value+",";
        }
     }
     ids.substring(0, ids.length-1);
     location.href="deleteAllAction.action?ids="+ids;
  }
  
  </script>

  <body>
  <form  action="queryExcAction.action" method="post" id="pageForm">
              <input type="hidden" name="pageFlag.pageIndex" id="pageIndexID" />
    	      <input type="hidden" name="pageFlag.pageSize" id="pageSizeID" value="${pageFlag.pageSize }" />
</form>
  <input type="button" value="批量删除" onclick="deleteAll()">
      异常管理系统
  <table border="1" width="600">
  <tr>
	<td>选择</td>
	<td>编号</td>
	<td>异常信息</td>
	<td>异常描述</td>
	<td>异常截图</td>
	<td>解决方法</td>
	<td>操作</td>
  </tr>
  <c:forEach items="${list}" var="a">
  <tr>
	<td><input type="checkbox" name="fxk" value="${a.excId}"></td>
	
	<td>${a.excId}</td>
	<td>${a.excInfo}</td>
	<td>${a.excCdes}</td>
	<td><img  alt="图片不存在" src="${a.imgUrl}" width="30"  height="30">
	      <input type="button" value="下载图片" onclick="downAdd('${a.imgUrl}')" /></td>
	<td>${a.excSolve}</td>
	<td>操作</td>
  </tr>
  </c:forEach>
  </table>
  <center>
         显示条数：<select name="pageFlag.pageSize" id="selectPageSizeID" onchange="queryPageSize()">
    				<option value="1" <c:if test="${pageFlag.pageSize == 1}">selected</c:if>>1</option>
    				<option value="2" <c:if test="${pageFlag.pageSize == 2}">selected</c:if>>2</option>
    				<option value="3" <c:if test="${pageFlag.pageSize == 3}">selected</c:if>>3</option>
    				<option value="6" <c:if test="${pageFlag.pageSize == 6}">selected</c:if>>6</option>
    				<option value="8" <c:if test="${pageFlag.pageSize == 8}">selected</c:if>>8</option>
    				<option value="12" <c:if test="${pageFlag.pageSize == 12}">selected</c:if>>12</option>
    		   </select>
        <a href="javascript:void(0);" onclick="homePage(1)">首页</a>
    	
    	<a href="javascript:void(0);" onclick="periousPage(${pageFlag.pageIndex})">上一页</a>
    	
    	<c:forEach items="${pageFlag.currentPageList}"  var="w" >
    	         
    	     <c:if test="${w==pageFlag.pageIndex}"> 
    	          <a href="javascript:void(0);"   onclick="currentPage(${w})"  style="color:red">${w}</a>
    	     </c:if>
    	     <c:if test="${w != pageFlag.pageIndex}">
    	     <a href="javascript:void(0);"   onclick="currentPage(${w})" >${w}</a> 
    	     </c:if>    
    	</c:forEach>
    	
    	<a href="javascript:void(0);" onclick="nextPage(${pageFlag.pageIndex}, ${pageFlag.pageTotal})">下一页</a>
    	
    	<a href="javascript:void(0);" onclick="lastPage(${pageFlag.pageTotal})">末页</a>
    	
    	当前第${pageFlag.pageIndex}页/共${pageFlag. pageTotal}页
    	剩余条数${pageFlag.dataResidue}/ 总记录数${pageFlag.dataTotal}
</center>
  </body>
</html>
