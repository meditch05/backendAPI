<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "../common/header.jsp" %>

<main role="main" id="user">
    
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
                <table border="1" style="box-sizing: border-box; border-collapse: collapse; border-spacing: 0px; border: 1px solid black;">
                    <tr style="background-color: #bbdefb">
                        <th>순서</th>
                        <th>아이디</th>
                        <th>이름</th>
                        <th>E-Mail</th>
                        <th>수정</th>
                    </tr>
                    <c:forEach var = "u" varStatus = "varStatus" items="${users}">
                        <tr>
                            <td>${varStatus.count}</td>
                            <td>${u.id}</td>
                            <td>${u.name}</td>
                            <td>${u.email}</td>
                            <td><button type="button" onclick="location.href='/user/edit?id=${u.id}'">정보 수정</button></td>
                        </tr>
                    </c:forEach>
                </table>
                <button type="button" onclick="location.href='/user/signup'">유저 추가</button>
                <br>
                
            </article>
        </c:otherwise>
    </c:choose>
</main>

<%@ include file = "../common/footer.jsp" %>