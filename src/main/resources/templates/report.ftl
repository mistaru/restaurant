<#import "parts/common.ftl" as c>
<@c.page>

<div>
    <div style="text-align: center;"><h1>Набор Блюд</h1></div>
    <form method="post" enctype="multipart/form-data" action="/report">
            <div>
                <select name="table" class="custom-select">
                    <option selected="selected">Номер набора</option>
                    <option>Первый</option>
                    <option>Второй</option>
                    <option>Третий</option>
                    <option>Четвертый</option>
                    <option>Пятый</option>
                </select>
            </div>

        <div>
            <select name="nameDish" class="custom-select">
                <option selected="selected">Выберите блюдо</option>
                <#if Dishes??>
                    <#list Dishes as Dishes>
                        <option>${Dishes.getNameDish()}</option>
                    </#list>
                </#if>
            </select>
        </div>

        <div class="form-group">
            <input type="number" class="form-control" name="count" placeholder="Кол-во порций"/>
        </div>

        <div class="form-group">
                <button type="submit" class="btn btn-warning">Добавить</button>
            </div>
        </form>
</div>


    <#if reportMessage??>
        <div>
            <br>
            <h2>${reportMessage}</h2>
        </div>
    </#if>

</@c.page>


