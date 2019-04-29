<%@ include file="/init.jsp" %>

<portlet:resourceURL id="/getSupplierPOList" var="getSuppllierPOListURL">
</portlet:resourceURL>

<liferay-ui:success key="po-update-success" message="po-update-success"/>
<liferay-ui:success key="po-update-error" message="po-update-error"/>
<liferay-ui:error key="error-po-publish" message="error-po-publish"/>
<liferay-ui:success key="po-publish-success" message="po-publish-success"/>

<section class="content">
  <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
	            <form id="filterBilling">
	              	<div class="form-group col-md-2">
	                  <select name="customCompany" id="supplierActiveCustomCompany" class="form-control">
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
	                  <select name="status" id="status" class="form-control">
						    <option value="-1">Select Status</option>
							<option value="YES">Yes</option>
							<option value="NO">No</option>
						</select>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchStartDate" id="outStandingBillstartDate" placeholder="Start Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchEndDate" id="outStandingBillendDate" placeholder="End Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="billNumber" id="billNo" placeholder="Bill Number"/>
	                </div>
	                <div class="form-group col-md-2">
	                   <input type=button class="btn btn-primary"  value="Search" id="searchSupplier">
	                </div>
	              </form>
	              <br/>
	              
	             <table id="supplierPO" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
            		<tbody></tbody>
            	</table>
	        </div>
         </div>
      </div>
   </div>
</section>            	

