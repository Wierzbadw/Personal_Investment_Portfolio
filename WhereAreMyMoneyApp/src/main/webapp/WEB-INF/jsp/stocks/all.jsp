<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>

<head>
    <title>Wydatki</title>
    <%@ include file="../header.jsp" %>
    <link href="<c:url value="../../../css/sb-admin-2.css"/>" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <a href="<c:url value="add"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> Add stock</a>
    </div>

    <%--    <div class="d-sm-flex align-items-center justify-content-between mb-4">--%>
    <%--        <form:form>--%>
    <%--        <form:select path="months.id" items="${months}"--%>
    <%--                     itemValue="id" itemLabel="name" class="form-control"/>--%>
    <%--        </form:form></div>--%>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Stocks</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <td><b>Symbol</b></td>
                        <td><b>Name</b></td>
                        <td><b>Industry</b></td>
                        <td><b>Price</b></td>
                        <td><b>Units</b></td>
                        <td><b>Total value</b></td>
                        <td><b>Daily change</b></td>
                        <td><b>Date</b></td>
                        <td><b>Details</b></td>
                        <td><b>Edit</b></td>
                        <td><b>Delete</b></td>
                    </tr>
                    <c:set var="allStocksValue" value="${0}"/>
                    <c:forEach items="${allStocks}" var="stocks">
                        <c:set var="allStocksValue" value="${allStocksValue + stocks.stockTotalValue}"/>
                        <tr>
                            <td> ${stocks.stockSymbol} </td>
                            <td> ${stocks.stockName} </td>
                            <td> ${stocks.stockIndustry} </td>
                            <td> $${stocks.stockPrice} </td>
                            <td id="test"> ${stocks.stockUnits} </td>
                            <td> ${stocks.stockTotalValue} </td>
                            <td> ${stocks.stockChangeInPercent}[%] </td>
                            <td> ${stocks.date} </td>
                            <td><a href="details?detailsOfId=${stocks.id}">Details</a></td>
                            <td><a href="edit?idToEdit=${stocks.id}">Edit</a></td>
                            <td><a href="remove?toRemoveId=${stocks.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    Total stock value: $${String.format("%.2f",allStocksValue)} <br/><br/>
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <a href="<c:url value=".."/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> Back </a>
    </div>

    <%@ include file="../footer.jsp" %>

