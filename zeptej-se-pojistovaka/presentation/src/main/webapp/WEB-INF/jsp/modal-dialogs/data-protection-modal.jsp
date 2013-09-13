<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include-preceding-html.jsp"%>

<div id="data-protection-modal" class="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title"><spring:message code="data-protection" /></h3>
            </div>
            <div class="modal-body">
                <p>
                    Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.<br />
                    Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.
                </p>
            </div>
            <div class="modal-footer">
                <button class="btn btn-info" data-dismiss="modal" aria-hidden="true"><spring:message code="close" /></button>
            </div>
        </div>
    </div>
</div>
