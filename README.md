# Blood-Donor

Sql Scripts for Blood-Donors :

Drop Table Users_Feedback;
Drop Table Users_Role;
Drop Table Role;
Drop Table Users_Address;
Drop Table Users;

Create Table Users(Login_Id Varchar2(15) , Password Varchar2(15),Email_Id Varchar2(30) Not Null , First_Name Varchar2(8),Last_Name Varchar2(8),Mobile_No Varchar2(20) Not Null,Blood_Group Varchar2(8),Constraint Login_Id_Primary Primary Key(Login_Id) );

Create Table Users_Address(Login_Id Varchar2(15) references Users(Login_Id), City Varchar2(15),State Varchar2(15),Location Varchar2(20),Constraint Address_Login_Id_Primary Primary Key(Login_Id));

Create Table Role(Role_Id number(10),Role_Name Varchar2(15),Constraint Role_Id_Primary Primary Key(Role_Id));

Create Table Users_Role(Login_Id Varchar2(15) references Users(Login_Id),Role_Id Number(10) references Role(Role_Id));

Create Table Users_Feedback(Feedback_Id Number(10), Feedback_Message Varchar2(150),Posted_By varchar2(15) references Users(Login_Id),Donor_Id references Users(Login_Id),Constraint Feedback_ID_Primary Primary Key(Feedback_Id));


SQL> DESC Users;
 Name					   Null?    Type
 ----------------------------------------- -------- ----------------------------
 LOGIN_ID				   NOT NULL VARCHAR2(15)
 PASSWORD					    VARCHAR2(15)
 EMAIL_ID					    VARCHAR2(30)
 FIRST_NAME					    VARCHAR2(8)
 LAST_NAME					    VARCHAR2(8)
 MOBILE_NO					    NUMBER(10)
 BLOOD_GROUP					    VARCHAR2(8)

SQL> DESC Users_Address;
 Name					   Null?    Type
 ----------------------------------------- -------- ----------------------------
 LOGIN_ID				   NOT NULL VARCHAR2(15)
 CITY						    VARCHAR2(15)
 STATE						    VARCHAR2(15)
 LOCATION					    VARCHAR2(20)

SQL> DESC Role;
 Name					   Null?    Type
 ----------------------------------------- -------- ----------------------------
 ROLE_ID				   NOT NULL NUMBER(10)
 ROLE_NAME					    VARCHAR2(15)

SQL> DESC USERS_Role;
 Name					   Null?    Type
 ----------------------------------------- -------- ----------------------------
 LOGIN_ID					    VARCHAR2(15)
 ROLE_ID					    NUMBER(10)

SQL> DESC USERS_FEEDBACK;
 Name					   Null?    Type
 ----------------------------------------- -------- ----------------------------
 FEEDBACK_ID				   NOT NULL NUMBER(10)
 FEEDBACK_MESSAGE				    VARCHAR2(150)
 POSTED_BY					    VARCHAR2(15)
 DONOR_ID					    VARCHAR2(15)



# Test Data

Insert Into Users(Login_Id,Password,Email_Id,First_Name,Last_Name,Mobile_No,Blood_Group) Values('Srinu.Np','test111','SrinuNp_test@gmail.com','Srinu','Np','91770399675','B+');

Insert Into Users(Login_Id,Password,Email_Id,First_Name,Last_Name,Mobile_No,Blood_Group) Values('Venu.Np','test111','VenuNp_test@gmail.com','Venu','Np','9700019324','O+');

Insert Into Users(Login_Id,Password,Email_Id,First_Name,Last_Name,Mobile_No,Blood_Group) Values('Akash.Np','test111','AkashNp_test@gmail.com','Akash','Np','9666381515','B+');

Insert Into USERS_ADDRESS(Login_Id,City,State,Location) Values('Srinu.Np','Hyd','Telangana','HitechCity');

Insert Into USERS_ADDRESS(Login_Id,City,State,Location) Values('Venu.Np','Hyd','Telangana','KPHP');

Insert Into USERS_ADDRESS(Login_Id,City,State,Location) Values('Akash.Np','Hyd','Telangana','BanjaraHills');

Insert Into Role(Role_Id,Role_Name) Values(1,'Admin');
Insert Into Role(Role_Id,Role_Name) Values(2,'Donor');

Insert Into USERS_Role(Login_Id,Role_Id) values('Akash.Np',1);
Insert Into USERS_Role(Login_Id,Role_Id) values('Srinu.Np',2);
Insert Into USERS_Role(Login_Id,Role_Id) values('Venu.Np',2);
Insert Into USERS_Role(Login_Id,Role_Id) values('Akash.Np',2);

Insert Into USERS_FeedBack(Feedback_Id,Feedback_Message,Posted_By,Donor_ID) Values(1,'Responded On Time.Thanks Venu','Srinu.Np','Venu.Np');
Insert Into USERS_FeedBack(Feedback_Id,Feedback_Message,Posted_By,Donor_ID) Values(2,'Did not lift the call.','Srinu.Np','Venu.Np');
Insert Into USERS_FeedBack(Feedback_Id,Feedback_Message,Posted_By,Donor_ID) Values(3,'Not Reachable','Akash.Np','Venu.Np');

commit;






