## Test Cases:

----

## MASTER SITE


#### AliExpress

- comparing to aliExpress !!!in process!!!
	
----

#### Cart

<details><summary>Cart_addProduct:</summary>
<p>   
 
- adding a product to the cart from quick pop-up page
- adding a product to the cart from second product pop-up page            
- adding a product to the cart from less-than-5 tab
- adding a product to the cart from category 
- adding a product to the cart from product page
- adding both a product from aliExpress and a product from Amazon to the cart
</p>
</details> 
 
   
<details><summary>Cart_addProduct_withLoggedUser:</summary>
<p>   
 
- adding a product while unlogged, and the logging in and checking for the product in the cart
- adding a product then disconnecting and logging in back, and checking for the product in the cart

</p>
</details> 
 
   
<details><summary>Cart_addProduct_withVariations:</summary>
<p>   
 
- adding a product to the cart - with one variation
- adding a product to the cart - with two variations
- adding a same product twice to the cart, each time with one different variation 
- adding a same product twice to the cart, each time with two different variation (while the first is the same in both cases)        
- adding twice the same product to the cart, using plus-one button
- adding twice the same product to the cart, using quantity button
- adding twice the same product to the cart, using quantity and then plus-one buttons
- adding twice the same product to the cart, by changing quantity manually in the cart
 </p>
</details> 
    
<details><summary>Cart_mobile:</summary>
<p>   
 
- checking the final sum in the cart affected by changing the quantity in the cart
- adding product to the cart and changing quantity manually in the cart, for more then 10 items        
- removing product from from the cart
- removing product from the cart to favorites
</p>
</details> 
   
<details><summary>Cart_price:</summary>
<p>   
 
- checking the final sum in the cart includes the delivery
- checking the final sum in the cart includes the discount
- checking the final sum in the cart includes all products in the cart
- checking the final sum in the cart affected by the quantity of the product
- checking the final sum in the cart includes all different variations of the same product
- checking the final sum in the cart affected by removing one of the products
- checking the final sum in the cart affected by changing the quantity in the cart
</p>
</details> 
               
<details><summary>Cart_removeProduct:</summary>
<p>   
 
- removing product from the cart
- removing product from the cart to the favorites
- removing product from the cart and then returning it back
- adding same product twice with different variations, and then removing one of them from the cart
- removing product from the payment page   
- removing product to favorites from the payment page
</p>
</details> 

