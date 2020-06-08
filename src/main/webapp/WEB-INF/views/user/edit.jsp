<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "../common/header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<main role="main" id="user-form">
    <article>
        <form:form modelAttribute="user">
          <form:hidden path="id"/>
          <label>NAME</label> <form:input path="name"/><br/>
          <label>EMAIL</label> <form:input path="email"/><br/>
          <label>PASSWORD</label> <form:input path="password" showPassword="true"/><br/><br/>
          <input type="submit" value="수정하기"/>
        </form:form>
    </article>
</main>

<%@ include file = "../common/footer.jsp" %>

