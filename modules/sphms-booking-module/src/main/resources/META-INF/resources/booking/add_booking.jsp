<%@ include file="../init.jsp" %>

<portlet:actionURL var="addBookingURL" name="/add_booking">
</portlet:actionURL>

<liferay-ui:error key="err-add-booking" message="err-add-booking"/>


<section class="content-header">
	<h1>
		<c:if test="${bookingId eq 0 }">
    		<liferay-ui:message key="add.booking"/> 
    	</c:if>
    	<c:if test="${bookingId ne 0 }">
    		<liferay-ui:message key="update.booking"/> 
    	</c:if>
    	
  	</h1>
</section>

<liferay-ui:error key="err-add-booking" message="err-add-proposal"/>

<div class="row">
	<div class="col-xs-12">
    	<div class="box">
       		<div class="box-body">
       			<aui:form name="addBookingFm" action="${addBookingURL}"  method="post" cssClass="row contact_form">
       				<div class="row">
	       				<div class="form-group col-md-6">
	       					<aui:input type="text" name="camapaignTitle" label="campaign" value="${booking.campaignTitle }">
	       						<aui:validator name="required"></aui:validator>
	       					</aui:input>
	       				</div>
	       				<div class="form-group col-md-6">
	       					<aui:select name="clientId" label="client" cssClass="form-control">
	       					 	<aui:option value="">Select Client</aui:option>
	       					 	<c:forEach items="${allClientList }" var="client">
	       					 		<aui:option value="${client.clientId }" selected='${booking.client eq client.clientId ? true : false }' > ${client.clientName}</aui:option>
	       					 	</c:forEach>
							</aui:select>
	       				</div>
	       			</div>
	       			<div class="row">
	       				<div class="form-group col-md-4">
	       					<aui:select name="companyId" label="company" cssClass="form-control">
	       					 	<c:forEach items="${companyList }" var="company">
	       					 		<aui:option value="${company.companyId }" selected='${booking.customCompanyId eq company.companyId ? true : false }' > ${company.name}</aui:option>
	       					 	</c:forEach>
							</aui:select>
	       				</div>
	       				<fmt:formatDate pattern = "dd/MM/yyyy"  value = "${booking.startDate}"  var="startDate"/>
	       				<div class="form-group col-md-4">
	       					<aui:input name="startDate" label="start.date" cssClass="form-control" value="${startDate }" readonly="true">
	       						<aui:validator name="required"></aui:validator>
	       					</aui:input> 
	       				</div>
	       				 <fmt:formatDate pattern = "dd/MM/yyyy"  value = "${booking.endDate}"  var="endDate" />
	       				<div class="form-group col-md-4">
	       					<aui:input name="endDate" label="end.date" cssClass="form-control" value="${endDate }" readonly="true">
	       						<aui:validator name="required"></aui:validator>
	       					</aui:input> 
	       				</div>
	       			</div>	
       				<div class="row">
     					<div class="form-group col-md-12">
     						<h4><liferay-ui:message key="selected.hoardings"/> </h4>
     					</div>
     					<c:if test="${bookingId eq 0 }">
	     					<c:forEach items="${hordindList }" var="hording" varStatus="loop">
	     						<div class="form-group col-md-4">
		       					 	<aui:input type="text" name="title${loop.index}" label="title" value="${hording.title }" readonly="true"/>	
		       					 	<aui:input type="hidden" name="hordingId${index }" label="title" />
	     						</div>
	     						<div class="form-group col-md-3">
		       					 	<aui:input type="text" name="hsnNo${loop.index}" label="HSN Code" />	
	     						</div>
	     						<div class="form-group col-md-1">
		       					 	<aui:input type="text" name="hordingStartDate${loop.index}" label="Start Date"  value="${startDate }"/>	
	     						</div>
	     						<div class="form-group col-md-1">
		       					 	<aui:input type="text" name="hordingEndDate${loop.index}" label="End Date" value="${endDate }"/>	
	     						</div>
	     						<div class="form-group col-md-1">
		       					 	<aui:input type="text" name="moutingCharge${loop.index}" label="Mnt Chrg" />	
	     						</div>
	     						<div class="form-group col-md-1">
		       					 	<aui:input type="text" name="printingCharge${loop.index}" label="Prnt Chrg" />	
	     						</div>
	     						<div class="form-group col-md-1">
		       					 	<aui:input type="text" name="units${loop.index}" label="units" value="1">
		       					 		<aui:validator name="required" />
		       					 		<aui:validator name="number" />
		       					 		<aui:validator name="custom" errorMessage="err-valid-unit">
											function(val, fieldNode, ruleValue) {
						             			if(isNaN(val)){
						             				return false;
						             			}
						             			if(val<= 0){
						            				return false;
						            			}
				                                else {
						            				return true;
						            			}
											}
						         		</aui:validator>
		       					 	</aui:input>	
	     						</div>
	     						<hr/>
	     					</c:forEach>
     					</c:if>
     					<c:if test="${bookingId ne 0 }">
     						<c:forEach items="${bookingHordingBeanList }" var="bookingHordingBean" varStatus="loop">
     							<div class="form-group col-md-4">
		       					 	<aui:input type="text" name="title${loop.index}" label="title" value="${bookingHordingBean.hordingTitle }" readonly="true"/>	
		       					 	<aui:input type="hidden" name="hordingId${index }" value="${bookingHordingBean.hordingId }" label="title" />
	     						</div>
	     						<div class="form-group col-md-3">
		       					 	<aui:input type="text" name="hsnNo${loop.index}" label="HSN Code" value="${bookingHordingBean.hsnNo }"/>	
	     						</div><div class="form-group col-md-1">
	     						 	 <fmt:formatDate pattern = "dd/MM/yyyy"  value = "${bookingHordingBean.hordingBookingStartDate}"  var="hordingStartDate" />
		       					 	<aui:input type="text" name="hordingStartDate${loop.index}" label="Start Date"  value="${hordingStartDate }"/>	
	     						</div>
	     						<div class="form-group col-md-1">
	     							<fmt:formatDate pattern = "dd/MM/yyyy"  value = "${bookingHordingBean.hordingbookingEndDate}"  var="hordingEndDate" />
		       					 	<aui:input type="text" name="hordingEndDate${loop.index}" label="End Date" value="${hordingEndDate}"/>	
	     						</div>
	     						<div class="form-group col-md-1">
		       					 	<aui:input type="text" name="moutingCharge${loop.index}" label="Mnt Chrg" value="${bookingHordingBean.mountingCharge }"/>	
	     						</div>
	     						<div class="form-group col-md-1">
		       					 	<aui:input type="text" name="printingCharge${loop.index}" label="Prnt Chrg" value="${bookingHordingBean.printingCharge }"/>	
	     						</div>
	     						<div class="form-group col-md-1">
		       					 	<aui:input type="text" name="units${loop.index}" label="units" value="${bookingHordingBean.units }">
		       					 		<aui:validator name="required" />
		       					 		<aui:validator name="number" />
		       					 		<aui:validator name="custom" errorMessage="err-valid-unit">
											function(val, fieldNode, ruleValue) {
						             			if(isNaN(val)){
						             				return false;
						             			}
						             			if(val<= 0){
						            				return false;
						            			}
				                                else {
						            				return true;
						            			}
											}
						         		</aui:validator>
		       					 	</aui:input>	
	     						</div>
	     						<hr/>
     						</c:forEach>
     					</c:if>
     				</div>	
       				<div class="row">
     					<div class="form-group col-md-12">
							
							<c:if test="${bookingId eq 0 }">
    							<aui:button type="button" value="Add Booking"  cssClass="addBookingBtn btn btn-primary"/>
    						</c:if>
    						<c:if test="${bookingId ne 0 }">
    							<aui:button type="button" value="Update Booking"  cssClass="addBookingBtn btn btn-primary"/>
    						</c:if>
						</div>
					</div>
					<aui:input type="hidden"  name="selectedHordingIds" value="${ selectedHordingIds}"/>
					<aui:input type="hidden"  name="selectedBookinghordings" value="${ selectedBookinghordings}"/>
					<aui:input type="hidden" name="bookingId" value="${bookingId }"/>
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
<script type="text/javascript">
jQuery.noConflict();
(function($) {
    $(function() {
   		AUI().use('aui-base','liferay-portlet-url','aui-form-validator', function(A) {
   			var userModuleNameSpace =  '<portlet:namespace/>';
   			
   			var addBookingBtn= A.one(".addBookingBtn");
   			
   			var clientValidator = new A.FormValidator({
   				boundingBox: document.<portlet:namespace/>addBookingFm,
   				rules: {
   					<portlet:namespace/>clientId: {
   						required: true
   					}
   				},
   				fieldStrings: {
   					<portlet:namespace/>clientId: {
   						required: 'Please select Client'
   					}
   				}
   			});
   			
   			addBookingBtn.on('click', function(e) {
   				var formValidator = Liferay.Form.get('<portlet:namespace />addBookingFm').formValidator;
   				formValidator.validate();
   				clientValidator.validate();
   				if(!formValidator.hasErrors() && !clientValidator.hasErrors()){
   					document.<portlet:namespace />addBookingFm.submit();
   				}
   			});
   			
   			
   		});
    });
   })(jQuery);
</script>