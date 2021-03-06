

<portlet:resourceURL id="/getOutstandingClientReport" var="getOutstandingClientReportURL">

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
	                  <select name="searchclient" id="activeClient" class="form-control">
							<c:forEach items="${clientList}" var="client">
								<option value="${client.clientId}">${client.clientName}</option>
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
            	var activeClient = $("#activeClient").val();
            	var outStandingStartDate = $("#outStandingBillstartDate").val();
            	var outStandingEndDate = $("#outStandingBillendDate").val();
            	var getDocumentURL = '${getOutstandingClientReportURL}&<portlet:namespace />customCompany='+activeCustomCompany+'&<portlet:namespace />client='+activeClient+'&<portlet:namespace />startDate='+outStandingStartDate+'&<portlet:namespace />endDate='+outStandingEndDate;
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