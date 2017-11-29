<%@ include file="../init.jsp" %>

<portlet:actionURL var="addCreditNoteURL" name="/add_credit_note">
</portlet:actionURL>

<liferay-ui:success key="credit-note-add-error" message="credit-note-add-error"/>
<liferay-ui:success key="credit-note-update-error" message="credit-note-update-error"/>

<section class="content-header">
<c:choose>
	<c:when test="${ creditNote.creditNoteId gt 0}">
		<h1>
   		 	<liferay-ui:message key="update.credit.note"/> - ${client.clientName }
  		</h1>
	</c:when>
	<c:otherwise>
		<h1>
   			 <liferay-ui:message key="add.credit.note"/> - ${client.clientName }
  		</h1>
	</c:otherwise>
</c:choose>
</section>
<br/>
<div class="row">
	<div class="col-xs-12">
    	<div class="box">
       		<div class="box-body">
       			<aui:form name="addCreditNoteFm" action="${addCreditNoteURL}" cssClass="row contact_form">	
       				<div class="row">		 
						<div class="form-group col-md-4">
							 <aui:select name="billingId" label="credit.note.bill" cssClass="form-control">
							 	<aui:option value="">Select Bill</aui:option>
							 	<c:forEach items="${billingList }" var="billing">
							 		<aui:option value="${billing.billingId }" selected="${creditNote.billingId eq billing.billingId ? true:false }"> ${billing.billNo }</aui:option>
							 	</c:forEach>
							 </aui:select>
	       				</div>
						<div class="form-group col-md-4">
							 <aui:input name="amount" label="credit.note.amount" cssClass="form-control" placeholder="Rs." value="${creditNote.creditNoteAmount }"> 
						     	<aui:validator name="required" />
						     	<aui:validator name="number" />
							 </aui:input>
	       				</div>
	       				<div class="form-group col-md-4">
							 <aui:input name="tax" label="credit.note.tax" cssClass="form-control" placeholder="Rs." value="${creditNote.creditNoteTax }"> 
						     	<aui:validator name="required" />
						     	<aui:validator name="number" />
							 </aui:input>
	       				</div>
	       			</div>
	       			<div class="row">	
						<div class="form-group col-md-4">
							<fmt:formatDate pattern = "dd/MM/yyyy" value = "${creditNote.paymentDate}" var="paymentDate"/>
							 <aui:input name="paymentDate" label="payment.date" cssClass="form-control" value="${paymentDate }"> 
						     	<aui:validator name="required" />
							 </aui:input>
	       				</div>
	       				<div class="form-group col-md-4">
							 <aui:input name="chequeNo" label="chequeNo" cssClass="form-control" value="${creditNote.chequeNo }"> 
							 </aui:input>
	       				</div>
	       				<div class="form-group col-md-4">
							 <aui:input name="bankName" label="bank.name" cssClass="form-control" value="${creditNote.bankName }"> 
							 </aui:input>
	       				</div>
       				</div>
       				<div class="row">
       					<c:choose>
       						<c:when test="${ creditNote.creditNoteId gt 0}">
       							<div class="form-group col-md-12">
									<aui:button type="button" value="Update Credit Note"  cssClass="addCreditNoteBtn btn btn-primary"/>
								</div>
       						</c:when>
       						<c:otherwise>
       							<div class="form-group col-md-12">
									<aui:button type="button" value="Add Credit Note"  cssClass="addCreditNoteBtn btn btn-primary"/>
								</div>
       						</c:otherwise>
						</c:choose>
					</div>	
					<aui:input type="hidden" name="creditNoteId"  value="${ creditNote.creditNoteId}"/>
					<aui:input type="hidden" name="clientId"  value="${clientId}"/>
					
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
				var myFormValidator = Liferay.Form.get('<portlet:namespace />addCreditNoteFm').formValidator;
				myFormValidator.validateField('<portlet:namespace />paymentDate');
			});
	  });
	  
	  $('#'+'<portlet:namespace/>'+'amount').keyup(function () { 
		    this.value = this.value.replace(/[^0-9]/g,'');
	  });
	  
	  $('#'+'<portlet:namespace/>'+'tax').keyup(function () { 
		    this.value = this.value.replace(/[^0-9]/g,'');
	  });	 
	  
	  $('#'+ '<portlet:namespace/>' + 'paymentDate').datepicker({
	  		format: 'dd/mm/yyyy',  
	  	    autoclose: true
	  });
	  	 
	  
    });

})(jQuery);
</script>
<aui:script>
var userModuleNameSpace =  '<portlet:namespace/>';
AUI().use('aui-base','aui-form-validator', function(A) {
	var addCreditNoteBtn= A.one(".addCreditNoteBtn");
	addCreditNoteBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />addCreditNoteFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />addCreditNoteFm.submit();
		}
	});
});
</aui:script>
