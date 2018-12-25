

<portlet:resourceURL id="/getSupplierOutStandingReport" var="getSupplierOutStandingReportURL">

</portlet:resourceURL>

<section class="content">
  <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
	            <form id="filterBilling">
	              	<div class="form-group col-md-2">
	                  <select name="customCompany" id="activeCustomCompany" class="form-control">
						<option value="0">Select Company</option>
							<c:forEach items="${companyList }" var="company">
								<option value="${company.companyId }">${company.name }</option>
							</c:forEach>	
						</select>
	                </div>
	              	<div class="form-group col-md-2">
	                  <select name="landLoad" id="landLoad" class="form-control">
							<c:forEach items="${landLoadList}" var="landLoad">
								<option value="${landLoad.landLordId }">${landLoad.firstName} ${landLoad.lastName }</option>
							</c:forEach>	
						</select>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchStartDate" id="outStandingBillstartDate" placeholder="Start Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchEndDate" id="outStandingBillendDate" placeholder="End Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                   <input type=button class="btn btn-primary"  value="Export" id="exportCOUS">
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
        	$("#exportCOUS").on('click',function(){
            	var activeCustomCompany = $("#activeCustomCompany").val();
            	var activeLandlord = $("#landLoad").val();
            	var outStandingStartDate = $("#outStandingBillstartDate").val();
            	var outStandingEndDate = $("#outStandingBillendDate").val();
            	var getDocumentURL = '${getSupplierOutStandingReportURL}&<portlet:namespace />customCompany='+activeCustomCompany+'&<portlet:namespace />landlord='+activeLandlord+'&<portlet:namespace />startDate='+outStandingStartDate+'&<portlet:namespace />endDate='+outStandingEndDate;
                window.location.href=getDocumentURL;
            });
            
            $('#outStandingBillstartDate').datepicker({
        		format: 'dd/mm/yyyy',  
        	    autoclose: true
          }); 
          
          $('#outStandingBillendDate').datepicker({
      		format: 'dd/mm/yyyy',  
      	    autoclose: true
          }); 
         
          $('#outStandingBillendDate').datepicker('setDate', 'today');
          
          var d = new Date();
          d.setFullYear(d.getFullYear() - 1);
          $('#outStandingBillstartDate').datepicker('setDate', d);
        
        })(jQuery);
    </script> 