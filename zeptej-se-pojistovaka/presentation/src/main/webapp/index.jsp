<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include-preceding-html.jsp"%>

<%-- Forwards processing since we can't set the welcome page in web.xml to a "virtual" URL. --%>
<jsp:forward page="/public-homepage/" />
