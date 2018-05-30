<%@ include file="../init.jsp" %>

<portlet:actionURL var="addProposalURL" name="/add_proposal">
</portlet:actionURL>

<section class="content-header">
	<h1>
    	<liferay-ui:message key="add.proposal"/> 
  	</h1>
</section>

<liferay-ui:error key="err-add-proposal" message="err-add-proposal"/>

<div class="row">
	<div class="col-xs-12">
    	<div class="box">
       		<div class="box-body">
       			<aui:form name="addProposalFm" action="${addProposalURL}" cssClass="row contact_form">
       				<div class="row">
	       				<div class="form-group col-md-6">
	       					<aui:input type="text" name="camapaignTitle" label="campaign" />
	       				</div>
	       				<div class="form-group col-md-6">
	       					<aui:select name="client" label="client" cssClass="form-control">
	       					 	<aui:option value="">Select Client</aui:option>
	       					 	<c:forEach items="${allClientList }" var="client">
	       					 		<aui:option value="${client.clientId }" > ${client.clientName}</aui:option>
	       					 	</c:forEach>
							</aui:select>
	       				</div>
	       			</div>
	       			<div class="row">
	       				<div class="form-group col-md-6">
	       					<aui:input name="startDate" label="start.date" cssClass="form-control" readonly="true"/> 
	       				</div>
	       				<div class="form-group col-md-6">
	       					<aui:input name="endDate" label="end.date" cssClass="form-control" readonly="true"/> 
	       				</div>
	       			</div>	
       				<div class="row">
     					<div class="form-group col-md-12">
     						<h4><liferay-ui:message key="selected.hoardings"/> </h4>
     					</div>
     					<c:forEach items="${hordindList }" var="hording" varStatus="loop">
     						<div class="form-group col-md-3">
	       					 	<aui:input type="text" name="title${loop.index}" label="title" value="${hording.title }" readonly="true"/>	
	       					 	<aui:input type="hidden" name="hordingId${index }" label="title" />
     						</div>
     						<div class="form-group col-md-3">
	       					 	<aui:input type="text" name="moutingCharge${loop.index}" label="mountingCharge" />	
     						</div>
     						<div class="form-group col-md-3">
	       					 	<aui:input type="text" name="printingCharge${loop.index}" label="printingCharge" />	
     						</div>
     						<div class="form-group col-md-3">
	       					 	<aui:input type="text" name="units${loop.index}" label="units" />	
     						</div>
     						<hr/>
     					</c:forEach>
     				</div>	
       				<div class="row">
     					<div class="form-group col-md-12">
							<aui:button type="button" value="Add Proposal"  cssClass="addProposalBtn btn btn-primary"/>
						</div>
					</div>
					<aui:input type="hidden"  name="selectedHordingIds" value="${ selectedHordingIds}"/>
       			</aui:form>
       		</div>
       	</div>
    </div>
</div>
<script type="text/javascript">
jQuery.noConflict();
(function($) { 
	
	$(function() {
    	//Date picker
  	  $('#'+ '<portlet:namespace/>' + 'startDate').datepicker({
  		format: 'dd/mm/yyyy',  
  	    autoclose: true
  	  });
  	  
  	  $('#'+ '<portlet:namespace/>' + 'endDate').datepicker({
  			format: 'dd/mm/yyyy',  
  		    autoclose: true
  	  });
  	  
	 });
})(jQuery);
</script>

<aui:script>
var userModuleNameSpace =  '<portlet:namespace/>';
AUI().use('aui-base','aui-form-validator', function(A) {
	var addProposalBtn= A.one(".addProposalBtn");
	addProposalBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />addProposalFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />addProposalFm.submit();
		}
	});
});
</aui:script> 