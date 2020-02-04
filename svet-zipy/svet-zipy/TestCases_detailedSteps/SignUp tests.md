
## SignUp   tests
----


### Sign up with unused accounts:    !!!entered by the user!!!

<details>
<summary><strong>sign up with unused email, entered by the user</strong></summary> 
<p>   
   
- open main page
- press signup button		
- ask user and enter e-mail, with default password and use them to sign up		
- check if user logged in
- if succeed, there is "private area" button  
</p>
</details> 
   
<details><summary><strong>sign up with unused phone number, entered by the user</strong></summary>  
<p>   
   
- open main page
- press signup button		
- choose signup by phone
- ask user to enter temporary phone number and use it to sign up 		
- ask user to enter phone code and use it to confirm 		
- check if user logged in
- if succeed, there is "private area" button
</p>
</details> 
             
<details>
<summary><strong>sign up with unused google account, entered by the user</strong></summary> 
<p>   
   
- open main page
- press signup button		
- choose signup by google
- ask user to enter google account identifiers and use them to sign up 		
- check if user logged in
- if succeed, there is "private area" button
</p>
</details> 
		
<details>
<summary><strong>sign up with unused facebook account, entered by the user</strong></summary> 
<p>   
  
- open main page
- press signup button		
- choose signup by FB
- ask user to enter FB account identifiers and use them to sign up		
- check if user logged in
- if succeed, there is "private area" button 
</p>
</details> 
 	
----
 
### Negative Tests - by phone:

<details>
<summary><strong>(with parameters):</strong></summary> 
<p>   
     
- our parameters to test - phone numbers: 
      existing number
      empty number                
      number too short    		
      number too long  
      number including non digit signs in the middle              
      number starting not with 0   		
      wired phone number 
      illegal mobile number              
      illegal wired phone number
    
    
- enter main page
- press signup button		
- choose signup by phone
- enter phone number according to the parameters			
- press sign-up button if enabled
- enter phone code if needed: 		
- check if user logged in
- checking for an error in logging 
- if succeed, the test caught an error as expected and the user is not logged in
</p>
</details> 

   		
<details>
<summary><strong>sign up with incorrect phone by the user      !!!entered by user!!!</strong></summary>  
<p>   
   
- press signup button		
- choose signup by phone
- enter temporary phone number from user		
- enter phone code from user	 		
- check if user logged in
- checking for an error in logging 
- if succeed, the test caught an error as expected and the user is not logged in  
 </p>
</details> 
 	
----  
  
### Negative Tests - by google:

<details>
</strong></summary> (with parameters):</strong></summary> 
<p>   
     
- our parameters to test - email and password : 
      email with no google account 
      incorrect email    		
      empty email 
      empty password              
      wrong password   	
    
- enter main page
- press signup button		
- choose signup by google
- move to google frame
- enter google account identifiers: 
- check if user logged in
- checking for an error in logging 
- if succeed, the test caught an error as expected and the user is not logged in
</p>
</details> 
    	
<details>
<summary><strong>sign up with incorrect Google details, entered by user !!!entered by user!!!</strong></summary>  
<p>   
   
- enter main page
- press signup button		
- choose signup by google
- ask user for google account identifiers: 		
- enter google account identifiers from user: 
- check if user logged in
- checking for an error in logging 
- if succeed, the test caught an error as expected and the user is not logged in
</p>
</details> 
  	
----
  
### Negative Tests - by FB:

<details>
</strong></summary> (with parameters):</strong></summary> 
<p>   
     
- our parameters to test - email and password : 		
      email with no FB account
      phone with no FB account
      incorrect email
      empty email
      empty password
      wrong password
    
- enter main page
- press signup button		
- choose signup by FB
- move to FB frame
- enter FB account identifiers and accept connection: 		
- check if user logged in
- checking for an error in logging 
- if succeed, the test caught an error as expected and the user is not logged in
</p>
</details> 

<details>
<summary><strong>sign up with incorrect FB details, entered by user !!!entered by user!!!</strong></summary> 
 <p>   
  
- enter main page				
- press signup button		
- choose signup by FB
- move to FB frame
- ask user for FB account identifiers: 		
- enter FB account identifiers: 		
- check if user logged in
- checking for an error in logging 
- if succeed, the test caught an error as expected and the user is not logged in
</p>
</details> 

  
  
 ### Negative Tests - by Email:

<details>
</strong></summary> (with parameters):</strong></summary> 
 <p>   
  
- our parameters to test - email and password: 		
      existing email  
      wrong email- domain without "@"
      wrong email- empty
      wrong email- domain with non-alphanumeric
      wrong email- empty domain
      wrong email- no dot after domain
      wrong email- no ending
      wrong email- ending with non-alphabetic
      wrong email- starting with non-alphanumeric
      wrong email- name with space
      wrong email- empty name
      wrong email- domain with one char only
      wrong email- ending with one char only
      wrong email- longer than 254 chars
      wrong password - shorter than 5 chars
      wrong password - longer than 100 chars
      wrong password - empty
    
- enter main page
- press signup button		
- check terms
- enter login+password 
- check if user logged in (if so, appears new button "איזור אישי")
- checking for an error in logging 
- if succeed, the test caught an error as expected and the user is not logged in
</p>
</details> 
	    

<details>
<summary><strong>sign up with unchecked terms of use</strong></summary> 
<p>   
   
- enter main page
- press signup button		
- enter login+password and click signup manually
- check if user logged in (if so, appears new button "איזור אישי")
- checking for an error in logging 
- if succeed, the test caught an error as expected and the user is not logged in
</p>
</details> 
	
  
  
<details>
<summary><strong>sign up with incorrect email and password, by the user !!!entered by user!!!</strong></summary> 
 <p>   
  
- enter main page
- press signup button		
- enter temporary e-mail by user: 		
- check terms and enter login from above + password 
- check if user logged in (if so, appears new button "איזור אישי")
- checking for an error in logging 
- if succeed, the test caught an error as expected and the user is not logged in
</p>
</details> 
