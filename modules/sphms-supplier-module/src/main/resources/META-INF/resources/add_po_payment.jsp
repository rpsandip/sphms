<%@ include file="/init.jsp" %>
<portlet:actionURL var="addPOPaymentURL" name="/add_PO_payment">
</portlet:actionURL>

<section class="content-header">
<c:choose>
	<c:when test="${ poPayment.poPaymentId gt 0}">
		<h1>
   		 	<liferay-ui:message key="Update Payment"/>
  		</h1>
	</c:when>
	<c:otherwise>
		<h1>
   			 <liferay-ui:message key="Add Payment"/>
  		</h1>
	</c:otherwise>
</c:choose>
  
</section>
<br/>
<br/>
<div class="row">
	<div class="col-xs-12">
    	<div class="box">
       		<div class="box-body">
       			<aui:form name="addBillPaymentFm" action="${addPOPaymentURL}" cssClass="row contact_form">
       				<div class="row">
						<div class="form-group col-md-6">
							<aui:input name="amount" label="amount" cssClass="form-control" placeholder="Rs." value="${poPayment.amount }"> 
						     	<aui:validator name="required" />
						     	<aui:validator name="number" />
							 </aui:input>
						</div>
						<div class="form-group col-md-6">
							<aui:input name="gst" label="GST" cssClass="form-control" placeholder="Rs." value="${poPayment.gst }"> 
							 </aui:input>
						</div>
       				</div>
       				<div class="row">
						<div class="form-group col-md-6">
							 <fmt:formatDate pattern = "dd/MM/yyyy" value = "${poPayment.paymentDate}" var="paymentDate"/>
							 <aui:input name="paymentDate" label="Payment Date" cssClass="form-control" value="${paymentDate }">
							 	<aui:validator name="required" />
							 </aui:input> 
	       				</div>
						<div class="form-group col-md-6">
							<aui:input name="chequeNo" label="chequeNo" cssClass="form-control" value="${poPayment.chequeNo }"> 
							 </aui:input>
						</div>
       				</div>
       				<div class="row">
       					<c:choose>
       						<c:when test="${ poPayment.poPaymentId gt 0}">
       							<div class="form-group col-md-12">
									<aui:button type="button" value="Update Payment"  cssClass="addPaymentBtn btn btn-primary"/>
								</div>
       						</c:when>
       						<c:otherwise>
       							<div class="form-group col-md-12">
									<aui:button type="button" value="Add Payment"  cssClass="addPaymentBtn btn btn-primary"/>
								</div>
       						</c:otherwise>
						</c:choose>
					</div>	
       				<aui:input type="hidden"  name="billingId" value="${billingId }"/>
       				<aui:input type="hidden"  name="landLordId" value="${landLordId }"/>
       				<aui:input type="hidden"  name="poPaymentId" value="${poPayment.poPaymentId }"/>
       				<aui:input type="hidden"  name="companyId" value="${companyId }"/>
       				
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
  	  $('#'+ '<portlet:namespace/>' + 'paymentDate').datepicker({
  		format: 'dd/mm/yyyy',  
  	    autoclose: true
  	  }).on('changeDate', function(ev) {
  		  AUI().use('aui-base','aui-form-validator', function(A) {
  				var myFormValidator = Liferay.Form.get('<portlet:namespace />addBillPaymentFm').formValidator;
  				myFormValidator.validateField('<portlet:namespace />paymentDate');
  			});
  	  });
  	  
	  $('#'+'<portlet:namespace/>'+'amount').keyup(function () { 
		    this.value = this.value.replace(/[^0-9]/g,'');
	  });
	  
	  $('#'+'<portlet:namespace/>'+'gst').keyup(function () { 
		    this.value = this.value.replace(/[^0-9]/g,'');
	  });
	  });

})(jQuery);
</script>
<aui:script>
var userModuleNameSpace =  '<portlet:namespace/>';
AUI().use('aui-base','aui-form-validator', function(A) {
	var addPaymentBtn= A.one(".addPaymentBtn");
	addPaymentBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />addBillPaymentFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />addBillPaymentFm.submit();
		}
	});
});
</aui:script>