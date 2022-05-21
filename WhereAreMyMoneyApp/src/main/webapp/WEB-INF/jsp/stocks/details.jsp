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
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Details of stock: ${stock.stockName} [${stock.stockSymbol}]</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <td><b>Today's price ${stock.stockPrice}$</b></td>
                        <td><b>Previous close ${stock.previousClose}$</b></td>
                    </tr>
                    <tr>
                        <td><b>Day low: ${stock.dayLow}$</b></td>
                        <td><b>Day high: ${stock.dayHigh}$</b></td>
                    </tr>
                    <tr>
                        <td><b>Year low: ${stock.yearLow}$</b></td>
                        <td><b>Year high: ${stock.yearHigh}$</b></td>
                    </tr>
                    <tr>
                        <td><b>Average price for the last 50 days:${stock.priceAvg50}$ [change ${stock.changeFromAvg50InPercent}%]</b></td>
                        <td><b>Average price for the last 200 days: ${stock.priceAvg200}$ [change ${stock.changeFromAvg200InPercent}%]</b></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <a href="<c:url value=".."/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> Back </a>
    </div>

    <%@ include file="../footer.jsp" %>






