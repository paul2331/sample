function addnav(start,end,current,totalPages,showNumbers,itemsPerRecord){
		console.log("Changing...");
		var nav = document.getElementById("pg");
		while (nav.hasChildNodes()) {
			nav.removeChild(nav.lastChild);
		}
		var aTag = document.createElement('span');				
				aTag.setAttribute('id',"msg");
				aTag.innerHTML = "Showing "+current+" off "+totalPages+" pages("+document.getElementById("total").value+" records)";				
				aTag.setAttribute('class',"others");										
				nav.appendChild(aTag);
				nav.appendChild( document.createTextNode(' '));	
		var aTag = document.createElement('a');
				aTag.setAttribute('href',"#");
				aTag.setAttribute('id',"first");
				aTag.innerHTML = "First";
				if(current==1){				
					aTag.setAttribute('class',"current");			
					aTag.setAttribute('onClick',"");			
				}else{
					aTag.setAttribute('class',"others");			
					aTag.setAttribute('onClick',"navicate(1,'S',"+showNumbers+","+itemsPerRecord+")");				
				}			
				nav.appendChild(aTag);
				
		for(i=start;i<=end;i++){			
			var aTag = document.createElement('a');
				aTag.setAttribute('href',"#");
				aTag.setAttribute('id',""+i);
				aTag.innerHTML = ""+i;
			if(i==current)
				aTag.setAttribute('class',"current");
			else	
				aTag.setAttribute('class',"others");
			if(i==start)
				aTag.setAttribute('onClick',"navicate("+i+",'S',"+showNumbers+","+itemsPerRecord+")");
			else if(i==end)
				aTag.setAttribute('onClick',"navicate("+i+",'E',"+showNumbers+","+itemsPerRecord+")");
			else 	
				aTag.setAttribute('onClick',"navicate("+i+",'M',"+showNumbers+","+itemsPerRecord+")");
				
				nav.appendChild( document.createTextNode(' '));	
				nav.appendChild(aTag);	
				nav.appendChild( document.createTextNode(' '));	
		}
		var aTag = document.createElement('a');
				aTag.setAttribute('href',"#");
				aTag.setAttribute('id',"last");
				aTag.innerHTML = "Last";							
				if(current==totalPages){				
					aTag.setAttribute('class',"gray");			
					aTag.setAttribute('onClick',"");			
				}else{
					aTag.setAttribute('class',"others");			
					aTag.setAttribute('onClick',"navicate("+totalPages+",'E',"+showNumbers+","+itemsPerRecord+")");				
				}				
				nav.appendChild(aTag);
	}
	function navicate(page,pos,showNumbers,itemsPerRecord){
		console.log("Requesting "+page);
		var start =1;var end =5;var totalRecords = document.getElementById("total").value;
		var totalPages =5;
		var noOfRows = showNumbers;
		var pagePerRecord = itemsPerRecord;
		totalPages = Math.floor(totalRecords/pagePerRecord);
		if((totalRecords%pagePerRecord)>0)totalPages++;
		console.log(totalPages);
		var changeNeed = false;
		if(page<1){
		//firstTime
			end = noOfRows;
			if(totalPages<noOfRows)end = totalPages; 			
			addnav(start,end,1,totalPages,showNumbers,itemsPerRecord);
			return;
		}
		getRecords(page,itemsPerRecord);
		if(pos=="E"){
			if(page<=totalPages){				
				end = ( page -1 ) + (noOfRows - 1 );
				if(end>totalPages) end = totalPages;
				start = end - (noOfRows - 1);
				if(start<1) start = 1;
				changeNeed = true;
			}
		}else if(pos=="S"){
			if(page>=1){				
				start = (page - noOfRows) + 2;
				if(start<1) start = 1;
				end = start + noOfRows - 1;
				if(end>totalPages) end = totalPages;
				changeNeed = true;
			}
		}
		
		if(changeNeed)addnav(start,end,page,totalPages,showNumbers,itemsPerRecord);
		else{			
			for(var j=(page-noOfRows);j<(page+noOfRows);j++){			
				var ele = document.getElementById(""+j);				
				if(ele!=null){ele.setAttribute("class","others");}
			}	
			var ele = document.getElementById(""+page);
			if(ele!=null)ele.setAttribute("class","current");	
			var ele = document.getElementById("msg");
			ele.innerHTML = "Showing "+page+" off "+totalPages;		
		}
		if(page==1){
			var ele = document.getElementById("first");				
			ele.setAttribute("class","gray");	
			ele.setAttribute("onClick","");					
		}else{
			var ele = document.getElementById("first");		
			ele.setAttribute('class',"others");			
			ele.setAttribute('onClick',"navicate(1,'S',"+showNumbers+","+itemsPerRecord+")");			
		}if(page==totalPages){
			var ele = document.getElementById("last");			
			ele.setAttribute("class","gray");	
			ele.setAttribute("onClick","");				
		}else{
			var ele = document.getElementById("last");	
			ele.setAttribute('class',"others");			
			ele.setAttribute('onClick',"navicate("+totalPages+",'E',"+showNumbers+","+itemsPerRecord+")");			
		}
	}

