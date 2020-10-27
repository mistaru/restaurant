<#import "parts/common.ftl" as c>
<@c.page>
    <div class="container">

        <a class="btn btn-danger" data-toggle="collapse" href="#collapseExampleSss" role="button" aria-expanded="false"
           aria-controls="collapseExampleSss">
            Добавить заказ
        </a>

        <div class="collapse" id="collapseExampleSss">
            <div class="form-group mt-3">
                <form class="form-inline" method="post" action="/report">
                    <div>
                        <select name="table" class="custom-select mb-2">
                            <option selected="selected">Номер набора</option>
                            <option>Первый</option>
                            <option>Второй</option>
                            <option>Третий</option>
                            <option>Четвертый</option>
                            <option>Пятый</option>
                        </select>
                    </div>

                    <div>
                        <select name="nameDish" class="custom-select mb-2">
                            <option selected="selected">Выберите блюдо</option>
                            <#if Dishes??>
                                <#list Dishes as Dishes>
                                    <option>${Dishes.getNameDish()}</option>
                                </#list>
                            </#if>
                        </select>
                    </div>

                    <div class="form-group">
                        <input type="number" class="form-control mb-2 mr-sm-2" name="count"
                               placeholder="Кол-во порций"/>
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-warning">Добавить</button>
                    </div>
                </form>
            </div>
        </div>

        <#if reportMessage??>
            <div>
                <br>
                <h2>${reportMessage}</h2>
            </div>
        </#if>


        <div style="text-align: center;"><h3>История заказов</h3></div>

        <table class="table table-dark table-striped">
            <thead>
            <tr>
                <th>Номер стола</th>
                <th>Блюдо</th>
                <th>Кол-во порций</th>
            </tr>
            </thead>

            <tbody>
            <#if reportList??>
                <#list reportList as reportList>
                    <tr>
                        <td>${reportList.table.toString()}</td>
                        <td>${reportList.dish.nameDish}</td>
                        <td>${reportList.count}</td>
                    </tr>
                <#else>
                    Список пуст. Добавьте заказы.
                </#list>
            </#if>
            </tbody>
        </table>
    </div>
</@c.page>


