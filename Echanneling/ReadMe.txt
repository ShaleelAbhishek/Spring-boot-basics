send POST request from insomnia with correct mapping in the url,
http://localhost:8181/employee

************
POST request
************
{ 
	 "name": "Gayan",
	 "marks": 65,

	"address":{
 		"city":"colombo"},
	
	"telephones":[{
			"tpNumber": "12548725"},
		 {"tpNumber": "12548785"}
		
	],
	"projects":[{
		"projectName":"Project-1"

	}]
 }

******category*****
{"categoryId":2,
	"category": "Cardiologist",
	"doctorId": 1
	
}

******doctor***
{
	"doctorName": "abhi",
	
	"telephones":[{
			"telNumber": "12548725"},
		 {"telNumber": "12548785"}
		
	]
}
