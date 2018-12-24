# Blood-Donor

Sql Scripts for Blood-Donors :

Drop Table Users_Feedback;
Drop Table Users_Role;
Drop Table Role;
Drop Table Users_Address;
Drop Table Users;

Create Table Users(Login_Id Varchar2(15) Primary Key, Password Varchar2(15),Email_Id Varchar2(30) Unique, First_Name Varchar2(8),Last_Name Varchar2(8),Mobile_No Number(10),Blood_Group Varchar2(8));

Create Table Users_Address(Login_Id Varchar2(15) Primary Key, City Varchar2(15),State Varchar2(15),Location Varchar2(20));

Create Table Role(Role_Id number(10) Primary Key,Role_Name Varchar2(15));

Create Table Users_Role(Login_Id Varchar2(15) references Users(Login_Id),Role_Id Number(10) references Role(Role_Id));

Create Table Users_Feedback(Feedback_Id Number(10) Primary Key, Feedback_Message Varchar2(150),Posted_By varchar2(15) references Users(Login_Id),Donor_Id references Users(Login_Id));


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










