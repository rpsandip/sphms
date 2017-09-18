<%@ include file="../init.jsp" %>
<portlet:actionURL var="addBillPaymentURL" name="/add_bill_payment">
</portlet:actionURL>

<section class="content-header">
<c:choose>
	<c:when test="${ payment.paymentId gt 0}">
		<h1>
   		 	<liferay-ui:message key="update.payment"/>
  		</h1>
	</c:when>
	<c:otherwise>
		<h1>
   			 <liferay-ui:message key="add.payment"/>
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
       			<aui:form name="addBillPaymentFm" action="${addBillPaymentURL}" cssClass="row contact_form">
       				<div class="row">
						<div class="form-group col-md-6">
							<aui:input name="amount" label="amount" cssClass="form-control" placeholder="Rs." value="${payment.amount }"> 
						     	<aui:validator name="required" />
						     	<aui:validator name="number" />
							 </aui:input>
						</div>
						<div class="form-group col-md-6">
							<aui:input name="chequeNo" label="chequeNo" cssClass="form-control" value="${payment.chequeNo }"> 
							 </aui:input>
						</div>
       				</div>
       				<div class="row">
						<div class="form-group col-md-6">
							<aui:input name="tds" label="tds" cssClass="form-control" placeholder="Rs." value="${payment.tds }"> 
							 </aui:input>
						</div>
						<div class="form-group col-md-6">
							<aui:input name="deduction" label="deduction" cssClass="form-control" placeholder="Rs." value="${payment.deduction }"> 
							 </aui:input>
						</div>
       				</div>
       				<div class="row">
       					<c:choose>
       						<c:when test="${ payment.paymentId gt 0}">
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
       				<aui:input type="hidden"  name="paymentId" value="${paymentId }"/>
       				
				</aui:form>
			</div>
		</div>
	</div>
</div>

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