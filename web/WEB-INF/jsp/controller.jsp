<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="org.reubo.util.*"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <h1>JSP Page</h1>
    <%

      FileUploadBean bean = new FileUploadBean();
      bean.setSavePath("D:\\temp\\");
      bean.doUpload(request);
      String name = bean.getFieldValue("name");
  
      String status = bean.getFieldValue("status");

      out.println(name + " "+ status);
      
     // FileInputStream is = new FileInputStream(fileName);

      //int ch;
      //while ((ch = is.read()) >= 0)
      //out.print((char) ch);

     // is.close();

    %>
    
    <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
    <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
    --%>
    
    </body>
</html>