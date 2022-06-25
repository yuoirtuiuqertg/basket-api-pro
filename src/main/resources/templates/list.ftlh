<!DOCTYPE html>
<html>
<head>
    <title>MAGAZINE</title>
</head>
<body>
<h1>MAGAZINE
    <h4>Товары </h4>

    <#list list as baskets>
        <div>
            <p><b>${baskets.list}</b> ${baskets.price} руб. ${baskets.count}  ${baskets.id}</p>
        </div>

    <#else>
        <h3>Товаров нет</h3>
    </#list>
</body>
</html>