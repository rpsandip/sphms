<%@ include file="/init.jsp" %>

<liferay-ui:tabs names="OutStanding Report,LandLoad Report,Out Standing Client Report,Hording Report,Supplier OutStanding" refresh="false"  tabsValues="OutStanding Report, LandLoad Report,Out Standing Client Report,Hording Report">
    <liferay-ui:section>
      <%@ include file="Reports/outStandingReport.jsp" %>
    </liferay-ui:section>
    <liferay-ui:section>
        <%@ include file="Reports/landLoadReport.jsp" %>
    </liferay-ui:section>
    <liferay-ui:section>
       <%@ include file="Reports/outStandingClientReport.jsp" %>
    </liferay-ui:section>
     <liferay-ui:section>
       <%@ include file="Reports/hordingsReport.jsp" %>
    </liferay-ui:section>
    <liferay-ui:section>
       <%@ include file="Reports/supplieroutstanding.jsp" %>
    </liferay-ui:section>
</liferay-ui:tabs>