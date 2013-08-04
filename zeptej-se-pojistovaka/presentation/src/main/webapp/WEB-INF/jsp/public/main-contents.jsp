<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include-preceding-html.jsp"%>

<div id="contents-wrapper" class="color-container white-container">
    <div class="row">

        <%@ include file="questionsAndAnswers/list.jsp"%>

        <div class="col-12 col-sm-5">
            <%@ include file="filters/list.jsp"%>
            <%@ include file="facebook-comments.jsp"%>
        </div>
    </div>
</div>
