
<portlet:resourceURL id="/getGSTReport" var="getGSTReportUrl"/>

<section class="content">
  <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
	            <form id="gstReportFm">
	              	<div class="form-group col-md-2">
	                  <select name="gstReportCustomCompany" id="gstReportCustomCompany" class="form-control">
						<option value="0">Select Company</option>
							<option value="-1">All</option>
							<c:forEach items="${companyList }" var="company">
								<option value="${company.companyId }">${company.name }</option>
							</c:forEach>	
						</select>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchStartDate" id="gstReportstartDate" placeholder="Start Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchEndDate" id="gstReportendDate" placeholder="End Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                   <input type=button class="btn btn-primary"  value="Export" id="exportGSTReport">
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
        	$("#exportGSTReport").on('click',function(){
        		var activeCustomCompany = $("#gstReportCustomCompany").val();
            	var gstReportStartDate = $("#gstReportstartDate").val();
            	var gstReportEndDate = $("#gstReportendDate").val();
            	var getDocumentURL = '${getGSTReportUrl}&<portlet:namespace />customCompany='+activeCustomCompany+'&<portlet:namespace />startDate='+gstReportStartDate+'&<portlet:namespace />endDate='+gstReportEndDate;
                window.location.href=getDocumentURL;
            });
            
            $('#gstReportstartDate').datepicker({
        		format: 'dd/mm/yyyy',  
        	    autoclose: true
          }); 
          
          $('#gstReportendDate').datepicker({
      		format: 'dd/mm/yyyy',  
      	    autoclose: true
          }); 
         
          $('#gstReportendDate').datepicker('setDate', 'today');
          
          var d = new Date();
          d.setFullYear(d.getFullYear() - 1);
          $('#gstReportstartDate').datepicker('setDate', d);
        
        })(jQuery);
    </script> 