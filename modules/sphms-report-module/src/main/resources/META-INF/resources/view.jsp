<%@ include file="/init.jsp" %>

<liferay-ui:tabs names="OutStanding Report,LandLoad Report,Out Standing Client Report" refresh="false"  tabsValues="OutStanding Report, LandLoad Report,Out Standing Client Report">
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