<%@ include file="/init.jsp" %>

<liferay-ui:success key="delete-supplier-bill-success" message="delete-supplier-bill-success"/>
<liferay-ui:error key="delete-supplier-bill-error" message="delete-supplier-bill-error"/>


<liferay-ui:success key="supplier-bill-add-suceess" message="supplier-bill-add-suceess"/>
<liferay-ui:success key="supplier-bill-update-success" message="supplier-bill-update-success"/>


<portlet:resourceURL id="/getSupplierBillList" var="getSupplierBillURL"></portlet:resourceURL>


<portlet:renderURL var="addSupplierBillURL">
        <portlet:param name="mvcRenderCommandName" value="/add_supplier_bill" />
</portlet:renderURL>
<a href="${addSupplierBillURL}" class="btn btn-primary">Add Supplier Bill</a>

<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
            	 <form id="filterBookign">
	              	<div class="form-group col-md-3">
	              		<select name="searchclient" id="company" class="form-control">
							<option value=""> Select Company </option>
							<c:forEach items="${companyList }" var="company">
								<option value="${company.companyId }">${company.name }</option>
							</c:forEach>	
						</select>
	              	</div>
	              	<div class="form-group col-md-3">
	              		<select name="searchclient" id="supplier" class="form-control">
							<option value=""> Select Supplier </option>
							<c:forEach items="${supplierList }" var="supplier">
								<option value="${supplier.supplierId }">${supplier.supplierName }</option>
							</c:forEach>	
						</select>
	              	</div>
	              	<div class="form-group col-md-3">
	                  <select name="billType" id="billType" class="form-control">
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
	                  <input type="text" class="form-control" name="searchStartDate" id="startDate" placeholder="Start Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchEndDate" id="endDate" placeholder="End Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type=button class="btn btn-primary"  value="Search" id="filterSearch">
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
            $(function() {  
            	 AUI().use('aui-base','liferay-portlet-url', function(A) {
            		 
            		 var billType = $("#billType").val();
                  	 var startDate = $("#startDate").val();
                  	 var endDate = $("#endDate").val();
                  	 var companyId = $("#company").val();
                     var supplierId = $("#supplier").val();
            		 var resourceURL= Liferay.PortletURL.createResourceURL();
            		 resourceURL.setPortletId('<%=themeDisplay.getPortletDisplay().getId() %>');
            		 resourceURL.setResourceId('/getSupplierBillList');
            		 resourceURL.setParameter('billType',billType);
            		 resourceURL.setParameter('searchStartDate',startDate);
            		 resourceURL.setParameter('searchEndDate',endDate);
            		 resourceURL.setParameter('companyId',companyId);
            		 resourceURL.setParameter('supplierId',supplierId);
            		 
            		 
            		 expenseDataTable =  $('#supplierBillList').DataTable({
            		 "processing": true,
            	     "serverSide": true,
            	     "searching": false,
            	     "pageLength": 50,
            	     "bSort": false,
            	     "ajax": resourceURL.toString(),
            		 "order": [],
            		 "columns": [
            		           		{ "data": "billType", "name" : "billType" , "title" : "Type"},
            		           		{ "data": "billNo", "name" : "billNo" , "title" : "Bill No"},
            		           		{ "data": "desc", "name" : "desc" , "title" : "Description"},
            		           		{ "data": "billDate", "name" : "billDate", "title" : "Bill Date"  },
            		           		{ "data": "amount", "name" : "amount", "title" : "Amount"  },
            		           		{ "data": "gst", "name" : "gst", "title" : "GST"  },
            	                    { "data": "action", "name" : "Action" , "title" : "Action",
            	                    	"render": function(data, type, row, meta){
            	                    		var displayData="";
            	                    			var editExpenseURL = Liferay.PortletURL.createRenderURL();
            	                    			editExpenseURL.setParameter("supplierBillId",row.supplierBillId);
            	                    			editExpenseURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    			editExpenseURL.setParameter("mvcRenderCommandName","/add_supplier_bill");
            	                    			displayData = '<a href="'+editExpenseURL+'" class="btn btn-block btn-primary">Edit</a>';
            	                    			
            	                    			var editExpenseURL = Liferay.PortletURL.createRenderURL();
            	                    			editExpenseURL.setParameter("supplierBillId",row.supplierBillId);
            	                    			editExpenseURL.setParameter("supplierId",row.supplierId);
            	                    			editExpenseURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    			editExpenseURL.setParameter("mvcRenderCommandName","/get_supplier_bill_payments");
            	                    			displayData = displayData +  '<a href="'+editExpenseURL+'" class="btn btn-block btn-primary">Payments</a>';
            	                    			
            	                    			var deleteExpenseURL = Liferay.PortletURL.createActionURL();
            	                    			deleteExpenseURL.setParameter("supplierBillId",row.supplierBillId);
            	                    			deleteExpenseURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    			deleteExpenseURL.setName("/delete_supplier_bill");
            	                    			
            	                    			displayData = displayData + '<a href="'+deleteExpenseURL+'" class="btn btn-block btn-primary">Delete</a>';
            	                    			
            	                    			return displayData;
            	                    	 }
            	                    }
            	                ]
            	 });
            		 
                     $("#filterSearch").on('click',function(){
                    	 var billType = $("#billType").val();
                      	 var startDate = $("#startDate").val();
                      	 var endDate = $("#endDate").val();
                      	 var companyId = $("#company").val();
                         var supplierId = $("#supplier").val();
                		var resourceURL= Liferay.PortletURL.createResourceURL();
                     	resourceURL.setPortletId('<%=themeDisplay.getPortletDisplay().getId() %>');
                		resourceURL.setResourceId('/getSupplierBillList');
                		resourceURL.setParameter('billType',billType);
               		 	resourceURL.setParameter('searchStartDate',startDate);
               		    resourceURL.setParameter('searchEndDate',endDate);
               		    resourceURL.setParameter('companyId',companyId);
               		    resourceURL.setParameter('supplierId',supplierId);
               			var getDocumentURL = resourceURL.toString();
                         expenseDataTable.ajax.url(getDocumentURL).load();
         			});  
                      
                       
            });
            	
          });
           
           $('#startDate').datepicker({
        		format: 'dd/mm/yyyy',  
        	    autoclose: true
          }); 
          
          $('#endDate').datepicker({
      		format: 'dd/mm/yyyy',  
      	    autoclose: true
        }); 
            
         
          
        })(jQuery);
</script>