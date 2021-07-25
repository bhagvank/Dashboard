<%@ page session="false"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


The time is now <%= new java.util.Date() %>.

<c:out value="${model.now}"/>
<HTML>
<BODY>
<TABLE>
<c:forEach items="${model.list}" var="item">
<TR>
<TD>
<c:out value="${item}"/>
</TD>
</TR>
</c:forEach>
</TABLE>
</BODY>
</HTML>