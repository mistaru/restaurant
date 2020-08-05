<#import "parts/common.ftl" as c>

<@c.page>
    <div class="container">

    <a class="btn btn-danger" data-toggle="collapse" href="#collapseExampleSs" role="button" aria-expanded="false"
       aria-controls="collapseExampleSs">
        Добавить ингридиент
    </a>

    <div class="collapse" id="collapseExampleSs">
    <div class="form-group mt-3">
        <form class="form-inline" method="post" action="/addIngredients">
            <div>
                <select name="nameDish" class="custom-select mb-2">
                    <option selected="selected">выберите блюдо</option>
                    <#if Dishes??>
                        <#list Dishes as Dishes>
                            <option>${Dishes.getNameDish()}</option>
                        </#list>
                    </#if>
                </select>
            </div>

            <div>
                <select name="productName" class="custom-select mb-2">
                    <option selected="selected">выберите ингредиент</option>
                    <#if ingredientsList??>
                        <#list ingredientsList as ingredientsList>
                            <option>${ingredientsList.getProductName()}</option>
                        </#list>
                    </#if>
                </select>
            </div>

            <div class="form-group">
                <input type="number" class="form-control mb-2 mr-sm-2" name="count"
                       placeholder="Кол-во(шт,пч,100гр)"/>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-warning">Добавить</button>
            </div>
        </form>
    </div>
    </div>


    <div style="text-align: center;"><h3>История</h3></div>

    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th>Блюдо</th>
            <th>Ингридиент</th>
            <th>Вес/штук</th>
        </tr>
        </thead>
        <tbody>
        <#if compositions??>
            <#list compositions as compositions>
                <tr>
                    <td>${compositions.dish.nameDish}</td>
                    <td>${compositions.ingredients.productName}</td>
                    <td>${compositions.count}</td>
                </tr>
            <#else>
                Список пуст. Добавьте ингридиенты.
            </#list>
        </#if>
        </tbody>
    </table>
    </div>
</@c.page>