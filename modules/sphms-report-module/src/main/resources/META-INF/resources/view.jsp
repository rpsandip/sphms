<%@ include file="/init.jsp" %>

<liferay-ui:tabs names="outStanding Report,landLoad Report,outStandingClientReport" refresh="false"  tabsValues="outStanding Report,landLoad Report,outStandingClientReports">
    <liferay-ui:section>
      <%@ include file="Reports/outStandingReport.jsp" %>
    </liferay-ui:section>
    <liferay-ui:section>
        <%@ include file="Reports/landLoadReport.jsp" %>
    </liferay-ui:section>
    <liferay-ui:section>
       <%@ include file="Reports/outStandingClientReport.jsp" %>
    </liferay-ui:section>
</liferay-ui:tabs>