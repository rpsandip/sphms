

<portlet:resourceURL id="/getSupplierOutStandingReport" var="getSupplierOutStandingReportURL">

</portlet:resourceURL>

<section class="content">
  <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
	            <form id="filterBilling">
	              	<div class="form-group col-md-2">
	                  <select name="customCompany" id="supplierActiveCustomCompany" class="form-control">
						<option value="0">Select Company</option>
							<c:forEach items="${companyList }" var="company">
								<option value="${company.companyId }">${company.name }</option>
							</c:forEach>	
						</select>
	                </div>
	              	<div class="form-group col-md-2">
	                  <select name="landLoad" id="supplierLandLoad" class="form-control">
							<c:forEach items="${landLoadList}" var="landLoad">
								<option value="${landLoad.landLordId }">${landLoad.firstName} ${landLoad.lastName }</option>
							</c:forEach>	
						</select>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchStartDate" id="supplierOutStandingBillstartDate" placeholder="Start Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchEndDate" id="supplierOutStandingBillendDate" placeholder="End Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                   <input type=button class="btn btn-primary"  value="Export" id="exportSOUS">
	                </div>
	              </form>
	              <br/>
	        </div>
         </div>
      </div>
   </div>
</section>            	

 <script type="text/javascript">
          jQuery.noConflict();
        (function($) {
        	$("#exportSOUS").on('click',function(){
        		console.log('clicked');
            	var activeCustomCompany = $("#supplierActiveCustomCompany").val();
            	var activeLandlord = $("#supplierLandLoad").val();
            	var outStandingStartDate = $("#outStandingBillstartDate").val();
            	var outStandingEndDate = $("#outStandingBillendDate").val();
            	var getDocumentURL = '${getSupplierOutStandingReportURL}&<portlet:namespace />customCompany='+activeCustomCompany+'&<portlet:namespace />landlord='+activeLandlord+'&<portlet:namespace />startDate='+outStandingStartDate+'&<portlet:namespace />endDate='+outStandingEndDate;
                window.location.href=getDocumentURL;
            });
            
            $('#supplierOutStandingBillstartDate').datepicker({
        		format: 'dd/mm/yyyy',  
        	    autoclose: true
          }); 
          
          $('#supplierOutStandingBillendDate').datepicker({
      		format: 'dd/mm/yyyy',  
      	    autoclose: true
          }); 
         
          $('#supplierOutStandingBillendDate').datepicker('setDate', 'today');
          
          var d = new Date();
          d.setFullYear(d.getFullYear() - 1);
          $('#supplierOutStandingBillstartDate').datepicker('setDate', d);
        
        })(jQuery);
    </script> 