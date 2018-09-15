

<portlet:resourceURL id="/getOutstandingReport" var="getOutstandingReportURL">

</portlet:resourceURL>

<section class="content">
  <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
	            <form id="filterBilling">
	              	<div class="form-group col-md-2">
	                  <select name="customCompany" id="customCompany" class="form-control">
						<option value="0">Select Company</option>
							<c:forEach items="${companyList }" var="company">
								<option value="${company.companyId }">${company.name }</option>
							</c:forEach>	
						</select>
	                </div>
	              	<div class="form-group col-md-2">
	                  <select name="searchclient" id="client" class="form-control">
						<option value="0">Select Client</option>
							<c:forEach items="${clientList }" var="client">
								<option value="${client.clientId }">${client.clientName }</option>
							</c:forEach>	
						</select>
	                </div>
	                <div class="form-group col-md-2">
	                  <select name="status" id="status" class="form-control">
						<option value="">Select Status</option>
							<option value="0">Created</option>
							<option value="2">Published</option>
						</select>
	                </div>
	              	<div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchStartDate" id="billstartDate" placeholder="Start Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchEndDate" id="billendDate" placeholder="End Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type=button class="btn btn-primary"  value="Search" id="filterSearch">
	                   <input type=button class="btn btn-primary"  value="Export" id="export">
	                </div>
	              </form>
	              <br/>
	             <table id="billings" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
            		<tbody></tbody>
            	</table>
            </div>
         </div>
      </div>
   </div>
</section>            	

 <script type="text/javascript">
        var billingsDataTable="";
       
        $('#billstartDate').datepicker({
    		format: 'dd/mm/yyyy',  
    	    autoclose: true
      }); 
      
      $('#billendDate').datepicker({
  		format: 'dd/mm/yyyy',  
  	    autoclose: true
      }); 
     
      $('#billendDate').datepicker('setDate', 'today');
      
      var d = new Date();
      d.setFullYear(d.getFullYear() - 1);
      $('#billstartDate').datepicker('setDate', d);

        
        jQuery.noConflict();
        (function($) {
            $(function() {  
            	 AUI().use('aui-base','liferay-portlet-url', function(A) {
            		 var customCompany = $("#customCompany").val();
            		 var client = $("#client").val();
            		 var status = $("#status").val();
            		 var startDate = $("#billstartDate").val();
                 	 var endDate = $("#billendDate").val();
            		 var getDocumentURL = '${getOutstandingReportURL}&<portlet:namespace />customCompany='+customCompany+'&<portlet:namespace />client='+client+'&<portlet:namespace />status='+status+'&<portlet:namespace />startDate='+startDate+'&<portlet:namespace />endDate='+endDate;
            		 billingsDataTable =  $('#billings').DataTable({
            		 "processing": true,
            	     "searching": false,
            	     "pageLength": 50,
            	     "ajax": getDocumentURL,
            		 "order": [],
            		 "columns": [
            	                    { "data": "client", "name" : "client", "title" : "Client Name"  },
            	                    { "data": "campaign", "name" : "campaign" , "title" : "campaign"},
            	                    { "data": "financeYear", "name" : "financeYear" , "title" : "FinanceYear"},
            	                    { "data": "billNo", "name" : "billNo" , "title" : "Bill No"},
            	                    { "data": "bookingDate", "name" : "bookingDate" , "title" : "booking Date"},
            	                    { "data": "totalBillAmount", "name" : "totalBillAmount" , "title" : "TotalBillAmount"},
            	                    { "data": "totalPayment", "name" : "totalPayment" , "title" : "TotalPayment"},
            	                    { "data": "totalOutStanding", "name" : "totalOutStanding" , "title" : "Total Out Standing"},
            	                ]
            	 });
            });
          });
          
                
        $("#filterSearch").on('click',function(){
            	var customCompany = $("#customCompany").val();
            	var client = $("#client").val();
            	var status = $("#status").val();
            	var startDate = $("#billstartDate").val();
            	var endDate = $("#billendDate").val();
            	var getDocumentURL = '${getOutstandingReportURL}&<portlet:namespace />customCompany='+customCompany+'&<portlet:namespace />client='+client+'&<portlet:namespace />status='+status+'&<portlet:namespace />startDate='+startDate+'&<portlet:namespace />endDate='+endDate;
            	billingsDataTable.ajax.url(getDocumentURL).load();
		 });
        
        $("#export").on('click',function(){
        	var customCompany = $("#customCompany").val();
        	var client = $("#client").val();
        	var status = $("#status").val();
        	var startDate = $("#billstartDate").val();
        	var endDate = $("#billendDate").val();
        	var getDocumentURL = '${getOutstandingReportURL}&<portlet:namespace />customCompany='+customCompany+'&<portlet:namespace />client='+client+'&<portlet:namespace />status='+status+'&<portlet:namespace />startDate='+startDate+'&<portlet:namespace />endDate='+endDate+'&<portlet:namespace />isExport='+true;;
            window.location.href=getDocumentURL;
        });
        })(jQuery);
    </script> 