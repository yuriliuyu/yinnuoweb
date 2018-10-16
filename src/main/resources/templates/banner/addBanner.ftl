<!DOCTYPE html>
<html>
<head>
<#include "../inc/header.ftl">
    <script>
        var editPushMode = false;
    </script>
    <script src="${webServer}assets/js/biz/banner/saveBanner.js"></script>
</head>
<body class="page-body">
<div class="page-container">
<#assign nav='directional'/>
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
                    <li><a><i class="fa-home"></i>定向推题</a></li>
                    <li class="active"><strong>新增推题</strong></li>
                </ol>
            </div>
        </div>
        <!-- Responsive Table -->
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <form id="membersListTableForm" class="form" role="form"
                              action="${webServer}front/directional/saveMembers" method="post">
                            <div class="filter-area">
                                <div class="form-horizontal" style="width: 350px;">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">录题机构</label>

                                        <div class="col-sm-8">
                                            <select class="form-control" name="selectInstitutionOps">
                                                <option value="-1">请选择</option>
                                            <#--<#list organizations as organization >
                                                <option value="${organization.id}">${organization.organizationName}</option>
                                            </#list>-->
                                            </select>
<#--
                                            <span><#if organizations?size==0>对不起，已经没有空机构（机构没有关联老师）</#if></span>
-->
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">录题人</label>

                                        <div class="col-sm-8">
                                            <button id="selectMembersBtn" class="btn btn-secondary btn-single"
                                                    type="button">
                                                选择录题人
                                            </button>
                                        </div>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                            <div class="separator"></div>

                            <div class="table-responsive">
                                <table id="membersListTable" cellspacing="0"
                                       class="table table-small-font table-bordered table-striped table-hover">
                                    <thead>
                                    <th>姓名</th>
                                    <th>手机号</th>
                                    <th>星级</th>
                                    <th>身份</th>
                                    <th>省份</th>
                                    <th>城市</th>
                                    <th>所在学校</th>
                                    <th>操作</th>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        <#import "../inc/macro.ftl" as macro />
                            <div class="clearfix">
                                <div class="col-md-6 text-right">
                                    <button id="saveMembersBtn" class="btn btn-success btn-icon" type="button">
                                        <i class="fa-check"></i>
                                        <span>提交</span>
                                    </button>
                                </div>
                                <div class="col-md-6">
                                    <a class="btn btn-white btn-icon"
                                       href="${webServer}front/directional/directionalList">
                                        <i class="fa-close"></i>
                                        <span>取消</span>
                                    </a>
                                </div>
                            </div>
                            <input type="hidden" name="teacherIds">
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