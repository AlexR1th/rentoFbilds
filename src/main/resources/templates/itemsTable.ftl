<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link type="text/css" href="/static/interfacestyle/style.css" rel="stylesheet">
</head>
<body>

<h1>Item List</h1>
<br>
<div class="dropdown">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Sorted
    </button>
    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <button class="dropdown-item btn btn-danger" onclick="window.location.href = '/web/item/all/sort/id'">Id</button>
        <button class="dropdown-item btn btn-danger" onclick="window.location.href = '/web/item/all/sort/name'">Name</button>
        <button class="dropdown-item btn btn-danger" onclick="window.location.href = '/web/item/all/sort/modified'">Modified</button>
    </div>
</div>
<br>
<div class="div1">
    <button type="button" style="border-color: #FF0000;border-radius: 50%;background-color: #00CED1"
            onclick="window.location.href = '/index.html'">Back
    </button>
<#--    <div class="dropdown-menu">-->
<#--        <a>menu</a>-->
<#--        <button class="btn btn-outline-success dropdown-item" onclick="window.location.href = '/web/item/all/sort/id'">Id</button>-->
<#--        <button class="btn btn-outline-success" onclick="window.location.href = '/web/item/all/sort/name'">Name</button>-->
<#--        <button class="btn btn-outline-success" onclick="window.location.href = '/web/item/all/sort/modified'">Modified</button>-->
<#--    </div>-->

    <#--<a href="/index.html" class="button1">Back</a>-->
</div>
<div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>id</th></th>
            <th>Name</th>
            <th>Description</th>
            <th>Created</th>
            <th>Modified</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <#list spisok as element> <!--Цикл по всем element !! -->
            <!--Для каждого element в списке items , который мы получили
             из контроллера . -----------------------------
             Формируем строку <tr>. У этой строки есть ..5.. ячеек
              Каждая ичейка является полем ..елемента.. !
              (id)(name) т.д !!! -->
            <tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.description}</td>
                <td>${element.created_at}</td>
                <td>${element.modified_at}</td>
                <td><a href="/web/item/delete/${element.id}" class="btn btn-outline-danger">Delete</a></td>
                <td><a href="/web/item/update/${element.id}" class="btn btn-outline-success">Edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
    <a href="/web/item/create" class="btn btn-warning">Create</a>
</div>
</body>
</html>