<portlet:resourceURL id="/getSupplierPurchageOutStandingReport" var="getSupplierPurchageOutStandingReportUrl"/>
<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
            	 <form id="filterBookign">
	              	<div class="form-group col-md-3">
	              		<select name="searchclient" id="supplierPurchageCompany" class="form-control">
							<c:forEach items="${companyList }" var="company">
								<option value="${company.companyId }">${company.name }</option>
							</c:forEach>	
						</select>
	              	</div>
	              	<div class="form-group col-md-3">
	              		<select name="searchclient" id="supplierPurchageSupplier" class="form-control">
							<c:forEach items="${supplierList }" var="supplier">
								<option value="${supplier.supplierId }">${supplier.supplierName }</option>
							</c:forEach>	
						</select>
	              	</div>
	              	<div class="form-group col-md-3">
	                  <select name="billType" id="supplierPurchageBillType" class="form-control">
						<option value="">Select Bill Type</option>
						<option value="Petrol">Petrol</option>
						<option value="Mobile">Mobile</option>
						<option value="Iron">Iron</option>
						<option value="Wood">Wood</option>
						<option value="AMC">AMC</option>
						<option value="Labour">Labour</option>
						<option value="Salary">Salary</option>
						<option value="Light Bill">Light Bill</option>
						<option value="Office Rent">Office Rent</option>
						<option value="Paper Bill">Paper Bill</option>
						<option value="Water Bill">Water Bill</option>
						<option value="Travelling">Travelling</option>
						<option value="Food">Food</option>
						<option value="Entertainment">Entertainment</option>
						<option value="Other">Other</option>
					  </select>
	                </div>
	              	<div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchStartDate" id="startsupplierpurchageDate" placeholder="Start Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchEndDate" id="endsupplierpurchageDate" placeholder="End Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type=button class="btn btn-primary"  value="Search" id="exportSupplierPurchageReport">
	                </div>
	              </form>
            	<table id="supplierBillList" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
            		<tbody></tbody>
            	</table>
            </div>
        </div>
     </div>
  </div>
</section> 

<script type="text/javascript">
        var expenseDataTable="";
        jQuery.noConflict();
        (function($) {
            
        	$("#exportSupplierPurchageReport").on('click',function(){
        		var activeCustomCompany = $("#supplierPurchageCompany").val();
        		var supplierId = $("#supplierPurchageSupplier").val();
        		var supplierType = $("#supplierPurchageBillType").val();
            	var startsupplierpurchageDate = $("#startsupplierpurchageDate").val();
            	var endsupplierpurchageDate = $("#endsupplierpurchageDate").val();
            	var getDocumentURL = '${getSupplierPurchageOutStandingReportUrl}&<portlet:namespace />customCompany='+activeCustomCompany+
            	'&<portlet:namespace />startDate='+startsupplierpurchageDate+
            	'&<portlet:namespace />endDate='+endsupplierpurchageDate+
            	'&<portlet:namespace />supplierId='+supplierId+
            	'&<portlet:namespace />supplierType='+supplierType;
                window.location.href=getDocumentURL;
            });
        	
           
          $('#startsupplierpurchageDate').datepicker({
        		format: 'dd/mm/yyyy',  
        	    autoclose: true
          }); 
          
          $('#endsupplierpurchageDate').datepicker({
      		format: 'dd/mm/yyyy',  
      	    autoclose: true
        }); 
          
		$('#endsupplierpurchageDate').datepicker('setDate', 'today');
          
          var d = new Date();
          d.setFullYear(d.getFullYear() - 1);
          $('#startsupplierpurchageDate').datepicker('setDate', d);
          
        })(jQuery);
</script>