<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include-preceding-html.jsp"%>

<div id="delete-modal" class="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <input name="item-to-be-deleted-id" type="hidden" />
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title confirmation-question"></h4>
            </div>
            <div class="modal-footer">
                <button class="btn btn-info delete">Smazat</button>
                <button class="btn" data-dismiss="modal" aria-hidden="true">Zrušit</button>
            </div>
        </div>
    </div>
</div>
