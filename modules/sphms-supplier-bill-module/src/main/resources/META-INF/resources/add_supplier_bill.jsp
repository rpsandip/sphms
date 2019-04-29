<%@ include file="/init.jsp" %>

<liferay-ui:error key="supplier-bill-add-error" message="supplier-bill-add-error"/>
<liferay-ui:error key="supplier-bill-update-error" message="supplier-bill-update-error"/>

<portlet:actionURL var="addSupplierBillURL" name="add_bill">
</portlet:actionURL>

<section class="content-header">
  <c:choose>
	<c:when test="${ supplierBill.supplierBillId gt 0}">
		<h1>
    		<liferay-ui:message key="Update Supplier Bill"/> 
  		</h1>
	</c:when>
	<c:otherwise>
		<h1>
    		<liferay-ui:message key="Add Supplier Bill"/> 
  		</h1>
	</c:otherwise>
</c:choose>
</section>
<div class="row">
	<div class="col-xs-12">
    	<div class="box">
       		<div class="box-body">
       			<aui:form name="supplierFm" action="${addSupplierBillURL}" cssClass="row contact_form" method="POST">
       				<div class="row">
	       				<div class="form-group col-md-6">
		              		<aui:select name="customCustomId" label="Company" cssClass="form-control">
								<c:forEach items="${companyList }" var="company">
									<aui:option value="${company.companyId }" selected='${company.companyId eq supplierBill.companyId ? true : false }' >${company.name }</aui:option>
								</c:forEach>	
							</aui:select>
	              		</div>
	              		<div class="form-group col-md-6">
		              		<aui:select name="supplierId" label="Supplier" cssClass="form-control">
								<c:forEach items="${supplierList }" var="supplier">
									<aui:option value="${supplier.supplierId }" selected='${supplier.supplierId eq supplierBill.supplierId ? true : false }' >${supplier.supplierName }</aui:option>
								</c:forEach>	
							</aui:select>
	              		</div>
					</div>
					<div class="row">
						<div class="form-group col-md-6">
							<aui:input name="supplierBillNo" label="Supplier Bill No" cssClass="form-control" value="${supplierBill.amount }">
	       						<aui:validator name="required" />
	       					</aui:input> 
	       				</div>	
	       				<div class="form-group col-md-6">
	       				
							 <fmt:formatDate pattern = "dd/MM/yyyy" value = "${supplierBill.supplierBillDate}" var="supplierBillDate"/>
							 <aui:input name="billDate" label="Bill Date" cssClass="form-control" value="${supplierBillDate }">
							 	<aui:validator name="required" />
							 </aui:input> 
	       				</div>
					</div>
					<div class="row">
						<div class="form-group col-md-4">
	       					 <aui:select name="type" label="type" cssClass="form-control">
						     	<aui:option value="Petrol" selected='${supplierBill.supplierBillType eq "Petrol" ? true : false }'>Petrol</aui:option>
						     	<aui:option value="Mobile" selected='${supplierBill.supplierBillType eq "Mobile" ? true : false }'>Mobile</aui:option>
						     	<aui:option value="Iron" selected='${supplierBill.supplierBillType eq "Iron" ? true : false }'>Iron</aui:option>
						     	<aui:option value="Wood" selected='${supplierBill.supplierBillType eq "Wood" ? true : false }'>Wood</aui:option>
						     	<aui:option value="AMC" selected='${supplierBill.supplierBillType eq "AMC" ? true : false }'>AMC</aui:option>
						     	<aui:option value="Labour" selected='${supplierBill.supplierBillType eq "Labour" ? true : false }'>Labour</aui:option>
						     	<aui:option value="Salary" selected='${supplierBill.supplierBillType eq "Salary" ? true : false }'>Salary</aui:option>
						     	<aui:option value="Light Bill" selected='${supplierBill.supplierBillType eq "Light Bill" ? true : false }'>Light Bill</aui:option>
						     	<aui:option value="Office Rent" selected='${supplierBill.supplierBillType eq "Office Rent" ? true : false }'>Office Rent</aui:option>
						     	<aui:option value="Paper Bill" selected='${supplierBill.supplierBillType eq "Paper Bill" ? true : false }'>Paper Bill</aui:option>
						     	<aui:option value="Water Bill" selected='${supplierBill.supplierBillType eq "Water Bill" ? true : false }'>Water Bill</aui:option>
						     	<aui:option value="Travelling" selected='${supplierBill.supplierBillType eq "Travelling" ? true : false }'>Travelling</aui:option>
						     	<aui:option value="Food" selected='${supplierBill.supplierBillType eq "Food" ? true : false }'>Food</aui:option>
						     	<aui:option value="Entertainment" selected='${supplierBill.supplierBillType eq "Entertainment" ? true : false }'>Entertainment</aui:option>
						     	<aui:option value="Other" selected='${supplierBill.supplierBillType eq "Other" ? true : false }'>Other</aui:option>
							 </aui:select>
						</div>
	       				<div class="form-group col-md-4">
	       					<aui:input name="amount" label="amount" cssClass="form-control" value="${supplierBill.amount }">
	       						<aui:validator name="required" />
					    	 	<aui:validator name="number"/>
	       					</aui:input>  
	       				</div>
	       				<div class="form-group col-md-4">
							 <aui:input name="gst" label="GST" cssClass="form-control" value="${supplierBill.gst }"> 
							 </aui:input>
	       				</div>
	       			</div>	
	       			<div class="row">
	       				<div class="form-group col-md-6">
	       					<aui:input type="textarea" name="description" label="description" cssClass="form-control" value="${supplierBill.supplierBillDesc }">
	       						<aui:validator name="required" />
	       						<aui:validator name="maxLength">500</aui:validator>
	       					</aui:input> 
	       				</div>
	       			</div>	
	       			<div class="row">
       					<c:choose>
       						<c:when test="${ supplierBill.supplierBillId gt 0}">
       							<div class="form-group col-md-12">
									<aui:button type="button" value="Update Supplier Bill"  cssClass="addExpenseBtn btn btn-primary"/>
								</div>
       						</c:when>
       						<c:otherwise>
       							<div class="form-group col-md-12">
									<aui:button type="button" value="Add Supploer Bill"  cssClass="addExpenseBtn btn btn-primary"/>
								</div>
       						</c:otherwise>
						</c:choose>
					</div>	
					<aui:input name="supplierBillId" type="hidden" value="${supplierBill.supplierBillId }"/>
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
  	  $('#'+ '<portlet:namespace/>' + 'billDate').datepicker({
  		format: 'dd/mm/yyyy',  
  	    autoclose: true
  	  }).on('changeDate', function(ev) {
  		  AUI().use('aui-base','aui-form-validator', function(A) {
  				var myFormValidator = Liferay.Form.get('<portlet:namespace />supplierFm').formValidator;
  				myFormValidator.validateField('<portlet:namespace />"billDate"');
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
	var addExpenseBtn= A.one(".addExpenseBtn");
	addExpenseBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />supplierFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />supplierFm.submit();
		}
	});
});
</aui:script>					