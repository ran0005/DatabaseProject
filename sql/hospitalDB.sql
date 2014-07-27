drop table if exists Orders cascade;
drop table if exists Employee cascade;
drop table if exists Volunteer cascade;
drop table if exists Services cascade;
drop table if exists Treatment;
drop table if exists Patient cascade;
drop table if exists Diagnosis cascade;
drop table if exists Room;
drop table if exists Admit cascade;
drop table if exists VolProvide;
drop table if exists StaffProvide;
drop table if exists AssignDoc;
drop table if exists Administers;
drop view if exists VisitIntervals;
drop view if exists EmployeePatientInteraction cascade;

create table Employee (
empID integer primary key,
eFirstName text not null,
eMInit text not null,
eLastName text not null,
eHiredate text not null,
eType text not null,
check (eType in ('Admitting Doctor', 'Consulting Doctor','Admin','Nurse','Tech','Staff'))
);

create table Volunteer (
volID integer primary key,
vFirstName text not null,
vMInit text not null,
vLastName text not null,
vHiredate text not null
);

create table Services (
servType text primary key,
staffOnly boolean not null,
check (servType in ('Gift shop','Info desk','Snack carts','Reading carts','Cafeteria','Janitorial'))
);

create table Treatment (
treatID integer primary key,
tName text unique not null,
tType text not null,
check (tType in ('Medication','Procedure'))
);

create table Diagnosis (
diagID integer primary key,
dName text not null
);

create table Patient (
patID integer primary key,
pFirstName text not null,
pMInit text not null,
pLastName text not null,
emergContact text not null,
insurance text not null
);

create table Room (
roomNum integer primary key,
patID integer unique,
empID integer,
foreign key(patID) references Patient(patID),
foreign key(empID) references Employee(empID)
);

create table Admit (
admitDocID integer,
diagID integer,
patID integer,
startTime text,
patType text not null,
dischargeAdminID integer,
endTime text,
check (patType in ('in', 'out')),
foreign key (admitDocID) references Employee(empID),
foreign key (diagID) references Diagnosis(diagID),
foreign key (patID) references Patient(patID),
foreign key (dischargeAdminID) references Employee(empID),
primary key (admitDocID,diagID, patID,startTime)
);

create table VolProvide (
volID integer,
servType text,
dayOfWeek text,
check (dayOfWeek in ('Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun')),
foreign key (volID) references Volunteer(volID),
foreign key (servType) references Services(servType),
primary key (volID,servType,dayOfWeek)
);

create table StaffProvide (
empID integer,
servType text,
foreign key(empID) references Employee(empID),
foreign key(servType) references Services(servType),
primary key (empID, servType)
);

create table AssignDoc (
primaryID integer,
secondaryID integer,
patID integer,
assignTime text,
foreign key (primaryID) references Employee(empID),
foreign key (secondaryID) references Employee(empID),
foreign key (patID) references Patient(patID),
primary key (primaryID,secondaryID,patID,assignTime)
);

create table Orders (
orderID integer,
empID integer not null,
treatID integer not null,
patID integer not null,
orderTime text not null,
foreign key (empID) references Employee(empID),
foreign key (treatID) references Treatment(treatID),
foreign key (patID) references Patient(patID),
primary key (orderID)
);

create table Administers (
orderID integer,
empAdministerID int,
adminTime text,
foreign key (orderID) references Orders (orderID),
foreign key (empAdministerID) references Employee (empID),
primary key (orderID, empAdministerID, adminTime)
);

create view VisitIntervals as
(
select patID, st1, min(st2::timestamp - st1::timestamp) timeBetween
from
(
select patID, startTime as st1
from Admit
where endtime is not null
) s1 join
(
select patID, startTime as st2
from Admit
) s2 using (patID)
where s1.st1 < s2.st2
group by patID, st1
);

create view EmployeePatientInteraction as 
(
	--The doctors who admitted the patients.
	select distinct admitDocID, patID
	from Admit
	where patType = 'in'
	union
	--The doctors assigned to each patient.
	select distinct secondaryID, patID
	from AssignDoc join Admit using (patID)
	where patType = 'in'
	and assignTime::timestamp > startTime::timestamp and (endTime is null or assignTime::timestamp < endTime::timestamp)
	union
	--The doctors who ordered a treatment for a patient.
	select distinct empID, patID
	from Orders join Admit using (patID)
	where patType = 'in'
	and orderTime::timestamp > startTime::timestamp and (endTime is null or orderTime::timestamp < endTime::timestamp)
	union
	--The employees who administered a treatment for a patient.
	select distinct empAdministerID, patID
	from Administers join Orders using (orderID)
	join Admit using (patID)
	where patType = 'in'
	and adminTime::timestamp > startTime::timestamp and (endTime is null or adminTime::timestamp < endTime::timestamp)
);
