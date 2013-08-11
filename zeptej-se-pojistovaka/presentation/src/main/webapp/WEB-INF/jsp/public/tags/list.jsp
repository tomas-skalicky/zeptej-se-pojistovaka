<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include-preceding-html.jsp"%>

<aside id="tags">
    <header>
        <h4 class="right-header dark-grey-container">
            <spring:message code="tags" />
        </h4>
    </header>
    <div class="deactivate-tag">
        <button class="btn btn-link btn-large">
            <spring:message code="tags.deactivate" />
        </button>
        <div class="clear"></div>
    </div>
    <div class="tag-list">
        <div class="btn-group tag">
            <a class="btn btn-link tag-label" type="button"><input name="tagId" type="hidden" value="8" /><span
                class="glyphicon glyphicon-home"></span> <span class="tag-name">pojištění Bytové jednotky</span></a><a href="#delete-modal"
                role="button" data-toggle="modal" class="btn btn-link delete"><span data-toggle="tooltip" title="Smazat"
                class="glyphicon glyphicon-remove" data-container="body"></span></a>
        </div>
        <div class="btn-group tag">
            <a class="btn btn-link tag-label" type="button"><input name="tagId" type="hidden" value="9" /><span
                class="glyphicon glyphicon-home"></span> <span class="tag-name">pojištění Domácnosti</span></a><a href="#delete-modal"
                role="button" data-toggle="modal" class="btn btn-link delete"><span data-toggle="tooltip" title="Smazat"
                class="glyphicon glyphicon-remove" data-container="body"></span></a>
        </div>
        <div class="btn-group tag">
            <a class="btn btn-link tag-label" type="button"><input name="tagId" type="hidden" value="10" /><span class="tag-name">Důchodové
                    pojištění</span></a><a href="#delete-modal" role="button" data-toggle="modal" class="btn btn-link delete"><span
                data-toggle="tooltip" title="Smazat" class="glyphicon glyphicon-remove" data-container="body"></span></a>
        </div>
        <div class="btn-group tag">
            <a class="btn btn-link btn-large tag-label" type="button"><input name="tagId" type="hidden" value="11" /><span
                class="glyphicon glyphicon-road"></span> <span class="tag-name">Havarijní pojištění</span></a>
        </div>
        <div class="btn-group tag">
            <a class="btn btn-link tag-label" type="button"><input name="tagId" type="hidden" value="12" /><span class="tag-name">pojištění
                    Na dožití</span></a>
        </div>
        <div class="btn-group tag">
            <a class="btn btn-link tag-label" type="button"><input name="tagId" type="hidden" value="13" /><span
                class="glyphicon glyphicon-heart"></span> <span class="tag-name">Nemocenské pojištění</span></a>
        </div>
        <div class="btn-group tag">
            <a class="btn btn-link tag-label" type="button"><input name="tagId" type="hidden" value="14" /><span class="tag-name">pojištění
                    Odpovědnosti za škodu</span></a>
        </div>
        <div class="btn-group tag">
            <a class="btn btn-link tag-label" type="button"><input name="tagId" type="hidden" value="15" /><span class="tag-name">Penzijní
                    připojištění</span></a>
        </div>
        <div class="btn-group tag">
            <a class="btn btn-link btn-large tag-label" type="button"><input name="tagId" type="hidden" value="16" /><span
                class="glyphicon glyphicon-road"></span> <span class="tag-name">Povinné ručení</span></a>
        </div>
        <div class="btn-group tag">
            <a class="btn btn-link btn-mini tag-label" type="button"><input name="tagId" type="hidden" value="17" /><span
                class="tag-name">pojištění Proti odcizení</span> </a><a href="#delete-modal" role="button" data-toggle="modal"
                class="btn btn-link btn-mini delete"><span data-toggle="tooltip" title="Smazat" class="glyphicon glyphicon-remove"
                data-container="body"></span></a>
        </div>
        <div class="btn-group tag">
            <a class="btn btn-link btn-mini tag-label" type="button"><input name="tagId" type="hidden" value="18" /><span
                class="glyphicon glyphicon-briefcase"></span> <span class="tag-name">Spoření</span> </a><a href="#delete-modal" role="button"
                data-toggle="modal" class="btn btn-link btn-mini delete"><span data-toggle="tooltip" title="Smazat"
                class="glyphicon glyphicon-remove" data-container="body"></span></a>
        </div>
        <div class="btn-group tag">
            <a class="btn btn-success tag-label selected-tag" type="button"><input name="tagId" type="hidden" value="19" /><span
                class="glyphicon glyphicon-heart"></span> <span class="tag-name">Úrazové pojištění</span></a><a href="#delete-modal"
                role="button" data-toggle="modal" class="btn delete selected-tag"><span data-toggle="tooltip" title="Smazat"
                class="glyphicon glyphicon-remove" data-container="body"></span></a>
        </div>
        <div class="btn-group tag">
            <a class="btn btn-link btn-small tag-label" type="button"><input name="tagId" type="hidden" value="20" /><span
                class="glyphicon glyphicon-fire"></span> <span class="tag-name">Živelné pojištění</span></a><a href="#delete-modal"
                role="button" data-toggle="modal" class="btn btn-link btn-small delete"><span data-toggle="tooltip" title="Smazat"
                class="glyphicon glyphicon-remove" data-container="body"></span></a>
        </div>
    </div>
    <footer>
        <div class="input-group" id="add-tag">
            <span data-toggle="tooltip" title="Název nového filtru" data-placement="top"><input name="tagName" type="text"
                placeholder="Název nového filtru..." class="form-control" /></span> <span class="input-group-btn">
                <button class="btn btn-info" type="button" data-toggle="tooltip" title="Přidat" data-container="body">
                    <span class="glyphicon glyphicon-plus"></span>
                </button>
            </span>
        </div>
    </footer>
</aside>
