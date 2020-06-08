<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "common/header.jsp" %>

<main role="main" id="main">

    <article class="one">
        <a href="<c:url value='/character/elice_rabbit'/>">
            <img src="/images/image1.png" alt="White Rabbit">
            <h2>엘리스 토끼</h2>
        </a>
    </article>

    <article class="two">
        <a href="<c:url value='/character/cheshire_cat'/>">
            <img src="/images/image2.png" alt="Cheshire Cat">
            <h2>체셔</h2>
        </a>
    </article>

    <article class="three">
        <a href="<c:url value='/character/queen_of_hearts'/>">
            <img src="/images/image3.png" alt="Queen of Hearts">
            <h2>하트여왕</h2>
        </a>
    </article>

    <article class="one">
        <a href="<c:url value='/character/caterpillar'/>">
            <img src="/images/image6.png" alt="Caterpillar">
            <h2>캐터필러</h2>
        </a>
    </article>

    <article class="text">
        <p>엘리스에 오신 여러분 환영합니다! :)</p>
    </article>
</main>

<%@ include file = "common/footer.jsp" %>