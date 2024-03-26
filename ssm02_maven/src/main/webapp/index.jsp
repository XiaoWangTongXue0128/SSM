<%@ page pageEncoding="utf-8" %>
<html>

    <script src="js/jquery-3.3.1.min.js"></script>

    <style>
        dt,dd{
            margin-top:8px;
            margin-bottom:8px;
        }
    </style>

    <script>

        $(function(){
            $('#btn').click(function(){
                $('#addBox').append('<dd>员工名称：<input name="ename" required="required" /> 员工工资：<input name="sal" required="required" /> <input type="button" class="deleteBtn" value="×" /></dd>');
                //为刚刚新增加那行的按钮(最后一个按钮)设置实践
                $('.deleteBtn:last').click(function(){
                    $(this).parent().remove();
                });
            });
        });

    </script>

    <body>
        <form action="saveDept" method="post">
            <dl id="addBox">
                <dt> <button>保存</button> <input id="btn" type="button" value="增加员工" /></dt>
                <dt>部门名称：<input name="dname" required="required" /> 部门位置：<input name="loc" required="required" /></dt>
                <dd>员工名称：<input name="ename" required="required" /> 员工工资：<input name="sal" required="required" /></dd>
              </dl>
        </form>

        <hr/>

        <a href="deptList.jsp">部门列表</a>
    </body>
</html>
