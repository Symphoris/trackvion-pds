select drop database trackdevdb;
create database trackdevdb;
use trackdevdb;

#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------

#------------------------------------------------------------
# Table: Addresses
#------------------------------------------------------------

CREATE TABLE Addresses(
        ID_Address        Int  Auto_increment  NOT NULL ,
        Number_Address    Int NOT NULL ,
        Street_Address        Varchar (35) NOT NULL ,
        City_Address      Varchar (35) NOT NULL ,
        PostalCode_Address Varchar (5) NOT NULL ,
        Country_Address       Varchar (30) NOT NULL
	,CONSTRAINT Address_PK PRIMARY KEY (ID_Address)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Residences
#------------------------------------------------------------

CREATE TABLE Residences(
        ID_Residence   Int Auto_increment NOT NULL ,
        Name_Residence Varchar (50) NOT NULL ,
        ID_Address   Int NOT NULL
	,CONSTRAINT Residences_PK PRIMARY KEY (ID_Residence)

	,CONSTRAINT Residences_Adress_FK FOREIGN KEY (ID_Address) REFERENCES Addresses(ID_Address)
	,CONSTRAINT Residences_Adress_AK UNIQUE (ID_Address)
)ENGINE=InnoDB;

#------------------------------------------------------------
# Table: Package
#------------------------------------------------------------

CREATE TABLE Package(
        ID_PACKAGE   Int Auto_increment NOT NULL ,
        package_name Varchar (50) NOT NULL ,
        price Int NOT NULL ,
        description Varchar (50) NOT NULL ,
        connected_object Int NOT NULL ,
        meal Int NOT NULL ,
        total_price INT NOT NULL
        ,CONSTRAINT Package_PK PRIMARY KEY (ID_PACKAGE)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Employees
#------------------------------------------------------------
CREATE TABLE Employees(
        ID_Employee          Int  Auto_increment  NOT NULL ,
        Login_Employee Varchar (20) NOT NULL ,
        Password_Employee  Varchar (40) NOT NULL ,
        Lastname_Employee         Varchar (30) NOT NULL ,
        Firstname_Employee      Varchar (30) NOT NULL ,
        PhoneNumber_Employee      Varchar (12) NOT NULL ,
        ID_Address           Int NOT NULL
	,CONSTRAINT Employee_PK PRIMARY KEY (ID_Employee)

	,CONSTRAINT Employee_Adress_FK FOREIGN KEY (ID_Address) REFERENCES Addresses(ID_Address)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Levels
#------------------------------------------------------------
CREATE TABLE Levels(
        ID_Level          Int   NOT NULL ,
        ID_Residence      Int NOT NULL
	,CONSTRAINT Level_PK PRIMARY KEY (ID_Level,ID_Residence)
	,CONSTRAINT Level_Residences_FK FOREIGN KEY (ID_Residence) REFERENCES Residences(ID_Residence)
)ENGINE=InnoDB;

#------------------------------------------------------------
# Table: Apartments
#------------------------------------------------------------
CREATE TABLE Apartments(
        ID_Apartment   Int  Auto_increment  NOT NULL,
        Name_Apartment  Varchar(30) NOT NULL ,
        ID_Level      Int NOT NULL
	,CONSTRAINT Apartment_PK PRIMARY KEY (ID_Apartment)
	,CONSTRAINT Apartment_Level_FK FOREIGN KEY (ID_Level) REFERENCES Levels(ID_Level)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Residents
#------------------------------------------------------------

CREATE TABLE Residents(
        ID_Resident          Int  Auto_increment  NOT NULL ,
        Login_Resident       Varchar (20) NOT NULL ,
        Password_Resident    Varchar (40) NOT NULL ,
        Lastname_Resident    Varchar (30) NOT NULL ,
        Firstname_Resident   Varchar (30) NOT NULL ,
        Age_Resident         Int NOT NULL ,
        Information_Resident Varchar (300) NOT NULL COMMENT "medical information"  ,
		ID_Apartment         Int
	,CONSTRAINT Residents_PK PRIMARY KEY (ID_Resident)
	,CONSTRAINT Residents_Apartment_FK FOREIGN KEY (ID_Apartment) REFERENCES Apartments(ID_Apartment)
)ENGINE=InnoDB;

#------------------------------------------------------------
# Table: Candidate
#------------------------------------------------------------ 
  CREATE TABLE Candidate(
        ID_Candidate Int  Auto_increment  NOT NULL ,
        civility Varchar(20) NOT NULL,
        age int NOT NULL,
        firstname Varchar (30) NOT NULL ,
        lastname Varchar (30) NOT NULL ,
        noteFinance int ,
        noteSante int,
        CONSTRAINT ID_Candidate PRIMARY KEY (ID_Candidate)
)ENGINE=InnoDB;



insert into Candidate (civility, age,firstname,lastname,noteFinance, noteSante)
values('Mme',82,'Anne', 'Pauline', 5,2);

#------------------------------------------------------------
# Table: Referentiel_Objects
#------------------------------------------------------------
CREATE TABLE Referentiel_Objects(
		Type_Object Varchar(30) NOT NULL,
        CONSTRAINT Referentiel_Objects PRIMARY KEY (Type_Object)
);

#------------------------------------------------------------
# Table: Objects
#------------------------------------------------------------
CREATE TABLE Objects(
        ID_Object     Int  Auto_increment  NOT NULL ,
        Type_Object   Varchar(30) NOT NULL,
	    State_Object  Bool NOT NULL ,
        ID_Apartment Int NOT NULL ,
        Mac_Object VarChar(17),
		Nickname_Object VarChar(30) NOT NULL,
		WatchMinutesOn Int NOT NULL,
		WatchMinutesOff Int NOT NULL
	,CONSTRAINT Objects_PK PRIMARY KEY (ID_Object)
	,CONSTRAINT Objects_Type_FK FOREIGN KEY (Type_Object) REFERENCES Referentiel_Objects(Type_Object) 
	,CONSTRAINT Objects_Apartment_FK FOREIGN KEY (ID_Apartment) REFERENCES Apartments(ID_Apartment)
)ENGINE=InnoDB;

# Table: Alerts
#------------------------------------------------------------

CREATE TABLE Alerts(
        ID_Alert        Int  Auto_increment  NOT NULL ,
		State_Alert   Bool NOT NULL ,
        Level_Alert    Int NOT NULL,
        Date_Alert      TIMESTAMP NOT NULL ,
        Message_Alert   Varchar (60) ,
        ID_Object             Int NOT NULL
	,CONSTRAINT Alerts_PK PRIMARY KEY (ID_Alert)

	,CONSTRAINT Alerts_Objects_FK FOREIGN KEY (ID_Object) REFERENCES Objects(ID_Object)
)ENGINE=InnoDB;

#------------------------------------------------------------
# Table: Malfunctions
#------------------------------------------------------------

CREATE TABLE Malfunctions(
        ID_Malfunction   Int  Auto_increment  NOT NULL ,
		State_Malfunction  Bool NOT NULL ,
        Date_Malfunction TIMESTAMP NOT NULL ,
        Message_Malfunction   Varchar (100) ,
		Type_Malfunction      Int NOT NULL,
        ID_Object             Int NOT NULL
	,CONSTRAINT Malfunctions_PK PRIMARY KEY (ID_Malfunction)

	,CONSTRAINT Malfunctions_Objects_FK FOREIGN KEY (ID_Object) REFERENCES Objects(ID_Object)
)ENGINE=InnoDB;

#------------------------------------------------------------
#Table: ConnectedBathtub_Objects
#------------------------------------------------------------

CREATE TABLE ConnectedBathtub_Objects (
       ID_ConnectedBathtub     Int NOT NULL ,
       MaxWaterLevel           Int NOT NULL ,
	   TargetWaterLevel        Int NOT NULL ,
       MaxWaterTemperature     Int NOT NULL ,
	   TargetWaterTemperature  Int NOT NULL ,
       Update_Bathtub    TIMESTAMP NOT NULL
       ,CONSTRAINT ConnectedBathtub_PK PRIMARY KEY (ID_ConnectedBathtub)
       ,CONSTRAINT ConnectedBathtub_Objects_FK FOREIGN KEY (ID_ConnectedBathtub) REFERENCES Objects(ID_Object)
)ENGINE=InnoDB;

#------------------------------------------------------------
#Table: ConnectedHobs_Objects
#------------------------------------------------------------

CREATE TABLE ConnectedHobs_Objects (
       ID_ConnectedHobs     	Int NOT NULL ,
	   MaxHobsTemperature     	Int NOT NULL ,
       TargetHobsTemperature    Int NOT NULL ,
       Update_Hobs        TIMESTAMP NOT NULL
       ,CONSTRAINT ConnectedHobs_PK PRIMARY KEY (ID_ConnectedHobs)
       ,CONSTRAINT ConnectedHobs_Objects_FK FOREIGN KEY (ID_ConnectedHobs) REFERENCES Objects(ID_Object)
)ENGINE=InnoDB;

#------------------------------------------------------------
#Table: ConnectedBulbs_Objects
#------------------------------------------------------------

CREATE TABLE ConnectedBulbs_Objects (
       ID_ConnectedBulbs      Int NOT NULL ,
       MaxBulbBrightness      Int NOT NULL ,
       TargetBulbBrightness   Int NOT NULL ,
       MaxBulbOperatingTime   Int NOT NULL ,
       Update_Bulbs	    TIMESTAMP NOT NULL
       ,CONSTRAINT ConnectedBulbs_PK PRIMARY KEY (ID_ConnectedBulbs) 
       ,CONSTRAINT ConnectedBulbs_Objects_FK FOREIGN KEY (ID_ConnectedBulbs) REFERENCES Objects(ID_Object)
)ENGINE=InnoDB;

#------------------------------------------------------------
#Table: ConnectedBlinds_Objects
#------------------------------------------------------------

CREATE TABLE ConnectedBlinds_Objects (
       ID_ConnectedBlinds     Int NOT NULL,
	   TargetBlindPosition    Int NOT NULL,
       MaxBlindOpeningTime    Int NOT NULL ,
       Update_Blinds     TIMESTAMP NOT NULL
       ,CONSTRAINT ConnectedBlinds_PK PRIMARY KEY (ID_ConnectedBlinds)
       ,CONSTRAINT ConnectedBlinds_Objects_FK FOREIGN KEY (ID_ConnectedBlinds) REFERENCES Objects(ID_Object)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: HistoricalMedicalData
#------------------------------------------------------------
CREATE TABLE HistoricalMedicalData(
	     Id_HistoricalMedicalData  Int  Auto_increment  NOT NULL ,
         Date Varchar (20) NOT NULL ,
	     MedicalData       float,
         Id_Object int not null
	  ,CONSTRAINT ID_HistoricaleMedicalData_PK PRIMARY KEY (ID_HistoricalMedicalData),
       CONSTRAINT Data_Object_FK FOREIGN KEY (ID_Object ) REFERENCES Objects(ID_Object)
)ENGINE=InnoDB;

#------------------------------------------------------------
# Table: Questionnary
#------------------------------------------------------------

CREATE TABLE Questionnary(
        ID_Questionnary Int  Auto_increment  NOT NULL ,
        ID_Candidate int NOT NULL,
        health Varchar(20),
        sporty Varchar (30),
        allergic Varchar (30),
        disabled varchar (50),
        financeOption Varchar (30) NOT NULL,
        CONSTRAINT ID_Questionnary PRIMARY KEY (ID_Questionnary),
        CONSTRAINT Questionnary_FK FOREIGN KEY (ID_Candidate) REFERENCES Candidate(ID_Candidate)
)ENGINE=InnoDB;

#------------------------------------------------------------
# Table: Profil
#------------------------------------------------------------

CREATE TABLE Profil(
        ID_Profil Int  Auto_increment  NOT NULL ,
		age int(20),
        firstname Varchar (30),
        lastname Varchar (30),
		profil_Type varchar (50),
        CONSTRAINT ID_Profil PRIMARY KEY (ID_Profil)
        )ENGINE=InnoDB;

#------------------------------------------------------------
# Table: MedicalAlerts
#------------------------------------------------------------

CREATE TABLE MedicalAlerts(
        ID_Alert        Int  Auto_increment  NOT NULL ,
		State_Alert   Bool NOT NULL ,
		State_Notification   Bool NOT NULL ,
        Level_Alert    Int NOT NULL,
        Date_Alert      Varchar(20) NOT NULL ,
        Message_Alert   Varchar (60) ,
        ID_Object             Int NOT NULL
	,CONSTRAINT Alerts_PK PRIMARY KEY (ID_Alert)
	,CONSTRAINT Alert_Objects_FK FOREIGN KEY (ID_Object) REFERENCES Objects(ID_Object)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Position
#------------------------------------------------------------

CREATE TABLE Positions(
	     ID_Position  int  auto_increment  NOT NULL ,
         datePosition Varchar (20) NOT NULL ,
	     positionX       float, positionY float,
         ID_Object int NOT NULL
	  ,CONSTRAINT id_position_pk PRIMARY KEY (ID_Position)
	  ,CONSTRAINT date_object_fk FOREIGN KEY (ID_Object ) REFERENCES Objects(ID_Object)
)ENGINE=InnoDB;


insert into Referentiel_Objects(Type_Object) values('Connected Bracelet');
insert into Referentiel_Objects(Type_Object) values('Bathtub');
insert into Referentiel_Objects(Type_Object) values('Hob');
insert into Referentiel_Objects(Type_Object) values('Bulb');
insert into Referentiel_Objects(Type_Object) values('Blind');

insert into Addresses (Number_Address, Street_Address, City_Address, PostalCode_Address, Country_Address) values ('71', 'rue Saint-Simon' , 'Créteil' , '94000', 'France');

insert into Employees (Login_Employee, Password_Employee, Lastname_Employee, Firstname_Employee, PhoneNumber_Employee, ID_Address) values ('pierre_adm', 'tv', 'Jacquet', 'Pierre', '0607080901', 1);

insert into Residences (Name_Residence, ID_Address) values ('R1', 1);

insert into Levels (ID_Level, ID_Residence) values (0, 1);
insert into Levels (ID_Level, ID_Residence) values (1, 1);

insert into Apartments(Name_Apartment, ID_Level) values('Apartment A' , 0);
insert into Apartments(Name_Apartment, ID_Level) values('Apartment B' , 0);
insert into Apartments(Name_Apartment, ID_Level) values('Apartment C' , 0);
insert into Apartments(Name_Apartment, ID_Level) values('Apartment D' , 0);
insert into Apartments(Name_Apartment, ID_Level) values('Apartment E' , 0);
insert into Apartments(Name_Apartment, ID_Level) values('Apartment F' , 0);
insert into Apartments(Name_Apartment, ID_Level) values('Apartment G' , 0);
insert into Apartments(Name_Apartment, ID_Level) values('Apartment H' , 1);
insert into Apartments(Name_Apartment, ID_Level) values('Apartment I' , 1);
insert into Apartments(Name_Apartment, ID_Level) values('Apartment J' , 1);

insert into Residents(Login_Resident, Password_Resident, Lastname_Resident, Firstname_Resident, Age_Resident, Information_Resident, ID_Apartment) values ('pierre_res','tv','Jacquet','Pierre',85,'This person has Heart problems',1);
insert into Residents(Login_Resident, Password_Resident, Lastname_Resident, Firstname_Resident, Age_Resident, Information_Resident, ID_Apartment) values ('pierre_res2','tv','Jacquet2','Pierre2',87,'This person has Heart problems',1);
insert into Residents(Login_Resident, Password_Resident, Lastname_Resident, Firstname_Resident, Age_Resident, Information_Resident, ID_Apartment) values ('ismail_res','tv','Zaaouar','Ismail',87,'This person has a diabete problem',2);

insert into Objects (Type_Object, State_Object, ID_Apartment, Mac_Object, Nickname_Object, WatchMinutesOn, WatchMinutesOff) values ('Connected Bracelet', 1, 1, '34:f5:ee:a4:87:23','', 6000,42000);
insert into Objects (Type_Object, State_Object, ID_Apartment, Mac_Object, Nickname_Object, WatchMinutesOn, WatchMinutesOff) values ('Connected Bracelet', 1, 2, 'e9:67:8a:98:6d:56','', 6000,42000);

insert into Objects (Type_Object, State_Object, ID_Apartment, Mac_Object, Nickname_Object, WatchMinutesOn, WatchMinutesOff) values ('Bathtub', 1, 7, 'a6:4e:ea:66:95','', 60,420);
insert into ConnectedBathtub_Objects(ID_ConnectedBathtub,MaxWaterLevel,TargetWaterlevel,MaxWaterTemperature,TargetWaterTemperature,Update_Bathtub) values(LAST_INSERT_ID(),90,50,40,30,NOW());

insert into Objects (Type_Object, State_Object, ID_Apartment, Mac_Object, Nickname_Object, WatchMinutesOn, WatchMinutesOff) values ('Hob', 1, 7, '24:ec:3a:12:21:1a','', 60,420);
insert into ConnectedHobs_Objects(ID_ConnectedHobs,MaxHobsTemperature,TargetHobsTemperature,Update_Hobs) values(LAST_INSERT_ID(),240,60,NOW());

insert into Objects (Type_Object, State_Object, ID_Apartment, Mac_Object, Nickname_Object, WatchMinutesOn, WatchMinutesOff) values ('Bulb', 1, 7, '4f:9c:de:07:ca:24','', 60,420);
insert into ConnectedBulbs_Objects(ID_ConnectedBulbs,MaxBulbBrightness,TargetBulbBrightness,MaxBulbOperatingTime,Update_Bulbs) values(LAST_INSERT_ID(),90,60,24,NOW());

insert into Objects (Type_Object, State_Object, ID_Apartment, Mac_Object, Nickname_Object, WatchMinutesOn, WatchMinutesOff) values ('Blind', 1, 7, '45:ab:12:e3:66:95','', 60,420);
insert into ConnectedBlinds_Objects(ID_ConnectedBlinds,TargetBlindPosition,MaxBlindOpeningTime,Update_Blinds) values(LAST_INSERT_ID(),50,24,NOW());

insert into Alerts (State_Alert, Level_Alert, Date_Alert, Message_Alert, ID_Object) values(0, 3, NOW(), 'Example of alert', 1);
insert into Alerts (State_Alert, Level_Alert, Date_Alert, Message_Alert, ID_Object) values(1, 3, NOW(), 'Example of alert', 4);
insert into Alerts (State_Alert, Level_Alert, Date_Alert, Message_Alert, ID_Object) values(1, 1, NOW(), 'Example of alert', 5);

insert into Malfunctions(State_Malfunction, Date_Malfunction, Message_Malfunction, Type_Malfunction, ID_Object) values(0, NOW(), 'Example of malfunction',0,4);
insert into Malfunctions(State_Malfunction, Date_Malfunction, Message_Malfunction, Type_Malfunction, ID_Object) values(1, NOW(), 'Example of malfunction',0,5);
insert into Malfunctions(State_Malfunction, Date_Malfunction, Message_Malfunction, Type_Malfunction, ID_Object) values(1, NOW(), 'Example of malfunction',0,2);
