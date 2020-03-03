send POST request from insomnia with correct mapping in the url,
http://localhost:8182/allocation

************
POST request
************
{
	"empId": "1",
	"name": "Allocation-1",
	"startDate": "2020.02.29",
	"endDate": "2021.02.29"

}

************
Response
************
{
  "id": 1,
  "empId": 1,
  "name": "Allocation-1",
  "startDate": "2020.02.29",
  "endDate": "2021.02.29"
}


Then to connect this Allocation service with Employee service,

