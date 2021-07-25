<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.vericept.dashboard.services.reporting.*,java.io.*,java.util.*"%>
<%@page import="com.vericept.dashboard.delegate.BusinessDelegate"%>
<%@page import="com.vericept.dashboard.constants.*"%>

<%
      String portletName = request.getParameter("portletName");
     
          //get Preferences
          Map prefMap = (Map) request.getAttribute("preferences");
          
          BusinessDelegate delegate = (BusinessDelegate) session.getAttribute("delegate");
          if(delegate == null)
          {
            delegate = new BusinessDelegate();
            session.setAttribute("delegate",delegate);
          }
 
   
       ByteArrayOutputStream outputStream = delegate.getPortletReport(prefMap,portletName);;

   byte[] bytes = outputStream.toByteArray();
   OutputStream jspStream = response.getOutputStream();
   jspStream.write(bytes,0,bytes.length);
   jspStream.flush();
   jspStream.close();
  
%>