<#import "parts/common.ftl" as c>
<@c.page>
    <div class="container">

        <a class="btn btn-danger" data-toggle="collapse" href="#collapseExampleS" role="button" aria-expanded="false"
           aria-controls="collapseExampleS">
            Добавить
        </a>

        <a class="btn btn-success" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
           aria-controls="collapseExample">
            Найти
        </a>

        <div class="collapse" id="collapseExampleS">
            <form class="form-inline" method="post" action="/dishes">
                <div>
                    <input type="text" class="form-control mb-2 mr-sm-2" name="nameDish" placeholder="Название блюда"
                           required/>
                    <input type="number" class="form-control mb-2 mr-sm-2" name="price" placeholder="Цена (в сомах)"
                           required/>

                    <input type="text" class="form-control mb-2 mr-sm-2" name="description" placeholder="описание блюда"
                           required/>
                    <button type="submit" class="btn btn-warning mb-2">Добавить</button>
                </div>
            </form>
        </div>

        <div class="collapse" id="collapseExample">
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
            </tr>
            </thead>
            <tbody>
            <#list menuDishes as menuDishes>
                <tr>
                    <td>${menuDishes.getNameDish()}</td>
                    <td>${menuDishes.getPrice()}</td>
                    <td>${menuDishes.getDescription()}</td>
                </tr>
            <#else>
                No message
            </#list>
            </tbody>
        </table>
    </div>

</@c.page>
