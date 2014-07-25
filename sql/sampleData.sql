--Employee Data
insert into Employee values
(1, 'Ian', 'R', 'McPherson', '2013-01-05', 'Tech'),
(2, 'Justin', 'A', 'Middleton', '2012-04-07', 'Admitting Doctor'),
(3, 'Rob', 'T', 'Baldwin', '2013-06-08', 'Consulting Doctor'),
(4, 'Eric', 'S', 'Turner', '2014-02-01', 'Admin'),
(5, 'Ryan', 'D', 'Nichols', '2013-11-15', 'Consulting Doctor'),
(6, 'Andrew', 'J', 'Sok', '2013-12-17', 'Nurse'),
(7, 'Taylor', 'L', 'Tran', '2012-09-20', 'Staff'),
(8, 'Bryan', 'E', 'Wang', '2012-03-14', 'Admin'),
(9, 'Luke', 'F', 'Riney', '2013-07-12', 'Staff'),
(10, 'Sasha', 'L', 'Litt', '2012-04-15', 'Admitting Doctor');

--Volunteer Data
insert into Volunteer values
(1, 'Rodger', 'M', 'Varley', '2013-07-10'),
(2, 'Domenic', 'L', 'Bush', '2014-01-01'),
(3, 'Isidore', 'W', 'Woods', '2014-02-18'),
(4, 'Larissa', 'H', 'Timberlake', '2014-02-25'),
(5, 'Gordie', 'L', 'Daniel', '2013-12-22'),
(6, 'Denver', 'L', 'Steffen', '2013-12-10'),
(7, 'Karl', 'T', 'Tammara', '2014-01-23'),
(8, 'Linnet', 'M', 'Paris', '2014-02-19'),
(9, 'Derryl', 'G', 'Kendal', '2014-01-17'),
(10, 'Rachael', 'P', 'Clay', '2012-11-25');

--Services Data
insert into Services values
('Gift shop',false),
('Info desk',false),
('Snack carts',false),
('Reading carts',false),
('Cafeteria',true),
('Janitorial',true);

--Treatment Data
insert into Treatment values
(1, 'Penicillin', 'Medication'),
(2, 'Vicodin', 'Medication'),
(3, 'Oxycodone', 'Medication'),
(4, 'Surgery', 'Procedure'),
(5, 'Broad Spectrum AntiBiotics', 'Medication'),
(6, 'Lumbar Puncture', 'Procedure'),
(7, 'Lung Function Test', 'Procedure'),
(8, 'Strep test', 'Procedure'),
(9, 'Flu test', 'Procedure'),
(10, 'Blood Test', 'Procedure'),
(11, 'MRI', 'Procedure'),
(12, 'Corticosteroids', 'Medication');

--Diagnosis Data
insert into Diagnosis values
(1, 'Lupus'),
(2, 'Common Cold'),
(3, 'Flu'),
(4, 'Diabetes'),
(5, 'Asthma'),
(6, 'Hypothyriodism'),
(7, 'Appendicitis');

--Patient Data
insert into Patient values
(1, 'Walt', 'M', 'Quigley', '202-555-0161', 'Blue Shield'),
(2, 'Dax', 'L', 'Hampson', '205-573-4141', 'Unitedhealth'),
(3, 'Aylmer', 'L', 'Clifton', '815-245-0451', 'Wellpoint Inc.'),
(4, 'Terrell', 'J', 'Massey', '202-555-0106', 'Kaiser Foundation'),
(5, 'Ariel', 'T', 'Trevis', '202-555-0170', 'Unitedhealth'),
(6, 'Dirk', 'K', 'Evelyn', '815-954-4584', 'Wellpoint Inc.'),
(7, 'Ike', 'D', 'Quigley', '205-575-9561', 'Wellpoint Inc.'),
(8, 'Zackary', 'H', 'West', '202-587-3841', 'Kaiser Foundation'),
(9, 'Noah', 'C', 'Henderson', '221-574-9832', 'Wellpoint Inc.'),
(10, 'Jeb', 'A', 'Dean', '202-855-1961', 'Unitedhealth');

--Room Data
insert into Room values
(1, null, null),
(2, null, null),
(3, 6, 4),
(4, 5, 8),
(5, null, null),
(6, null, null),
(7, null, null),
(8, null, null),
(9, null, null),
(10, null, null),
(11, null, null),
(12, null, null),
(13, null, null);

