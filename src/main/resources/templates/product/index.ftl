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
                    <form role="form" method="post" action="/spring/seller/product/save">
                        <div class="form-group">
                            <label>名称</label><input name="productName" type="text" class="form-control" value="${(productInfo.getProductName())!''}"/>
                        </div>

                        <div class="form-group">
                            <label>价格</label><input name="productPrice" type="text" class="form-control" value="${(productInfo.getProductPrice())!''}"/>
                        </div>

                        <div class="form-group">
                            <label>库存</label><input name="productStock" type="text" class="form-control" value="${(productInfo.getProductStock())!''}"/>
                        </div>

                        <div class="form-group">
                            <label>描述</label><input name="productDescription" type="text" class="form-control" value="${(productInfo.getProductDescription())!''}"/>
                        </div>

                        <div class="form-group">
                            <label>图片</label>
                            <img height="100" width="100" src="${(productInfo.getProductIcon())!''}">
                            <input name="productIcon" type="text" class="form-control" value="${(productInfo.getProductIcon())!''}"/>
                        </div>

                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                                <#list categoryList as category>
                                    <option value="${category.getCategoryType()}"
                                        <#if (productInfo.categoryType)?? && productInfo.categoryType == category.categoryType>
                                            selected
                                        </#if>>
                                        ${category.getCategoryName()}
                                    </option>
                                </#list>
                            </select>
                        </div>

                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}">
                        </div> <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
