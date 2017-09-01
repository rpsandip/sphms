<%@ include file="../init.jsp" %>
<liferay-ui:error key="err-add-land-lord-payment" message="err-add-land-lord-payment"/>
<liferay-ui:error key="err-update-land-lord-payment" message="err-update-land-lord-payment"/>

<portlet:actionURL var="addLandLordPayMentURL" name="/add_land_lord_payment">
</portlet:actionURL>

<section class="content-header">
  
<c:choose>
	<c:when test="${ landLordPayment.landLordPaymentId gt 0}">
		<h1>
   		 	<liferay-ui:message key="update.land-lord.payment"/> - ${landLord.firstName } ${landLord.lastName }
  		</h1>
	</c:when>
	<c:otherwise>
		<h1>
   			 <liferay-ui:message key="add.land-lord.payment"/>  - ${landLord.firstName } ${landLord.lastName }
  		</h1>
	</c:otherwise>
</c:choose>
  
  
  
</section>
<br/>
<div class="row">
	<div class="col-xs-12">
    	<div class="box">
       		<div class="box-body">
       			<aui:form name="landLordPaymentForm" action="${addLandLordPayMentURL}" cssClass="row contact_form">
       				<div class="row">
	       				<aui:select name="hordingId" label="Hording" cssClass="form-control">
	       					<c:forEach items="${landLordHordingList }" var="hording">
	       						<aui:option value="${hording.hordingId }"  selected='${hording.hordingId eq landLordPayment.hordingId ? true : false }'>${hording.title }</aui:option>
	       					</c:forEach>	
	       				</aui:select>
					</div>
					<div class="row">		 
						<div class="form-group col-md-6">
							 <aui:input name="amount" label="amount" cssClass="form-control" placeholder="Rs." value="${landLordPayment.amount }"> 
						     	<aui:validator name="required" />
						     	<aui:validator name="number" />
							 </aui:input>
	       				</div>
       				</div>
       				<div class="row">		 
						<div class="form-group col-md-6">
							<fmt:formatDate pattern = "dd/MM/yyyy" value = "${landLordPayment.paymentDate}" var="paymentDate"/>
							 <aui:input name="paymentDate" label="payment.date" cssClass="form-control" value="${paymentDate }"> 
						     	<aui:validator name="required" />
							 </aui:input>
	       				</div>
       				</div>
       				<div class="row">
       					<c:choose>
       						<c:when test="${ landLordPayment.landLordPaymentId gt 0}">
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
					<aui:input type="hidden"  name="landLordId" value="${landLordId }"/>
					<aui:input type="hidden"  name="landLordPaymentId" value="${landLordPayment.landLordPaymentId }"/>
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
				var myFormValidator = Liferay.Form.get('<portlet:namespace />landLordPaymentForm').formValidator;
				myFormValidator.validateField('<portlet:namespace />paymentDate');
			});
	  });
	  
	  $('#'+'<portlet:namespace/>'+'amount').keyup(function () { 
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
		var formValidator = Liferay.Form.get('<portlet:namespace />landLordPaymentForm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />landLordPaymentForm.submit();
		}
	});
});
</aui:script>