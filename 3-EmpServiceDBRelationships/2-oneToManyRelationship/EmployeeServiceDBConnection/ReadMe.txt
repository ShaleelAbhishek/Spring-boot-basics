send POST request from insomnia with correct mapping in the url,
http://localhost:8181/employee


POST request
**********************
{ 
	 "name": "Gayan",
	 "marks": 65,

	"address":{
 		"city":"colombo"},
	
	"telephones":[{					//you have to give square brackets since 
			"tpNumber": "12548785"		//telephones is a LIST<>.
			
	}]
 }

************************
Preview

  "id": 1,
  "name": "Gayan",
  "marks": 65,
  "address": {
    "id": 1,
    "city": "colombo"
  },
  "telephones": [
    {
      "id": 1,
      "tpNumber": "12545680"
    }
  ]
}
