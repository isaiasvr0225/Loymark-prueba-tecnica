<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="WEB-INF/commons/head.jsp"/>
<jsp:include page="WEB-INF/commons/navbar.jsp"/>
<jsp:include page="WEB-INF/commons/dashboard.jsp"/>

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Productos</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Descripcion</th>
                            <th>Precio</th>
                            <th></th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <!-- Iteramos cada elemento de la lista de productos -->
                        <c:forEach var="producto" items="${productosList}" >
                            <tr>
                                <td>${producto.id}</td>
                                <td>${producto.name}</td>
                                <td>${producto.description}</td>
                                <td>${producto.price}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/producto-servlet?accion=agregar&id=${producto.id}"
                                       class="btn btn-secondary">
                                        <i class="fas fa-angle-double-right"></i> Agregar
                                    </a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/usuario-servlet?accion=editar&id=${producto.id}"
                                       class="btn btn-secondary">
                                        <i class="fas fa-angle-double-right"></i> Editar
                                    </a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/usuario-servlet?accion=eliminar&id=${producto.id}"
                                       class="btn btn-secondary">
                                        <i class="fas fa-angle-double-right"></i> Eliminar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="WEB-INF/commons/footer.jsp"/>