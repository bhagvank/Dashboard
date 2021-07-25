<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.vericept.dashboard.constants.*,java.util.*,com.vericept.dashboard.valueobject.*"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
<BODY>
<form action="ViewNewPortlets.jsp" target="right">
<table>
<tr>
<th>Portlet</th>
<td><select name="portletName">
<!-- <option value="<%=IPortletNames.CATEGORY_COMBINATION%>">Category Combo</option>
<option value="<%=IPortletNames.MOVING_AVERAGE%>">Moving Average</option>    
<option value="<%=IPortletNames.STACKED_AREA%>">Stacked Area</option>    
<option value="<%=IPortletNames.PIE_CHART%>">Pie Chart</option>    -->
<option value="<%=IPortletNames.USER_COUNT%>">UserCount</option>
<option value="<%=IPortletNames.CATEGORY_COUNT%>">CategoryCount</option>
<option value="<%=IPortletNames.SRC_COUNT%>">SourceCount</option>
<option value="<%=IPortletNames.DEST_COUNT%>">DestinationCount</option>
<option value="<%=IPortletNames.PROTOCOLS%>">Protocols</option>
</select>
</td>
</tr>
<tr>
<th>Period</th>
<td><select name="period">
<option value="<%=IPortletConstants.DAILY%>">24 Hours</option>
<option value="<%=IPortletConstants.MONTHLY%>">30 days</option>
<option value="<%=IPortletConstants.SEVEN_DAYS%>">7 days</option>
<option value="<%=IPortletConstants.TEN_DAYS%>">10 days</option>
</select>
</td>
</tr>
<tr>
<th>Category Group</th>
<td><select name="categoryGroup">
      <c:forEach items="${requestScope.model.categoryGroups}" var="categoryGroup">
    <option value="${categoryGroup.name}">${categoryGroup.name}</option>
    </c:forEach>
    <!--
<option value="<%=IPageConstants.INTERNET_ABUSE%>">Internet Abuse</option>
<option value="<%=IPageConstants.COMPLIANCE%>">Privacy & Compliance</option>
<option value="<%=IPageConstants.IPLOSS%>">Intellectual Property Loss</option>
<option value="<%=IPageConstants.INSIDER_HACKER%>">Insider Hacker</option>
<option value="<%=IPageConstants.WORKPLACE_STRESS%>">Workplace-Stress</option>
<option value="<%=IPageConstants.ALL_INSTANCE%>">All-Instance</option>
<option value="<%=IPageConstants.THREE_SIXTY_DEGREES%>">360 degrees</option>
-->
</select>
</td>
</tr>

<tr>
<th>Chart Type</th>
<td><select name="<%=IPreferences.CHART_TYPE%>">
<option value="<%=IChartConstants.BAR_GRAPH%>">Bar Graph</option>
<option value="<%=IChartConstants.PIE_CHART%>">Pie Chart</option>
<option value="<%=IChartConstants.TABLE_VIEW%>">Table View</option>
</select>
</td>
</tr>
<tr>
<th>FieldCount</th>
<td><select name="<%=IPreferences.FIELD_COUNT%>">
<option value="10">10</option>
<option value="20">20</option>
<option value="30">30</option>
</select>
</td>
</tr>
<tr>
<th>Sort Order</th>
<td><select name="<%=IPreferences.SORT_ORDER%>">
<option value="asc">ascending</option>
<option value="desc">descending</option>
</select>
</td>
</tr>
<tr>
<td>
<input type=submit value=submit>
</td>
</tr>
</table>
</form>
</BODY>
</HTML>
