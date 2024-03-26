<%@ page pageEncoding="utf-8" %>
<html>
    <head>
        <script src="js/jquery-3.3.1.min.js"></script>
        <script>
            $(function(){

                $.post('deptList',{},function(depts){

                    //将depts中的数据拼装在网页上。
                    for(var i=0;i<depts.length;i++){
                        var dept = depts[i] ;
                        $('#showBox').append('<dt>'+dept.dname+'</dt>');
                        for(var j=0;j<dept.emps.length;j++){
                            var emp = dept.emps[j] ;
                            $('#showBox').append('<dd>'+emp.ename+','+emp.sal+'</dd>');
                        }
                    }

                },'json');

            });
        </script>
    </head>
    <body>
        <h2>部门信息列表</h2>
        <dl id="showBox">

        </dl>
    </body>
</html>