<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <jsp:include page="../inc.jsp"></jsp:include>

    <script type="javascript">
        var myChart=$('demo');
        myChart.showLoading();
        $.get('${pageContext.request.contextPath}/arch/querydata', function (data) {
            myChart.hideLoading();
            echarts.util.each(data.children, function (datum, index) {
                index % 2 === 0 && (datum.collapsed = true);
            });

            myChart.setOption(option = {
                tooltip: {
                    trigger: 'item',
                    triggerOn: 'mousemove'
                },
                series: [
                    {
                        type: 'tree',

                        data: [data],

                        top: '1%',
                        left: '7%',
                        bottom: '1%',
                        right: '20%',

                        symbolSize: 7,

                        label: {
                            normal: {
                                position: 'left',
                                verticalAlign: 'middle',
                                align: 'right',
                                fontSize: 9
                            }
                        },

                        leaves: {
                            label: {
                                normal: {
                                    position: 'right',
                                    verticalAlign: 'middle',
                                    align: 'left'
                                }
                            }
                        },

                        expandAndCollapse: true,
                        animationDuration: 550,
                        animationDurationUpdate: 750
                    }
                ]
            });
        });
    </script>
    <title>Title</title>
</head>
<body>
<div class="easyui-layout" data-options="fit : true,border : false">
    <div data-options="region:'center',border:false">
        <div id="container">
            <p>图标demo</p>
            <div id="demo"></div>
        </div>
    </div>
</div>
</body>
</html>
