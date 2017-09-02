<%@ include file="../init.jsp" %>

<portlet:actionURL var="addBookingURL" name="/add_booking">
</portlet:actionURL>

<liferay-ui:error key="err-add-booking" message="err-add-booking"/>


<section class="content-header">
	<h1>
		<c:if test="${bookingId ne 0 }">
    		<liferay-ui:message key="add.booking"/> 
    	</c:if>
    	<c:if test="${bookingId gt 0 }">
    		<liferay-ui:message key="update.booking"/> 
    	</c:if>
    	
  	</h1>
</section>

<liferay-ui:error key="err-add-booking" message="err-add-proposal"/>

<div class="row">
	<div class="col-xs-12">
    	<div class="box">
       		<div class="box-body">
       			<aui:form name="addBookingFm" action="${addBookingURL}" cssClass="row contact_form">
       				<div class="row">
	       				<div class="form-group col-md-6">
	       					<aui:input type="text" name="camapaignTitle" label="campaign" value="${booking.campaignTitle }"/>
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
	       				 <fmt:formatDate pattern = "dd/MM/yyyy"  value = "${booking.startDate}"  var="startDate"/>
	       				<div class="form-group col-md-6">
	       					<aui:input name="startDate" label="start.date" cssClass="form-control" value="${startDate }"/> 
	       				</div>
	       				 <fmt:formatDate pattern = "dd/MM/yyyy"  value = "${booking.endDate}"  var="endDate"/>
	       				<div class="form-group col-md-6">
	       					<aui:input name="endDate" label="end.date" cssClass="form-control" value="${endDate }"/> 
	       				</div>
	       			</div>	
       				<div class="row">
     					<div class="form-group col-md-12">
     						<h4><liferay-ui:message key="selected.hoardings"/> </h4>
     					</div>
     					<c:if test="${bookingId eq 0 }">
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
     					</c:if>
     					<c:if test="${bookingId ne 0 }">
     						<c:forEach items="${bookingHordingBeanList }" var="bookingHordingBean" varStatus="loop">
     							<div class="form-group col-md-3">
		       					 	<aui:input type="text" name="title${loop.index}" label="title" value="${bookingHordingBean.hordingTitle }" readonly="true"/>	
		       					 	<aui:input type="hidden" name="hordingId${index }" value="${bookingHordingBean.hordingId }" label="title" />
	     						</div>
	     						<div class="form-group col-md-3">
		       					 	<aui:input type="text" name="moutingCharge${loop.index}" label="mountingCharge" value="${bookingHordingBean.mountingCharge }"/>	
	     						</div>
	     						<div class="form-group col-md-3">
		       					 	<aui:input type="text" name="printingCharge${loop.index}" label="printingCharge" value="${bookingHordingBean.printingCharge }"/>	
	     						</div>
	     						<div class="form-group col-md-3">
		       					 	<aui:input type="text" name="units${loop.index}" label="units" value="${bookingHordingBean.units }"/>	
	     						</div>
	     						<hr/>
     						</c:forEach>
     					</c:if>
     				</div>	
       				<div class="row">
     					<div class="form-group col-md-12">
							<aui:button type="button" value="Add Booking"  cssClass="addBookingBtn btn btn-primary"/>
						</div>
					</div>
					<aui:input type="hidden"  name="selectedHordingIds" value="${ selectedHordingIds}"/>
					<aui:input type="hidden"  name="selectedHordingIds" value="${ selectedBookinghordings}"/>
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

<aui:script>
var userModuleNameSpace =  '<portlet:namespace/>';
AUI().use('aui-base','aui-form-validator', function(A) {
	var addBookingBtn= A.one(".addBookingBtn");
	addBookingBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />addBookingFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />addBookingFm.submit();
		}
	});
});
</aui:script> 