<%@ page pageEncoding="UTF-8"%>
<%@ include file="include-preceding-html.jsp"%>

<div class="text-center page-footer color-container dark-grey-container">
    <p>
        <button class="btn btn-link show-data-protection" type="button" data-toggle="modal" data-target="#data-protection-modal">
            <spring:message code="data-protection" />
        </button>
        |
        <button class="btn btn-link show-contact" type="button" data-toggle="modal" data-target="#contact-modal">
            <spring:message code="contact" />
        </button>
        |
        <button class="btn btn-link show-cv" type="button" data-toggle="modal" data-target="#cv-modal">
            <spring:message code="my-cv" />
        </button>
    </p>
    <p>&copy; 2013 Marie Skalická</p>
</div>
