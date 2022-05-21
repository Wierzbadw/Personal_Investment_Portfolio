<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>Usuwanie</title>
    <%@ include file="../header.jsp" %>
    <link href="<c:url value="../../../css/sb-admin-2.css"/>" rel="stylesheet">
</head>
<h3>Do you want to delete stock: ${stock.stockName} [${stock.stockSymbol}] ?</h3>
<br/><br/>
<div class="form-group">
    <form method="post">
        <input type="hidden" name="toRemoveId" value="${stock.id}"><br/><br/>
        <button type="submit" value="yes" name="confirmed" class="btn btn-primary">YES</button>
        <button type="submit" value="no" name="confirmed" class="btn btn-primary">NO</button><br/><br/>
    </form>
    <br/><br/>
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <a href="<c:url value=".."/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> Back </a>
    </div><%@ include file="../footer.jsp" %>
