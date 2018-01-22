<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/mystyle.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<span style="display: none" id="handleSpanId">
		    <button type="button" class="btn btn-primary">
		    	<!-- btn btn-info -->
		    	<span class="glyphicon glyphicon-folder-open"  id="editProductId">编辑</span>
		    </button>
</span>

<!-- table容器 -->
<table id="producteTableId"></table>

<!-- 工具栏按钮 -->
<div id="tabToolBar">
    <button type="button" class="btn btn-success" onclick="AddProductInfo()">
        <span class="glyphicon glyphicon-plus">新增</span>
    </button>

    <button type="button" class="btn btn-danger">
        <span class="glyphicon glyphicon-scissors" onclick="delAll()">批量删除</span>
    </button>

</div>

<script type="text/javascript">

    //页面加载查询列表
    $("#producteTableId").bootstrapTable({
        url:"<%=request.getContextPath()%>/product/queryProductInfo.do",
        method:"post",
        striped: true,  	// 斑马线效果     默认false
        //只允许选中一行
        singleSelect:true,
        //选中行是不选中复选框或者单选按钮
        clickToSelect:true,
        showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        uniqueId: "productid",                 //每一行的唯一标识，一般为主键列
        showColumns: true,                  //是否显示所有的列
        showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 2,     //  最少留两列
        detailView: false,                  //是否显示父子表

        //发送到服务器的数据编码类型
        contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
        toolbar:'#tabToolBar',   //  工具定义位置
        columns:[
            {field:'',title:'选择',width:50,
                formatter:function(value,row,index){   //  格式化  当前单元格内容
                    return "<input type='checkbox' value="+row.productid+" name='ck'/>";
                }
            },
            {field:'productId',title:'产品ID',width:100},
            {field:'productName',title:'产品名称',width:100},
            {field:'productBrand',title:'品牌名称',width:100,sortable:true,
                formatter:function(value,row,index){
                    if(value==1){
                        return "联想";
                    }else if(value==2){
                        return "华硕";
                    }else if(value==3){
                        return "方正";
                    }else{
                        return "神舟";
                    }
                }
            },
            {field:'productPrice',title:'产品价格',width:100,sortable:true},
            {field:'productTime',title:'产品日期',width:100,
                /* formatter:function(value,row,index){//value 当前字段值  row当前行的数据  index当前行
                    var simfomat = new Date();
                    simfomat.setTime(value);   //转换时间
                    return  simfomat.toLocaleDateString();
                }  */
            },
            {field:'productType',title:'产品类型',width:100,
                formatter:function(value,row,index){
                    if(row.productType==1){
                        return "日化";
                    }else if (row.productType==2){
                        return "家电";
                    }else if(row.productType==3){
                        return "家具";
                    }else if(row.productType==4){
                        return "电脑";
                    }
                }
            },

            {field:'操作',title:'操作',width:100,align:"center",
                formatter:function(value,row,index){
                    $("#editProductId").attr("onclick","updateProInfoById("+row.productid+")");
                    $("#delProductId").attr("onclick","deletePro("+row.productid+")");
                    $("#exportWoedId").attr("onclick","exportWord("+row.productid+")");
                    return $("#handleSpanId").html();
                }
            },
        ],
        //传递参数（*）
        queryParams: function(params) {

            var whereParams = {
                /*
                    分页  自定义的参数         默认传 limit（展示几条）    offset（从第几条开始    起始条数）
                */
                "pageSize":params.limit,
                "start":params.offset,
                "productname":$("#productNameId").val(),
                "minTime":$("#minTime").val(),
                "maxTime":$("#maxTime").val(),
                "productbrand":$("#brandId").val(),
            }
            return whereParams;
        },
        //前台--排序字段
        //sortName:'proPrice',
        //sortOrder:'desc',
        //前台--搜索框
        search:true,
        //启动回车键做搜索功能
        searchOnEnterKey:true,
        //分页方式   后台请求的分页方式
        sidePagination:'server',
        pagination: true,                   //是否显示分页（*）
        pageNum: 1,                       //每页的记录行数（*）
        pageSize: 3,                       //每页的记录行数（*）
        pageList: [3, 6, 9,12],        //可供选择的每页的行数（*）
    });

    //条件查询
    function searchByCondition(){
        $("#producteTableId").bootstrapTable('refresh',{
            query:{
                "productname":$("#productNameId").val(),
                "minTime":$("#minTime").val(),
                "maxTime":$("#maxTime").val(),
                "productbrand":$("#brandId").val(),
            }
        })
    }

    //重置
    function resetForForm(){
        document.getElementById("cnditionFormId").reset();
        searchByCondition();
    }

    //新增
    function AddProductInfo(){
        dialog("<%=request.getContextPath()%>/product/toSaveOrUpdatePage.do","<%=request.getContextPath()%>/product/saveOrUpdate.do","新增","新增产品");
    }

    //定义一个弹出框
    function dialog(toPageUrl,handleUrl,title,labelTitle){
        var dialog = bootbox.dialog({
            title: title,
            message: getJspHtml(toPageUrl),   //调用方法
            buttons:{
                "save":{
                    label: labelTitle,
                    //自定义样式
                    className: "btn-success",
                    callback: function() {
                        $.ajax({
                            url:handleUrl,
                            type:'post',
                            data:$("#addProFormId").serialize(),
                            success:function(){
                                bootbox.alert("保存成功");
                                $("#producteTableId").bootstrapTable('refresh');
                            },
                            error:function(){
                                bootbox.alert("操作失败，请调试！");
                            }
                        });
                    }
                },
                "unSave":{
                    label: '取消',
                    //自定义样式
                    className: "btn-info",
                    callback: function() {
                        // return false;  //dialog不关闭
                    }
                }
            }
        });
    }


    //发送Ajax查询页面信息
    function getJspHtml(urlStr){
        var  jspHtml = "";
        $.ajax({
            url:urlStr,
            type:'post',
            //同步的ajax
            async:false,
            success:function(data){
                jspHtml = data;
            },
            error:function(){
                bootbox.alert("跳转页面出现系统错误！");
            }
        });
        return jspHtml;
    }

    //批量删除
    function delAll(){
        if($("[name='ck']:checked").length==0){
            alert("请至少选择一条数据");
        }else{
            var flag=confirm("您确认删除这"+$("[name='ck']:checked").length+"条信息吗？");
            if(flag){
                var ids="";
                $("[name='ck']:checked").each(
                    function(){
                        ids+=$(this).val()+",";
                    }
                )
            }
            $.ajax({
                url:"<%=request.getContextPath()%>/product/delProduct.do",
                type:"post",
                data:{"ids":ids},
                success:function(){
                    bootbox.alert("删除成功！");
                    $("#producteTableId").bootstrapTable('refresh');
                },
                error:function(){
                    alert("系统错误！");
                }
            })
        }
    }

    //修改
    function  updateProInfoById(id){
        dialog("<%=request.getContextPath()%>/product/toSaveOrUpdatePage.do?productid="+id,"<%=request.getContextPath()%>/product/saveOrUpdate.do","修改","修改产品信息");
    }
</script>
</body>
</html>