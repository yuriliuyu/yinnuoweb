<!DOCTYPE html>
<html>
<head>
<#include "inc/header.ftl">
</head>
<body class="page-body">
<div class="page-container">
<#include "inc/sidebar.ftl">
    <div class="main-content">
        <div class="page-title">
            <div class="hidden-sm hidden-xs sidebar-toggle">
                <a href="javascript:;" data-toggle="sidebar">
                    <i class="fa-bars"></i>
                </a>
            </div>
            <div class="breadcrumb-env">
                <ol class="breadcrumb bc-1">
                    <li><a><i class="fa-home"></i>首页</a></li>
                </ol>
            </div>
        <!-- <#include "inc/user.ftl"> -->
        </div>
        <!-- Responsive Table -->
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="panel-title">首页</div>
                    </div>
                    <div class="panel-body">
                        <div class="content">欢迎使用茵诺医疗管理系统！</div>
                    </div>
                </div>
            </div>
        </div>
    <#include "inc/footer.ftl">
    </div>
</div>
<div class="page-loading-overlay">
    <div class="loader-2"></div>
</div>
</body>
</html>