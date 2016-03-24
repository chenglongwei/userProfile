<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="PERSON LIST" />
    <c:param name="body">
        <p>
            <a href='${pageContext.request.contextPath}/profile/form/' class="btn btn-info">CREATE</a>
        </p>
        <table
            class="table table-striped table-bordered table-condensed">
            <tr>
                <th>ID</th>
                <th>firstname</th>
                <th>lastname</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${page.content}" var="person">
                <tr>
                    <td>${(person.id)}</td>
                    <td>${(person.firstname)}</td>
                    <td>${(person.lastname)}</td>
                    <td><a
                        href='${pageContext.request.contextPath}/person/edit/${person.id}'
                        class="btn btn-primary">編集</a> <a
                        href='${pageContext.request.contextPath}/person/delete/${person.id}'
                        class="btn">削除</a></td>
                </tr>
            </c:forEach>
        </table>

        <p>${(page.number + 1)}/${(page.totalPages)}</p>
        <div class="pagination">
            <ul>
                <li>
                        <a href='<c:url value="?page=0" />'>&laquo;
                            first</a>
                    </li>

            </ul>
        </div>
    </c:param>
</c:import>

