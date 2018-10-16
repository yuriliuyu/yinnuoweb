<!DOCTYPE html>
<html>
<head>
<#import "inc/macro.ftl" as macro />
<#include "inc/header.ftl">
    <script type="text/javascript" src="${webServer}assets/js/biz/organization/organizationDetail.js"></script>
    <script>
        function reinitIframe() {
            var iframe1 = document.getElementById("iframeTab1");
            var iframe2 = document.getElementById("iframeTab2");
            var iframe3 = document.getElementById("iframeTab3");
            try {
                iframe1.height = iframe1.contentWindow.document.documentElement.scrollHeight;
                iframe2.height = iframe2.contentWindow.document.documentElement.scrollHeight;
                iframe3.height = iframe3.contentWindow.document.documentElement.scrollHeight;
            } catch (ex) {
            }
        }
        $(function () {
            window.setInterval(function () {
                reinitIframe()
            }, 200);
        })
    </script>
</head>
<body class="page-body">
<div class="page-container">
<#assign nav='organization' subNav='organizationList'/>
<#include "inc/sidebar.ftl">
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
                    <li><a><i class="fa-home"></i>机构管理</a></li>
                    <li><a>机构详情</a></li>
                    <#--<li class="active"><strong>${organization.organizationName!}</strong></li>-->
                </ol>
            </div>
        <#include "inc/user.ftl">
        </div>
        <!-- Responsive Table -->
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="panel-title">机构信息</div>
                    </div>
                    <div class="panel-body">
                        <div class="form clearfix">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label">机构名称：</label>
                                    <#--<span class="control-label">${organization.organizationName!}</span>-->
                                </div>
                                <div class="form-group">
                                    <label class="control-label">所在省份：</label>
                                    <#--<span class="control-label">${teacher.provinceName!}</span>-->
                                </div>
                                <div class="form-group">
                                    <label class="control-label">机构教师数量：</label>
                                    <#--<span class="control-label">${countTeacher!}</span>-->
                                </div>
                                <div class="form-group">
                                    <label class="control-label">辅导年级：</label>
                                    <#--<span class="control-label">${teacher.grades!}</span>-->
                                </div>
                                <div class="form-group">
                                    <label class="control-label">机构简介：</label>
                                    <#--<span class="control-label">${teacher.selfDescription!}</span>-->
                                </div>
                                <div class="form-group">
                                    <label class="control-label">状态：</label>
                                    <label id="statusText" class="control-label">
                                    <#--<#if organization.status==0>-->
                                        <#--<span class="text-secondary">正常</span>-->
                                    <#--</#if>-->
                                    <#--<#if organization.status==1>-->
                                        <#--<span class="text-danger">已封号</span>-->
                                    <#--</#if>-->
                                    </label>
                                </div>
                            </div>
                            <div class="col-md-5">
                                <div class="form-group">
                                    <label class="control-label">机构账号：</label>
                                    <#--<span class="control-label">${organization.teacherPhoneNumber!}</span>-->
                                </div>
                                <div class="form-group">
                                    <label class="control-label">所在城市：</label>
                                    <#--<span class="control-label">${teacher.cityName!}</span>-->
                                </div>
                                <div class="form-group">
                                    <label class="control-label">机构分类：</label>
                                    <#--<span class="control-label">Plan ${organization.planType!}</span>-->
                                </div>
                                <div class="form-group">
                                    <label class="control-label">辅导学科：</label>
                                    <#--<span class="control-label">${teacher.subjects!}</span>-->
                                </div>
                                <div class="form-group">
                                    <label class="control-label">注册时间：</label>
                                    <#--<span class="control-label">${organization.createTime?string("yyyy-MM-dd HH:mm:ss")}</span>-->
                                </div>
                                <#--<#if organization.planType?exists&&organization.planType=='B'>-->
	                                <#--<div class="form-group">-->
	                                    <#--<label class="control-label">机构邀请码：</label>-->
	                                    <#--<span class="control-label">${organization.teacherPhoneNumber!}</span>-->
	                                <#--</div>-->
                                <#--</#if>-->
                            </div>
                            <div class="col-md-3">
                                <div class="avatar">
                                    <img src="${webServer}assets/images/user-4.png" class="img-circle" width="120">
                                </div>
                                <div class="forbidden-btn">
                                <#--<#if organization.status==0>-->
                                    <#--<#assign btnStatusClass='btn-red' btnStatusText='禁用账户'/>-->
                                <#--</#if>-->
                                <#--<#if organization.status==1>-->
                                    <#--<#assign btnStatusClass='btn-success' btnStatusText='启用账户'/>-->
                                <#--</#if>-->
                                    <#--<button id="updateOrgStatusBtn" data-id="${organization.id}"-->
                                            <#--data-status="${organization.status}"-->
                                            <#--class="btn ${btnStatusClass} btn-icon btn-icon-standalone">-->
                                        <#--<i class="fa-lock"></i>-->
                                        <#--<span>${btnStatusText}</span>-->
                                    <#--</button>-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="panel-title">其他信息</div>
                    </div>
                    <div class="panel-body">
                        <ul class="nav nav-tabs">
                            <li class="active">
                                <a href="#tab_1" data-toggle="tab">
                                    <span class="visible-xs"><i class="fa-home"></i></span>
                                    <span class="hidden-xs">音频录制记录</span>
                                </a>
                            </li>
                            <li>
                                <a href="#tab_2" data-toggle="tab">
                                    <span class="visible-xs"><i class="fa-user"></i></span>
                                    <span class="hidden-xs">教师列表</span>
                                </a>
                            </li>
                            <li>
                                <a href="#tab_3" data-toggle="tab">
                                    <span class="visible-xs"><i class="fa-envelope-o"></i></span>
                                    <span class="hidden-xs">习题集列表</span>
                                </a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <iframe id="iframeTab1"
                                        src="${webServer}front/organization/getAudioList?orgId=${organization.id!}"
                                        frameborder="0"
                                        width="100%" scrolling="no"></iframe>
                            </div>
                            <div class="tab-pane" id="tab_2">
                                <iframe id="iframeTab2"
                                        src="${webServer}front/organization/getTeacherList?orgId=${organization.id!}"
                                        frameborder="0"
                                        width="100%" scrolling="no"></iframe>
                            </div>
                            <div class="tab-pane" id="tab_3">
                                <iframe id="iframeTab3"
                                        src="${webServer}front/organization/getAudioSetList?orgId=${organization.id!}"
                                        frameborder="0"
                                        width="100%" scrolling="no"></iframe>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <#include "inc/footer.ftl">
    </div>
</div>
</body>
</html>