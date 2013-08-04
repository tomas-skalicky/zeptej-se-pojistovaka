<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include-preceding-html.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Zeptej se Pojišťováka</title>
<tiles:insertAttribute name="headIncludes" />
</head>

<body>
    <div class="container">
        <div class="row">
            <tiles:insertAttribute name="header" />
        </div>

        <div class="row">
            <div class="col-12">
                <tiles:insertAttribute name="mainContents" />
            </div>
        </div>

        <footer class="row">
            <div class="col-12 col-lg-6 col-offset-3">
                <tiles:insertAttribute name="footer" />
            </div>
        </footer>
    </div>


    <!-- Modals -->
    <%@ include file="/WEB-INF/jsp/modal-dialogs/delete-modal.jsp"%>
    <%@ include file="/WEB-INF/jsp/modal-dialogs/data-protection-modal.jsp"%>
    <%@ include file="/WEB-INF/jsp/modal-dialogs/contact-modal.jsp"%>
    <%@ include file="/WEB-INF/jsp/modal-dialogs/cv-modal.jsp"%>

    <%@ include file="/WEB-INF/jsp/footer-javascripts.jsp"%>
</body>
</html>
