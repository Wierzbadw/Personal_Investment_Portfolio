<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Formularz dodawania/zmian</title>
    <%@ include file="../header.jsp" %>

    <link href="<c:url value="../../../css/sb-admin-2.css"/>" rel="stylesheet">
</head>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
</div>
<div class="container-fluid">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Choose currency and amount</h6>
        <h3>Please choose only from: PLN, EUR,GBP, JPY, CAD, CHF, GBP</h3>
    </div>
    <div class="card-body">
        <div class="form-group">
            <form:form method="post" modelAttribute="currency">
                <form:hidden path="id"/>
            <label for="currencyBase">Name</label>
                <form:input path="currencyBase" class="form-control"/>
                <form:errors path="currencyBase"/><br/><br/>
            <label for="currencyAmount">Amount</label>
                <form:input path="currencyAmount" class="form-control"/>
                <form:errors path="currencyAmount"/><br/><br/>
            <button type="submit" class="btn btn-primary">Save</button>
            </form:form>
            <br/><br/>
            <a href="<c:url value="/currenciesForm/list"/>"
               class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                <i class="fas fa-download fa-sm text-white-50"></i> Currencies List</a>
            <br/><br/>
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <a href="<c:url value=".."/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                        <i class="fas fa-download fa-sm text-white-50"></i> Back </a></div>
                    <%@ include file="../footer.jsp" %>
