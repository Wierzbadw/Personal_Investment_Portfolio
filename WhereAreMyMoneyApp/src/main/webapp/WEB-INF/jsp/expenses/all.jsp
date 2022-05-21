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
            <i class="fas fa-download fa-sm text-white-50"></i> Add expense</a>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Estimated monthly expenses</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <td><b>Name</b></td>
                        <td><b>Category</b></td>
                        <td><b>Amount[$]</b></td>
                        <td><b>Edit</b></td>
                        <td><b>Delete</b></td>
                    </tr>
                    <c:set var="expTotal" value="${0}"/>
                    <c:set var="enterTotal" value="${0}"/>
                    <c:set var="foodTotal" value="${0}"/>
                    <c:set var="tranTotal" value="${0}"/>
                    <c:set var="houseTotal" value="${0}"/>
                    <c:set var="utilTotal" value="${0}"/>
                    <c:set var="othersTotal" value="${0}"/>
                    <c:forEach items="${allExpenses}" var="expenses">
                        <c:set var="expTotal" value="${expTotal + expenses.expenseAmount}"/>
                        <c:if test="${(expenses.category == 'Entertainment')}"><c:set var="enterTotal" value="${enterTotal + expenses.expenseAmount}"/></c:if>
                        <c:if test="${(expenses.category == 'Food')}"><c:set var="foodTotal" value="${foodTotal + expenses.expenseAmount}"/></c:if>
                        <c:if test="${(expenses.category == 'Transportation')}"><c:set var="tranTotal" value="${tranTotal + expenses.expenseAmount}"/></c:if>
                        <c:if test="${(expenses.category == 'Housing')}"><c:set var="houseTotal" value="${houseTotal + expenses.expenseAmount}"/></c:if>
                        <c:if test="${(expenses.category == 'Utilities')}"><c:set var="utilTotal" value="${utilTotal + expenses.expenseAmount}"/></c:if>
                        <c:if test="${(expenses.category == 'Others')}"><c:set var="othersTotal" value="${othersTotal + expenses.expenseAmount}"/></c:if>

                        <tr>
                            <td> ${expenses.expenseName} </td>
                            <td> ${expenses.category} </td>
                            <td id="testFood" > ${expenses.expenseAmount} </td>
                            <td><a href="edit?idToEdit=${expenses.id}">Edit</a></td>
                            <td><a href="remove?toRemoveId=${expenses.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <div hidden>
        Total expenses:<p>${expTotal}</p>
        Entertainment expenses:<p id="enterPercent"> ${100*enterTotal/expTotal}</p>
        Food expenses:<p id="foodPercent">${100*foodTotal/expTotal} </p>
        Transportation expenses:<p id="tranPercent">${100*tranTotal/expTotal}</p>
        Housing expenses:<p id="housePercent">${100*houseTotal/expTotal}</p>
        Utilities expenses:<p id="utilPercent">${100*utilTotal/expTotal}</p>
        Others expenses:<p id="othersPercent">${100*othersTotal/expTotal}</p>
    </div>

<%@include  file="chart.html" %>
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <a href="<c:url value=".."/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> Back </a>
</div>



<%@ include file="../footer.jsp" %>
