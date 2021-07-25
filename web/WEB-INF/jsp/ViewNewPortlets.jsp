<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.vericept.dashboard.delegate.BusinessDelegate"%>
<%@page import="com.vericept.dashboard.constants.*"%>
<%@page import="java.awt.image.*,java.util.*"%>
<%@page import="javax.imageio.*,java.io.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<table>
<c:if test="${param.portletName !=null}">
<c:choose>
<c:when test="${param.chartType == 'Table View'}">
<TR>
<c:forEach items="${requestScope.model.dataMap}" var="item">
<TD>${item.key}</TD>
<TD>${item.value}</TD>    
</c:forEach>    
</TR>
</c:when>
<c:otherwise>
<tr>
<td colspan="6">
<img src="${requestScope.model.image}">
</td>
</tr>
</c:otherwise>
</c:choose>
<TR>
<c:forEach items="${requestScope.model.hitMap}" var="item">
<TD>${item.key}</TD>
<TD>${item.value}</TD>
</c:forEach>
</TR>
</c:if>
</table>
</BODY>
</HTML>