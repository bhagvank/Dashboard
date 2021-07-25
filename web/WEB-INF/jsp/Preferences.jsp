<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page import="com.vericept.dashboard.constants.*,java.util.*,com.vericept.dashboard.valueobject.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Preferences</title>
    </head>
    <body>

    <h1>Preferences</h1>
    <form action="Preferences.jsp">
    <input type="hidden" name="action" value="update">
    <table>
    <tr>
<th>Layout</th>

<td><select name="layout">
<c:forEach items="${requestScope.model.layouts}" var="layout">
    <option value="${layout.id}">${layout.name}</option>
    </c:forEach>
</select>
</td>
    </tr>
    
    <tr>
<th>Portlets</th>
<td><select name="portlet">
    <c:forEach items="${requestScope.model.portlets}" var="portlet">
    <option value="${portlet.id}">${portlet.name}</option>
    </c:forEach>
</td>
   
 <tr>
<th>Chart Type</th>
<td><select name="viewType">
<option value="<%=IChartConstants.BAR_GRAPH%>">Bar Graph</option>
<option value="<%=IChartConstants.PIE_CHART%>">Pie Chart</option>
<option value="<%=IChartConstants.TABLE_VIEW%>">Table View</option>
</select>
</td>
</tr>
<tr>
<th>FieldCount</th>
<td><select name="fieldCount">
<option value="10">10</option>
<option value="20">20</option>
<option value="30">30</option>
</select>
</td>
</tr>
<tr>
<th>Sort Order</th>
<td><select name="categoriesList">
<option value="asc">ascending</option>
<option value="desc">descending</option>
</select>
</td>
</tr>
     <tr>
    <td>
    <input type="submit" value="update">
    </td>
    </tr>
    </table>
    </form>
    </body>
</html>
