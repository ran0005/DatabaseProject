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
tName text not null,
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
patID integer,
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
empID integer,
treatID integer,
patID integer,
orderTime text,
foreign key (empID) references Employee(empID),
foreign key (treatID) references Treatment(treatID),
foreign key (patID) references Patient(patID),
primary key (empID,treatID,patID,orderTime)
);

create table Administers (
docOrderID integer,
treatID integer,
patID integer,
orderTime text,
empAdministerID int,
adminTime text not null,
foreign key (docOrderID, treatID, patID, orderTime) references Orders (empID, treatID, patID, orderTime),
foreign key (empAdministerID) references Employee (empID),
primary key (docOrderID, treatID, patID, orderTime, empAdministerID)
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
