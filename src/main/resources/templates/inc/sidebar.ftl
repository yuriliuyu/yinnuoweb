<div class="sidebar-menu toggle-others fixed">
    <div class="sidebar-menu-inner">
        <header class="logo-env">
            <!-- logo -->
            <div class="logo">
                <span class="logo-expanded"><img src="${webServer}/static/assets/images/logo.png"><span>茵诺医疗管理系统</span></span>
                <span class="logo-collapsed"><img src="${webServer}/static/assets/images/logo.png"></span>
            </div>
            <div class="mobile-menu-toggle visible-xs">
                <a href="javascript:;" data-toggle="mobile-menu">
                    <i class="fa-bars"></i>
                </a>
            </div>
        </header>
        <ul id="main-menu" class="main-menu">
        <#--<#if Session.systemFunctionTreeVOs?exists>
            <#assign iconJson="{'revenueManage':'linecons-database','exerciseSets':'linecons-doc','teacherManage':'linecons-user','operate':'linecons-comment','audioLibs':'linecons-music','everydayTask':'linecons-note','organization':'linecons-shop','directional':'linecons-paper-plane','quickAnswer':'linecons-megaphone','teacherSetting':'linecons-params','systemUser':'linecons-cog'}"?eval />
            <#list Session.systemFunctionTreeVOs as systemFunctionTree>
                <#assign parentUrl=systemFunctionTree.functionUrl>
                <#assign navCss=parentUrl?split('/')[2]>
                <li <#if nav?exists && nav='${navCss}'>class="active opened"</#if>>
                    <#if systemFunctionTree.children?exists>
                        <a href="javascript:;">
                            <i class="${iconJson[navCss]}"></i>
                            <span class="title">${systemFunctionTree.functionName?default('')}</span>
                        </a>
                    <#else>
                        <a href="${webServer}${systemFunctionTree.functionUrl?default('')}">
                            <i class="${iconJson[navCss]}"></i>
                            <span class="title">${systemFunctionTree.functionName?default('')}</span>
                        </a>
                    </#if>

                    <#if systemFunctionTree.children?exists>
                        <ul>
                            <#list systemFunctionTree.children as subSystemFunctionTree>
                                <#assign subUrl=subSystemFunctionTree.functionUrl>
                                <#assign subNavCss=subUrl?split('/')[3]>
                                <li <#if subNav?exists && subNav='${subNavCss}'>class="active opened"</#if>>
                                    <a href="${webServer}${subSystemFunctionTree.functionUrl?default('')}">
                                        <span class="title">${subSystemFunctionTree.functionName?default('')}</span>
                                    </a>
                                </li>
                            </#list>
                        </ul>
                    </#if>
                </li>
            </#list>
        </#if>-->

            <li>
                    <a href="${webServer}/web/banners">
                        <i></i>
                        <span class="title">banner管理</span>
                    </a>

            </li>

            <li>
                <a href="${webServer}">
                    <i></i>
                    <span class="title">合作管理</span>
                </a>
            </li>
            <li>
                <a href="${webServer}">
                    <i></i>
                    <span class="title">案例管理</span>
                </a>
            </li>
            <li>
                <a href="${webServer}">
                    <i></i>
                    <span class="title">商品管理</span>
                </a>
            </li>
        </ul>
    </div>
</div>