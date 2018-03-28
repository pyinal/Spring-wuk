<!DOCTYPE html>
<html>
<#include "../common/header.ftl">
<body>

<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>更新时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                <#list productInfoPage.content as productInfoPages>
                <tr>
                    <td>${productInfoPages.getProductId()}</td>
                    <td>${productInfoPages.getProductName()}</td>
                    <td><img height="100" width="150" src="${productInfoPages.getProductIcon()}"></td>
                    <td>${productInfoPages.getProductPrice()}</td>
                    <td>${productInfoPages.getProductStock()}</td>
                    <td>${productInfoPages.getProductDescription()}</td>
                    <td>${productInfoPages.getCategoryType()}</td>
                    <td>${productInfoPages.getCreateTime()}</td>
                    <td>${productInfoPages.getUpdateTime()}</td>
                    <td><a href="./index?productId=${productInfoPages.getProductId()}">修改</a></td>
                    <td>
                        <#if productInfoPages.getProductStatus() == 0>
                            <a href="./off_sale?productId=${productInfoPages.getProductId()}">下架</a>
                        <#else>
                            <a href="./on_sale?productId=${productInfoPages.getProductId()}">上架</a>
                        </#if>

                    </td>
                </tr>
                </#list>
                        </tbody>
                    </table>

                <#--分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="?page=${currentPage - 1}&size=${size}">Prev</a></li>
                    <#else >
                        <li><a href="?page=${currentPage - 1}&size=${size}">Prev</a></li>
                    </#if>

                    <#list 1..productInfoPage.getTotalPages() as index>
                        <#if  currentPage == index>
                            <li class="disabled"><a href="?page=${index}&size=${size}">${index}</a></li>
                        <#else>
                            <li><a href="?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage == productInfoPage.getTotalPages()>
                        <li class="disabled"><a href="?page=${currentPage + 1}&size=${size}">Next</a></li>
                    <#else >
                        <li><a href="?page=${currentPage + 1}&size=${size}">Next</a></li>
                    </#if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
