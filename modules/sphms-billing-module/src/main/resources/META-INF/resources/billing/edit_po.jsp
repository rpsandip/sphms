<%@ include file="../init.jsp" %>

<portlet:actionURL var="editPODetailURL" name="/edit-po">
</portlet:actionURL>

<section>
	<h1>
    	<span>
    		<liferay-ui:message key="edit.po"/> 
    	</span>
    	<span class="pull-right">
    		<h4>PO  : </h4> ${poNumber }
    	</span>
  	</h1>
</section>

<div class="row">
	<div class="col-xs-12">
    	<div class="box">
       		<div class="box-body">
       			<aui:form name="editPOFm" action="${editPODetailURL}" cssClass="row contact_form" method="POST">
      				
      				<c:forEach items="${billingPOBeanList }" var="billingPOBean" >
      				
	      				<div class="row">
		       				<div class="form-group col-md-12">
		       					<b>Hoarding : </b> ${billingPOBean.hordingTitle }
		       				</div>
		       				<div class="form-group col-md-12">
		       					<aui:input type="text" name="totalAmount" label="Total Amount" value="${billingPOBean.totalAmount }"/>
		       					<aui:input type="hidden" name="hordingId" label="" value="${billingPOBean.hordingId }"/>
		       				</div>
		       			</div>	
	       			
	       			</c:forEach>
	       			
	       			
	       			<div class="row">
     					<div class="form-group col-md-12">
     						<%-- <aui:input type="hidden" name="hordingId" value="${billingPOBean.hordingId }"></aui:input> --%>
     						 <aui:input type="hidden" name="billingId" value="${billingId }"></aui:input>
     						 <aui:input type="hidden" name="landLordId" value="${landLordId }"></aui:input>
							<aui:button type="button" value="Update PO"  cssClass="editPOBtn btn btn-primary"/>
						</div>
					</div>
      			</aui:form>
      		</div>
      	</div>		
    </div>
</div>    
<aui:script>
var userModuleNameSpace =  '<portlet:namespace/>';
AUI().use('aui-base','aui-form-validator', function(A) {
	var editPOBtn= A.one(".editPOBtn");
	editPOBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />editPOFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />editPOFm.submit();
		}
	});
});
</aui:script> 		 
      