<%@ include file="/init.jsp" %>

<liferay-ui:tabs names="outStanding Report,landLoad Report,tab3" refresh="false"  tabsValues="outStanding Report,landLoad Report,tab3">
    <liferay-ui:section>
      <%@ include file="Reports/outStandingReport.jsp" %>
    </liferay-ui:section>
    <liferay-ui:section>
        <%@ include file="Reports/landLoadReport.jsp" %>
    </liferay-ui:section>
    <liferay-ui:section>
      
    </liferay-ui:section>
</liferay-ui:tabs>