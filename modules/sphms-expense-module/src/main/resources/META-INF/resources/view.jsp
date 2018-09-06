<%@ include file="/init.jsp" %>

<liferay-ui:success key="delete-expense-success" message="delete-expense-success"/>
<liferay-ui:error key="delete-expense-error" message="delete-expense-error"/>


<liferay-ui:success key="expnese-add-suceess" message="expnese-add-suceess"/>
<liferay-ui:success key="expense-update-success" message="expense-update-success"/>


<portlet:renderURL var="addExpenseURL">
        <portlet:param name="mvcRenderCommandName" value="/add_expense" />
</portlet:renderURL>
<a href="${addExpenseURL}" class="btn btn-primary">Add Expense</a>

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
	                  <select name="expenseType" id="expenseType" class="form-control">
						<option value="">Select Expense Type</option>
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
            	<table id="expenseList" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
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
            		 
            		 var resourceURL= Liferay.PortletURL.createResourceURL();
            		 resourceURL.setPortletId('com_sphms_expense_portlet_portlet_ExpenseModulePortlet');
            		 resourceURL.setResourceId('/getExpenseList');
            		 
            		 expenseDataTable =  $('#expenseList').DataTable({
            		 "processing": true,
            	     "serverSide": true,
            	     "searching": false,
            	     "pageLength": 50,
            	     "bSort": false,
            	     "ajax": resourceURL.toString(),
            		 "order": [],
            		 "columns": [
            		           		{ "data": "expenseType", "name" : "expenseType" , "title" : "Type"},
            	                    { "data": "amount", "name" : "amount", "title" : "Amount"  },
            	                    { "data": "paymenttype", "name" : "paymenttype", "title" : "Payment Type"  },
            	                    { "data": "description", "name" : "description", "title" : "Description"  },
            	                    { "data": "expenseDate", "name" : "expenseDate" , "title" : "Expense Date"},
            	                    { "data": "action", "name" : "Action" , "title" : "Action",
            	                    	"render": function(data, type, row, meta){
            	                    		var displayData="";
            	                    			var editExpenseURL = Liferay.PortletURL.createRenderURL();
            	                    			editExpenseURL.setParameter("expenseId",row.expenseId);
            	                    			editExpenseURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    			editExpenseURL.setParameter("mvcRenderCommandName","/add_expense");
            	                    			displayData = '<a href="'+editExpenseURL+'" class="btn btn-block btn-primary">Edit</a>';
            	                    			
            	                    			var deleteExpenseURL = Liferay.PortletURL.createActionURL();
            	                    			deleteExpenseURL.setParameter("expenseId",row.expenseId);
            	                    			deleteExpenseURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    			deleteExpenseURL.setName("/delete_expense");
            	                    			
            	                    			displayData = displayData + '<a href="'+deleteExpenseURL+'" class="btn btn-block btn-primary">Delete</a>';
            	                    			
            	                    			return displayData;
            	                    	 }
            	                    }
            	                ]
            	 });
            		 
                     $("#filterSearch").on('click',function(){
                     	var expenseType = $("#expenseType").val();
                     	var startDate = $("#startDate").val();
                     	var endDate = $("#endDate").val();
                     	var companyId = $("#company").val();
                     	var resourceURL= Liferay.PortletURL.createResourceURL();
               		 	resourceURL.setPortletId('com_sphms_expense_portlet_portlet_ExpenseModulePortlet');
               		 	resourceURL.setResourceId('/getExpenseList');
               		 	resourceURL.setParameter('expenseType',expenseType);
               		 	resourceURL.setParameter('searchStartDate',startDate);
               		 	resourceURL.setParameter('companyId',companyId);
               		 	
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