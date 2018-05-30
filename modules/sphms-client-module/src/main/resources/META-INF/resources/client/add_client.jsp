<%@ include file="../init.jsp" %>

<portlet:actionURL var="addClientURL" name="/add_client">
</portlet:actionURL>

<liferay-ui:error key="error-add-client" message="error-add-client"/>
<liferay-ui:error key="error-update-client" message="error-update-client"/>

<section class="content-header">
  <c:choose>
	<c:when test="${ client.clientId gt 0}">
		<h1>
    		<liferay-ui:message key="update.client"/> 
  		</h1>
	</c:when>
	<c:otherwise>
		<h1>
    		<liferay-ui:message key="add.client"/> 
  		</h1>
	</c:otherwise>
</c:choose>
</section>
<br/>
<div class="row">
	<div class="col-xs-12">
    	<div class="box">
       		<div class="box-body">
       			<aui:form name="addClientForm" action="${addClientURL}" cssClass="row contact_form">
       				<div class="row">
	       				<div class="form-group col-md-12">
	       					 <aui:input name="clientName" label="clientName" cssClass="form-control" value="${client.clientName }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>	 
       				</div>
       				<div class="row">
	       				<div class="form-group col-md-6">
	       					 <aui:input name="address1" label="address1" cssClass="form-control" value="${client.address1 }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>
						<div class="form-group col-md-6">
	       					 <aui:input name="address2" label="address2" cssClass="form-control" value="${client.address2 }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>	 
       				</div>
       				<div class="row">
       					<div class="form-group col-md-6">
	       					 <aui:input name="city" label="city" cssClass="form-control" value="${client.city }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>
						<div class="form-group col-md-6">
	       					 <aui:input name="state" label="state" cssClass="form-control" value="${client.state }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>	 
       				</div>
       				<div class="row">
       					<div class="form-group col-md-4">
	       					 <aui:input name="contactPersonName" label="contactPersonName" cssClass="form-control" value="${client.contactPersonName }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>
						<div class="form-group col-md-4">
	       					 <aui:input name="contactPersonEmail" label="contactPersonEmail" cssClass="form-control" value="${client.contactPersonEmail }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
						     	<aui:validator name="email"></aui:validator>
							 </aui:input>
						</div>
						<div class="form-group col-md-4">
	       					 <aui:input name="contactPersonPhoneNo" label="contactPersonPhoneNo" cssClass="form-control" value="${client.contactPersonPhoneNo }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>
       				</div>
       				<div class="row">
       					<div class="form-group col-md-6">
	       					 <aui:input name="panNo" label="Pan No" cssClass="form-control" value="${client.panNo }">
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>
						<div class="form-group col-md-6">
	       					 <aui:input name="gstNo" label="GST No" cssClass="form-control" value="${client.gstNo }">
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>	 
       				</div>
       				<c:choose>
						<c:when test="${ client.clientId gt 0}">
							<div class="row">
       							<div class="form-group col-md-12">
									<aui:button type="button" value="Update Client"  cssClass="addClientBtn btn btn-primary"/>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="row">
       							<div class="form-group col-md-12">
									<aui:button type="button" value="Add Client"  cssClass="addClientBtn btn btn-primary"/>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
					<aui:input type="hidden"  name="clientId" value="${client.clientId }"/>
       			</aui:form>
       		</div>
       	</div>
     </div>
</div>
<aui:script>
var userModuleNameSpace =  '<portlet:namespace/>';
AUI().use('aui-base','aui-form-validator', function(A) {
	var addClientBtn= A.one(".addClientBtn");
	addClientBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />addClientForm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />addClientForm.submit();
		}
	});
});
</aui:script>      			