<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="addProductForm" method="post" action="add_product"> <div class="form-group">
    <label for="name">Nombre:</label>
    <input type="text" class="form-control" id="name" name="name" required>
</div>
    <div class="form-group">
        <label for="price">Precio:</label>
        <input type="number" class="form-control" id="price" name="price" required>
    </div>
    <div class="form-group">
        <label for="description">Descripción:</label>
        <textarea class="form-control" id="description" name="description" rows="3"></textarea>
    </div>
    <button type="submit" class="btn btn-primary">Agregar Producto</button>
</form>

<script src="../WEB-INF/js/form-validation.js"></script>
</body>
</html>
