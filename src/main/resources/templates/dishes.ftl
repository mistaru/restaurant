<#import "parts/common.ftl" as c>
<@c.page>

    <div>
        <div style="text-align: center;"><h1>Новое блюдо</h1></div>
        <form method="post" enctype="multipart/form-data" action="/dishes">
            <div class="form-group">
                <input type="text" class="form-control" name="nameDish" placeholder="название блюда"/>
            </div>
            <div class="form-group">
                <input type="number" class="form-control" name="price" placeholder="цена (в сомах)"/>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="description" placeholder="описание блюда"/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-warning">Добавить</button>
            </div>
        </form>
    </div>


    <div>
        <div style="text-align: center;"><h1>Удалить блюдо</h1></div>
        <form method="post" enctype="multipart/form-data" action="delete">
            <div class="form-group">
                <input type="text" class="form-control" name="nameDish" placeholder="введите наименование"/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-danger">Удалить</button>
            </div>
        </form>
    </div>

    <#if DishMessage??>
        <div>
            <br>
            <h2>${DishMessage}</h2>
        </div>
    </#if>

    <!-- Если ошибка мы здесь выведим сообщение -->
    <#if errMessage??>
        <div>
            <br>
            <h2>${errMessage}</h2>
        </div>
    </#if>
</@c.page>


