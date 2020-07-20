<#import "parts/common.ftl" as c>
<@c.page>
    <form method="post" action="filter">
        <input type="text" name="filter">
        <button type="submit">Найти</button>
    </form>
    <div style="text-align: center;"><h1>Меню</h1></div>
    <div class="card-columns">
        <#list menuDishes as menuDishes>
            <div class="card my-5" style="width: 30rem;">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><h5>${menuDishes.getNameDish()}</h5></li>
                    <li class="list-group-item">цена:  ${menuDishes.getPrice()}</li>
                    <li class="list-group-item">${menuDishes.getDescription()}</li>
                </ul>
            </div>
        <#else>
            No message
        </#list>
    </div>
</@c.page>
