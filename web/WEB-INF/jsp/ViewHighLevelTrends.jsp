<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.vericept.dashboard.delegate.BusinessDelegate"%>
<%@page import="com.vericept.dashboard.constants.*"%>
<%@page import="java.awt.image.*,java.util.*"%>
<%@page import="javax.imageio.*,java.io.*"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>


<%
     Map categoryTrendMap = new HashMap();
      String portletName = request.getParameter("portletName");
     // if(portletName !=null)
      //{
          //get Preferences
          Map prefMap = (Map) request.getAttribute("preferences");
          
          BusinessDelegate delegate = (BusinessDelegate) session.getAttribute("delegate");
          if(delegate == null)
          {
            delegate = new BusinessDelegate();
            session.setAttribute("delegate",delegate);
          }
       
          categoryTrendMap = delegate.getCategoryTrendMap(prefMap,portletName);
      //}
%>
<TABLE>
<TR>

</TR>
</TABLE>
</BODY>
</HTML>