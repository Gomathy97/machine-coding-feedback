### Description: Implement a ride-sharing application with the below-expected features.
https://www.geeksforgeeks.org/flipkart-machine-coding-round-experience/

### Features:
1. The application allows users to share rides on a route. 
2. Users can either offer a shared ride (Driver) or consume a shared ride (Passenger). 
3. Users can search and select one from multiple available rides on a route with the same source and destination.

### Requirements:
1. Application should allow user onboarding. 
   1. add_user(user_detail)
      1. Add basic user details 
   2. add_vehicle(vehicle_detail)
      1. Add the user’s vehicle(s) details 
2. User should be able to offer a shared ride on a route with details. 
   1. offer_ride(ride_detail)
      1. Ride will have details like vehicle, origin, destination, available seats. (A ride will have no intermediate stops.)
3. Users can select a ride from multiple offered rides using a selection strategy. (A user can only request  a ride (only for 1 or 2 people))
   1. select_ride(source, destination, seats, selection_strategy)
      1. Preferred Vehicle (Activa/Polo/XUV)
      2. Most Vacant. 
4. System should be able to end the ride. User can only offer a ride for a given vehicle, once there are no active offered rides for that vehicle. 
   1. end_ride(ride_details)
5. Find total rides offered/taken by all users. 
   1. print_ride_stats()

### Bonus Question:

* If the user’s origin/destinations are not available directly but it’s possible via multiple rides, then the application should output multiple rides. (Example: for input: Bangalore to Mumbai, the output can be Bangalore to Goa and Goa to Mumbai) 

### Other Notes:
1. Write a driver class for demo purposes. Which will execute all the commands in one place in the code and test cases.  
2. Do not use any database or NoSQL store, use in-memory data-structure for now.
3. Do not create any UI for the application. 
4. Please prioritize code compilation, execution, and completion.
5. Work on the expected output first and then add good-to-have features of your own.

### Expectations:
1. Make sure that you have a working and demonstrable code. 
2. Make sure that the code is functionally correct. 
3. Use of proper abstraction, modeling, separation of concerns is required. 
4. Code should be modular, readable and unit-testable. 
5. Code should easily accommodate new requirements with minimal changes. 
6. Proper exception handling is required.

### Sample Test Cases:
1. Onboard 5 users 
   1. add_user(“Rohan, M, 36”); add_vehicle(“Rohan, Swift, KA-01-12345)
   2. add_user(“Shashank, M, 29”); add_vehicle(“Shashank, Baleno, TS-05-62395)
   3. add_user(“Nandini, F, 29)
   4. add_user(“Shipra, F, 27”) ; add_vehicle(“Shipra”, Polo, KA-05-41491); add_vehicle(“Shipra, Activa KA-12-12332”)
   5. add_user(“Gaurav, M, 29)
   6. add_user(“Rahul, M, 35); add_vehicle(“Rahul”, “XUV”, KA-05-1234); 
2. Offer 4 rides by 3 users 
   1. offer_ride(“Rohan, Origin=Hyderabad, Available Seats=1, Vehicle=Swift, KA-01-12345, Destination= Bangalore”)
   2. offer_ride(“Shipra, Origin=Bangalore, Available Seats=1, Vehicle=Activa KA-12-12332, Destination=Mysore”)
   3. offer_ride(“Shipra, Origin=Bangalore, Available Seats=2, Vehicle=Polo, KA-05-41491, Destination=Mysore”)
   4. offer_ride(“Shashank, Origin=Hyderabad, Available Seats=2, Vehicle=Baleno, TS-05-62395, Destination=Bangalore”)
   5. offer_ride(“Rahul, Origin=Hyderabad, Available Seats=5, Vehicle=XUV,  KA-05-1234, Destination=Bangalore”)
   6. offer_ride(“Rohan, Origin=Bangalore, Available Seats=1, Vehicle=Swift, KA-01-12345, Destination=Pune”)
      * This call should fail, since a ride has already been offered by this user for this vehicle. 
3. Find rides for 4 users 
   1. select_ride(“Nandini, Origin=Bangalore, Destination=Mysore, Seats=1, Most Vacant”)
      * 2(c) is the desired output. 
   2. select_ride(“Gaurav, Origin=Bangalore, Destination=Mysore, Seats=1, Preferred Vehicle=Activa”)
      * 2(b) is the desired output 
   3. select_ride(“Shashank, Origin=Mumbai, Destination=Bangalore, Seats=1, Most Vacant”)
      * No rides found 
   4. select_ride(“Rohan, Origin=Hyderabad, Destination=Bangalore, Seats=1, Preferred Vehicle=Baleno”)
      * 2(d) is the desired output 
   5. select_ride(“Shashank, Origin=Hyderabad, Destination=Bangalore, Seats=1,Preferred Vehicle=Polo”)
      * No rides found 
4. End Rides 
   1. end_ride(2-a)
   2. end_ride(2-b)
   3. end_ride(2-c)
   4. end_ride(2-d)
5. Find total rides by user: Rides Taken: Rides that have were taken and have been marked as “ended” Rides Offered: Rides that were offered and have been marked as “ended”. Note: Even if the offered ride was not taken by any user, it counts as an offered ride. 
   1. print_ride_stats()
      * Nandini: 1 Taken, 0 Offered 
      * Rohan: 1 Taken, 1 Offered 
      * Shashank: 0 Taken, 1 Offered 
      * Gaurav: 1 Taken, 0 Offered 
      * Rahul: 0 Taken, 0 Offered 
      * Shipra: 0 Taken, 2 Offered