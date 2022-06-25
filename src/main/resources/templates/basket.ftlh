<!DOCTYPE html>
<html>
<head>
    <title>MAGAZINE</title>
</head>
<body>
<h1>MAGAZINE
    <h4>Товары </h4>

    <#list basket as baskets>
        <div>
            <p><b>${baskets.title}</b> ${baskets.price} руб. ${baskets.count}  ${baskets.id}</p>
        </div>

    <#else>
        <h3>Товаров нет</h3>
    </#list>
    <p> цена корзины : ${price}</p>
    <p> колличество товаров в корзине : ${count}</p>
</body>
</html>