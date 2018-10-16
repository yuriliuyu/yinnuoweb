<!doctype html>
<html>
<head>
<#include "../inc/header.ftl">
</head>
<body class="page-body">
<div class="page-container">
<#assign nav='banners' subNav='banner'/>
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
                    <li class="active"><strong>banner管理</strong></li>
                </ol>
            </div>
        <#--<#include "inc/user.ftl">-->
        </div>
        <!-- Responsive Table -->
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="form-group">
                            <a class="btn btn-secondary btn-single"
                               href="${webServer}web/banner/add">新建banner</a>
                        </div>
                        <div class="separator"></div>
                        <div class="table-responsive">
                            <table cellspacing="0"
                                   class="table table-small-font table-bordered table-striped table-hover">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>手机图片</th>
                                    <th>电脑图片</th>
                                    <th>排序(值大排在前)</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list banners as banner>
                                <tr>
                                    <th>
                                        <a class="text-blue"
                                           href="${webServer}/web/banner/detail/${banner.id}">${banner.id}</a>
                                    </th>
                                    <td><img src="${banner.picPc}" class="img-inline userpic-32" width="56"/></td>
                                    <td><img src="${banner.picMobile}" class="img-inline userpic-32" width="56"/></td>
                                    <td>${banner.orderId}</td>
                                </tr>
                                </#list>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    <#include "../inc/footer.ftl">
    </div>
</div>
</body>
</html>