<script type="text/javascript">
        var supplierDataTable="";
        jQuery.noConflict();
        (function($) {
            $(function() { 
            	
            	
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
            	
            	
            	 AUI().use('aui-base','liferay-portlet-url', function(A) {
            		 
            		 
            		 var resourceURL= Liferay.PortletURL.createResourceURL();
            		 var activeCustomCompany = $("#supplierActiveCustomCompany").val();
                  	var activeLandlord = $("#supplierLandLoad").val();
                  	var outStandingStartDate = $("#outStandingBillstartDate").val();
                  	var outStandingEndDate = $("#outStandingBillendDate").val();
                  	var status = $("#status").val();
                  	var outStandingStartDate = $("#outStandingBillstartDate").val();
                	var outStandingEndDate = $("#outStandingBillendDate").val();
                	var billNo = $("#billNo").val();
                  	var resourceURL = '${getSuppllierPOListURL}&<portlet:namespace />customCompany='+activeCustomCompany+'&<portlet:namespace />landlord='+activeLandlord+'&<portlet:namespace />status='+status+'&<portlet:namespace />searchStartDate='+outStandingStartDate+'&<portlet:namespace />searchEndDate='+outStandingEndDate+'&<portlet:namespace />billNo='+billNo;
            		
                  	console.log(resourceURL);
                  	
                  	
            		 supplierDataTable =  $('#supplierPO').DataTable({
                		 "processing": true,
                	     "serverSide": true,
                	     "searching": false,
                	     "pageLength": 50,
                	     "bSort": false,
                	     "ajax": resourceURL.toString(),
                		 "order": [],
                		 "columns": [
                		           		{ "data": "supplier", "name" : "supplier" , "title" : "Supplier"},
                		           		{ "data": "campaign", "name" : "campaign" , "title" : "Campaign"},
                	                    { "data": "poNumber", "name" : "poNumber", "title" : "PO Number"  },
                	                    { "data": "supplierbillno", "name" : "supplierbillno", "title" : "Supplier Bill No"  },
                	                    { "data": "supplierpaymentgiven", "name" : "supplierpaymentgiven" , "title" : "Supplier Payment Given"},
                	                    { "data": "totalOutStanding", "name" : "totalOutStanding" , "title" : "Total OutStanding"},
                	                    { "data": "totalPaymentGiven", "name" : "totalPaymentGiven" , "title" : "Total Payment Given"},
                	                    { "data": "status", "name" : "status" , "title" : "Status",
                	                    	"render": function(data, type, row, meta){
                	                    		var displayData = '';
                	                    		
                	                    		if(row.status=='Generated'){
                	                    			
                	                    			var publishBillURL = Liferay.PortletURL.createActionURL();
	            	                    			publishBillURL.setParameter("billingId",row.billingId);
	            	                    			publishBillURL.setParameter("landlordId",row.landLordId);
	            	                    			publishBillURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
	            	                    			publishBillURL.setName("/publish_PO");
	            	                    			
	            	                    			displayData = displayData +  '<a href="'+publishBillURL+'" class="btn btn-block btn-primary">Publish</a>';
                	                    			
                	                    		}else{
                	                    			displayData = "Sent To Client";	
                	                    		}
                	                    		
		           	                    		return displayData;
                	                    	 }
                	                    },
                	                    { "data": "billDocument", "name" : "billDocument" , "title" : "Download",
                	                    	
                	                    	"render": function(data, type, row, meta){
                	                    		var displayData = '';
            	                    			//'<a href="'+ row.billDocumentURL +'" class="">Download</a>';
            	                    		
		           	                    		var downloadBillURL = Liferay.PortletURL.createResourceURL();
		           	                    		downloadBillURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
		           	                    		downloadBillURL.setResourceId('/download-po');
		           	                    		downloadBillURL.setParameter("landlordId",row.landLordId);
		           	                    		downloadBillURL.setParameter("billingId",row.billingId);
		           	                    		
		           	                    		displayData = displayData +  '<a href="'+downloadBillURL.toString()+'" class="btn btn-block btn-primary">Download</a>';
		           	                    		
		           	                    		return displayData;
                	                    	 }
            		 					},
                	                    { "data": "action", "name" : "Action" , "title" : "Action",
                	                    	"render": function(data, type, row, meta){
                	                    		
                	                    			var editPOURL = Liferay.PortletURL.createRenderURL();
                	                    			editPOURL.setParameter("billingId",row.billingId);
                	                    			editPOURL.setParameter("landLordId",row.landLordId);
                	                    			editPOURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
                	                    			editPOURL.setParameter("mvcRenderCommandName","/edit_po");
                	                    			var displayData  = '<a href="'+editPOURL+'" class="btn btn-block btn-primary">Edit</a>';
                	                    			
                	                    			var editPOURL = Liferay.PortletURL.createRenderURL();
                	                    			editPOURL.setParameter("billingId",row.billingId);
                	                    			editPOURL.setParameter("landLordId",row.landLordId);
                	                    			editPOURL.setParameter("companyId",row.companyId);
                	                    			editPOURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
                	                    			editPOURL.setParameter("mvcRenderCommandName","/po_payment");
                	                    			 displayData += '  <a href="'+editPOURL+'" class="btn btn-block btn-primary">Payment</a>';
                	                    		
                	                    			return displayData;
                	                    	 }
                	                    }
                	                ]
                	 	});
            		 
            		 
            		 $("#searchSupplier").on('click',function(){
                 		console.log('clicked' + $("#supplierLandLoad").val());
                     	var activeCustomCompany = $("#supplierActiveCustomCompany").val();
                     	var activeLandlord = $("#supplierLandLoad").val();
                     	var outStandingStartDate = $("#outStandingBillstartDate").val();
                     	var outStandingEndDate = $("#outStandingBillendDate").val();
                    	var status = $("#status").val();
                    	var billNo = $("#billNo").val();
                     	var getDocumentURL = '${getSuppllierPOListURL}&<portlet:namespace />customCompany='+activeCustomCompany+'&<portlet:namespace />landlord='+activeLandlord+'&<portlet:namespace />status='+status+'&<portlet:namespace />searchStartDate='+outStandingStartDate+'&<portlet:namespace />searchEndDate='+outStandingEndDate+'&<portlet:namespace />billNo='+billNo;;
                     	supplierDataTable.ajax.url(getDocumentURL).load();
                     });
                     
                 
            		 
            	 });
            });
              
          })(jQuery);
  </script>
  