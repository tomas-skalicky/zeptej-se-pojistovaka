<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include-preceding-html.jsp"%>

<aside id="filters">
    <header>
        <h4 class="right-header dark-grey-container">filtry</h4>
    </header>
    <div class="deactivate-filter">
        <button class="btn btn-link btn-large">Deaktivovat filter</button>
        <div class="clear"></div>
    </div>
    <div class="filter-list">
        <div class="btn-group filter">
            <a class="btn btn-link filter-label" type="button"><input name="filterId" type="hidden" value="8" /><span
                class="glyphicon glyphicon-home"></span> <span class="filter-name">pojištění Bytové jednotky</span></a><a href="#delete-modal"
                role="button" data-toggle="modal" class="btn btn-link delete"><span data-toggle="tooltip" title="Smazat"
                class="glyphicon glyphicon-remove" data-container="body"></span></a>
        </div>
        <div class="btn-group filter">
            <a class="btn btn-link filter-label" type="button"><input name="filterId" type="hidden" value="9" /><span
                class="glyphicon glyphicon-home"></span> <span class="filter-name">pojištění Domácnosti</span></a><a href="#delete-modal"
                role="button" data-toggle="modal" class="btn btn-link delete"><span data-toggle="tooltip" title="Smazat"
                class="glyphicon glyphicon-remove" data-container="body"></span></a>
        </div>
        <div class="btn-group filter">
            <a class="btn btn-link filter-label" type="button"><input name="filterId" type="hidden" value="10" /><span
                class="filter-name">Důchodové pojištění</span></a><a href="#delete-modal" role="button" data-toggle="modal"
                class="btn btn-link delete"><span data-toggle="tooltip" title="Smazat" class="glyphicon glyphicon-remove"
                data-container="body"></span></a>
        </div>
        <div class="btn-group filter">
            <a class="btn btn-link btn-large filter-label" type="button"><input name="filterId" type="hidden" value="11" /><span
                class="glyphicon glyphicon-road"></span> <span class="filter-name">Havarijní pojištění</span></a>
        </div>
        <div class="btn-group filter">
            <a class="btn btn-link filter-label" type="button"><input name="filterId" type="hidden" value="12" /><span
                class="filter-name">pojištění Na dožití</span></a>
        </div>
        <div class="btn-group filter">
            <a class="btn btn-link filter-label" type="button"><input name="filterId" type="hidden" value="13" /><span
                class="glyphicon glyphicon-heart"></span> <span class="filter-name">Nemocenské pojištění</span></a>
        </div>
        <div class="btn-group filter">
            <a class="btn btn-link filter-label" type="button"><input name="filterId" type="hidden" value="14" /><span
                class="filter-name">pojištění Odpovědnosti za škodu</span></a>
        </div>
        <div class="btn-group filter">
            <a class="btn btn-link filter-label" type="button"><input name="filterId" type="hidden" value="15" /><span
                class="filter-name">Penzijní připojištění</span></a>
        </div>
        <div class="btn-group filter">
            <a class="btn btn-link btn-large filter-label" type="button"><input name="filterId" type="hidden" value="16" /><span
                class="glyphicon glyphicon-road"></span> <span class="filter-name">Povinné ručení</span></a>
        </div>
        <div class="btn-group filter">
            <a class="btn btn-link btn-mini filter-label" type="button"><input name="filterId" type="hidden" value="17" /><span
                class="filter-name">pojištění Proti odcizení</span> </a><a href="#delete-modal" role="button" data-toggle="modal"
                class="btn btn-link btn-mini delete"><span data-toggle="tooltip" title="Smazat" class="glyphicon glyphicon-remove"
                data-container="body"></span></a>
        </div>
        <div class="btn-group filter">
            <a class="btn btn-link btn-mini filter-label" type="button"><input name="filterId" type="hidden" value="18" /><span
                class="glyphicon glyphicon-briefcase"></span> <span class="filter-name">Spoření</span> </a><a href="#delete-modal" role="button"
                data-toggle="modal" class="btn btn-link btn-mini delete"><span data-toggle="tooltip" title="Smazat"
                class="glyphicon glyphicon-remove" data-container="body"></span></a>
        </div>
        <div class="btn-group filter">
            <a class="btn btn-success filter-label selected-filter" type="button"><input name="filterId" type="hidden" value="19" /><span
                class="glyphicon glyphicon-heart"></span> <span class="filter-name">Úrazové pojištění</span></a><a href="#delete-modal"
                role="button" data-toggle="modal" class="btn delete selected-filter"><span data-toggle="tooltip" title="Smazat"
                class="glyphicon glyphicon-remove" data-container="body"></span></a>
        </div>
        <div class="btn-group filter">
            <a class="btn btn-link btn-small filter-label" type="button"><input name="filterId" type="hidden" value="20" /><span
                class="glyphicon glyphicon-fire"></span> <span class="filter-name">Živelné pojištění</span></a><a href="#delete-modal"
                role="button" data-toggle="modal" class="btn btn-link btn-small delete"><span data-toggle="tooltip" title="Smazat"
                class="glyphicon glyphicon-remove" data-container="body"></span></a>
        </div>
    </div>
    <footer>
        <div class="input-group" id="add-filter">
            <span data-toggle="tooltip" title="Název nového filtru" data-placement="top"><input name="filterName" type="text"
                placeholder="Název nového filtru..." class="form-control" /></span> <span class="input-group-btn">
                <button class="btn btn-info" type="button" data-toggle="tooltip" title="Přidat" data-container="body">
                    <span class="glyphicon glyphicon-plus"></span>
                </button>
            </span>
        </div>
    </footer>
</aside>
