# ReactBackEnd
Please run this command before run project 

INSERT INTO role(
	role_id, role_name)
	VALUES (1,'Administrator');
  
INSERT INTO role(
	role_id, role_name)
	VALUES (2, 'Operation');
  
INSERT INTO role(
	role_id, role_name)
	VALUES (3, 'Access');
  

INSERT INTO login(user_id, approved, email, mobile_no, password, role_id, user_name)
          VALUES (1,true, 'admin@gmail.com', 9874563214, 'Admin123', 1, 'Admin');
