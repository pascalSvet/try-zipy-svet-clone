
## Search tests
----

### Search_field:


  **clearing search field**
  
    -open main page
    -enter search keyword and then clear the field
    **if succeed, then the field will be empty 

  **performing empty search**
  		  		
    -open main page
    -enter search keyword and then clear the field
    **if succeed, then the field will be empty and the "type a product name" message will shake
		
  **opening of dropdown autocomplete menu** 
   
    -open main page
    -enter search keyword
    **if succeed, then a dropdown menu with autocomplete hints will open
		         
  **closing of dropdown autocomplete menu after clearing the search field**
  
    -open main page
    -enter search keyword
    -clear the search field
    **if succeed, then a dropdown menu will close
		 		
  **performing search with autocomplete hint**
  
    -open main page
    -enter search keyword
    -choose the first hint and save its name
    -save the new search name
    **if search succeed correctly, the search field contains the hint and there is option for ordering the results
		   
  **keeping the keyword in search field after switching to amazon**
  
    -open main page
    -enter search keyword
    -switch to amazon
    **if succeed, then a search field will keep the keyword
		    
  **keeping the keyword search after switching to ebay**
  
    -open main page
    -enter search keyword
    -switch to ebay
    **if succeed, then a search field will keep the keyword	
			  
   **keeping the keyword search after switching to Less-than-5**
  
    -open main page
    -enter search keyword
    -switch to Less-than-5
    **if succeed, then a search field will keep the keyword	
				   		
  **clearing the keyword in search field after switching to amazon**
  
    -open main page
    -perform search and then clear the field
    -switch to amazon
    **if succeed, then a search field will be empty
		   
  **clearing the keyword search after switching to ebay**
  
    -open main page
    -perform search and then clear the field
    -switch to ebay
    **if succeed, then a search field will be empty
		    
  **clearing the keyword search after switching to Less-than-5**
  
    -open main page
    -perform search and then clear the field
    -switch to Less-than-5
    **if succeed, then a search field will be empty
		


### Search_input:

  **searching in Israel site - in english**
  
    -open the main page
    -perform search and open the product
    **if search succeed, there is option for ordering the results 
   
  **searching in Israel site - in hebrew**
  
    -open the main page
    -perform search and open the product
    **if search succeed, there is option for ordering the results 
		  
  **searching in Portugal site - in english**
  
    -open the main page
    -perform search and open the product
    **if search succeed, there is option for ordering the results  
   
  **searching in Portugal site - in portuguese with special characters**
  
    -open the main page
    -perform search with the first part of special characters in portuguese
    -perform another search with the second part of special characters in portuguese
    **if search succeed, there is option for ordering the results in both cases 
		
  **searching with special signs - apostrophe**
  
    -open the main page
    -perform search and open the product
    **if search succeed correctly, the element we were looking for did not change, and there is option for ordering the results
   
  **searching with special signs - dash**
  
    -open the main page
    -perform search and open the product
    **if search succeed correctly, the element we were looking for did not change, and there is option for ordering the results
		   
  **searching with special signs - parenthesis**
  
    -open the main page
    -perform search and open the product
    **if search succeed correctly, the element we were looking for did not change, and there is option for ordering the results
   
  **searching with special signs - bracket**
  
    -open the main page
    -perform search and open the product
    **if search succeed correctly, the element we were looking for did not change, and there is option for ordering the results



### Search_links:**

  **searching on Israel site - link from aliExpress**

    -open product on aliExpress and save its title
    -search by the link on zipy, open the product and save its title 
    **if search succeed, the product we found on zipy is the same from aliExpress
   
  **searching on Israel site - link from ebay**
 
    -open product on ebay and save its title
    -search by the link on zipy, open the product and save its title 
    **if search succeed, the product we found on zipy is the same from ebay 
   
  **searching on Israel site - link from amazon**
  
    -open product on amazon and save its title
    -search by the link on zipy, open the product and save its title 
    **if search succeed, the product we found on zipy is the same from amazon   
   
 **searching on Greece site - link from aliExpress**
  
    -open product on aliExpress and save its title
    -search by the link on zipy, open the product and save its title 
    **if search succeed, the product we found on zipy is the same from aliExpress
   
  **searching on Greece site - link from ebay.de**
  
    -open product on ebay.de and save its title
    -search by the link on zipy, open the product and save its title 
    **if search succeed, the product we found on zipy is the same from ebay.de 
   
  **searching on Greece site - link from amazon.de**

    -open product on amazon.de and save its title
    -search by the link on zipy, open the product and save its title 
    **if search succeed, the product we found on zipy is the same from amazon.de   
 

    
### Search_redirect:

  **redirecting search results from amazon to other, if nothing found**
  
    -open main amazon page
    -perform search for a product that is definitely not on the site
    **if replaced, there is an appropriate message
   
  **redirecting search results from ebay to other, if nothing found** 
  
    -open main ebay page
    -perform search for a product that is definitely not on the site
    -turn off smart search
    **if replaced, there is an appropriate message
          
  **redirecting search results from ebay to other, more suitable, when smart search is on**
  
    -open main ebay page
    -perform search for a product that is definitely not on the site
    -turn off smart search
    -turn it on back
    **if replaced, there is an appropriate message
   
  **redirecting search results from other to any other, if nothing found**
  
    -open main aliExpress page
    -perform search for a product that is definitely not on the site
    **if replaced, there is an appropriate message		
  