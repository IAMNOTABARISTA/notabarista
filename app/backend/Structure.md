# log out page
method: GET

GET /user/{username}

if user is in the database then we find the user and login will be successful 

# sign in
method: POST

POST /user/{username}
add the username, password, other details in database

# update user profile
method: PUT

PUT /user/{username}/profile/{data_id}


update existing data of a particular user