[link to detailed scenarios](https://gitlab.com/morozov_igor/zipyqasvet/-/blob/master/svet-zipy/svet-zipy/TestCases_detailedSteps/Cart%20tests.md)
           
----

#### Catalogs

<details><summary>Сatalogs_il:</summary>
<p>   
 
- Сatalogs_il_aliExpress_combined (with parameters)
- Сatalogs_il_aliExpress_separated
- Сatalogs_il_amazon_combined (with parameters)
- Сatalogs_il_amazon_separated
</p>
</details> 
  
  
 <details><summary>Сatalogs_gr:</summary>
<p>   
  
- Сatalogs_gr_aliExpress_combined (with parameters)
- Сatalogs_gr_aliExpress_separated
- Сatalogs_gr_amazon_combined (with parameters)
- Сatalogs_gr_amazon_separated
 </p>
</details> 
  	
[link to detailed scenarios](https://gitlab.com/morozov_igor/zipyqasvet/-/blob/master/svet-zipy/svet-zipy/TestCases_detailedSteps/Catalogs%20tests.md)

----

#### Errors

<details><summary>Errors_502</summary>
<p>   
 
- catching 502 error while opening many tabs in categories - Greece
- catching 502 error while opening many tabs in categories - Portugal
- catching 502 error while opening many tabs in categories - Israel
- catching 502 error while opening many tabs in deals - Greece
- catching 502 error while opening many tabs in deals - Portugal
- catching 502 error while opening many tabs in deals - Israel
</p>
</details> 

[link to detailed scenarios](https://gitlab.com/morozov_igor/zipyqasvet/-/blob/master/svet-zipy/svet-zipy/TestCases_detailedSteps/Errors%20tests.md)
   	  
----
    
#### Favorites

<details><summary>Favorites_icon</summary>
<p>   
 
- appearance of favorite-pin icon on thumbnail, on mouse hover
- correct colors of favorite-pin button
</p>
</details> 


<details><summary>Favorites_adding</summary>
 <p>   
 
- adding to favorites from product page
- adding to favorites from product pop-up page
- adding to favorites from daily deals thumbnail
- adding to favorites from less-than-5 tab
- adding to favorites from search thumbnail
- adding to favorites from category 
</p>
</details> 

[link to detailed scenarios](https://gitlab.com/morozov_igor/zipyqasvet/-/blob/master/svet-zipy/svet-zipy/TestCases_detailedSteps/Favorites%20tests.md)
   
----

#### Gallery

<details><summary>Gallery</summary>
 <p> 
 
- updating gallery image according to the chosen variation
- updating gallery image after changing chosen variation
- updating gallery image after sliding left
- updating updating gallery image after sliding right
- updating gallery image after sliding more the once
- adding image near the chosen variation according to the choice
- updating image near the variation after changing the chosen variation
</p>
</details> 

[link to detailed scenarios](https://gitlab.com/morozov_igor/zipyqasvet/-/blob/master/svet-zipy/svet-zipy/TestCases_detailedSteps/Gallery%20tests.md)
   
----
 
#### Loading

<details><summary>Loading:</summary>
<p>   
 
- presence of loader-spinner on thumbnail click
- updating of loader-spinner after clicking on another thumbnail
</p>
</details> 
  
  
 <details><summary>Loading_mobile:</summary>
 <p>   
 
- TestsMobile - presence of loader-spinner on thumbnail click
- TestsMobile - updating of loader-spinner after clicking on another thumbnail
</p>
</details> 

[link to detailed scenarios](https://gitlab.com/morozov_igor/zipyqasvet/-/blob/master/svet-zipy/svet-zipy/TestCases_detailedSteps/Loading%20tests.md)
        
----
    
#### Main Page Thumbs

<details><summary>MainPageThumbs_greece:</summary>
<p>   
 
- opening main page thumbnails in Greece site
- opening main page thumbnails in Greece site - ebay
- opening main page thumbnails in Greece site - amazon
</p>
</details> 
  
  
<details><summary>MainPageThumbs_israel:</summary>
 <p>   
 
- opening main page thumbnails in Israel site  
</p>
</details> 

[link to detailed scenarios](https://gitlab.com/morozov_igor/zipyqasvet/-/blob/master/svet-zipy/svet-zipy/TestCases_detailedSteps/MainPage%20tests.md)
              	
----

#### Payments

<details><summary>Payments:</summary>
 <p> 
 
- buying product, directly from search
- buying product from the cart
- buying all products from the cart
- buying product directly from its page, when there is another product in the cart
- buying product from aliExpress
- buying product from amazon
- buying random product, from lessThan5 tab 
</p>
</details> 

[link to detailed scenarios](https://gitlab.com/morozov_igor/zipyqasvet/-/blob/master/svet-zipy/svet-zipy/TestCases_detailedSteps/Payment%20tests.md)

---- 
          
#### Populars

<details><summary>Israel site:</summary>
<p>   
 
- populars thumbnails on aliExpress page
</p>
</details> 
 
 
<details><summary>Greece site:</summary>
<p>   
 
- populars thumbnails on aliExpress page
- populars thumbnails on ebay page
- populars thumbnails on amazon page
</p>
</details> 
 
 
<details><summary>Cyprus site:</summary>
<p>   
 
- populars thumbnails on aliExpress page
- populars thumbnails on ebay page
- populars thumbnails on amazon page 
</p>
</details> 
   
   
<details><summary>Romania site:</summary>
<p>   
 
- populars thumbnails on aliExpress page
- populars thumbnails on ebay page
- populars thumbnails on amazon page
</p>
</details> 
    
    
<details><summary>Italy site:</summary>
<p>   
 
- populars thumbnails on aliExpress page
- populars thumbnails on ebay page
- populars thumbnails on amazon page 
</p>
</details> 
  
  
<details><summary>Portugal site:</summary>
<p>   
 
- populars thumbnails on aliExpress page
- populars thumbnails on ebay page
- populars thumbnails on amazon page    	
</p>
</details> 

[link to detailed scenarios](https://gitlab.com/morozov_igor/zipyqasvet/-/blob/master/svet-zipy/svet-zipy/TestCases_detailedSteps/Populars%20tests.md)
  
----

#### Search

<details><summary>Search_field:</summary>
<p>   
 
- clearing search field
- performing empty search
- opening of dropdown autocomplete menu
- closing of dropdown autocomplete menu after clearing the search field
- performing search with autocomplete hint
- keeping the keyword in search field after switching to amazon
- keeping the keyword search after switching to ebay
- keeping the keyword search after switching to Less-than-5
- clearing the keyword in search field after switching to amazon
- clearing the keyword search after switching to ebay
- clearing the keyword search after switching to Less-than-5
</p>
</details> 
     
     
<details><summary>Search_input:</summary>
<p>   
 
- searching in Israel site - in english
- searching in Israel site - in hebrew
- searching in Portugal site - in english
- searching in Portugal site - in portuguese with special characters
- searching with special signs - apostrophe
- searching with special signs - dash
- searching with special signs - parenthesis
- searching with special signs - bracket
 </p>
</details> 
    
    
<details><summary>Search_links:</summary>
<p>   
 
- searching on Israel site - link from aliExpress
- searching on Israel site - link from ebay
- searching on Israel site - link from amazon
- searching on Greece site - link from aliExpress
- searching on Greece site - link from ebay.de
- searching on Greece site - link from amazon.de
</p>
</details> 
     
     
<details><summary>Search_redirect:</summary>
<p>   
 
- redirecting search results from amazon to other, if nothing found
- redirecting search results from ebay to other, if nothing found
- redirecting search results from ebay to other, more suitable, when smart search is on
- redirecting search results from aliExpress to other, if nothing found
</p>
</details> 
 
 
[link to detailed scenarios](https://gitlab.com/morozov_igor/zipyqasvet/-/blob/master/svet-zipy/svet-zipy/TestCases_detailedSteps/Search%20tests.md)
          
----
              
#### Sign Up

<details><summary>Sign up with unused accounts, !!!entered by the user!!!:</summary>
<p>   
 
- sign up with unused email, entered by the user
- sign up with unused phone number, entered by the user
- sign up with unused google account, entered by the user
- sign up with unused facebook account, entered by the user
 </p>
</details> 
        
        
 <details><summary>Negative Tests - by phone:</summary>
 <p>   
 
- existing number
- empty number
- number too short 
- number too long 
- number including non digit signs in the middle
- number starting not with 0
- wired phone number
- illegal mobile number
- illegal wired phone number
- sign up with incorrect phone, entered by the user !!!user input required!!!
</p>
</details> 
       
         
 <details><summary>Negative Tests - by google:</summary>
 <p>   
 
- email with no google account
- incorrect email
- empty email 
- empty password
- wrong password
- sign up with incorrect Google details, entered by user !!!user input required!!!
</p>
</details> 
      
         
 <details><summary>Negative Tests - by FB:</summary>
 <p>   
 
- email with no FB account
- phone with no FB account
- incorrect email
- empty email 
- empty password
- wrong password
- sign up with incorrect FB details, entered by user !!!user input required!!!
</p>
</details> 
       
         
 <details><summary>Negative Tests - by email:</summary>
 <p>   
 
- existing email
- wrong email- domain without "@"
- wrong email- empty
- wrong email- domain with non-alphanumeric
- wrong email- empty domain
- wrong email- no dot after domain
- wrong email- no ending
- wrong email- ending with non-alphabetic
- wrong email- starting with non-alphanumeric
- wrong email- name with space
- wrong email- empty name
- wrong email- domain with one char only
- wrong email- ending with one char only
- wrong email- longer than 254 chars
- wrong password - shorter than 5 chars
- wrong password - longer than 100 chars
- wrong password - empty
- sign up with unchecked terms of use
- sign up with incorrect email and password, entered by the user !!!user input required!!!
</p>
</details> 

[link to detailed scenarios](https://gitlab.com/morozov_igor/zipyqasvet/-/blob/master/svet-zipy/svet-zipy/TestCases_detailedSteps/SignUp%20tests.md)
 
----        
     
#### User

<details><summary>User_password:</summary>
<p>   
 
- changing the password
- recovering the password  !!!user input required!!!
</p>
</details> 
 
 
<details><summary>User_email:</summary>
<p>   
 
- changing the email  
</p>
</details> 
        
         
<details><summary>User_mobile:</summary>
<p>   
 
- TestsMobile - changing the password
- TestsMobile - changing the email
 </p>
</details> 
 

[link to detailed scenarios](https://gitlab.com/morozov_igor/zipyqasvet/-/blob/master/svet-zipy/svet-zipy/TestCases_detailedSteps/User%20tests.md)
 
          
----        
----        
                
## TEST SITE

<details><summary> Test Main Page Thumbs</summary>
<p>   
same as master site:
 
- Test_MainPageThumbs_greece
- Test_MainPageThumbs_israel

</p>
</details> 


<details><summary> Test Populars Thumbs</summary>
<p>   
same as master site:
 
- Israel site
- Greece site
- Cyprus site
- Romania site
- Italy site
- Portugal site
</p>
</details> 


<details><summary> Test Favorites </summary>
<p>   
same as master site:
 
- Favorites_icon
- Favorites_adding

</p>
</details> 


----   
----   
     
## DEV SITE

<details><summary>Dev Main Page Thumbs</summary>
<p>   
same as master site:
 
- Dev_MainPageThumbs_greece
- Dev_MainPageThumbs_israel

</p>
</details> 


<details><summary>Dev Populars Thumbs</summary>
<p>   
same as master site:
 
- Israel site
- Greece site
- Cyprus site
- Romania site
- Italy site
- Portugal site
</p>
</details> 


<details><summary>Dev Favorites</summary>
<p>   
same as master site:
 
- Favorites_icon
- Favorites_adding

</p>
</details> 
  