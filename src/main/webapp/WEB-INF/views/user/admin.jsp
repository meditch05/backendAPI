<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> -->

<%@ include file = "../common/header.jsp" %>

<main role="main" id="user">
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <c:choose>
            <c:when test="${empty users}">
                <article class="charater-img">
                    <img src="/images/image5.png" alt="Dodo">
                    <h2>현재 코더랜드에 등록된 사람이 없습니다.</h2>
                    <button type="button" onclick="location.href='/user/signup'">유저 추가</button>
                </article>
            </c:when>

            <c:otherwise>
                <article>
                    <table>
                        <tr>
                            <td>기본 키</td>
                            <td>이름</td>
                            <td>아이디</td>

                        </tr>
                        <c:forEach var = "u" varStatus = "varStatus" items="${users}">
                            <tr>
                                <td>${varStatus.count}</td>
                                <td>${u.name}</td>
                                <td>${u.email}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <button type="button" onclick="location.href='/user/signup'">유저 추가</button>
                </article>
            </c:otherwise>
        </c:choose>
    </sec:authorize>


</main>

<%@ include file = "../common/footer.jsp" %>
