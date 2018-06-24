<%@ include file="/init.jsp" %>

<liferay-ui:error key="expense-add-error" message="expense-add-error"/>
<liferay-ui:error key="expense-update-error" message="expense-update-error"/>

<portlet:actionURL var="addExpenseURL" name="/add_expense">
</portlet:actionURL>

<section class="content-header">
  <c:choose>
	<c:when test="${ expense.expenseId gt 0}">
		<h1>
    		<liferay-ui:message key="update.expense"/> 
  		</h1>
	</c:when>
	<c:otherwise>
		<h1>
    		<liferay-ui:message key="add.expense"/> 
  		</h1>
	</c:otherwise>
</c:choose>
</section>
<div class="row">
	<div class="col-xs-12">
    	<div class="box">
       		<div class="box-body">
       			<aui:form name="expenseFm" action="${addExpenseURL}" cssClass="row contact_form" method="POST">
       				<div class="row">
	       				<div class="form-group col-md-6">
	              		<aui:select name="customCustomId">
							<c:forEach items="${companyList }" var="company">
								<option value="${company.companyId }" selected='${company.companyId eq expense.customCompanyId ? true : false }' >${company.name }</option>
							</c:forEach>	
						</aui:select>
	              	</div>
	       				<div class="form-group col-md-6">
	       					 <aui:select name="type" label="type" cssClass="form-control">
						     	<aui:option value="Petrol" selected='${expense.type eq "Petrol" ? true : false }'>Petrol</aui:option>
						     	<aui:option value="Mobile" selected='${expense.type eq "Mobile" ? true : false }'>Mobile</aui:option>
						     	<aui:option value="Iron" selected='${expense.type eq "Iron" ? true : false }'>Iron</aui:option>
						     	<aui:option value="Wood" selected='${expense.type eq "Wood" ? true : false }'>Wood</aui:option>
						     	<aui:option value="AMC" selected='${expense.type eq "AMC" ? true : false }'>AMC</aui:option>
						     	<aui:option value="Labour" selected='${expense.type eq "Labour" ? true : false }'>Labour</aui:option>
						     	<aui:option value="Salary" selected='${expense.type eq "Salary" ? true : false }'>Salary</aui:option>
						     	<aui:option value="Light Bill" selected='${expense.type eq "Light Bill" ? true : false }'>Light Bill</aui:option>
						     	<aui:option value="Office Rent" selected='${expense.type eq "Office Rent" ? true : false }'>Office Rent</aui:option>
						     	<aui:option value="Paper Bill" selected='${expense.type eq "Paper Bill" ? true : false }'>Paper Bill</aui:option>
						     	<aui:option value="Water Bill" selected='${expense.type eq "Water Bill" ? true : false }'>Water Bill</aui:option>
						     	<aui:option value="Travelling" selected='${expense.type eq "Travelling" ? true : false }'>Travelling</aui:option>
						     	<aui:option value="Food" selected='${expense.type eq "Food" ? true : false }'>Food</aui:option>
						     	<aui:option value="Entertainment" selected='${expense.type eq "Entertainment" ? true : false }'>Entertainment</aui:option>
						     	<aui:option value="Other" selected='${expense.type eq "Other" ? true : false }'>Other</aui:option>
							 </aui:select>
						</div>
					</div>
					<div class="row">
	       				<div class="form-group col-md-6">
	       					<aui:input name="amount" label="amount" cssClass="form-control" value="${expense.amount }">
	       						<aui:validator name="required" />
					    	 	<aui:validator name="number"/>
	       					</aui:input>  
	       				</div>
	       			</div>	
	       			<div class="row">
	       				<div class="form-group col-md-6">
	       					<aui:input type="textarea" name="description" label="description" cssClass="form-control" value="${expense.description }">
	       						<aui:validator name="required" />
	       						<aui:validator name="maxLength">500</aui:validator>
	       					</aui:input>  
	       				</div>
	       			</div>	
	       			<div class="row">
	       				<div class="form-group col-md-6">
							 <fmt:formatDate pattern = "dd/MM/yyyy" value = "${expense.expenseDate}" var="expenseDate"/>
							 <aui:input name="expenseDate" label="expense.date" cssClass="form-control" value="${expenseDate }">
							 	<aui:validator name="required" />
							 </aui:input> 
	       				</div>
	       			</div>	
	       			<div class="row">
       					<c:choose>
       						<c:when test="${ expense.expenseId gt 0}">
       							<div class="form-group col-md-12">
									<aui:button type="button" value="Update Expense"  cssClass="addExpenseBtn btn btn-primary"/>
								</div>
       						</c:when>
       						<c:otherwise>
       							<div class="form-group col-md-12">
									<aui:button type="button" value="Add Expense"  cssClass="addExpenseBtn btn btn-primary"/>
								</div>
       						</c:otherwise>
						</c:choose>
					</div>	
					<aui:input name="expenseId" type="hidden" value="${expense.expenseId }"/>
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
  	  $('#'+ '<portlet:namespace/>' + 'expenseDate').datepicker({
  		format: 'dd/mm/yyyy',  
  	    autoclose: true
  	  }).on('changeDate', function(ev) {
  		  AUI().use('aui-base','aui-form-validator', function(A) {
  				var myFormValidator = Liferay.Form.get('<portlet:namespace />expenseFm').formValidator;
  				myFormValidator.validateField('<portlet:namespace />expenseDate');
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
	var addExpenseBtn= A.one(".addExpenseBtn");
	addExpenseBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />expenseFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />expenseFm.submit();
		}
	});
});
</aui:script>					