

<portlet:resourceURL id="/getOutstandingClientReport" var="getOutstandingClientReportURL">

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
        	var customCompany = $("#customCompany").val();
        	var client = $("#client").val();
        	
        	var getDocumentURL = '${getOutstandingClientReportURL}&<portlet:namespace />customCompany='+customCompany+'&<portlet:namespace />client='+client;
            window.location.href=getDocumentURL;
        });
        
        })(jQuery);
    </script> 