--Admit Data
insert into Admit values
(2, 2, 1, '2014-01-15 13:45', 'out', '4', '2014-01-15 14:15'),
(2, 2, 1, '2014-03-07 13:45', 'in', '4', '2014-03-10 14:15'), 
(2, 3, 1, '2014-04-01 13:45', 'in', '4', '2014-04-04 14:15'),
(2, 3, 2, '2014-01-23 08:35', 'in', '8', '2014-01-25 15:21'),
(2, 3, 2, '2014-03-23 08:35', 'in', '8', '2014-03-25 15:21'),
(10, 5, 3, '2014-02-13 09:31', 'in', '8', '2014-02-14 10:11'),
(2, 2, 4, '2014-01-01 09:31', 'out', '4', '2014-01-01 11:15'),
(10, 3, 5, '2014-07-01 15:31', 'out', 4, '2014-07-01 16:30'),
(10, 2, 5, '2014-07-20 15:31', 'in', null, null),
(2, 4, 6, '2014-07-21 06:11', 'in', null, null),
(2, 2, 7, '2014-07-22 07:11', 'out', null, null),
(10, 7, 7, '2014-04-13 17:14', 'in', '4', '2014-04-17 12:30'),
(10, 2, 8, '2014-03-14 09:24', 'out', '8', '2014-03-14 10:12'),
(10, 2, 9, '2014-05-11 12:59', 'out', '8', '2014-05-11 13:41'),
(10, 1, 10, '2014-05-22 10:02', 'in', '4', '2014-06-01 12:01'),
(10, 1, 10, '2014-06-22 10:02', 'in', '4', '2014-07-01 12:01'),
(2, 2, 10, '2014-07-22 10:02', 'in', '4', '2014-08-01 12:01'),
(10, 3, 10, '2014-08-22 10:02', 'in', '4', '2014-09-01 12:01');

--VolProvide Data
insert into VolProvide values
(1, 'Gift shop', 'Mon'),
(1, 'Info desk', 'Tue'),
(1, 'Snack carts', 'Thu'),
(2, 'Reading carts', 'Fri'),
(2, 'Gift shop', 'Wed'),
(3, 'Snack carts', 'Sat'),
(3, 'Info desk', 'Tue'),
(3, 'Snack carts', 'Sun'),
(4, 'Info desk', 'Wed'),
(4, 'Reading carts', 'Mon'),
(5, 'Gift shop', 'Sat'),
(6, 'Info desk', 'Tue'),
(7, 'Snack carts', 'Sun'),
(7, 'Reading carts', 'Mon'),
(8, 'Gift shop', 'Tue'),
(8, 'Snack carts', 'Thu'),
(9, 'Info desk', 'Fri'),
(9, 'Snack carts', 'Wed'),
(10, 'Info desk', 'Sat'),
(10, 'Reading carts', 'Tue');

-- StaffProvide Data
insert into StaffProvide values
(7, 'Cafeteria'),
(9, 'Janitorial');

-- AssignDoc Data
insert into AssignDoc values
(2, 3, 2, '2014-01-23 11:24'),
(2, 10, 2, '2014-01-23 11:24'),
(10, 5, 3, '2014-02-13 12:31'),
(10, 3, 5, '2014-07-20 16:51'),
(10, 5, 5, '2014-07-21 14:10'),
(2, 3, 6, '2014-07-22 15:11'),
(10, 2, 7, '2014-04-14 09:13'),
(10, 3, 7, '2014-04-14 13:21'),
(10, 5, 7, '2014-04-16 08:34'),
(10, 3, 10, '2014-05-23 16:42');

-- Orders Data
insert into Orders values
(1, 2, 5, 1, '2014-01-15 14:04'),
(2, 3, 9, 2, '2014-01-23 13:34'),
(3, 10, 1, 2, '2014-01-23 13:54'),
(4, 5, 7, 3, '2014-02-13 12:02'),
(5, 2, 5, 4, '2014-01-01 10:01'),
(6, 3, 9, 5, '2014-07-20 17:30'),
(7, 10, 1, 5, '2014-07-21 9:42'),
(8, 3, 10, 6, '2014-07-22 17:21'),
(9, 2, 11, 7, '2014-04-14 10:33'),
(10, 3, 4, 7, '2014-04-14 15:11'),
(11, 5, 2, 7, '2014-04-16 9:24'),
(12, 10, 5, 8, '2014-03-14 09:39'),
(13, 10, 5, 9, '2014-05-11 13:14'),
(14, 10, 11, 10, '2014-05-22 12:42'),
(15, 3, 6, 10, '2014-05-24 11:14'),
(16, 3, 12, 10, '2014-05-25 12:11');

-- Administers Data
insert into Administers values
(1, 2, '2014-01-15 14:15'),
(2, 1, '2014-01-23 13:44'),
(3, 6, '2014-01-23 14:05'),
(4, 1, '2014-02-13 12:39'),
(5, 6, '2014-01-01 10:20'),
(6, 1, '2014-07-20 17:45'),
(7, 5, '2014-07-21 10:15'),
(8, 10, '2014-07-23 8:21'),
(9, 1, '2014-04-14 11:33'),
(10, 2, '2014-04-15 10:11'),
(11, 6, '2014-04-16 9:36'),
(12, 6, '2014-03-14 09:46'),
(13, 6, '2014-05-11 13:25'),
(14, 1, '2014-05-22 14:31'),
(15, 5, '2014-05-24 12:21'),
(15, 3, '2014-05-24 12:21'),
(16, 3, '2014-05-25 14:19');
