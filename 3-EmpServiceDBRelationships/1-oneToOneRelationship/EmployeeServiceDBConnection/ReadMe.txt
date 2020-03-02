send POST request from insomnia with correct mapping in the url,
http://localhost:8181/employee

this will map address and employee with one to one relationship.

this is the way you post data in jason.


POST request
*************
{
	"name": "Abhishek",        //here both ids will be auto generated.
	"marks": 65,
"address":{
	
 	"city":"Dompe"}
 }
*************


Preview
*************
{
  "id": 2,
  "name": "Abhis",
  "marks": 65,
  "address": {
    "id": 2,
    "city": "Dmpe"
  }
}
