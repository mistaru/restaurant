<#import "parts/common.ftl" as c>
<@c.page>
    <div class="container">

        <a class="btn btn-danger" data-toggle="collapse" href="#collapseExampleSs" role="button" aria-expanded="false"
           aria-controls="collapseExampleSs">
            Добавить
        </a>

        <a class="btn btn-success" data-toggle="collapse" href="#collapseExampleq" role="button" aria-expanded="false"
           aria-controls="collapseExampleq">
            Найти
        </a>

        <div class="collapse" id="collapseExampleSs">
            <div class="form-group mt-3">
            <form class="form-inline" method="post" action="add">
                <div>
                    <input type="text" class="form-control mb-2 mr-sm-2" name="nameDish" placeholder="Название блюда"
                           required/>
                    <input type="number" class="form-control mb-2 mr-sm-2" name="price" placeholder="Цена (в сомах)"
                           required/>
                    <input type="text" class="form-control mb-2 mr-sm-2" name="description" placeholder="Описание блюда"
                           required/>
                    <button type="submit" class="btn btn-warning mb-2">Добавить</button>
                </div>
            </form>
            </div>
        </div>

        <div class="collapse" id="collapseExampleq">
            <div class="form-group mt-3">
                <form class="form-inline" method="post" action="filter">
                    <div class="form-group">
                        <input type="text" class="form-control mb-2 mr-sm-2" name="filter" placeholder="Наименование"/>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-warning mb-2">Найти</button>
                    </div>
                </form>
            </div>
        </div>

        <div style="text-align: center;"><h1>Меню</h1></div>

        <table class="table table-dark table-striped">
            <thead>
            <tr>
                <th>Название</th>
                <th>Цена</th>
                <th>Описание</th>
                <th>Действия</th>
            </tr>
            </thead>
            <tbody>
      <#if menuDishes??>
            <#list menuDishes as menuDishes>
                <tr>
                    <td>${menuDishes.nameDish}</td>
                    <td>${menuDishes.price}</td>
                    <td>${menuDishes.description}</td>
                    <td><a href="/delete/${menuDishes.id}">Удалить</a></td>
                </tr>
            <#else>
                Список пуст. Добавьте блюдо.
            </#list>
      </#if>
            </tbody>
        </table>
    </div>

</@c.page>
