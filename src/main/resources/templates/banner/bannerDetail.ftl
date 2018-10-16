<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <#include "../inc/header.ftl">
        <script>
            $(document).ready(function(){
                $("#altPc").click(function(){
                    var bannerId = $("#altPc").attr("bannerId");
                    alert(bannerId);
                    var d = dialog({
                        title: '上传',
                        content: '<form id="uploadPicForm" action="' + WEB_SERVER + 'web/banner/uploadPc" method="post" enctype="multipart/form-data">' +
                                '<input type="hidden" name="bannerId" value="' + bannerId + '">' +
                                '<input type="file" name="picFile"></form>',
                        cancelValue: '取消',
                        cancel: function () {
                        },
                        okValue: '确定',
                        ok: function () {
                            $('#uploadPicForm').submit();
                            return false;
                        }

                    });
                    d.show();
                });
            });

        </script>
</head>
<body class="page-body">
<div class="page-container">
    <#assign nav='audioLibs' subNav='audioManage'/>
    <#include "../inc/sidebar.ftl">
    <div class="main-content">
        <div class="page-title">
            <div class="hidden-sm hidden-xs sidebar-toggle">
                <a href="javascript:;" data-toggle="sidebar">
                    <i class="fa-bars"></i>
                </a>
            </div>
            <div class="sidebar-toggle" title="返回" onclick="window.history.go(-1);">
                <a href="javascript:;">
                    <i class="fa-chevron-left"></i>
                </a>
            </div>
            <div class="breadcrumb-env">
                <ol class="breadcrumb bc-1">
                    <li class="active"><strong>banner详情</strong></li>
                </ol>
            </div>
        </div>
        <!-- Responsive Table -->
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="panel-title">ID:${banner.id}</div>
                    </div>
                    <div class="panel-body">
                        <form id="bannerDetailForm" class="form" role="form"
                              action="${webServer}web/banner/save" method="post" enctype="multipart/form-data">
                        <div class="list-group">
                            <div class="list-group-item">
                                <div class="list-group-item-heading clearfix"><strong class="col-xs-12">排序</strong></div>
                                <div class="list-group-item-text clearfix">
                                    <div class="col-xs-12"><input type="text" name="orderId" value="${banner.orderId}"></div>
                                </div>
                            </div>
                            <div class="list-group-item">
                                <div class="list-group-item-heading clearfix"><strong class="col-xs-12">pc图片</strong></div>
                                <div class="list-group-item-text clearfix">
                                    <div class="col-xs-12" >
                                        <img src="${banner.picPc}" name="picPc" class="wh-image" bannerId="${banner.id}" id="altPc"/>
                                    </div>

                                </div>
                            </div>
                            <div class="list-group-item">
                                <div class="list-group-item-heading clearfix"><strong class="col-xs-12">手机图片 </strong></div>
                                <div class="list-group-item-text clearfix">
                                    <div class="col-xs-12">
                                        <img src="${banner.picMobile}" name="picMobile" class="wh-image"/>
                                    </div>

                                </div>
                            </div>
                        </div>
                            <div class="clearfix">
                                <div class="col-md-6 text-right">
                                    <button type="submit" id="saveBannerBtn" class="btn btn-success btn-icon">
                                        <i class="fa-check"></i>
                                        <span>提交</span>
                                    </button>
                                </div>
                                <div class="col-md-6">
                                    <a class="btn btn-white btn-icon"
                                       href="${webServer}web/banners/">
                                        <i class="fa-close"></i>
                                        <span>取消</span>
                                    </a>
                                </div>
                            </div>
                            <input type="hidden" name="id" value="${banner.id}"/>
                            <input type="hidden" name="picPc" value="${banner.picPc}"/>
                            <input type="hidden" name="picMobile" value="${banner.picMobile}"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <#include "../inc/footer.ftl">
    </div>
</div>
</body>
</html>