<%@ include file="/init.jsp" %>
<portlet:renderURL var="addClientURL">
        <portlet:param name="mvcRenderCommandName" value="/prepare-proposal" />
</portlet:renderURL>

<liferay-ui:success key="proposal-added-successfully" message="proposal-added-successfully"/>

<a href="${addClientURL}" class="btn btn-primary">Add Proposal</a>