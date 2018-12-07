<%@ include file="../init.jsp" %>
<liferay-ui:error key="err-add-land-lord" message="err-add-land-lord"/>
<liferay-ui:error key="err-update-land-lord" message="err-update-land-lord"/>

<portlet:actionURL var="addLandLordURL" name="/add_land_lord">
</portlet:actionURL>

<section class="content-header">
  <c:choose>
	<c:when test="${ landLord.landLordId gt 0}">
		<h1>
    		<liferay-ui:message key="update.land-lord"/> 
  		</h1>
	</c:when>
	<c:otherwise>
		<h1>
    		<liferay-ui:message key="add.land-lord"/> 
  		</h1>
	</c:otherwise>
</c:choose>
</section>
<br/>
<div class="row">
	<div class="col-xs-12">
    	<div class="box">
       		<div class="box-body">
       			<aui:form name="addLandLordForm" action="${addLandLordURL}" cssClass="row contact_form" method="POST">
       				<div class="row">
	       				<div class="form-group col-md-6">
	       					 <aui:input name="firstName" label="firstName" cssClass="form-control" value="${landLord.firstName }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>	 
						<div class="form-group col-md-6">
							 <aui:input name="lastName" label="lastName" cssClass="form-control" value="${landLord.lastName }"> 
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
	       				</div>
       				</div>
       				<div class="row">
       					<div class="form-group col-md-6">
       						 <aui:input name="location" label="location" cssClass="form-control" value="${landLord.location }">
					     		<aui:validator name="required" />
					     		<aui:validator name="maxLength">70</aui:validator>
						 	</aui:input>
						</div>
						 <div class="form-group col-md-6">	
						 	<aui:input name="city" label="city" cssClass="form-control" value="${landLord.city }">
					     		<aui:validator name="required" />
					     		<aui:validator name="maxLength">70</aui:validator>
						 	</aui:input>
       					</div>
       				</div>
       				<div class="row">
       					<div class="form-group col-md-6">	
						 	<aui:input name="state" label="State" cssClass="form-control" value="${landLord.statec }">
					     		<aui:validator name="required" />
					     		<aui:validator name="maxLength">70</aui:validator>
						 	</aui:input>
       					</div>
       					<div class="form-group col-md-6">
       						 <aui:input name="phoneNo" label="phoneNo" cssClass="form-control" value="${landLord.phoneNo }">
					    	 	<aui:validator name="required" />
					    	 	<aui:validator name="maxLength">70</aui:validator>
						 	</aui:input>
       					</div>
       				</div>
       				<div class="row">
       					<div class="form-group col-md-6">	
						 	<aui:input name="gstNo" label="GST No" cssClass="form-control" value="${landLord.gstNo }">
					     		<aui:validator name="required" />
					     		<aui:validator name="maxLength">70</aui:validator>
						 	</aui:input>
       					</div>
       				</div>
       				<c:choose>
						<c:when test="${ landLord.landLordId gt 0}">
							<div class="row">
       							<div class="form-group col-md-12">
									<aui:button type="button" value="Update Land Lord"  cssClass="addLandLordBtn btn btn-primary"/>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="row">
       							<div class="form-group col-md-12">
									<aui:button type="button" value="Add Land Lord"  cssClass="addLandLordBtn btn btn-primary"/>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
					<aui:input type="hidden"  name="landLordId" value="${landLord.landLordId }"/>
       			</aui:form>
       		</div>
        </div>
   </div>
</div>	

<aui:script>
var userModuleNameSpace =  '<portlet:namespace/>';
AUI().use('aui-base','aui-form-validator', function(A) {
	var addLandLordBtn= A.one(".addLandLordBtn");
	addLandLordBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />addLandLordForm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />addLandLordForm.submit();
		}
	});
});
</aui:script>