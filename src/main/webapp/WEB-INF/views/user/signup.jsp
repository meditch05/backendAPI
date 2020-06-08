<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "../common/header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<main role="main" id="user-form">
    <article>
        <form:form modelAttribute="user">
          <label>ID</label> <form:input path="id"/><br/>
          <label>NAME</label> <form:input path="name"/><br/>
          <label>EMAIL</label> <form:input path="email"/><br/>
          <label>PASSWORD</label> <form:input path="password"/><br/>
          <input type="submit" value="유저 정보 저장"/>
        </form:form>
    </article>
</main>

<%@ include file = "../common/footer.jsp" %>