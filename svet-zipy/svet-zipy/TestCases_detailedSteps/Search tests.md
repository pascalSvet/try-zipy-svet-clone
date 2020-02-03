
## Search tests
----

### Search_field:


  **clearing search field**
  
      -open deals page
   
  **opening of dropdown autocomplete menu** 
   
      -open deals page
            
  **closing of dropdown autocomplete menu after clearing the search field**
  
      -open the less-than-5 tab
   		
  **performing search with autocomplete hint**
  
      -open main page
   
  **keeping the keyword in search field after switching to amazon**
  
      -get to the required product page 
    
  **keeping the keyword search after switching to ebay**
  
      -get to the aliExpress product page 
  
   **keeping the keyword search after switching to Less-than-5**
  
      -open the less-than-5 tab
   		
  **clearing the keyword in search field after switching to amazon**
  
      -open main page
   
  **clearing the keyword search after switching to ebay**
  
      -get to the required product page 
    
  **clearing the keyword search after switching to Less-than-5**
  
      -get to the aliExpress product page 
----


### Search_input:

  **searching in Israel site - in english**
  
		//open the main page
		//perform search and open the product
		//if search succeed, there is option for ordering the results 
   
  **searching in Israel site - in hebrew**
  
		//open the main page
		//perform search and open the product
		//if search succeed, there is option for ordering the results 
		  
  **searching in Portugal site - in english**
  
		//open the main page
		//perform search and open the product
		//if search succeed, there is option for ordering the results  
   
  **searching in Portugal site - in portuguese with special characters**
  
		//open the main page
		//perform search with the first part of special characters in portuguese
		//perform another search with the second part of special characters in portuguese
		//if search succeed, there is option for ordering the results in both cases 
		
  **searching with special signs - apostrophe**
  
		//open the main page
		//perform search and open the product
		//if search succeed correctly, the element we were looking for did not change, and there is option for ordering the results
   
  **searching with special signs - dash**
  
		//open the main page
		//perform search and open the product
		//if search succeed correctly, the element we were looking for did not change, and there is option for ordering the results
		   
  **searching with special signs - parenthesis**
  
		//open the main page
		//perform search and open the product
		//if search succeed correctly, the element we were looking for did not change, and there is option for ordering the results
   
  **searching with special signs - bracket**
  
		//open the main page
		//perform search and open the product
		//if search succeed correctly, the element we were looking for did not change, and there is option for ordering the results



### Search_links:**

  **searching on Israel site - link from aliExpress**

		//open product on aliExpress and save its title
		//search by the link on zipy, open the product and save its title 
		//if search succeed, the product we found on zipy is the same from aliExpress
   
  **searching on Israel site - link from ebay**
 
		//open product on ebay and save its title
		//search by the link on zipy, open the product and save its title 
		//if search succeed, the product we found on zipy is the same from ebay 
   
  **searching on Israel site - link from amazon**
  
		//open product on amazon and save its title
		//search by the link on zipy, open the product and save its title 
		//if search succeed, the product we found on zipy is the same from amazon   
   
 **searching on Greece site - link from aliExpress**
  
		//open product on aliExpress and save its title
		//search by the link on zipy, open the product and save its title 
		//if search succeed, the product we found on zipy is the same from aliExpress
   
  **searching on Greece site - link from ebay.de**
  
		//open product on ebay.de and save its title
		//search by the link on zipy, open the product and save its title 
		//if search succeed, the product we found on zipy is the same from ebay.de 
   
  **searching on Greece site - link from amazon.de**

		//open product on amazon.de and save its title
		//search by the link on zipy, open the product and save its title 
		//if search succeed, the product we found on zipy is the same from amazon.de   
 

    
### Search_redirect:

  **redirecting search results from amazon to other, if nothing found**
  
		//open main amazon page
		//perform search for a product that is definitely not on the site
		//if replaced, there is an appropriate message
   
  **redirecting search results from ebay to other, if nothing found** 
  
		//open main ebay page
		//perform search for a product that is definitely not on the site
		//turn off smart search
		//if replaced, there is an appropriate message
          
  **redirecting search results from ebay to other, more suitable, when smart search is on**
  
		//open main ebay page
		//perform search for a product that is definitely not on the site
		//turn off smart search
		//turn it on back
		//if replaced, there is an appropriate message
   
  **redirecting search results from other to any other, if nothing found**
  
		//open main aliExpress page
		//perform search for a product that is definitely not on the site
		//if replaced, there is an appropriate message		
  