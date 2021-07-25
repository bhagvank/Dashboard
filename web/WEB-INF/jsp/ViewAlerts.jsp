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


<ul>
<%
     List messageList = new ArrayList();
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
       
          messageList = delegate.getMessageList(prefMap,portletName,IMessageConstants.CATEGORY_INTERNET_ABUSE);
      //}
%>
<%
// out.println(messageList.size());
for(int i=0; i< messageList.size(); i++)
{
    String str = (String) messageList.get(i);
  //  out.println(str);
%>

<li><%= str%> </li>
<%
}
%>    
</ul>
</BODY>
</HTML>