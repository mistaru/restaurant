<#import "parts/common.ftl" as c>
<@c.page>
    <div class="container">
        <a class="btn btn-danger" data-toggle="collapse" href="#collapseExampleS" role="button" aria-expanded="false"
           aria-controls="collapseExampleS">
            Добавить
        </a>

        <a class="btn btn-warning" data-toggle="collapse" href="#collapseExampleD" role="button" aria-expanded="false"
           aria-controls="collapseExampleD">
            Удалить
        </a>

        <a class="btn btn-success" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
           aria-controls="collapseExample">
            Поиск
        </a>

        <div class="collapse" id="collapseExampleS">
            <div class="form-group mt-3">
                <form class="form-inline" method="post" action="/ingredients">

                        <input type="text" class="form-control mb-2 mr-sm-2" name="productName" placeholder="Наименование"/>
                        <select name="enumUnit" class="custom-select mb-2">
                            <option>грамм</option>
                            <option>пучок</option>
                            <option>штук</option>
                        </select>
                        <input type="number" class="form-control mb-2 mr-sm-2" name="price" placeholder="Цена(шт,пч,100гр)"/>
                        <button type="submit" class="btn btn-warning mb-2">Добавить</button>
                </form>
            </div>
        </div>

        <div class="collapse" id="collapseExampleD">
            <div class="form-group mt-3">
                <form method="post" action="deleteIngredients">
                    <div class="form-group">
                        <input type="text" class="form-control" name="productName" placeholder="введите наименование"/>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-warning">Удалить</button>
                    </div>
                </form>
            </div>
        </div>

        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form class="form-inline" method="post" action="filterIng">
                    <div class="form-group">
                        <input type="text" class="form-control mb-2 mr-sm-2" name="filter" placeholder="Наименование"/>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-warning mb-2">Найти</button>
                    </div>
                </form>
            </div>
        </div>

        <div style="text-align: center;"><h3>Ингридиенты</h3></div>

        <table class="table table-dark table-striped">
            <thead>
            <tr>
                <th>Название</th>
                <th>Единицы измерения</th>
                <th>Цена за 100 грамм</th>
            </tr>
            </thead>
            <tbody>
            <#list Ingredients as Ingredients>
                <tr>
                    <td>${Ingredients.getProductName()}</td>
                    <td>${Ingredients.getEnumUnit()}</td>
                    <td>${Ingredients.getPrice()}</td>
                </tr>
            <#else>
                Список пуст. Добавьте ингридиенты.
            </#list>
            </tbody>
        </table>
    </div>

    <#if errMessageI??>
        <div>
            <br>
            <h2>${errMessageI}</h2>
        </div>
    </#if>

</@c.page>
