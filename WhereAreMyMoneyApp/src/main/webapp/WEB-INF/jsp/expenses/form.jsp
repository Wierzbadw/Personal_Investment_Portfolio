<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Formularz dodawania/zmian</title>
    <%@ include file="../header.jsp" %>
    <link href="<c:url value="../../../css/sb-admin-2.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src=https://code.jquery.com/jquery-1.12.4.js></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
</div>
<div class="container-fluid">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Add expense</h6>
        <h3>Please choose only from categories: Entertainment, Food, Transportation, Housing, Utilities, Others</h3>
    </div>
    <div class="card-body">
        <div class="form-group">
            <form:form method="post" modelAttribute="expense">
                <form:hidden path="id"/>
            <label for="expenseName">Name</label>
                <form:input path="expenseName" class="form-control"/>
                <form:errors path="expenseName"/><br/><br/>
            <label for="category">Category</label>
                <form:input path="category" class="form-control"/>
                <form:errors path="category"/><br/><br/>
                <label for="expenseAmount">Amount</label>
                <form:input path="expenseAmount" class="form-control"/>
                <form:errors path="expenseAmount"/><br/><br/>
            <button type="submit" class="btn btn-primary">Save</button>
            </form:form>
            <br/><br/>
            <a href="<c:url value="/expensesForm/list"/>"
               class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                <i class="fas fa-download fa-sm text-white-50"></i> Expenses list</a>
            <br/><br/>
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <a href="<c:url value=".."/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                        <i class="fas fa-download fa-sm text-white-50"></i> Back </a></div>
                    <%@ include file="../footer.jsp" %>
