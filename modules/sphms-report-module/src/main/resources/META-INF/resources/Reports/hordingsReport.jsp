

<portlet:resourceURL id="/getHordingReport" var="getHordingReportURL">

</portlet:resourceURL>

<section class="content">
  <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
	            <form id="filterBilling">
	              	<div class="form-group col-md-2">
	                  <select name="hordingName" id="activeHording" class="form-control">
						<option value="0">Select Hording</option>
							<c:forEach items="${hordingList}" var="hording">
								<option value="${hording.hordingId }">${hording.title} - ${hording.city}</option>
							</c:forEach>	
						</select>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchStartDate" id="hordingStartDate" placeholder="Start Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchEndDate" id="hordingEndDate" placeholder="End Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                   <input type=button class="btn btn-primary"  value="Export" id="exportHording">
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
        	$("#exportHording").on('click',function(){
            	var activeHording = $("#activeHording").val();
            	var hordingStartDate = $("#hordingStartDate").val();
            	var hordingEndDate = $("#hordingEndDate").val();
            	var getDocumentURL = '${getHordingReportURL}&<portlet:namespace />activeHording='+activeHording+'&<portlet:namespace />hordingStartDate='+hordingStartDate+'&<portlet:namespace />endDate='+hordingEndDate;
                window.location.href=getDocumentURL;
            });
            
            $('#hordingStartDate').datepicker({
        		format: 'dd/mm/yyyy',  
        	    autoclose: true
          }); 
          
          $('#hordingEndDate').datepicker({
      		format: 'dd/mm/yyyy',  
      	    autoclose: true
          }); 
         
          $('#hordingEndDate').datepicker('setDate', 'today');
          
          var d = new Date();
          d.setFullYear(d.getFullYear() - 1);
          $('#hordingStartDate').datepicker('setDate', d);
        
        })(jQuery);
    </script> 