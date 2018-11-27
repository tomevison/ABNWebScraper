# ABN WebScraper

Reads .csv of company names and returns the top ABN result on https://abr.business.gov.au/

Input/output .csv files can be defined in Webscraper.src.Application.Main.java

### input:
```
Company abc
Electrical
Computers
Hairdressers
```

### output:
```
SearchTerm,ABN,Company Name,State,Postcode
Company abc,68 139 239 071,ABC,WA,6036        
Electrical,15 611 951 172,#ELECTRICAL PTY LTD,NSW,2117        
Computers,80 917 519 417,COMPUTER COMPANYQLD,4012        
Hairdressers,59 479 503 534,HAIRDRESSER
```

