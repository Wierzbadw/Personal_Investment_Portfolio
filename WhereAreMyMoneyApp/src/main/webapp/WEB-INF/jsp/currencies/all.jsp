<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Wydatki</title>
    <%@ include file="../header.jsp" %>
    <link href="<c:url value="../../../css/sb-admin-2.css"/>" rel="stylesheet">
</head>
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <a href="<c:url value="add"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> Add currency</a>
    </div>
<%--    <div class="d-sm-flex align-items-center justify-content-between mb-4">--%>
<%--        <form:form>--%>
<%--        <form:select path="months.id" items="${months}"--%>
<%--                     itemValue="id" itemLabel="name" class="form-control"/>--%>
<%--        </form:form></div>--%>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Currencies</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <td><b>Base</b></td>
                        <td><b>Rate[$]</b></td>
                        <td><b>Amount</b></td>
                        <td><b>Value[$]</b></td>
                        <td><b>Annual change[%]</b></td>
                        <td><b></b></td>
                        <td><b>Delete</b></td>
                        <td><b>Delete</b></td>
                    </tr>
                    <c:set var="PLN" value="${0}"/>
                    <c:set var="EUR" value="${0}"/>
                    <c:set var="GBP" value="${0}"/>
                    <c:set var="JPY" value="${0}"/>
                    <c:set var="CAD" value="${0}"/>
                    <c:set var="CHF" value="${0}"/>
                    <c:set var="GBP" value="${0}"/>
                    <c:forEach items="${allCurrencies}" var="currencies">
                    <tr>
                        <c:if test="${(currencies.currencyBase == 'PLN')}"><c:set var="PLN" value="${PLN + currencies.currencyValue}"/></c:if>
                        <c:if test="${(currencies.currencyBase == 'EUR')}"><c:set var="EUR" value="${EUR + currencies.currencyValue}"/></c:if>
                        <c:if test="${(currencies.currencyBase == 'GBP')}"><c:set var="GBP" value="${GBP + currencies.currencyValue}"/></c:if>
                        <c:if test="${(currencies.currencyBase == 'JPY')}"><c:set var="JPY" value="${JPY + currencies.currencyValue}"/></c:if>
                        <c:if test="${(currencies.currencyBase == 'CAD')}"><c:set var="CAD" value="${CAD + currencies.currencyValue}"/></c:if>
                        <c:if test="${(currencies.currencyBase == 'CHF')}"><c:set var="CHF" value="${CHF + currencies.currencyValue}"/></c:if>
                        <c:if test="${(currencies.currencyBase == 'AUD')}"><c:set var="AUD" value="${AUD + currencies.currencyValue}"/></c:if>

                            <td> ${currencies.currencyBase} </td>
                            <td> ${currencies.currencyRate} </td>
                            <td> ${String.format("%.2f",currencies.currencyAmount)} </td>
                            <td> ${String.format("%.2f",currencies.currencyValue)} </td>
                            <td> ${currencies.currencyYearChange} <td>
                            <td><a href="edit?idToEdit=${currencies.id}">Edit</a></td>
                            <td><a href="remove?toRemoveId=${currencies.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <div hidden>
        PLN value:<p id="PLN_value"> ${PLN}</p>
        EUR value:<p id="EUR_value">${EUR} </p>
        GBP value:<p id="GBP_value">${GBP}</p>
        JPY value:<p id="JPY_value">${JPY}</p>
        CAD value:<p id="CAD_value">${CAD}</p>
        CHF value:<p id="CHF_value">${CHF}</p>
        AUD value:<p id="AUD_value">${AUD}</p>
    </div>

    <%@include  file="chart.html" %>
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <a href="<c:url value=".."/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> Back </a>
</div>

<%@ include file="../footer.jsp" %>

