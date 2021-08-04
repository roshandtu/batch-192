<%
int f1=Integer.parseInt(request.getParameter("n1"));
int f2=Integer.parseInt(request.getParameter("n2"));
int result=f1+f2 ;
%>
<jsp:forward page="resultjsp.jsp">
<jsp:param name="result"  value="<%=result%>" />
</jsp:forward>
