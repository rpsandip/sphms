<%@ include file="../init.jsp" %>

<portlet:actionURL var="editBillingURL" name="/edit-billing">
</portlet:actionURL>

<liferay-ui:error key="err-update-booking" message="err-update-booking"/>

<section>
	<h1>
    	<span>
    		<liferay-ui:message key="edit.billing"/> 
    	</span>
    	<span class="pull-right">
    		<h4>Bill No : </h4> ${billingBean.displayBillNo }
    	</span>
  	</h1>
</section>

<div class="row">
	<div class="col-xs-12">
    	<div class="box">
       		<div class="box-body">
       			<aui:form name="editBillingFm" action="${editBillingURL}" cssClass="row contact_form" method="POST">
       				<c:set var="hordingCount" value="0"/>
       				<div class="row">
	       				<div class="form-group col-md-4">
	       					<b>Client : </b> ${billingBean.clientName }
	       				</div>
	       				<div class="form-group col-md-4">
	       					<b>Campaign : </b> ${billingBean.campaign }
	       				</div>
	       				<div class="form-group col-md-4">
	       					<fmt:formatDate pattern = "dd/MM/yyyy" 	value = "${ billingBean.bookingDate}"  var="bookingDate"/>
	       					<b>Booking Date : </b> ${bookingDate }
	       				</div>
	       			</div>
	       			<div class="row">
	       				<div class="form-group col-md-12">
	       					<hr/>
						</div>
					</div>		       			
	       			<div class="row">
	       				<div class="form-group col-md-4">
	       					<aui:input type="text" name="clientPANNo" label="client.pan.no" value="${billingBean.clientPANNo }"/>
	       				</div>	
	       				<div class="form-group col-md-4">
	       					<aui:input type="text" name="clientPONo" label="client.po.no" value="${billingBean.clientPONumber }"/>
	       				</div>	
	       				<div class="form-group col-md-4">
	       					<aui:input type="text" name="clientGSTNo" label="client.gst.no" value="${billingBean.clientGSTNumber }"/>
	       				</div>	
	       			</div>
	       			<div class="row">
	       				<div class="form-group col-md-4">
	       					<aui:input type="text" name="display" label="display" value="${billingBean.display }"/>
	       				</div>	
	       				<div class="form-group col-md-4">
	       					<aui:input type="text" name="accessAmount" label="access.amount" value="${billingBean.accessAmount }">
						     	<aui:validator name="number" />
	       					</aui:input>
	       				</div>	
	       				<div class="form-group col-md-4">
	       					<aui:input type="text" name="pendingAmount" label="pending.amount" value="${billingBean.pendingAmount }">
	       						<aui:validator name="number" />
	       					</aui:input>
	       				</div>	
	       			</div>
	       			
	       			<div class="row">
	       				<div class="form-group col-md-4">
	       				 <fmt:formatDate pattern = "dd/MM/yyyy" value = "${billingBean.publishDate}" var="publishDate"/>
	       					<aui:input type="text" name="publishDate" label="Publish Date" value="${ publishDate}"/>
	       				</div>	
	       			</div>	
	       			
	       			<div class="row">
	       				<div class="form-group col-md-12">
	       					<h4> Hoarding Detail :</h4>
	       				</div>
	       				<div class="row">
		       				<div class="form-group col-md-12">
		       					<hr/>
							</div>
						</div>		
	       				<c:forEach items="${billingHordingBeanList }" var="billingHordingBean" varStatus="loop">
	       					<aui:input type="hidden" name="hordingId${loop.index}" label="title" value="${billingHordingBean.hordingId }" readonly="true"/>
	       					<div class="form-group col-md-3">
	       					 	<aui:input type="text" name="title${loop.index}" label="title" value="${billingHordingBean.hording.title } (${billingHordingBean.hording.city })" readonly="true"/>
     						</div>
     						<div class="form-group col-md-3">
	       					 	<aui:input type="text" name="hsnNo${loop.index}" label="HSN/SAC Code" value="${billingHordingBean.hsnNo }">
	       					 		<aui:validator name="number" />
	       					 	</aui:input>
     						</div>
     						<div class="form-group col-md-2">
	       					 	<aui:input type="text" name="totalMountingCharge${loop.index}" label="totalMountingCharge" value="${billingHordingBean.totalMountingCharge }">
	       					 		<aui:validator name="number" />
	       					 	</aui:input>
     						</div>
     						<div class="form-group col-md-2">
	       					 	<aui:input type="text" name="totalPrintingCharge${loop.index}" label="totalPrintingCharge" value="${billingHordingBean.totalPrintingCharge }">
	       					 		<aui:validator name="number" />
	       					 	</aui:input>
     						</div>
     						<div class="form-group col-md-2">
	       					 	<aui:input type="text" name="totalHordingCharge${loop.index}" label="totalHordingCharge" value="${billingHordingBean.totalHordingCharge }">
	       					 		<aui:validator name="required" />
	       					 		<aui:validator name="number" />
	       					 	</aui:input>
     						</div>
     						<c:set var="hordingCount" value="${hordingCount + 1}" scope="page"/>
	       				</c:forEach>
	       			</div>	
	       			
	       			<div class="row">
     					<div class="form-group col-md-12">
     						<aui:input type="hidden" name="totalHordingCount" value="${hordingCount }"></aui:input>
     						<aui:input type="hidden" name="billingId" value="${billingBean.billingId }"></aui:input>
							<aui:button type="button" value="Update Bill"  cssClass="editBillBtn btn btn-primary"/>
						</div>
					</div>
       			</aui:form>
       		</div>
       </div>
    </div>
</div>       	

<script type="text/javascript">

		jQuery.noConflict();
		(function($) {
		    $(function() {
		    	
		    	var userModuleNameSpace =  '<portlet:namespace/>';
		    	AUI().use('aui-base','aui-form-validator', function(A) {
		    		var editBillBtn= A.one(".editBillBtn");
		    		editBillBtn.on('click', function(e) {
		    			var formValidator = Liferay.Form.get('<portlet:namespace />editBillingFm').formValidator;
		    			formValidator.validate();
		    			if(!formValidator.hasErrors()){
		    				document.<portlet:namespace />editBillingFm.submit();
		    			}
		    		});
		    	});
		    	
		    	$('#'+'<portlet:namespace/>'+'publishDate').datepicker({
					format : 'dd/mm/yyyy',
					autoclose : true
				});
		    	
		    });
		   })(jQuery);
</script>