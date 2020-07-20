<#import "parts/common.ftl" as c>
<@c.page>
<a class="btn btn-danger" data-toggle="collapse" href="#collapseExampleS" role="button" aria-expanded="false"
   aria-controls="collapseExampleS">
    Добавить ингридиент
</a>


<div class="collapse" id="collapseExampleS">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data" action="/ingredients">

            <div class="form-group">
                <input type="text" class="form-control" name="productName" placeholder="ингридиент"/>
            </div>
            <div>
                <select name="enumUnit" class="custom-select">
                    <option selected="selected">ед. изм.</option>
                    <option>гр</option>
                    <option>пч</option>
                    <option>шт</option>
                </select>
            </div>
            <div class="form-group">
                <input type="number" class="form-control" name="price" placeholder="Цена(шт,пч,100гр)"/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-warning">Добавить</button>
            </div>
        </form>
    </div>
</div>

<a class="btn btn-warning" data-toggle="collapse" href="#collapseExampleD" role="button" aria-expanded="false"
   aria-controls="collapseExampleD">
    Удалить ингридиент
</a>
<div class="collapse" id="collapseExampleD">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data" action="deleteIngredients">
            <div class="form-group">
                <input type="text" class="form-control" name="productName" placeholder="введите наименование"/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-warning">Удалить</button>
            </div>
        </form>
    </div>
</div>

<a class="btn btn-success" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
   aria-controls="collapseExample">
    Поиск ингредиента
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data" action="filterIng">
            <div class="form-group">
                <input type="text" class="form-control" name="filter" placeholder="наименование"/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-warning">Найти</button>
            </div>
        </form>
    </div>
</div>

        <div style="text-align: center;"><h1>Ингредиенты</h1></div>
        <div class="card-columns">
            <#list Ingredients as Ingredients>
                <div class="card my-8" style="width: 14rem;">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><h5>${Ingredients.getProductName()}</h5></li>
                        <li class="list-group-item">ед.из: <span> ${Ingredients.getEnumUnit()}</span> </li>
                        <li class="list-group-item">цена: <span>  ${Ingredients.getPrice()}</span> </li>
                    </ul>
                </div>
            <#else>
                 Список пуст. Добавьте ингридиенты.
            </#list>
        </div>

        <#if errMessageI??>
            <div>
                <br>
                <h2>${errMessageI}</h2>
            </div>
        </#if>

        </@c.page>
