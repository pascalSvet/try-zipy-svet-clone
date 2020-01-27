## Test Cases:

----

## Master


#### Cart

    **AliExpress:**
	    - comparing to aliExpress !!!in process!!!
	
----

#### Cart

    **Cart_addProduct:**
	    - adding a product to the cart from product pop-up page
	    - adding a product to the cart from second product pop-up page            
	    - adding a product to the cart from less-than-5 tab
	    - adding a product to the cart from category (from categories side panel)
	    - adding a product to the cart from product page
	    - adding both a product from aliExpress and a product from Amazon to the cart

    **Cart_addProduct_withLoggedUser:**
	    - adding a product while unlogged, and the logging in and checking for the product in the cart
	    - adding a product then disconnecting and logging in back, and checking for the product in the cart

    **Cart_addProduct_withVariations:**
	    - adding a product to the cart - with one variation
	    - adding a product to the cart - with two variations
	    - adding a same product twice to the cart, each time with one different variation 
	    - adding a same product twice to the cart, each time with two different variation (while the first is the same in both cases)        
	    - adding twice the same product to the cart, using plus-one button
	    - adding twice the same product to the cart, using quantity button
	    - adding twice the same product to the cart, using quantity and then plus-one buttons
	    - adding twice the same product to the cart, by changing quantity manually in the cart
  
    **Cart_mobile:**
	    - checking the final sum in the cart affected by changing the quantity in the cart
	    - adding product to the cart and changing quantity manually in the cart, for more then 10 items        
	    - removing product from from the cart
	    - removing product from the cart to favorites

    **Cart_price:**
            - checking the final sum in the cart includes the delivery
            - checking the final sum in the cart includes the discount
            - checking the final sum in the cart includes all products in the cart
            - checking the final sum in the cart affected by the quantity of the product
            - checking the final sum in the cart includes all different variations of the same product
            - checking the final sum in the cart affected by removing one of the products
            - checking the final sum in the cart affected by changing the quantity in the cart
            
    **Cart_removeProduct:**
            - removing product from the cart
            - removing product from the cart to the favorites
            - removing product from the cart and then returning it back
            - adding same product twice with different variations, and then removing one of them from the cart
    
----

#### Catalogs

    - Сatalogs_il_aliExpress_combined
    - Сatalogs_il_aliExpress_separated
    - Сatalogs_il_amazon_combined
    - Сatalogs_il_amazon_separated
    - Сatalogs_gr_aliExpress_combined
    - Сatalogs_gr_aliExpress_separated
    - Сatalogs_gr_amazon_combined
    - Сatalogs_gr_amazon_separated
  
----
    
#### Favorites

    - appearance of favorite-pin icon on thumbnail, on mouse hover
    - correct colors of favorite-pin button
    - adding to favorites from product page
    - adding to favorites from product pop-up page
    - adding to favorites from daiy deals thumbnail
    - adding to favorites from less-than-5 tab
    - adding to favorites from search thumbnail
    - adding to favorites from category thumbnail (from categories side panel)

----
    
#### Main Page Thumbs

    **MainPageThumbs_greece:**
      - opening main page thumbnails in Greece site
      - opening main page thumbnails in Greece site - ebay
      - opening main page thumbnails in Greece site - amazon
    **MainPageThumbs_israel:**
      - opening main page thumbnails in Israel site  
            	
----

#### Payments

    - buying product, directy from search
    - buying product from the cart
    - buying all products from the cart
    - buying product directly from its page, when there is another product in the cart
    - byuing product from aliExpress
    - byuing product from amazon
    - buying random product, from lessThan5 tab 

---- 
          
#### Populars

    **Populars_israel:**
          - aliExpress
    **Populars_greece:**
          - aliExpress
          - ebay
          - amazon
    **Populars_cyprus:**
          - aliExpress
          - ebay
          - amazon      
    **Populars_romania:**
          - aliExpress
          - ebay
          - amazon      
    **Populars_italy:**
          - aliExpress
          - ebay
          - amazon      
    **Populars_portugal:**
          - aliExpress
          - ebay
          - amazon      	
 
----
     
#### Sign Up

    **Sign up with unused accounts, !!!entered by the user!!!:**
          - sign up with unused email, entered by the user
          - sign up with unused phone number, entered by the user
          - sign up with unused google account, entered by the user
          - sign up with unused facebook account, entered by the user 
        
     **Negative Tests - by phone:**
          - existing number
          - empty number
          - number too short 
          - number too long 
          - number including non digit signs in the middle
          - number starting not with 0
          - wired phone number
          - illegal mobile number
          - illegal wired phone number
          - sign up with incorrect phone, entered by the user !!!entered by user!!!
        
     **Negative Tests - by google:**
          - email with no google account
          - incorrect email
          - empty email 
          - empty password
          - wrong password
          - sign up with incorrect Google details, entered by user !!!entered by user!!!
        
     **Negative Tests - by FB:**
          - email with no FB account
          - phone with no FB account
          - incorrect email
          - empty email 
          - empty password
          - wrong password
          - sign up with incorrect FB details, entered by user !!!entered by user!!!
        
     **Negative Tests - by email:**
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
          - sign up with incorrect email and password, entered by the user !!!entered by user!!!

----        
     
#### User

    **User_password:**
          - changing the password
          - recovering the password  !!!entered by user!!!
    **User_email:**
          - changing the email          
    **User_mobile:**
          - TestsMobile - changing the password
          - TestsMobile - changing the email
          
----        
                
## Test

    ** Test Main Page Thumbs **
    ** Test Populars **
    ** Test Favorites **


----   
     
## Dev

    **Test Main Page Thumbs**
    **Test Populars**
    **Test Favorites**
