<#import "parts/common.ftl" as c>

<@c.page>
    <div>
        <div style="text-align: center;"><h1>Состав блюда</h1></div>
        <form method="post" enctype="multipart/form-data" action="/addIngredients">

            <div>
                <select name="nameDish" class="custom-select">
                    <option selected="selected">выберите блюдо</option>
                    <#if Dishes??>
                        <#list Dishes as Dishes>
                            <option>${Dishes.getNameDish()}</option>
                        </#list>
                    </#if>
                </select>
            </div>

            <div>
                <select name="productName" class="custom-select">
                    <option selected="selected">выберите ингредиент</option>
                    <#if ingredientsList??>
                        <#list ingredientsList as ingredientsList>
                            <option>${ingredientsList.getProductName()}</option>
                        </#list>
                    </#if>
                </select>
            </div>

            <div class="form-group">
                <input type="number" class="form-control" name="count" placeholder="Кол-во(шт,пч,100гр)"/>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-warning">Добавить</button>
            </div>
        </form>
    </div>
</@c.page>


