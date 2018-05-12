   Feature: Buy a ticket on JetStart Website and login in

         Scenario: Buy a one way ticket whose destination is Christchurch
          Given I open the JetStart website
    	  And I choose a destination "Christchurch"
    	  And I want buy a one way ticket and choose date
    	  And I select flight time
    	  And I have no bundle and baggage
    	  And I dont mind where i sit and dont book hotel
    	  Then I log in and enter the right username and password
    	  Then I should get login_in 